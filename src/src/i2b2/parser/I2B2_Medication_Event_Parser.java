package src.i2b2.parser;

import java.util.List;

import src.lingPipe.i2b2.dictionary.lookup.MedicationEvent;
import src.lingPipe.i2b2.tokenizers.BaseTokenizer;

public class I2B2_Medication_Event_Parser {
	
	private List<MedicationEvent> medicationSentences;
	public static final String MODE_OF_ADMINSTRATION = "p.o., drip, IV, sublingual, subcutaneously, po topical sq iv sl pr im pv each "
			+ "nostril nasal ou use as directed";
	public static final String DOSAGE = "mg a day, low dose, one unit, 500 units cc tab tabs tablet tablets caps units mcg puff puffs spray "
			+ "sprays mEq IU OU teaspoon teaspoons tablespoon tablespoons whiffs gtt capsule capsules sniff sniffs scoop grain "
			+ "grains g gm gms gram grams meq";
	public static final String FREQUENCY = "q.h.s. , b.i.d. , QID, daily , t.i.d. , as needed, QHS qd-bid qd bid-tid bid tid-qid tid qid qod q2hr q4hr "
			+ "q4-6hr q6hr q8hr q12hr q24hr qwk qod qam qpm qhs qmonth q3hr q4-6hr twice daily once a week [0-9]+ a day [0-9]+ per day";
	public static final String DURATION = "for less than a year, X 12 doses, x5 days, five days, x3 doses, for 48 hours, for "
			+ "the 7-day period";
	
	private boolean DISABLE_RULE_E;
	private boolean DISABLE_RULE_K;
	private boolean DISABLE_RULE_B;
	private boolean DISABLE_RULE_C;
	private boolean DISABLE_RULE_D;
	private boolean DISABLE_RULE_F;
	private boolean DISABLE_RULE_G;
	
	private String DRUG_AMOUNT_PATTERN = new String("^([0-9]{1,2}(\\.[0-9])?)()*$");

	public List<MedicationEvent> parseMedicationSentences(List<MedicationEvent> medSentences) throws Exception {
		
		medicationSentences = medSentences;
		String medicationSentence = new String("");
		
		for (int i = 0; i < medicationSentences.size(); i++) {
			
			medicationSentence = medicationSentences.get(i).getMedicationSentence();
			
			for(int j = 0; j < medicationSentences.get(i).getMedications().size(); j++) {
				
				String medication = medicationSentences.get(i).getMedications().get(j);
				String possibleMedEvents = medicationSentence.split(medication)[0];
				String possibleMedEvents1 = medicationSentence.split(medication)[1];
				
				analyzePattern(possibleMedEvents, possibleMedEvents1, i, medication);
			}
		}
		
		for(int i = 0; i < medicationSentences.size(); i++) {
			
			medicationSentences.get(i).pruneMedEvents();
		}
		
		return medicationSentences;
		
	}
	
	private String convertStringListToString(List<String> list) {
		
		String str = "";
		
		for(int i = 0; i < list.size(); i++) {
			
			str.concat(list.get(i) + "");
		}
		
		return str;
	}
	
	private void analyzePattern(String beforeMed, String afterMed, int index, String medication) throws Exception {
		
		BaseTokenizer tokenizer = new BaseTokenizer();
		
		List<String> afterMedTokens = tokenizer.tokenizeText(afterMed);
		List<String> beforeMedTokens = tokenizer.tokenizeText(beforeMed);
		
		DISABLE_RULE_E = false;
		DISABLE_RULE_K = false;
		DISABLE_RULE_B = false;
		DISABLE_RULE_C = false;
		DISABLE_RULE_D = false;
		DISABLE_RULE_F = false;
		DISABLE_RULE_G = false;
		analyzeAfterMedPatterns(afterMedTokens, index, medication);
		analyzeBeforeAndAfterMedPattern(beforeMedTokens, afterMedTokens, index, medication);
		analyzeBeforeMedPatterns(beforeMedTokens, index, medication);
	}
	
