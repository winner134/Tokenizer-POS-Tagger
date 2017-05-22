package src.lingPipe.i2b2.dictionary.lookup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import src.lingPipe.i2b2.tokenizers.BaseTokenizer;


public class DictionaryCleaner1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Scanner inDictionary = new Scanner(new BufferedReader(new FileReader("resources/dictionaries/Rx-Norm/RxTerms201401.txt")));
		BufferedWriter outDictionary =new BufferedWriter(new FileWriter("resources/dictionaries/Rx-Norm/RxNorm_DisplayNames1.txt"));
		final String EMAIL_REGEX = "[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})";
		final String OTHER_REGEX = "QE'<WvG=VHJ>XYKLF83TC6PDO51%U47MS#bN:R&I!BA/,-Z";
		BaseTokenizer tokenizer = new BaseTokenizer();
		String dictionaryLinesOut = null;
		

		List<String> tokens = tokenizer.tokenizeTextFromFile("resources/dictionaries/Rx-Norm/RxNorm_DisplayNames.txt");
		List<String> tokens1 = tokenizer.tokenizeTextFromFile("resources/dictionaries/Other/prescription_medications.txt");
		List<String> newDictionaryTokens = new LinkedList<String>();
			
		for (int j = 0; j < tokens.size(); j++) {
			
			String token = tokens.get(j);
				
			try {
				
				if(EMAIL_REGEX.matches(token) || OTHER_REGEX.contains(token)) {
					
					dictionaryLinesOut = dictionaryLinesOut + "\n";
				}
				
				else if(!newDictionaryTokens.contains(token.charAt(0) + token.substring(1).toLowerCase()))  {
					
					dictionaryLinesOut = dictionaryLinesOut + " " + token.charAt(0) + token.substring(1).toLowerCase() + "\n";
					newDictionaryTokens.add(token.charAt(0) + token.substring(1).toLowerCase());
				}
			}
			
			catch(Exception e) {
				
				continue;
			}
			
		}
		
		for (int j = 0; j < tokens1.size(); j++) {
			
			String token = tokens1.get(j);
				
			try {
				
				if(EMAIL_REGEX.matches(token) || OTHER_REGEX.contains(token)) {
					
					dictionaryLinesOut = dictionaryLinesOut + "\n";
				}
				
				else if(!newDictionaryTokens.contains(token.charAt(0) + token.substring(1).toLowerCase()))  {
					
					dictionaryLinesOut = dictionaryLinesOut + " " + token.charAt(0) + token.substring(1).toLowerCase() + "\n";
					newDictionaryTokens.add(token.charAt(0) + token.substring(1).toLowerCase());
				}
			}
			
			catch(Exception e) {
				
				continue;
			}
			
		}
		
		outDictionary.write(dictionaryLinesOut);
		outDictionary.close();
		
	}
	
}