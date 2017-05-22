package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.*;

import src.clean_up.pipeline.MedicationSymbolsReplacer;
import src.i2b2.parser.I2B2_Medication_Event_Parser;
import src.i2b2.parser.medPatternsBaseListener;
import src.i2b2.parser.medPatternsLexer;
import src.i2b2.parser.medPatternsParser;
import src.lingPipe.i2b2.dictionary.lookup.I2B2_Dictionary_Lookup;
import src.lingPipe.i2b2.dictionary.lookup.MedicationEvent;
import src.lingPipe.i2b2.pos.tagging.I2B2_POS_Tagger;
import src.lingPipe.i2b2.sentence.splitter.MedlineSentenceSplitter;
import src.lingPipe.i2b2.tokenizers.BaseTokenizer;


public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	private static medPatternsParser parser;
	private static medPatternsLexer lexer;
	private static TokenStream stream;
	private static TokenSource source;
	private static medPatternsBaseListener listener;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BaseTokenizer tokenizer = new BaseTokenizer();
		List<String> tokens = tokenizer.tokenizeTextFromFile("resources/i2b2-2009-Discharge Summaries/2/241468");
		
		for(int i=0; i < tokens.size(); i++) {
			
			System.out.println(tokens.get(i));
		}
		
		MedlineSentenceSplitter splitter = MedlineSentenceSplitter.getMedLineSentenceSplitter();
		List<String> sentences = splitter.getSentences(tokenizer.getTokenList(), tokenizer.getWhiteList());
		
		//I2B2_POS_Tagger tagger = new I2B2_POS_Tagger();
		//tagger.tagText(tokens);
		
		MedicationSymbolsReplacer annotateDischargeSummary = new MedicationSymbolsReplacer();
		annotateDischargeSummary.dischargeSummaryAdjustment("resources/i2b2-2009-Discharge Summaries/7/191800");
		
		/**CharStream textCharStream = new ANTLRFileStream("resources/i2b2-2009-Discharge Summaries/1/161159_annotated");
		lexer = new medPatternsLexer(textCharStream);
		source = lexer;
		stream = new BufferedTokenStream(source);
		parser = new medPatternsParser(stream);
		listener = new medPatternsBaseListener();
		listener.enterIsland(parser.island());
		listener.exitIsland(parser.island());*/
		
		for(int i = 0; i < sentences.size(); i++) {
			
			System.out.println(sentences.get(i));
		}
	}
	
	private static void tokenizeDischargeSummaries(File folder) throws Exception {
		
		//BaseTokenizer tokenizer1 = new BaseTokenizer();
	    for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	tokenizeDischargeSummaries(fileEntry);
	        } else {

	        	//parser.parseDischargeSummary(fileEntry.getAbsolutePath());
	        	/**List<String> tokens = tokenizer1.tokenizeTextFromFile(fileEntry.getPath());
	    		System.out.println(fileEntry.getPath());*/
	    		
	    		//List<String> tokens = tokenizer1.tokenizeTextFromFile("resources/Sample DS/SampleDS.txt");
	    		
	    		/*for(int i = 0; i < tokens.size(); i++) {
	    			
	    			System.out.println(tokens.get(i) + "\n");
	    		}*/
	    		
	    		/**MedlineSentenceSplitter splitter = MedlineSentenceSplitter.getMedLineSentenceSplitter();
	    		List<String> sentences1 = splitter.getSentences(tokens, tokenizer1.getWhiteList());
	    		//System.out.println(sentences1.size() + "\n");
	    		//output.flush();
	    		I2B2_Dictionary_Lookup lookup = new I2B2_Dictionary_Lookup();
	    		List<MedicationEvent> medicationSentences = lookup.getMedicationSentences(sentences1, tokenizer1.getTOKENIZER_FACTORY());*/
	    		
	    		//System.out.println("\n\n Medication Sentences\n\n");
	    		//output.flush();
	    		
	    		/*for(int i = 0; i < medicationSentences.size(); i++) {
	    			
	    			//System.out.println("SENTENCE " + (i+1) + ": " 
	    			//+ medicationSentences.get(i).getMedicationSentence() + "\n");
	    			
	    			//System.out.println("\nMedications in Sentence\n\n");
	    			//output.flush();
	    			
	    			for (int j = 0; j < medicationSentences.get(i).getMedications().size(); j++) {
	    				
	    				System.out.println(medicationSentences.get(i).getMedications().get(j));
	    				//output.newLine();
	    				//output.flush();
	    			}
	    			
	    			System.out.println("\n");
	    			//output.flush();
	    		}*/
	    		
	    		/**I2B2_Medication_Event_Parser parser = new I2B2_Medication_Event_Parser();
	    		medicationSentences = parser.parseMedicationSentences(medicationSentences);
	    		

	    		System.out.println("\n\n Medication Sentences\n\n");*/
	    		//output.flush();
	    		
	    		/**for(int i = 0; i < medicationSentences.size(); i++) {
	    			
	    			System.out.println("SENTENCE " + (i+1) + ": " 
	    			+ medicationSentences.get(i).getMedicationSentence() + "\n");
	    			
	    			System.out.println("\nMedication Events in Sentence\n\n");
	    			
	    			//output.flush();
	    			
	    			for (int j = 0; j < medicationSentences.get(i).getMedicationEvents().size(); j++) {
	    				
	    				System.out.println(medicationSentences.get(i).getMedicationEvents().get(j));
	    				//output.newLine();
	    				//output.flush();
	    			}
	    			
	    			//output.write("\n");
	    			//output.flush();*/
	    		}
	        }
	    
	    }
}

