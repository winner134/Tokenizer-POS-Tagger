package src.clean_up.pipeline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.aliasi.tag.Tagging;

import src.lingPipe.i2b2.pos.tagging.I2B2_POS_Tagger;
import src.lingPipe.i2b2.tokenizers.BaseTokenizer;

public class MedicationSymbolsReplacer {

	public static final String RxNormDictionary = "resources/dictionaries/Other/prescription_medications.txt";
	public static final String frequencyDictionary = "resources/dictionaries/Other/frequencies.txt";
	public static final String modesDictionary = "resources/dictionaries/Other/mode.txt";
	public static final String durationsDictionary = "resources/dictionaries/Other/duration.txt";
	public static final String unitsDictionary = "resources/dictionaries/Other/units.txt";
	public static final String stopWordsDictionary = "resources/dictionaries/Other/stopwords.txt";
	public static final char SPECIAL_CHARACTER_1 = '[';
	public static final char SPECIAL_CHARACTER_2 = '^';
	public static final char SPECIAL_CHARACTER_3 = '(';
	public static final char SPECIAL_CHARACTER_4 = ')';
	public static final char SPECIAL_CHARACTER_5 = ']';
	public static final char SPECIAL_CHARACTER_6 = '+';
	public static final char SPECIAL_CHARACTER_7 = '{';
	public static final char SPECIAL_CHARACTER_8 = '}';
	public static final char SPECIAL_CHARACTER_9 = '*';
	public static final char SPECIAL_CHARACTER_10 = '!';
	public static final char SPECIAL_CHARACTER_11 = '\\';
	public static final char SPECIAL_CHARACTER_12 = '?';
	public static final char SPECIAL_CHARACTER_13 = '&';
	public static final char SPECIAL_CHARACTER_14 = '@';
	public static final char SPECIAL_CHARACTER_15 = '|';
	public static final char SPECIAL_CHARACTER_16 = '#';
	public static final char SPECIAL_CHARACTER_17 = ',';
	public static final char SPECIAL_CHARACTER_18 = '.';
	public static final char SPECIAL_CHARACTER_19 = '_';
	public static final char SPECIAL_CHARACTER_20 = '/';
	public static final char[] SPECIAL_CHARACTERS = {SPECIAL_CHARACTER_1, SPECIAL_CHARACTER_2, SPECIAL_CHARACTER_3,
		SPECIAL_CHARACTER_4, SPECIAL_CHARACTER_5, SPECIAL_CHARACTER_6, SPECIAL_CHARACTER_7, SPECIAL_CHARACTER_8,
		SPECIAL_CHARACTER_9, SPECIAL_CHARACTER_10, SPECIAL_CHARACTER_11, SPECIAL_CHARACTER_12, SPECIAL_CHARACTER_13,
		SPECIAL_CHARACTER_14, SPECIAL_CHARACTER_15, SPECIAL_CHARACTER_16, SPECIAL_CHARACTER_17, SPECIAL_CHARACTER_18,
		SPECIAL_CHARACTER_19, SPECIAL_CHARACTER_20
	};
	private static final String MED_NAME_TAG = " MED ";
	private static final String MED_FREQ_TAG = " FREQ ";
	private static final String MED_MODE_TAG = " MODE ";
	private static final String MED_DURATION_TAG = " DRT ";
	private static final String MED_UNIT_TAG = " UNIT ";
	private static final String VERB = "V";
	private static BufferedWriter adjustedDischargeSummary;
	private Scanner dischargeSummary;
	private String discharge;

