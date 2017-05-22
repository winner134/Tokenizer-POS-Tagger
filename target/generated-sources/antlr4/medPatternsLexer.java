// Generated from medPatterns.g4 by ANTLR 4.2.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class medPatternsLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, INT=2, SPECIAL_CHAR=3, SPECIAL_CHAR_1=4, SpecialSymbol1=5, SpecialSymbol2=6, 
		SpecialSymbol3=7, SpecialSymbol4=8, SpecialSymbol5=9, SpecialSymbol6=10, 
		WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"ID", "INT", "SPECIAL_CHAR", "'-'", "'MED'", "'FREQ'", "'MODE'", "'DRT'", 
		"'UNIT'", "'REASON'", "WS"
	};
	public static final String[] ruleNames = {
		"ID", "INT", "SPECIAL_CHAR", "SPECIAL_CHAR_1", "SpecialSymbol1", "SpecialSymbol2", 
		"SpecialSymbol3", "SpecialSymbol4", "SpecialSymbol5", "SpecialSymbol6", 
		"WS"
	};



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



	public medPatternsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "medPatterns.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\rL\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\6\2\33\n\2\r\2\16\2\34\3\3\6\3 \n\3\r\3\16\3!\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\6\fG\n\f\r\f\16\fH\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\3\2\5\4\2C\\c|\t\2#(*.\60\61<B]]_a}\177\4\2\13\13\"\"N\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3"+
		"\32\3\2\2\2\5\37\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2\r+\3\2\2\2"+
		"\17\60\3\2\2\2\21\65\3\2\2\2\239\3\2\2\2\25>\3\2\2\2\27F\3\2\2\2\31\33"+
		"\t\2\2\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\4"+
		"\3\2\2\2\36 \4\62;\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\""+
		"\6\3\2\2\2#$\t\3\2\2$\b\3\2\2\2%&\7/\2\2&\n\3\2\2\2\'(\7O\2\2()\7G\2\2"+
		")*\7F\2\2*\f\3\2\2\2+,\7H\2\2,-\7T\2\2-.\7G\2\2./\7S\2\2/\16\3\2\2\2\60"+
		"\61\7O\2\2\61\62\7Q\2\2\62\63\7F\2\2\63\64\7G\2\2\64\20\3\2\2\2\65\66"+
		"\7F\2\2\66\67\7T\2\2\678\7V\2\28\22\3\2\2\29:\7W\2\2:;\7P\2\2;<\7K\2\2"+
		"<=\7V\2\2=\24\3\2\2\2>?\7T\2\2?@\7G\2\2@A\7C\2\2AB\7U\2\2BC\7Q\2\2CD\7"+
		"P\2\2D\26\3\2\2\2EG\t\4\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IJ"+
		"\3\2\2\2JK\b\f\2\2K\30\3\2\2\2\6\2\34!H\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}