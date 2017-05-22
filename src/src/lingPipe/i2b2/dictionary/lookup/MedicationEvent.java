package src.lingPipe.i2b2.dictionary.lookup;

import java.util.LinkedList;
import java.util.List;

public class MedicationEvent {

	private String medicationSentence;
	private List<String> medications;
	private List<String> medicationEvents;
	
	public MedicationEvent() {
		
		medicationSentence = new String("");
		medications = new LinkedList<String>();
		medicationEvents = new LinkedList<String>();
	}
	
	public void setMedicationSentence(String sentence) {
		
		medicationSentence = sentence;
	}
	
	public void addMedication(String medication) {
		
		medications.add(medication);
	}
	
	public void addMedicationEvent(String medEvent) {
		
		if(!medicationEvents.contains(medEvent) && !medEvent.contains(",") &&
				!medEvent.contains(":") && !medEvent.contains(".") && !medEvent.contains("which")) 
			medicationEvents.add(medEvent);
	}
	
	public void pruneMedEvents() {
		
		String medEvent = new String("");
		
		for (int i = 0; i < medicationEvents.size(); i++) {
			
			medEvent = medicationEvents.get(i);
			
			if (!medEvent.contains("qd")
					&& (((!medEvent.contains("po") && !medEvent.contains("sodium")) || (!medEvent.contains("po") && medEvent.contains("sodium")
				        && !medEvent.contains("139"))) || (medEvent.contains("po") && !medEvent.contains("tid") && !medEvent.contains("bid")
						&& !medEvent.contains("prn") && !medEvent.contains("q4h")))) {
			
				medicationEvents.remove(medEvent);
			}
		
		}
	}

	public List<String> getMedicationEvents() {
		return medicationEvents;
	}

	public String getMedicationSentence() {
		return medicationSentence;
	}

	public List<String> getMedications() {
		return medications;
	}

	
}
