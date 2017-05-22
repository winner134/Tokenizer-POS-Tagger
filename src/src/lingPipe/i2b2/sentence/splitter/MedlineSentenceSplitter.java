package src.lingPipe.i2b2.sentence.splitter;

import java.util.LinkedList;
import java.util.List;

import com.aliasi.sentences.MedlineSentenceModel;
import com.aliasi.sentences.SentenceModel;

public class MedlineSentenceSplitter {

	private static MedlineSentenceSplitter instance = null;
	private SentenceModel SENTENCE_MODEL  = new MedlineSentenceModel();
	private List<String> dischargeSummarySentences;
	
	public static MedlineSentenceSplitter getMedLineSentenceSplitter() {
		
		if (instance == null) {
        	instance = new MedlineSentenceSplitter();
		}
		
		return instance;
	}
	
	private MedlineSentenceSplitter() {
		
	}
	
	public List<String> getSentences(List<String> tokenList, List<String> whiteSpaceList) {
		
		String[] tokens = convertListToStringArray(tokenList);
		String[] whites = convertListToStringArray(whiteSpaceList);
		dischargeSummarySentences = new LinkedList<String>();
		
		int[] sentenceBoundaries = SENTENCE_MODEL.boundaryIndices(tokens, whites);

		System.out.println(sentenceBoundaries.length 
				   + " SENTENCE END TOKEN OFFSETS");
			
		if (sentenceBoundaries.length < 1) {
		    System.out.println("No sentence boundaries found.");
		    return null;
		}
		
		int sentStartTok = 0;
		int sentEndTok = 0;
		String sentence;
		
		for (int i = 0; i < sentenceBoundaries.length; ++i) {
			
		    sentEndTok = sentenceBoundaries[i];
		    System.out.println("SENTENCE "+(i+1)+": ");
		    sentence = "";
		    
		    for (int j=sentStartTok; j<=sentEndTok; j++) {
		    	
		    	System.out.print(tokens[j]+whites[j+1]);
		    	sentence = sentence + tokens[j]+whites[j+1];
		    }
		    
		    dischargeSummarySentences.add(sentence);
		    System.out.println();
		    sentStartTok = sentEndTok+1;
		}
		
		return dischargeSummarySentences;
	}
	
	private String[] convertListToStringArray(List<String> list) {
		
		String[] array = new String[list.size()];
		
		for(int i = 0; i < list.size(); i++) {
			
			array[i] = list.get(i);
		}
		
		return array;
	}
}
