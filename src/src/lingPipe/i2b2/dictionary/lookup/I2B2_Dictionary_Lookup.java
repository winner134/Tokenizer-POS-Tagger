package src.lingPipe.i2b2.dictionary.lookup;

import src.i2b2.parser.I2B2_Medication_Event_Parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;
import com.aliasi.dict.ApproxDictionaryChunker;
import com.aliasi.dict.DictionaryEntry;
import com.aliasi.dict.TrieDictionary;
import com.aliasi.spell.FixedWeightEditDistance;
import com.aliasi.spell.WeightedEditDistance;
import com.aliasi.tokenizer.TokenizerFactory;

public class I2B2_Dictionary_Lookup {

	public static final String RxNormDictionary = "resources/dictionaries/Other/prescription_medications.txt";
	private WeightedEditDistance editDistance = new FixedWeightEditDistance(0,-1,-1,-1,Double.NaN);
	private static final double maxDistance = 1.0;
	private List<MedicationEvent> medications;
	//private static BufferedWriter outResults;

	public List<MedicationEvent> getMedicationSentences(List<String> dischargeSummarySentences, TokenizerFactory tokenizerFactory) throws IOException {
		
		Scanner dictionary = new Scanner(new BufferedReader(new FileReader(this.RxNormDictionary)));
		DictionaryEntry<String> entry;
		String dictionaryEntry;
		TrieDictionary<String> dict = new TrieDictionary<String>();
		medications = new LinkedList<MedicationEvent>();
		//outResults = new BufferedWriter(new FileWriter("resources/output/Drug NER/sampleNER.txt"));
		
		while(dictionary.hasNext()) {
			
			dictionaryEntry = dictionary.next().toLowerCase();
			if(!dictionaryEntry.isEmpty()) {
				
				entry = new DictionaryEntry<String>(dictionaryEntry, dictionaryEntry);
				dict.addEntry(entry);
				//System.out.println(dictionaryEntry);
			}
		}
		
		dictionary.close();
		
        ApproxDictionaryChunker chunker = new ApproxDictionaryChunker(dict, tokenizerFactory, editDistance, maxDistance);
        boolean printFlag;
        
        for (int i = 0; i < dischargeSummarySentences.size(); i++) {
            
        	//outResults.write("\n\n Text = " + dischargeSummarySentences.get(i) + "\n");
            
            Chunking chunking = chunker.chunk(dischargeSummarySentences.get(i).toLowerCase());
            CharSequence cs = chunking.charSequence();
            Set<Chunk> chunkSet = chunking.chunkSet();
            printFlag = false;
            MedicationEvent medication = new MedicationEvent();

            //outResults.write("Matched Phrase " + "Dict Entry" + "Distance" + "\n");
            for (Chunk chunk : chunkSet) {
                int start = chunk.start();
                int end = chunk.end();
                CharSequence str = cs.subSequence(start,end);
                double distance = chunk.score();
                String match = chunk.type();
               // outResults.write(str + "\t" + match + "\t" + distance + "\n");
                
                if(!match.isEmpty() && !medication.getMedications().contains(str.toString())) {
                	printFlag = true;
                	medication.addMedication(str.toString());
                }
                
            }
            
            if (printFlag) {
            	//outResults.write("SENTENCE " + (i+1) + ": " + "\n" + dischargeSummarySentences.get(i) + "\n");
            	
            	try {
            		
            		String possibleAfterSymbol = dischargeSummarySentences.get(i+1).split(" ")[0];
            	
            		if(I2B2_Medication_Event_Parser.DOSAGE.contains(possibleAfterSymbol) 
            				|| I2B2_Medication_Event_Parser.DURATION.contains(possibleAfterSymbol)
            				|| I2B2_Medication_Event_Parser.FREQUENCY.contains(possibleAfterSymbol) 
            				|| I2B2_Medication_Event_Parser.MODE_OF_ADMINSTRATION.contains(possibleAfterSymbol)) {
            		
            			medication.setMedicationSentence(dischargeSummarySentences.get(i).toLowerCase() + possibleAfterSymbol.toLowerCase());
            			medications.add(medication);
            		}
            		
            		else {
            			
            			medication.setMedicationSentence(dischargeSummarySentences.get(i).toLowerCase());
                		medications.add(medication);
            		}
            	}
            	
            	catch(Exception e) {
            		
            		medication.setMedicationSentence(dischargeSummarySentences.get(i).toLowerCase());
            		medications.add(medication);
            	}
            }
        }
        
        //outResults.close();
        return medications;
	}
}