	private void analyzeAfterMedPatterns(List<String> afterMedTokens, int index, String medication) {
		
		String afterMedPattern = this.convertStringListToString(afterMedTokens);
		
		try {
			
			Integer possibleDosage = Integer.parseInt(afterMedTokens.get(0));
			
			/** Rule J0*/
			//System.out.println("Rule J0 Checked");
			
			try {
				
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && MODE_OF_ADMINSTRATION.contains(afterMedPattern.toLowerCase()) && 
						FREQUENCY.contains(afterMedPattern.toLowerCase()) && DURATION.contains(afterMedPattern.toLowerCase())) {
				
					medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2) + " " + afterMedTokens.get(3) + afterMedTokens.get(4));
				
					DISABLE_RULE_E = true;
					DISABLE_RULE_B = true;
					DISABLE_RULE_K = true;
				
				//	System.out.println("Rule J0 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule J0 FAILURE");
			}
			
			/** Rule B0 */
			//System.out.println("Rule B0 Checked");
			
			try {
				
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && MODE_OF_ADMINSTRATION.contains(afterMedPattern.toLowerCase()) 
						&& FREQUENCY.contains(afterMedPattern.toLowerCase()) && !DISABLE_RULE_B) {
				
					medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2) + " " + afterMedTokens.get(3));
				
			    	DISABLE_RULE_E = true;
					DISABLE_RULE_K = true;
				
				//	System.out.println("Rule B0 Fired" + " Sentence " + (index+1));
				}
			
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule B0 FAILURE");
			}
			
			/** Rule L0*/
			//System.out.println("Rule L0 Checked");
			
			try{
				
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && FREQUENCY.contains(afterMedPattern.toLowerCase()) 
						&& DURATION.contains(afterMedPattern.toLowerCase())) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2)  + " " + afterMedTokens.get(3));
					
					DISABLE_RULE_E = true;
					DISABLE_RULE_C = true;
					
				//	System.out.println("Rule L0 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule L0 FAILURE");
			}
			
			/** Rule C0 */
			//System.out.println("Rule C0 Checked");
			
			try {
				
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && !DISABLE_RULE_C && (FREQUENCY.contains(afterMedPattern.toLowerCase())
						|| (FREQUENCY.contains(afterMedPattern.toLowerCase())) || (FREQUENCY.contains(afterMedPattern.toLowerCase()))
						|| (FREQUENCY.contains(afterMedPattern.toLowerCase())))) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2));
					
					medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2) + " " + afterMedTokens.get(3));
					
					medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2) + " " + afterMedTokens.get(3) + " " + afterMedTokens.get(4));
					
					medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2) + " " + afterMedTokens.get(3) + " " + afterMedTokens.get(4)
							+ " " + afterMedTokens.get(5));
					
					DISABLE_RULE_E = true;
					
					//System.out.println("Rule C0 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule C0 FAILURE");
			}
			
			/** Rule K0*/
			//System.out.println("Rule K0 Checked");
			
			try{
				
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && MODE_OF_ADMINSTRATION.contains(afterMedPattern.toLowerCase()) && 
						!DISABLE_RULE_K) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2));
					
					DISABLE_RULE_E = true;
					
					//System.out.println("Rule K0 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule K0 FAILURE");
			}
			
			/** Rule T0*/
			//System.out.println("Rule T0 Checked");
			
			try{
				
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && DURATION.contains(afterMedPattern.toLowerCase())) {
					
					if (afterMedTokens.get(2).toLowerCase() == "p") {
						medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
								afterMedTokens.get(1) + " " + "p.o.");
						medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
								afterMedTokens.get(1) + " " + "p.o. " + afterMedTokens.get(6));
						medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
								afterMedTokens.get(1) + " " + "p.o. " + afterMedTokens.get(6) + " " + afterMedTokens.get(7));
					}
					
					else {
						
						medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
								afterMedTokens.get(1) + " " + afterMedTokens.get(2));
						medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
								afterMedTokens.get(1) + " " + afterMedTokens.get(2) + " " + afterMedTokens.get(6));
						medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
								afterMedTokens.get(1) + " " + afterMedTokens.get(2) + " " + afterMedTokens.get(6) + " " + afterMedTokens.get(7));
					}
					
					DISABLE_RULE_E = true;
					
					//System.out.println("Rule T0 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule T0 FAILURE");
			}
			
			
			/** Rule E0 */
			//System.out.println("Rule E0 Checked");
			
			try{
				
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && !DISABLE_RULE_E) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " + possibleDosage.toString() + " " +
							afterMedTokens.get(1));
					
				//	System.out.println("Rule E0 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule E0 FAILURE");
			}
			
		}
		
		catch(Exception e) {
			
			/** Rule J1*/
			//System.out.println("Rule J1 Checked");
			
			try{
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && MODE_OF_ADMINSTRATION.contains(afterMedPattern.toLowerCase()) && 
						FREQUENCY.contains(afterMedPattern.toLowerCase()) && DURATION.contains(afterMedPattern.toLowerCase())) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " +
							afterMedTokens.get(0) + " " + afterMedTokens.get(1) + " " + afterMedTokens.get(2) + " " + afterMedTokens.get(3));
					
					DISABLE_RULE_E = true;
					DISABLE_RULE_B = true;
					DISABLE_RULE_K = true;
					
					//System.out.println("Rule J1 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule J1 FAILURE");
			}
			
			/** Rule B1*/
			//System.out.println("Rule B1 Checked");
			
			try{
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && MODE_OF_ADMINSTRATION.contains(afterMedPattern.toLowerCase()) 
						&& FREQUENCY.contains(afterMedPattern.toLowerCase()) && !DISABLE_RULE_B) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " +
							afterMedTokens.get(0) + " " + afterMedTokens.get(1) + " " + afterMedTokens.get(2));
					
					DISABLE_RULE_E = true;
					DISABLE_RULE_K = true;
					
				//	System.out.println("Rule B1 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule B1 FAILURE");
			}
			
			/** Rule L1*/
			//System.out.println("Rule L1 Checked");
			
			try{
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && FREQUENCY.contains(afterMedPattern.toLowerCase()) 
						&& DURATION.contains(afterMedPattern.toLowerCase())) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " +
							afterMedTokens.get(0) + " " + afterMedTokens.get(1)  + " " + afterMedTokens.get(2));
					
					DISABLE_RULE_E = true;
					DISABLE_RULE_C = true;
					
				//	System.out.println("Rule L1 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule L1 FAILURE");
			}
			
			/** Rule C1 */
			//System.out.println("Rule C1 Checked");
			
			try {
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && !DISABLE_RULE_C && ((FREQUENCY.contains(afterMedPattern.toLowerCase()))||
						(FREQUENCY.contains(afterMedPattern.toLowerCase())) || (FREQUENCY.contains(afterMedPattern.toLowerCase()))
						|| (FREQUENCY.contains(afterMedPattern.toLowerCase())))) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2));
					
					medicationSentences.get(index).addMedicationEvent(medication + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2) + " " + afterMedTokens.get(3));
					
					medicationSentences.get(index).addMedicationEvent(medication + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2) + " " + afterMedTokens.get(3) + " " + afterMedTokens.get(4));
					
					medicationSentences.get(index).addMedicationEvent(medication + " " +
							afterMedTokens.get(1) + " " + afterMedTokens.get(2) + " " + afterMedTokens.get(3) + " " + afterMedTokens.get(4)
							+ " " + afterMedTokens.get(5));
					
					DISABLE_RULE_E = true;
					
				//	System.out.println("Rule C1 Fired" + " Sentence " + (index+1));
				}	
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule C1 FAILURE");
			}
			
			/** Rule O OR Rule P */
			//System.out.println("Rule P/O Checked");
			
			try{
				if(MODE_OF_ADMINSTRATION.contains(afterMedPattern.toLowerCase()) && FREQUENCY.contains(afterMedPattern.toLowerCase())) {
					
					try {
						
						Integer possibleDosage = Integer.parseInt(afterMedTokens.get(2));
						
						/** Rule P0*/
					//	System.out.println("Rule P0 Checked");
						if(DOSAGE.contains(afterMedPattern.toLowerCase()) && FREQUENCY.contains(afterMedPattern.toLowerCase())) {
							
							medicationSentences.get(index).addMedicationEvent(medication + " " + afterMedTokens.get(1) + " " + afterMedTokens.get(2) +
									" " + possibleDosage.toString() + " " + afterMedTokens.get(4) + afterMedTokens.get(5));
							
							DISABLE_RULE_D = true;
							
						//	System.out.println("Rule P0 Fired" + " Sentence " + (index+1));
						}
					}
					
					
					catch(Exception e2) {
						
						/** Rule O*/
						medicationSentences.get(index).addMedicationEvent(medication + " " + afterMedTokens.get(0) + " " + afterMedTokens.get(1));
						
						DISABLE_RULE_D = true;
						
						//System.out.println("Rule O Fired");
						
						/** Rule P1*/
						//System.out.println("Rule P1 Checked");
						if(DOSAGE.contains(afterMedPattern.toLowerCase())) {
							
							medicationSentences.get(index).addMedicationEvent(medication + " " + afterMedTokens.get(0) + " " + afterMedTokens.get(1) +
									" " + afterMedTokens.get(2));
							
							//System.out.println("Rule P1 Fired" + " Sentence " + (index+1));
						}
					}
					
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
			
				//System.out.println("Rule P/O FAILURE");
			}
			
			/** Rule D*/
			//System.out.println("Rule D Checked");
			try {
				if(MODE_OF_ADMINSTRATION.contains(afterMedPattern.toLowerCase()) && !DISABLE_RULE_D) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " + afterMedTokens.get(0));
					
					//System.out.println("Rule D Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule D FAILURE");
			}
			
			/** Rule K1*/
			//System.out.println("Rule K1 Checked");
			try {
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && MODE_OF_ADMINSTRATION.contains(afterMedPattern.toLowerCase()) &&
						!DISABLE_RULE_K) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " "  +
							afterMedTokens.get(0) + " " + afterMedTokens.get(1));
					
					DISABLE_RULE_E = true;
					
					//System.out.println("Rule K1 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule K1 FAILURE");
			}
			
			/** Rule T1*/
			//System.out.println("Rule T1 Checked");
			try {
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && DURATION.contains(afterMedPattern.toLowerCase())) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " + afterMedTokens.get(0) + " " + afterMedTokens.get(1));
					
					DISABLE_RULE_E = true;
					
					//System.out.println("Rule T1 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule T1 FAILURE");
			}
			
			/** Rule E1*/
			//System.out.println("Rule E1 Checked");
			try {
				if(afterMedPattern.toLowerCase() == "alternating" && afterMedPattern.toLowerCase() == "doses" && 
						afterMedPattern.toLowerCase() == "of" && !DISABLE_RULE_E) {
					
					try {
						
						Integer possibleDosage = Integer.parseInt(afterMedTokens.get(3));
						
						if(DOSAGE.contains(afterMedPattern.toLowerCase())) {
							medicationSentences.get(index).addMedicationEvent(medication + " alternating doses of " + possibleDosage.toString() + " " +
									afterMedTokens.get(4));
				//			System.out.println("Rule E1 Fired" + " Sentence " + (index+1));
						}
					}
					
					catch(NumberFormatException e1) {
						
					//	System.out.println("Rule E1 FAILURE");
					}
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule E1 FAILURE");
			}
			
			/** Rule E2 */
			//System.out.println("Rule E2 Checked");
			
			try {
				if(DOSAGE.contains(afterMedPattern.toLowerCase()) && !DISABLE_RULE_E) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " +
							afterMedTokens.get(0));
					
				//	System.out.println("Rule E2 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule E2 FAILURE");
			}
			
			/** Rule H*/
			//System.out.println("Rule H Checked");
			try {
				if(DURATION.contains(afterMedPattern.toLowerCase())) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " + afterMedTokens.get(0));
					
				//	System.out.println("Rule H Fired");
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule H FAILURE");
			}
			
			/** Rule I*/
			//System.out.println("Rule I Checked");
			
			try {
				if(FREQUENCY.contains(afterMedPattern.toLowerCase())) {
					
					medicationSentences.get(index).addMedicationEvent(medication + " " + afterMedTokens.get(0));
					
				//	System.out.println("Rule I Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule I FAILURE");
			}
			
		}
		
		/**Rule U*/
		//System.out.println("Rule U Checked");
		try {
			
			Integer possibleDosage = Integer.parseInt(afterMedTokens.get(1));
			
			medicationSentences.get(index).addMedicationEvent(medication + " of " + possibleDosage.toString());
			//System.out.println("Rule U Fired" + " Sentence " + (index+1));
		}
		
		catch(Exception e6) {
			
			//System.out.println("Rule U FAILURE");
		}
		
	}
	
	private void analyzeBeforeMedPatterns(List<String> beforeMedTokens, int index, String medication) {
		
		String beforeMedPattern = this.convertStringListToString(beforeMedTokens);
		
		/** Rule F*/
		//System.out.println("Rule F Checked");
		try {
			if(MODE_OF_ADMINSTRATION.contains(beforeMedPattern.toLowerCase()) && !DISABLE_RULE_F) {
				
				medicationSentences.get(index).addMedicationEvent(beforeMedTokens.get(beforeMedTokens.size() - 1) + " " + medication);
				
			//	System.out.println("Rule F Fired" + " Sentence " + (index+1));
			}
		}
		
		catch(IndexOutOfBoundsException iob) {
			
			//System.out.println("Rule F FAILURE");
		}
		
		/** Rule M*/
		//System.out.println("Rule M Checked");
		try {
			if(DURATION.contains(beforeMedPattern.toLowerCase())) {
				
				medicationSentences.get(index).addMedicationEvent(beforeMedTokens.get(beforeMedTokens.size() - 1) + " " + medication);
				
			//	System.out.println("Rule M Fired" + " Sentence " + (index+1));
			}
		}
		
		catch(IndexOutOfBoundsException iob) {
			
			//System.out.println("Rule M FAILURE");
		}
		
		/** Rule N*/
		//System.out.println("Rule N Checked");
		try {
			if(FREQUENCY.contains(beforeMedPattern.toLowerCase())) {
				
				medicationSentences.get(index).addMedicationEvent(beforeMedTokens.get(beforeMedTokens.size() - 1) + " " + medication);
				
				//System.out.println("Rule N Fired" + " Sentence " + (index+1));
			}
		}
		
		catch(IndexOutOfBoundsException iob) {
			
			//System.out.println("Rule N FAILURE");
		}
		
		try {
			
			Integer possibleDosage = Integer.parseInt(beforeMedTokens.get(beforeMedTokens.size() - 3));
			
			/** Rule G0 */
			//System.out.println("Rule G0 Checked");
			try {
				if(DOSAGE.contains(beforeMedPattern.toLowerCase()) && !DISABLE_RULE_G) {
					
					medicationSentences.get(index).addMedicationEvent(possibleDosage.toString() + " " +
							beforeMedTokens.get(beforeMedTokens.size() - 2) + " of " + medication);
					
				//	System.out.println("Rule G0 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule G0 FAILURE");
			}
		}
		
		catch(Exception e3) {
			
			/** Rule G1 */
			//System.out.println("Rule G1 Checked");
			
			try {
				if(DOSAGE.contains(beforeMedPattern.toLowerCase()) && !DISABLE_RULE_G) {
					
					medicationSentences.get(index).addMedicationEvent(beforeMedTokens.get(beforeMedTokens.size() - 2) + " " +
							 " of " + medication);
					
				//	System.out.println("Rule G1 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule G1 FAILURE");
			}
		}
		
		try {
			
			Integer possibleDosage = Integer.parseInt(beforeMedTokens.get(beforeMedTokens.size() - 4));
			
			/** Rule Q0*/
			//System.out.println("Rule Q0 Checked");
			try {
				if(DOSAGE.contains(beforeMedPattern.toLowerCase()) &&
						MODE_OF_ADMINSTRATION.contains(beforeMedPattern.toLowerCase())) {
					
					medicationSentences.get(index).addMedicationEvent(possibleDosage.toString() + " " +
							beforeMedTokens.get(beforeMedTokens.size() - 3) + " of " + beforeMedTokens.get(beforeMedTokens.size() - 2) + 
							" " + medication);
					
				//	System.out.println("Rule Q0 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule Q0 FAILURE");
			}
		}
		
		catch(Exception e4) {
			
			/** Rule Q1*/
			//System.out.println("Rule Q1 Checked");
			try{
				if(DOSAGE.contains(beforeMedPattern.toLowerCase()) &&
						MODE_OF_ADMINSTRATION.contains(beforeMedPattern.toLowerCase())) {
					
					medicationSentences.get(index).addMedicationEvent(beforeMedTokens.get(beforeMedTokens.size() - 3) + " of " + 
					beforeMedTokens.get(beforeMedTokens.size() - 2) + " " + medication);
					
				//	System.out.println("Rule Q1 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule Q1 FAILURE");
			}
		}
	}
	
	private void analyzeBeforeAndAfterMedPattern(List<String> beforeMedTokens, List<String> afterMedTokens, int index, String medication) 
			throws IndexOutOfBoundsException {
		
		String beforeMedPattern = this.convertStringListToString(beforeMedTokens);
		String afterMedPattern = this.convertStringListToString(afterMedTokens);
		
		/** Rule R*/
		//System.out.println("Rule R Checked");
		try {
			if(MODE_OF_ADMINSTRATION.contains(beforeMedPattern.toLowerCase()) &&
					DURATION.contains(afterMedPattern.toLowerCase())) {
				
				medicationSentences.get(index).addMedicationEvent(beforeMedTokens.get(beforeMedTokens.size() - 1) + medication + " " + 
						afterMedTokens.get(0));
				
				DISABLE_RULE_F = true;
						
			//	System.out.println("Rule R Fired" + " Sentence " + (index+1));
			}
		}
		
		catch(IndexOutOfBoundsException iob) {
			
			//System.out.println("Rule R FAILURE");
		}
		
		try {
			
			Integer possibleDosage = Integer.parseInt(beforeMedTokens.get(beforeMedTokens.size() - 3));
			
			/**Rule S0*/
			//System.out.println("Rule S0 Checked");
			try {
				if(DOSAGE.contains(beforeMedPattern.toLowerCase()) && FREQUENCY.contains(afterMedPattern.toLowerCase())) {
					
					medicationSentences.get(index).addMedicationEvent(possibleDosage.toString() + " " +
							beforeMedTokens.get(beforeMedTokens.size() - 2) + " of " + medication + " " + afterMedTokens.get(0));
					
					DISABLE_RULE_G = true;
					
				//	System.out.println("Rule S0 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule S0 FAILURE");
			}
		}
		
		catch(Exception e5) {
			
			/**Rule S1*/
			//System.out.println("Rule S1 Checked");
			try {
				if(DOSAGE.contains(beforeMedPattern.toLowerCase()) && FREQUENCY.contains(afterMedPattern.toLowerCase())) {
					
					medicationSentences.get(index).addMedicationEvent(beforeMedTokens.get(beforeMedTokens.size() - 2) + " of " + medication + " " + 
					afterMedTokens.get(0));
					
					DISABLE_RULE_G = true;
					
				//	System.out.println("Rule S1 Fired" + " Sentence " + (index+1));
				}
			}
			
			catch(IndexOutOfBoundsException iob) {
				
				//System.out.println("Rule S1 FAILURE");
			}
		}
	}
}
