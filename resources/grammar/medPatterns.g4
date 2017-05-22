grammar medPatterns;

@members {

public String getTokenErrorDisplay(Token t) {
	return t.toString();
}

Stack paraphrases = new Stack();

public String getErrorMessage(RecognitionException e,
String[] tokenNames)
{
	String msg = super.getErrorMessage(e, tokenNames);
	if ( paraphrases.size()>0 ) {
	String paraphrase = (String)paraphrases.peek();
	msg = msg+" "+paraphrase;
	}
	return msg;
}

}



prog: program;

program: chunk | program chunk;

chunk: water | island;

island @init { paraphrases.push("in island"); }
@after { paraphrases.pop(); }
: dg_list;

dg_list @init { paraphrases.push("in dg_list"); }
@after { paraphrases.pop(); }
: dg | dg dg_list; 

dg @init { paraphrases.push("in dg"); }
@after { paraphrases.pop(); }
:dg_S_modes_SET | dg_M_modes_SET;  

dg_M_modes_SET @init { paraphrases.push("in dg_M_modes_SET"); }
@after { paraphrases.pop(); }
: med mod_set_list {System.out.println("found med mod_set_list: " + $med.text + " "  + $mod_set_list.text);}
| dg_L_MOD med mod_set_list {System.out.println("found dg_L_MOD med mod_set_list: " + $dg_L_MOD.text + " " + $med.text
	+ " " + $mod_set_list.text
);} 
| med mod_set_list dg_R_MOD {System.out.println("found med mod_set_list dg_R_MOD: " + $med.text + " "  + $mod_set_list.text
	+ " " + $dg_R_MOD.text
);};                              

dg_S_modes_SET @init { paraphrases.push("in dg_S_modes_SET"); }
@after { paraphrases.pop(); }
: med {System.out.println("found med " + $med.text);}
| med dg_R_MOD {System.out.println("found med dg_R_MOD: " + $med.text + " " + $dg_R_MOD.text);}
| dg_L_MOD med {System.out.println("found dg_L_MOD med: " + $dg_L_MOD.text + " " + $med.text);} 
| dg_L_MOD med dg_R_MOD {System.out.println("found dg_L_MOD med: " + $dg_L_MOD.text + " " + $med.text
	+ " " + $dg_R_MOD.text
);};            

mod_set_list @init { paraphrases.push("in mod_set_list"); }
@after { paraphrases.pop(); }
: mod_set mod_set | mod_set mod_set_list; 
   
dg_L_MOD @init { paraphrases.push("in dg_L_MOD"); }
@after { paraphrases.pop(); }
: dose | modes | drt | drt | freq | freq | dose freq | dose freq | freq | drt; 

dg_R_MOD : mod_set;  
 
mod_set @init { paraphrases.push("in mod_set"); }
@after { paraphrases.pop(); }
: dose | drt | freq | modes | dose freq | dose modes freq freq | dose freq reason | dose modes freq freq reason  
| dose freq drt | modes freq | modes | dose modes freq | dose modes freq drt | dose modes | modes dose freq | dose drt
| dose drt | INT;

dose @init { paraphrases.push("in dose"); }
@after { paraphrases.pop(); }
: INT unit | INT SPECIAL_CHAR_1 INT unit;

med @init { paraphrases.push("in med"); }
@after { paraphrases.pop(); }
: SpecialSymbol1 ID SpecialSymbol1;

freq @init { paraphrases.push("in freq"); }
@after { paraphrases.pop(); }
: SpecialSymbol2 ID SpecialSymbol2;

modes @init { paraphrases.push("in modes"); }
@after { paraphrases.pop(); }
: SpecialSymbol3 ID SpecialSymbol3; 

drt @init { paraphrases.push("in init"); }
@after { paraphrases.pop(); }: SpecialSymbol4  ID SpecialSymbol4;

unit @init { paraphrases.push("in unit"); }
@after { paraphrases.pop(); }
: SpecialSymbol5 ID SpecialSymbol5;

reason @init { paraphrases.push("in reason"); }
@after { paraphrases.pop(); }
: SpecialSymbol6 ID SpecialSymbol6;

water @init { paraphrases.push("in water"); }
@after { paraphrases.pop(); }
: ID | INT | SPECIAL_CHAR | SPECIAL_CHAR_1 | INT SPECIAL_CHAR_1  INT SPECIAL_CHAR_1 INT ID 
| INT SPECIAL_CHAR_1 ID 
| INT SPECIAL_CHAR_1 INT ID         
| INT SPECIAL_CHAR_1 INT SPECIAL_CHAR_1 INT 
| INT SPECIAL_CHAR_1 INT SPECIAL_CHAR_1 INT SPECIAL_CHAR_1 INT 
| INT SPECIAL_CHAR_1 INT SPECIAL_CHAR_1 INT SPECIAL_CHAR_1 INT SPECIAL_CHAR_1 INT;  

// START:tokens
ID  :   ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ; 
SPECIAL_CHAR : ';' | ':' | '+' | '=' | '&' | '<' | '>' | '*'
| '!' |  '%' | '?' | '&' | '@' | '[' | ']' | '.' | '(' | ')' | '#' | '^' | '$'
| '{' | '}' | ',' | '.' | '(' | ')' | '|' | '/' | '_' | '"';
SPECIAL_CHAR_1: '-';
SpecialSymbol1: 'MED';
SpecialSymbol2: 'FREQ';
SpecialSymbol3: 'MODE' ; 
SpecialSymbol4: 'DRT';
SpecialSymbol5: 'UNIT'; 
SpecialSymbol6: 'REASON';   
WS : [ \t]+ -> skip ;