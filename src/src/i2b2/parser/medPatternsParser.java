// Generated from medPatterns.g4 by ANTLR 4.2.2
package src.i2b2.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class medPatternsParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, INT=2, SPECIAL_CHAR=3, SPECIAL_CHAR_1=4, SpecialSymbol1=5, SpecialSymbol2=6, 
		SpecialSymbol3=7, SpecialSymbol4=8, SpecialSymbol5=9, SpecialSymbol6=10, 
		WS=11;
	public static final String[] tokenNames = {
		"<INVALID>", "ID", "INT", "SPECIAL_CHAR", "'-'", "'MED'", "'FREQ'", "'MODE'", 
		"'DRT'", "'UNIT'", "'REASON'", "WS"
	};
	public static final int
		RULE_prog = 0, RULE_program = 1, RULE_chunk = 2, RULE_island = 3, RULE_dg_list = 4, 
		RULE_dg = 5, RULE_dg_M_modes_SET = 6, RULE_dg_S_modes_SET = 7, RULE_mod_set_list = 8, 
		RULE_dg_L_MOD = 9, RULE_dg_R_MOD = 10, RULE_mod_set = 11, RULE_dose = 12, 
		RULE_med = 13, RULE_freq = 14, RULE_modes = 15, RULE_drt = 16, RULE_unit = 17, 
		RULE_reason = 18, RULE_water = 19;
	public static final String[] ruleNames = {
		"prog", "program", "chunk", "island", "dg_list", "dg", "dg_M_modes_SET", 
		"dg_S_modes_SET", "mod_set_list", "dg_L_MOD", "dg_R_MOD", "mod_set", "dose", 
		"med", "freq", "modes", "drt", "unit", "reason", "water"
	};

	@Override
	public String getGrammarFileName() { return "medPatterns.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public String getTokenErrorDisplay(Token t) {
		return t.toString();
	}

	Stack paraphrases = new Stack();

	public String getErrorMessage(RecognitionException e,
	String[] tokenNames)
	{
		String msg = new String("");//super.getErrorMessage(e, tokenNames);
		if ( paraphrases.size()>0 ) {
		String paraphrase = (String)paraphrases.peek();
		msg = msg+" "+paraphrase;
		}
		return msg;
	}


	public medPatternsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); program(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public ChunkContext chunk() {
			return getRuleContext(ChunkContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		return program(0);
	}

	private ProgramContext program(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ProgramContext _localctx = new ProgramContext(_ctx, _parentState);
		ProgramContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_program, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(43); chunk();
			}
			_ctx.stop = _input.LT(-1);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ProgramContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_program);
					setState(45);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(46); chunk();
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ChunkContext extends ParserRuleContext {
		public WaterContext water() {
			return getRuleContext(WaterContext.class,0);
		}
		public IslandContext island() {
			return getRuleContext(IslandContext.class,0);
		}
		public ChunkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chunk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterChunk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitChunk(this);
		}
	}

	public final ChunkContext chunk() throws RecognitionException {
		ChunkContext _localctx = new ChunkContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_chunk);
		try {
			setState(54);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52); water();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53); island();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IslandContext extends ParserRuleContext {
		public Dg_listContext dg_list() {
			return getRuleContext(Dg_listContext.class,0);
		}
		public IslandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_island; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterIsland(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitIsland(this);
		}
	}

	public final IslandContext island() throws RecognitionException {
		IslandContext _localctx = new IslandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_island);
		 paraphrases.push("in island"); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); dg_list();
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dg_listContext extends ParserRuleContext {
		public DgContext dg() {
			return getRuleContext(DgContext.class,0);
		}
		public Dg_listContext dg_list() {
			return getRuleContext(Dg_listContext.class,0);
		}
		public Dg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dg_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterDg_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitDg_list(this);
		}
	}

	public final Dg_listContext dg_list() throws RecognitionException {
		Dg_listContext _localctx = new Dg_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dg_list);
		 paraphrases.push("in dg_list"); 
		try {
			setState(62);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58); dg();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59); dg();
				setState(60); dg_list();
				}
				break;
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DgContext extends ParserRuleContext {
		public Dg_M_modes_SETContext dg_M_modes_SET() {
			return getRuleContext(Dg_M_modes_SETContext.class,0);
		}
		public Dg_S_modes_SETContext dg_S_modes_SET() {
			return getRuleContext(Dg_S_modes_SETContext.class,0);
		}
		public DgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterDg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitDg(this);
		}
	}

	public final DgContext dg() throws RecognitionException {
		DgContext _localctx = new DgContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dg);
		 paraphrases.push("in dg"); 
		try {
			setState(66);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64); dg_S_modes_SET();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65); dg_M_modes_SET();
				}
				break;
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dg_M_modes_SETContext extends ParserRuleContext {
		public MedContext med;
		public Mod_set_listContext mod_set_list;
		public Dg_L_MODContext dg_L_MOD;
		public Dg_R_MODContext dg_R_MOD;
		public Dg_L_MODContext dg_L_MOD() {
			return getRuleContext(Dg_L_MODContext.class,0);
		}
		public Dg_R_MODContext dg_R_MOD() {
			return getRuleContext(Dg_R_MODContext.class,0);
		}
		public Mod_set_listContext mod_set_list() {
			return getRuleContext(Mod_set_listContext.class,0);
		}
		public MedContext med() {
			return getRuleContext(MedContext.class,0);
		}
		public Dg_M_modes_SETContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dg_M_modes_SET; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterDg_M_modes_SET(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitDg_M_modes_SET(this);
		}
	}

	public final Dg_M_modes_SETContext dg_M_modes_SET() throws RecognitionException {
		Dg_M_modes_SETContext _localctx = new Dg_M_modes_SETContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dg_M_modes_SET);
		 paraphrases.push("in dg_M_modes_SET"); 
		try {
			setState(82);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); ((Dg_M_modes_SETContext)_localctx).med = med();
				setState(69); ((Dg_M_modes_SETContext)_localctx).mod_set_list = mod_set_list();
				System.out.println("found med mod_set_list: " + (((Dg_M_modes_SETContext)_localctx).med!=null?_input.getText(((Dg_M_modes_SETContext)_localctx).med.start,((Dg_M_modes_SETContext)_localctx).med.stop):null) + " "  + (((Dg_M_modes_SETContext)_localctx).mod_set_list!=null?_input.getText(((Dg_M_modes_SETContext)_localctx).mod_set_list.start,((Dg_M_modes_SETContext)_localctx).mod_set_list.stop):null));
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72); ((Dg_M_modes_SETContext)_localctx).dg_L_MOD = dg_L_MOD();
				setState(73); ((Dg_M_modes_SETContext)_localctx).med = med();
				setState(74); ((Dg_M_modes_SETContext)_localctx).mod_set_list = mod_set_list();
				System.out.println("found dg_L_MOD med mod_set_list: " + (((Dg_M_modes_SETContext)_localctx).dg_L_MOD!=null?_input.getText(((Dg_M_modes_SETContext)_localctx).dg_L_MOD.start,((Dg_M_modes_SETContext)_localctx).dg_L_MOD.stop):null) + " " + (((Dg_M_modes_SETContext)_localctx).med!=null?_input.getText(((Dg_M_modes_SETContext)_localctx).med.start,((Dg_M_modes_SETContext)_localctx).med.stop):null)
					+ " " + (((Dg_M_modes_SETContext)_localctx).mod_set_list!=null?_input.getText(((Dg_M_modes_SETContext)_localctx).mod_set_list.start,((Dg_M_modes_SETContext)_localctx).mod_set_list.stop):null)
				);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77); ((Dg_M_modes_SETContext)_localctx).med = med();
				setState(78); ((Dg_M_modes_SETContext)_localctx).mod_set_list = mod_set_list();
				setState(79); ((Dg_M_modes_SETContext)_localctx).dg_R_MOD = dg_R_MOD();
				System.out.println("found med mod_set_list dg_R_MOD: " + (((Dg_M_modes_SETContext)_localctx).med!=null?_input.getText(((Dg_M_modes_SETContext)_localctx).med.start,((Dg_M_modes_SETContext)_localctx).med.stop):null) + " "  + (((Dg_M_modes_SETContext)_localctx).mod_set_list!=null?_input.getText(((Dg_M_modes_SETContext)_localctx).mod_set_list.start,((Dg_M_modes_SETContext)_localctx).mod_set_list.stop):null)
					+ " " + (((Dg_M_modes_SETContext)_localctx).dg_R_MOD!=null?_input.getText(((Dg_M_modes_SETContext)_localctx).dg_R_MOD.start,((Dg_M_modes_SETContext)_localctx).dg_R_MOD.stop):null)
				);
				}
				break;
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dg_S_modes_SETContext extends ParserRuleContext {
		public MedContext med;
		public Dg_R_MODContext dg_R_MOD;
		public Dg_L_MODContext dg_L_MOD;
		public Dg_L_MODContext dg_L_MOD() {
			return getRuleContext(Dg_L_MODContext.class,0);
		}
		public Dg_R_MODContext dg_R_MOD() {
			return getRuleContext(Dg_R_MODContext.class,0);
		}
		public MedContext med() {
			return getRuleContext(MedContext.class,0);
		}
		public Dg_S_modes_SETContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dg_S_modes_SET; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterDg_S_modes_SET(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitDg_S_modes_SET(this);
		}
	}

	public final Dg_S_modes_SETContext dg_S_modes_SET() throws RecognitionException {
		Dg_S_modes_SETContext _localctx = new Dg_S_modes_SETContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dg_S_modes_SET);
		 paraphrases.push("in dg_S_modes_SET"); 
		try {
			setState(100);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84); ((Dg_S_modes_SETContext)_localctx).med = med();
				System.out.println("found med " + (((Dg_S_modes_SETContext)_localctx).med!=null?_input.getText(((Dg_S_modes_SETContext)_localctx).med.start,((Dg_S_modes_SETContext)_localctx).med.stop):null));
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87); ((Dg_S_modes_SETContext)_localctx).med = med();
				setState(88); ((Dg_S_modes_SETContext)_localctx).dg_R_MOD = dg_R_MOD();
				System.out.println("found med dg_R_MOD: " + (((Dg_S_modes_SETContext)_localctx).med!=null?_input.getText(((Dg_S_modes_SETContext)_localctx).med.start,((Dg_S_modes_SETContext)_localctx).med.stop):null) + " " + (((Dg_S_modes_SETContext)_localctx).dg_R_MOD!=null?_input.getText(((Dg_S_modes_SETContext)_localctx).dg_R_MOD.start,((Dg_S_modes_SETContext)_localctx).dg_R_MOD.stop):null));
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(91); ((Dg_S_modes_SETContext)_localctx).dg_L_MOD = dg_L_MOD();
				setState(92); ((Dg_S_modes_SETContext)_localctx).med = med();
				System.out.println("found dg_L_MOD med: " + (((Dg_S_modes_SETContext)_localctx).dg_L_MOD!=null?_input.getText(((Dg_S_modes_SETContext)_localctx).dg_L_MOD.start,((Dg_S_modes_SETContext)_localctx).dg_L_MOD.stop):null) + " " + (((Dg_S_modes_SETContext)_localctx).med!=null?_input.getText(((Dg_S_modes_SETContext)_localctx).med.start,((Dg_S_modes_SETContext)_localctx).med.stop):null));
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(95); ((Dg_S_modes_SETContext)_localctx).dg_L_MOD = dg_L_MOD();
				setState(96); ((Dg_S_modes_SETContext)_localctx).med = med();
				setState(97); ((Dg_S_modes_SETContext)_localctx).dg_R_MOD = dg_R_MOD();
				System.out.println("found dg_L_MOD med: " + (((Dg_S_modes_SETContext)_localctx).dg_L_MOD!=null?_input.getText(((Dg_S_modes_SETContext)_localctx).dg_L_MOD.start,((Dg_S_modes_SETContext)_localctx).dg_L_MOD.stop):null) + " " + (((Dg_S_modes_SETContext)_localctx).med!=null?_input.getText(((Dg_S_modes_SETContext)_localctx).med.start,((Dg_S_modes_SETContext)_localctx).med.stop):null)
					+ " " + (((Dg_S_modes_SETContext)_localctx).dg_R_MOD!=null?_input.getText(((Dg_S_modes_SETContext)_localctx).dg_R_MOD.start,((Dg_S_modes_SETContext)_localctx).dg_R_MOD.stop):null)
				);
				}
				break;
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mod_set_listContext extends ParserRuleContext {
		public Mod_set_listContext mod_set_list() {
			return getRuleContext(Mod_set_listContext.class,0);
		}
		public Mod_setContext mod_set(int i) {
			return getRuleContext(Mod_setContext.class,i);
		}
		public List<Mod_setContext> mod_set() {
			return getRuleContexts(Mod_setContext.class);
		}
		public Mod_set_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mod_set_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterMod_set_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitMod_set_list(this);
		}
	}

	public final Mod_set_listContext mod_set_list() throws RecognitionException {
		Mod_set_listContext _localctx = new Mod_set_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mod_set_list);
		 paraphrases.push("in mod_set_list"); 
		try {
			setState(108);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102); mod_set();
				setState(103); mod_set();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105); mod_set();
				setState(106); mod_set_list();
				}
				break;
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dg_L_MODContext extends ParserRuleContext {
		public DoseContext dose() {
			return getRuleContext(DoseContext.class,0);
		}
		public DrtContext drt() {
			return getRuleContext(DrtContext.class,0);
		}
		public ModesContext modes() {
			return getRuleContext(ModesContext.class,0);
		}
		public FreqContext freq() {
			return getRuleContext(FreqContext.class,0);
		}
		public Dg_L_MODContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dg_L_MOD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterDg_L_MOD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitDg_L_MOD(this);
		}
	}

	public final Dg_L_MODContext dg_L_MOD() throws RecognitionException {
		Dg_L_MODContext _localctx = new Dg_L_MODContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dg_L_MOD);
		 paraphrases.push("in dg_L_MOD"); 
		try {
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110); dose();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111); modes();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(112); drt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(113); drt();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(114); freq();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(115); freq();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(116); dose();
				setState(117); freq();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(119); dose();
				setState(120); freq();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(122); freq();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(123); drt();
				}
				break;
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dg_R_MODContext extends ParserRuleContext {
		public Mod_setContext mod_set() {
			return getRuleContext(Mod_setContext.class,0);
		}
		public Dg_R_MODContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dg_R_MOD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterDg_R_MOD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitDg_R_MOD(this);
		}
	}

	public final Dg_R_MODContext dg_R_MOD() throws RecognitionException {
		Dg_R_MODContext _localctx = new Dg_R_MODContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dg_R_MOD);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); mod_set();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mod_setContext extends ParserRuleContext {
		public DoseContext dose() {
			return getRuleContext(DoseContext.class,0);
		}
		public TerminalNode INT() { return getToken(medPatternsParser.INT, 0); }
		public ModesContext modes() {
			return getRuleContext(ModesContext.class,0);
		}
		public DrtContext drt() {
			return getRuleContext(DrtContext.class,0);
		}
		public List<FreqContext> freq() {
			return getRuleContexts(FreqContext.class);
		}
		public ReasonContext reason() {
			return getRuleContext(ReasonContext.class,0);
		}
		public FreqContext freq(int i) {
			return getRuleContext(FreqContext.class,i);
		}
		public Mod_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mod_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterMod_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitMod_set(this);
		}
	}

	public final Mod_setContext mod_set() throws RecognitionException {
		Mod_setContext _localctx = new Mod_setContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mod_set);
		 paraphrases.push("in mod_set"); 
		try {
			setState(181);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); dose();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129); drt();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130); freq();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131); modes();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(132); dose();
				setState(133); freq();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(135); dose();
				setState(136); modes();
				setState(137); freq();
				setState(138); freq();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(140); dose();
				setState(141); freq();
				setState(142); reason();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(144); dose();
				setState(145); modes();
				setState(146); freq();
				setState(147); freq();
				setState(148); reason();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(150); dose();
				setState(151); freq();
				setState(152); drt();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(154); modes();
				setState(155); freq();
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(157); modes();
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(158); dose();
				setState(159); modes();
				setState(160); freq();
				}
				break;

			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(162); dose();
				setState(163); modes();
				setState(164); freq();
				setState(165); drt();
				}
				break;

			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(167); dose();
				setState(168); modes();
				}
				break;

			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(170); modes();
				setState(171); dose();
				setState(172); freq();
				}
				break;

			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(174); dose();
				setState(175); drt();
				}
				break;

			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(177); dose();
				setState(178); drt();
				}
				break;

			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(180); match(INT);
				}
				break;
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoseContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(medPatternsParser.INT); }
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public TerminalNode INT(int i) {
			return getToken(medPatternsParser.INT, i);
		}
		public TerminalNode SPECIAL_CHAR_1() { return getToken(medPatternsParser.SPECIAL_CHAR_1, 0); }
		public DoseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dose; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterDose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitDose(this);
		}
	}

	public final DoseContext dose() throws RecognitionException {
		DoseContext _localctx = new DoseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dose);
		 paraphrases.push("in dose"); 
		try {
			setState(189);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183); match(INT);
				setState(184); unit();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(185); match(INT);
				setState(186); match(SPECIAL_CHAR_1);
				setState(187); match(INT);
				setState(188); unit();
				}
				break;
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MedContext extends ParserRuleContext {
		public List<TerminalNode> SpecialSymbol1() { return getTokens(medPatternsParser.SpecialSymbol1); }
		public TerminalNode ID() { return getToken(medPatternsParser.ID, 0); }
		public TerminalNode SpecialSymbol1(int i) {
			return getToken(medPatternsParser.SpecialSymbol1, i);
		}
		public MedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_med; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterMed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitMed(this);
		}
	}

	public final MedContext med() throws RecognitionException {
		MedContext _localctx = new MedContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_med);
		 paraphrases.push("in med"); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(SpecialSymbol1);
			setState(192); match(ID);
			setState(193); match(SpecialSymbol1);
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FreqContext extends ParserRuleContext {
		public TerminalNode SpecialSymbol2(int i) {
			return getToken(medPatternsParser.SpecialSymbol2, i);
		}
		public TerminalNode ID() { return getToken(medPatternsParser.ID, 0); }
		public List<TerminalNode> SpecialSymbol2() { return getTokens(medPatternsParser.SpecialSymbol2); }
		public FreqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_freq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterFreq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitFreq(this);
		}
	}

	public final FreqContext freq() throws RecognitionException {
		FreqContext _localctx = new FreqContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_freq);
		 paraphrases.push("in freq"); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); match(SpecialSymbol2);
			setState(196); match(ID);
			setState(197); match(SpecialSymbol2);
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModesContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(medPatternsParser.ID, 0); }
		public List<TerminalNode> SpecialSymbol3() { return getTokens(medPatternsParser.SpecialSymbol3); }
		public TerminalNode SpecialSymbol3(int i) {
			return getToken(medPatternsParser.SpecialSymbol3, i);
		}
		public ModesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterModes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitModes(this);
		}
	}

	public final ModesContext modes() throws RecognitionException {
		ModesContext _localctx = new ModesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_modes);
		 paraphrases.push("in modes"); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(SpecialSymbol3);
			setState(200); match(ID);
			setState(201); match(SpecialSymbol3);
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DrtContext extends ParserRuleContext {
		public TerminalNode SpecialSymbol4(int i) {
			return getToken(medPatternsParser.SpecialSymbol4, i);
		}
		public TerminalNode ID() { return getToken(medPatternsParser.ID, 0); }
		public List<TerminalNode> SpecialSymbol4() { return getTokens(medPatternsParser.SpecialSymbol4); }
		public DrtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterDrt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitDrt(this);
		}
	}

	public final DrtContext drt() throws RecognitionException {
		DrtContext _localctx = new DrtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_drt);
		 paraphrases.push("in init"); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(SpecialSymbol4);
			setState(204); match(ID);
			setState(205); match(SpecialSymbol4);
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnitContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(medPatternsParser.ID, 0); }
		public List<TerminalNode> SpecialSymbol5() { return getTokens(medPatternsParser.SpecialSymbol5); }
		public TerminalNode SpecialSymbol5(int i) {
			return getToken(medPatternsParser.SpecialSymbol5, i);
		}
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitUnit(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unit);
		 paraphrases.push("in unit"); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); match(SpecialSymbol5);
			setState(208); match(ID);
			setState(209); match(SpecialSymbol5);
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReasonContext extends ParserRuleContext {
		public TerminalNode SpecialSymbol6(int i) {
			return getToken(medPatternsParser.SpecialSymbol6, i);
		}
		public TerminalNode ID() { return getToken(medPatternsParser.ID, 0); }
		public List<TerminalNode> SpecialSymbol6() { return getTokens(medPatternsParser.SpecialSymbol6); }
		public ReasonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reason; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterReason(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitReason(this);
		}
	}

	public final ReasonContext reason() throws RecognitionException {
		ReasonContext _localctx = new ReasonContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_reason);
		 paraphrases.push("in reason"); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); match(SpecialSymbol6);
			setState(212); match(ID);
			setState(213); match(SpecialSymbol6);
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WaterContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(medPatternsParser.INT); }
		public TerminalNode SPECIAL_CHAR_1(int i) {
			return getToken(medPatternsParser.SPECIAL_CHAR_1, i);
		}
		public TerminalNode ID() { return getToken(medPatternsParser.ID, 0); }
		public TerminalNode INT(int i) {
			return getToken(medPatternsParser.INT, i);
		}
		public TerminalNode SPECIAL_CHAR() { return getToken(medPatternsParser.SPECIAL_CHAR, 0); }
		public List<TerminalNode> SPECIAL_CHAR_1() { return getTokens(medPatternsParser.SPECIAL_CHAR_1); }
		public WaterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_water; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).enterWater(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof medPatternsListener ) ((medPatternsListener)listener).exitWater(this);
		}
	}

	public final WaterContext water() throws RecognitionException {
		WaterContext _localctx = new WaterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_water);
		 paraphrases.push("in water"); 
		try {
			setState(253);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215); match(ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216); match(INT);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(217); match(SPECIAL_CHAR);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(218); match(SPECIAL_CHAR_1);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(219); match(INT);
				setState(220); match(SPECIAL_CHAR_1);
				setState(221); match(INT);
				setState(222); match(SPECIAL_CHAR_1);
				setState(223); match(INT);
				setState(224); match(ID);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(225); match(INT);
				setState(226); match(SPECIAL_CHAR_1);
				setState(227); match(ID);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(228); match(INT);
				setState(229); match(SPECIAL_CHAR_1);
				setState(230); match(INT);
				setState(231); match(ID);
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(232); match(INT);
				setState(233); match(SPECIAL_CHAR_1);
				setState(234); match(INT);
				setState(235); match(SPECIAL_CHAR_1);
				setState(236); match(INT);
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(237); match(INT);
				setState(238); match(SPECIAL_CHAR_1);
				setState(239); match(INT);
				setState(240); match(SPECIAL_CHAR_1);
				setState(241); match(INT);
				setState(242); match(SPECIAL_CHAR_1);
				setState(243); match(INT);
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(244); match(INT);
				setState(245); match(SPECIAL_CHAR_1);
				setState(246); match(INT);
				setState(247); match(SPECIAL_CHAR_1);
				setState(248); match(INT);
				setState(249); match(SPECIAL_CHAR_1);
				setState(250); match(INT);
				setState(251); match(SPECIAL_CHAR_1);
				setState(252); match(INT);
				}
				break;
			}
			 paraphrases.pop(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return program_sempred((ProgramContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean program_sempred(ProgramContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r\u0102\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3\62\n\3"+
		"\f\3\16\3\65\13\3\3\4\3\4\5\49\n\4\3\5\3\5\3\6\3\6\3\6\3\6\5\6A\n\6\3"+
		"\7\3\7\5\7E\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\bU\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\tg\n\t\3\n\3\n\3\n\3\n\3\n\3\n\5\no\n\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\177\n\13\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00b8\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c0\n\16\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\5\25\u0100\n\25\3\25\2\3\4\26\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(\2\2\u011b\2*\3\2\2\2\4,\3\2\2\2\68\3\2\2\2"+
		"\b:\3\2\2\2\n@\3\2\2\2\fD\3\2\2\2\16T\3\2\2\2\20f\3\2\2\2\22n\3\2\2\2"+
		"\24~\3\2\2\2\26\u0080\3\2\2\2\30\u00b7\3\2\2\2\32\u00bf\3\2\2\2\34\u00c1"+
		"\3\2\2\2\36\u00c5\3\2\2\2 \u00c9\3\2\2\2\"\u00cd\3\2\2\2$\u00d1\3\2\2"+
		"\2&\u00d5\3\2\2\2(\u00ff\3\2\2\2*+\5\4\3\2+\3\3\2\2\2,-\b\3\1\2-.\5\6"+
		"\4\2.\63\3\2\2\2/\60\f\3\2\2\60\62\5\6\4\2\61/\3\2\2\2\62\65\3\2\2\2\63"+
		"\61\3\2\2\2\63\64\3\2\2\2\64\5\3\2\2\2\65\63\3\2\2\2\669\5(\25\2\679\5"+
		"\b\5\28\66\3\2\2\28\67\3\2\2\29\7\3\2\2\2:;\5\n\6\2;\t\3\2\2\2<A\5\f\7"+
		"\2=>\5\f\7\2>?\5\n\6\2?A\3\2\2\2@<\3\2\2\2@=\3\2\2\2A\13\3\2\2\2BE\5\20"+
		"\t\2CE\5\16\b\2DB\3\2\2\2DC\3\2\2\2E\r\3\2\2\2FG\5\34\17\2GH\5\22\n\2"+
		"HI\b\b\1\2IU\3\2\2\2JK\5\24\13\2KL\5\34\17\2LM\5\22\n\2MN\b\b\1\2NU\3"+
		"\2\2\2OP\5\34\17\2PQ\5\22\n\2QR\5\26\f\2RS\b\b\1\2SU\3\2\2\2TF\3\2\2\2"+
		"TJ\3\2\2\2TO\3\2\2\2U\17\3\2\2\2VW\5\34\17\2WX\b\t\1\2Xg\3\2\2\2YZ\5\34"+
		"\17\2Z[\5\26\f\2[\\\b\t\1\2\\g\3\2\2\2]^\5\24\13\2^_\5\34\17\2_`\b\t\1"+
		"\2`g\3\2\2\2ab\5\24\13\2bc\5\34\17\2cd\5\26\f\2de\b\t\1\2eg\3\2\2\2fV"+
		"\3\2\2\2fY\3\2\2\2f]\3\2\2\2fa\3\2\2\2g\21\3\2\2\2hi\5\30\r\2ij\5\30\r"+
		"\2jo\3\2\2\2kl\5\30\r\2lm\5\22\n\2mo\3\2\2\2nh\3\2\2\2nk\3\2\2\2o\23\3"+
		"\2\2\2p\177\5\32\16\2q\177\5 \21\2r\177\5\"\22\2s\177\5\"\22\2t\177\5"+
		"\36\20\2u\177\5\36\20\2vw\5\32\16\2wx\5\36\20\2x\177\3\2\2\2yz\5\32\16"+
		"\2z{\5\36\20\2{\177\3\2\2\2|\177\5\36\20\2}\177\5\"\22\2~p\3\2\2\2~q\3"+
		"\2\2\2~r\3\2\2\2~s\3\2\2\2~t\3\2\2\2~u\3\2\2\2~v\3\2\2\2~y\3\2\2\2~|\3"+
		"\2\2\2~}\3\2\2\2\177\25\3\2\2\2\u0080\u0081\5\30\r\2\u0081\27\3\2\2\2"+
		"\u0082\u00b8\5\32\16\2\u0083\u00b8\5\"\22\2\u0084\u00b8\5\36\20\2\u0085"+
		"\u00b8\5 \21\2\u0086\u0087\5\32\16\2\u0087\u0088\5\36\20\2\u0088\u00b8"+
		"\3\2\2\2\u0089\u008a\5\32\16\2\u008a\u008b\5 \21\2\u008b\u008c\5\36\20"+
		"\2\u008c\u008d\5\36\20\2\u008d\u00b8\3\2\2\2\u008e\u008f\5\32\16\2\u008f"+
		"\u0090\5\36\20\2\u0090\u0091\5&\24\2\u0091\u00b8\3\2\2\2\u0092\u0093\5"+
		"\32\16\2\u0093\u0094\5 \21\2\u0094\u0095\5\36\20\2\u0095\u0096\5\36\20"+
		"\2\u0096\u0097\5&\24\2\u0097\u00b8\3\2\2\2\u0098\u0099\5\32\16\2\u0099"+
		"\u009a\5\36\20\2\u009a\u009b\5\"\22\2\u009b\u00b8\3\2\2\2\u009c\u009d"+
		"\5 \21\2\u009d\u009e\5\36\20\2\u009e\u00b8\3\2\2\2\u009f\u00b8\5 \21\2"+
		"\u00a0\u00a1\5\32\16\2\u00a1\u00a2\5 \21\2\u00a2\u00a3\5\36\20\2\u00a3"+
		"\u00b8\3\2\2\2\u00a4\u00a5\5\32\16\2\u00a5\u00a6\5 \21\2\u00a6\u00a7\5"+
		"\36\20\2\u00a7\u00a8\5\"\22\2\u00a8\u00b8\3\2\2\2\u00a9\u00aa\5\32\16"+
		"\2\u00aa\u00ab\5 \21\2\u00ab\u00b8\3\2\2\2\u00ac\u00ad\5 \21\2\u00ad\u00ae"+
		"\5\32\16\2\u00ae\u00af\5\36\20\2\u00af\u00b8\3\2\2\2\u00b0\u00b1\5\32"+
		"\16\2\u00b1\u00b2\5\"\22\2\u00b2\u00b8\3\2\2\2\u00b3\u00b4\5\32\16\2\u00b4"+
		"\u00b5\5\"\22\2\u00b5\u00b8\3\2\2\2\u00b6\u00b8\7\4\2\2\u00b7\u0082\3"+
		"\2\2\2\u00b7\u0083\3\2\2\2\u00b7\u0084\3\2\2\2\u00b7\u0085\3\2\2\2\u00b7"+
		"\u0086\3\2\2\2\u00b7\u0089\3\2\2\2\u00b7\u008e\3\2\2\2\u00b7\u0092\3\2"+
		"\2\2\u00b7\u0098\3\2\2\2\u00b7\u009c\3\2\2\2\u00b7\u009f\3\2\2\2\u00b7"+
		"\u00a0\3\2\2\2\u00b7\u00a4\3\2\2\2\u00b7\u00a9\3\2\2\2\u00b7\u00ac\3\2"+
		"\2\2\u00b7\u00b0\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\31\3\2\2\2\u00b9\u00ba\7\4\2\2\u00ba\u00c0\5$\23\2\u00bb\u00bc\7\4\2"+
		"\2\u00bc\u00bd\7\6\2\2\u00bd\u00be\7\4\2\2\u00be\u00c0\5$\23\2\u00bf\u00b9"+
		"\3\2\2\2\u00bf\u00bb\3\2\2\2\u00c0\33\3\2\2\2\u00c1\u00c2\7\7\2\2\u00c2"+
		"\u00c3\7\3\2\2\u00c3\u00c4\7\7\2\2\u00c4\35\3\2\2\2\u00c5\u00c6\7\b\2"+
		"\2\u00c6\u00c7\7\3\2\2\u00c7\u00c8\7\b\2\2\u00c8\37\3\2\2\2\u00c9\u00ca"+
		"\7\t\2\2\u00ca\u00cb\7\3\2\2\u00cb\u00cc\7\t\2\2\u00cc!\3\2\2\2\u00cd"+
		"\u00ce\7\n\2\2\u00ce\u00cf\7\3\2\2\u00cf\u00d0\7\n\2\2\u00d0#\3\2\2\2"+
		"\u00d1\u00d2\7\13\2\2\u00d2\u00d3\7\3\2\2\u00d3\u00d4\7\13\2\2\u00d4%"+
		"\3\2\2\2\u00d5\u00d6\7\f\2\2\u00d6\u00d7\7\3\2\2\u00d7\u00d8\7\f\2\2\u00d8"+
		"\'\3\2\2\2\u00d9\u0100\7\3\2\2\u00da\u0100\7\4\2\2\u00db\u0100\7\5\2\2"+
		"\u00dc\u0100\7\6\2\2\u00dd\u00de\7\4\2\2\u00de\u00df\7\6\2\2\u00df\u00e0"+
		"\7\4\2\2\u00e0\u00e1\7\6\2\2\u00e1\u00e2\7\4\2\2\u00e2\u0100\7\3\2\2\u00e3"+
		"\u00e4\7\4\2\2\u00e4\u00e5\7\6\2\2\u00e5\u0100\7\3\2\2\u00e6\u00e7\7\4"+
		"\2\2\u00e7\u00e8\7\6\2\2\u00e8\u00e9\7\4\2\2\u00e9\u0100\7\3\2\2\u00ea"+
		"\u00eb\7\4\2\2\u00eb\u00ec\7\6\2\2\u00ec\u00ed\7\4\2\2\u00ed\u00ee\7\6"+
		"\2\2\u00ee\u0100\7\4\2\2\u00ef\u00f0\7\4\2\2\u00f0\u00f1\7\6\2\2\u00f1"+
		"\u00f2\7\4\2\2\u00f2\u00f3\7\6\2\2\u00f3\u00f4\7\4\2\2\u00f4\u00f5\7\6"+
		"\2\2\u00f5\u0100\7\4\2\2\u00f6\u00f7\7\4\2\2\u00f7\u00f8\7\6\2\2\u00f8"+
		"\u00f9\7\4\2\2\u00f9\u00fa\7\6\2\2\u00fa\u00fb\7\4\2\2\u00fb\u00fc\7\6"+
		"\2\2\u00fc\u00fd\7\4\2\2\u00fd\u00fe\7\6\2\2\u00fe\u0100\7\4\2\2\u00ff"+
		"\u00d9\3\2\2\2\u00ff\u00da\3\2\2\2\u00ff\u00db\3\2\2\2\u00ff\u00dc\3\2"+
		"\2\2\u00ff\u00dd\3\2\2\2\u00ff\u00e3\3\2\2\2\u00ff\u00e6\3\2\2\2\u00ff"+
		"\u00ea\3\2\2\2\u00ff\u00ef\3\2\2\2\u00ff\u00f6\3\2\2\2\u0100)\3\2\2\2"+
		"\r\638@DTfn~\u00b7\u00bf\u00ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}