	public void dischargeSummaryAdjustment(String dischargeSummaryFilePath) throws IOException, ClassNotFoundException {
		
		discharge = new String();
			
		dischargeSummary = new Scanner(new BufferedReader(new FileReader(dischargeSummaryFilePath)));
		
		BaseTokenizer tokenize = new BaseTokenizer();
		
		List<String> tokens = tokenize.tokenizeTextFromFile(dischargeSummaryFilePath);
		
		I2B2_POS_Tagger tagger = new I2B2_POS_Tagger();
		Tagging<String> tags = tagger.tagText(tokens);
		List<String> verbs = new LinkedList<String>();
		
		for (int i = 0; i < tags.tags().size(); i++) {
			
			if(tags.tag(i).contains(VERB)) {
				
				try {
					System.out.println("VERB?= " + tags.token(i));
					verbs.add(tags.token(i));
					tags.tokens().remove(tags.token(i));
				}
				
				catch(UnsupportedOperationException e) {
					continue;
				}
			}
		}
		
		for (int i = 0; i < tags.tokens().size(); i++) {
			
			if(!verbs.contains(tags.tokens().get(i)) && !verbs.contains(tags.token(i)))
			discharge = discharge.concat(" " + tags.tokens().get(i));
		}
	    
	    discharge = discharge.replaceAll("'", " ");
	    discharge = discharge.toLowerCase();
	    discharge = discharge.replaceAll("toprol-xl", MED_NAME_TAG);
	    replaceStopWords();
	    //replaceSpecialCharacters();
	    replaceMedNames();
	    replaceFrequencyWithTag();
	    replaceModeWithTag();
	    this.replaceDurationWithTag();
	    this.replaceUnitWithTag();
		
		adjustedDischargeSummary = new BufferedWriter(new FileWriter(dischargeSummaryFilePath + "_annotated"));
		adjustedDischargeSummary.write(discharge);
		adjustedDischargeSummary.close();
	}

	private void replaceMedNames() throws IOException {
		
		Scanner medNamesDictionary = new Scanner(new BufferedReader(new FileReader(RxNormDictionary)));	
		replaceAll(medNamesDictionary, MED_NAME_TAG);
		medNamesDictionary.close();
	}
	
	private void replaceFrequencyWithTag() throws FileNotFoundException {
		
		Scanner freqDictionary = new Scanner(new BufferedReader(new FileReader(frequencyDictionary)));
		replaceAll(freqDictionary,MED_FREQ_TAG );
		freqDictionary.close();
	}
	
	private void replaceModeWithTag() throws FileNotFoundException {
		
		Scanner modeDictionary = new Scanner(new BufferedReader(new FileReader(modesDictionary)));
		replaceAll(modeDictionary, MED_MODE_TAG);
		modeDictionary.close();
	}
	
	private void replaceDurationWithTag() throws FileNotFoundException {
		
		Scanner durationDictionary = new Scanner(new BufferedReader(new FileReader(durationsDictionary)));
		replaceAll(durationDictionary, MED_DURATION_TAG);
		durationDictionary.close();
	}
	
	private void replaceUnitWithTag() throws FileNotFoundException {
		
		Scanner unitDictionary = new Scanner(new BufferedReader(new FileReader(unitsDictionary)));
		replaceAll(unitDictionary, MED_UNIT_TAG);
		unitDictionary.close();
	}
	
	private void replaceStopWords() throws FileNotFoundException {
		
		Scanner stopWordDictionary = new Scanner(new BufferedReader(new FileReader(stopWordsDictionary)));
		replaceAll(stopWordDictionary , " ");
		stopWordDictionary.close();
	}
	
	private void replaceSpecialCharacters() throws FileNotFoundException {
		
		for (int i = 0; i < SPECIAL_CHARACTERS.length; i++) {
			
			discharge = discharge.replace(SPECIAL_CHARACTERS[i], ' ');
		}
	}
	
	private void replaceAll(Scanner dictionaryScanner, String replacement) {
		
		while(dictionaryScanner.hasNext()) {
			
			String dictionaryTerm = dictionaryScanner.nextLine().toLowerCase();
			
			if(discharge.contains((dictionaryTerm.trim()))) {
				
				if(dictionaryTerm.trim().length() <= 5 && dictionaryTerm.trim().length() > 0)
					discharge = discharge.replaceAll(" " + dictionaryTerm.trim() + " ", replacement
							+ dictionaryTerm.trim() + replacement);
				
				else
					discharge = discharge.replaceAll(dictionaryTerm.trim(), replacement
							+ dictionaryTerm.trim() + replacement);
			}	
		}
	}

}
