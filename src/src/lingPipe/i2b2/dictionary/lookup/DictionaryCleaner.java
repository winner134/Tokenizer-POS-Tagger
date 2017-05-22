package src.lingPipe.i2b2.dictionary.lookup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import src.lingPipe.i2b2.tokenizers.BaseTokenizer;


public class DictionaryCleaner {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Scanner inDictionary = new Scanner(new BufferedReader(new FileReader("resources/dictionaries/Rx-Norm/RxTerms201401.txt")));
		BufferedWriter outDictionary =new BufferedWriter(new FileWriter("resources/dictionaries/Rx-Norm/RxTerms201401-1.txt"));
		List<String> dictionaryLines = new LinkedList<String>();
		final int ID_Length = 7;
		
		BaseTokenizer tokenizer = new BaseTokenizer();
		String dictionaryLinesOut= null;
		

		List<String> tokens = tokenizer.tokenizeTextFromFile("resources/dictionaries/Rx-Norm/RxTerms201401.txt");
			
		for (int j = 0; j < tokens.size(); j++) {
			
			String token = tokens.get(j);
				
			try {
					
				Integer id = Integer.parseInt(token);
				
				if(id != null && token.length() != ID_Length) {
					
					dictionaryLinesOut = dictionaryLinesOut + " " + token;
				}
			}
				
			catch(NumberFormatException e) {
				
				try {
					
					if(token.equalsIgnoreCase("|") || token.equalsIgnoreCase("/"))
						dictionaryLinesOut = dictionaryLinesOut + "\n";
					
					if(!dictionaryLinesOut.contains(token) && !token.equalsIgnoreCase("|") && !token.equalsIgnoreCase("/") && 
							!token.equalsIgnoreCase(".") && !token.equalsIgnoreCase(",") && !token.equalsIgnoreCase("p")
							&& !token.equalsIgnoreCase("o")) {
						
						dictionaryLinesOut = dictionaryLinesOut + " " + token;
					}
				}
				
				catch(NullPointerException e1) {
					continue;
				}
			
				//System.out.println(" j = " + j);
				//System.out.println(dictionaryLinesOut);
				continue;
			}
				
		}
		
		//System.out.println(dictionaryLinesOut);
		outDictionary.write(dictionaryLinesOut);
		outDictionary.close();
	}

}
