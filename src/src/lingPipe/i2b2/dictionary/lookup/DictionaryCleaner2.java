package src.lingPipe.i2b2.dictionary.lookup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryCleaner2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner inDictionary = new Scanner(new BufferedReader(new FileReader("resources/dictionaries/other/healthCanada.txt")));
		BufferedWriter outDictionary =new BufferedWriter(new FileWriter("resources/dictionaries/other/healthCanadaModified.txt"));
		
		int counter = 0;
		
		while(inDictionary.hasNextLine()) {
		
			if(counter < 5)
				outDictionary.write("\'" + inDictionary.nextLine().trim() + "\' | ");
			counter++;
			
			if(counter == 5) {
				counter = 0;
				outDictionary.write("\'" + inDictionary.nextLine().trim() + "\'");
				outDictionary.newLine();
				outDictionary.write(" | ");
			}
		}
		
		inDictionary.close();
		outDictionary.close();
	}

}
