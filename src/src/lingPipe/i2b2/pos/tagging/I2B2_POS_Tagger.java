package src.lingPipe.i2b2.pos.tagging;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.aliasi.hmm.HiddenMarkovModel;
import com.aliasi.hmm.HmmDecoder;
import com.aliasi.tag.Tagging;
import com.aliasi.util.Streams;

public class I2B2_POS_Tagger {
	
	private HmmDecoder decoder;
	
	public I2B2_POS_Tagger() throws ClassNotFoundException, IOException {
		
		readPOS_Model();
	}
	
	public Tagging<String> tagText(List<String> tokens) {
		
		Tagging<String> tagging = decoder.tag(tokens);
		
		for (int i = 0; i < tagging.size(); ++i)
		    System.out.println(tagging.token(i) + "_" + tagging.tag(i) + " ");
		
		return tagging;
	}

	private void readPOS_Model() throws IOException, ClassNotFoundException {
		
		FileInputStream fileIn = new FileInputStream("resources/hmm/pos-en-bio-medpost.HiddenMarkovModel");
		ObjectInputStream objIn = new ObjectInputStream(fileIn);
		HiddenMarkovModel hmm = (HiddenMarkovModel) objIn.readObject();
		Streams.closeInputStream(objIn);
		decoder = new HmmDecoder(hmm);
	}
}