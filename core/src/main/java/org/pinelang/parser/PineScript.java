// Generated from PineScript.g4 by ANTLR 4.8

    package org.pinelang.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PineScript extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ON=1, SUFFIX_DP=2, SUFFIX_PX=3, ID=4, DOT=5, LPAREN=6, RPAREN=7, COMMA=8, 
		NULL=9, TRUE=10, FALSE=11, EQ=12, LBRACKET=13, RBRACKET=14, AND_AND=15, 
		OR_OR=16, QUESTION=17, SEMICOLON=18, COLON=19, LBRACE=20, RBRACE=21, RETURN=22, 
		IMPORT=23, PLUS=24, MINUS=25, MULTI=26, DIV=27, REMAINDER=28, AND=29, 
		OR=30, Identifier=31, ObjectType=32, DOUBLE_QUOTE_OPEN=33, DOUBLE_QUOTE_CLOSE=34, 
		STRING=35, IntegerLiteral=36, FloatLiteral=37, WS=38, COMMENT=39, LINE_COMMENT=40, 
		LineTerminator=41;
	public static final int
		RULE_program = 0, RULE_rootMember = 1, RULE_objectDefinition = 2, RULE_objectInitializer = 3, 
		RULE_objectIdentifier = 4, RULE_signalAssignement = 5, RULE_propertyDefinition = 6, 
		RULE_expression = 7, RULE_binaryOperation = 8, RULE_objectPropertyExpression = 9, 
		RULE_primitiveExpression = 10, RULE_stringLiteral = 11, RULE_integerSuffix = 12, 
		RULE_callableExpression = 13, RULE_arguments = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "rootMember", "objectDefinition", "objectInitializer", "objectIdentifier", 
			"signalAssignement", "propertyDefinition", "expression", "binaryOperation", 
			"objectPropertyExpression", "primitiveExpression", "stringLiteral", "integerSuffix", 
			"callableExpression", "arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'on'", "'dp'", "'px'", "'id'", "'.'", "'('", "')'", "','", "'null'", 
			"'true'", "'false'", "'=='", "'['", "']'", "'&&'", "'||'", "'?'", "';'", 
			"':'", "'{'", "'}'", "'return'", "'import'", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'and'", "'or'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ON", "SUFFIX_DP", "SUFFIX_PX", "ID", "DOT", "LPAREN", "RPAREN", 
			"COMMA", "NULL", "TRUE", "FALSE", "EQ", "LBRACKET", "RBRACKET", "AND_AND", 
			"OR_OR", "QUESTION", "SEMICOLON", "COLON", "LBRACE", "RBRACE", "RETURN", 
			"IMPORT", "PLUS", "MINUS", "MULTI", "DIV", "REMAINDER", "AND", "OR", 
			"Identifier", "ObjectType", "DOUBLE_QUOTE_OPEN", "DOUBLE_QUOTE_CLOSE", 
			"STRING", "IntegerLiteral", "FloatLiteral", "WS", "COMMENT", "LINE_COMMENT", 
			"LineTerminator"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PineScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PineScript(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public RootMemberContext rootMember() {
			return getRuleContext(RootMemberContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PineScript.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			rootMember();
			setState(31);
			match(EOF);
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

	public static class RootMemberContext extends ParserRuleContext {
		public ObjectDefinitionContext objectDefinition() {
			return getRuleContext(ObjectDefinitionContext.class,0);
		}
		public RootMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rootMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterRootMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitRootMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitRootMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootMemberContext rootMember() throws RecognitionException {
		RootMemberContext _localctx = new RootMemberContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rootMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			objectDefinition();
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

	public static class ObjectDefinitionContext extends ParserRuleContext {
		public TerminalNode ObjectType() { return getToken(PineScript.ObjectType, 0); }
		public ObjectInitializerContext objectInitializer() {
			return getRuleContext(ObjectInitializerContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PineScript.SEMICOLON, 0); }
		public ObjectDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterObjectDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitObjectDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitObjectDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectDefinitionContext objectDefinition() throws RecognitionException {
		ObjectDefinitionContext _localctx = new ObjectDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_objectDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(ObjectType);
			setState(36);
			objectInitializer();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(37);
				match(SEMICOLON);
				}
			}

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

	public static class ObjectInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PineScript.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PineScript.RBRACE, 0); }
		public ObjectIdentifierContext objectIdentifier() {
			return getRuleContext(ObjectIdentifierContext.class,0);
		}
		public List<ObjectDefinitionContext> objectDefinition() {
			return getRuleContexts(ObjectDefinitionContext.class);
		}
		public ObjectDefinitionContext objectDefinition(int i) {
			return getRuleContext(ObjectDefinitionContext.class,i);
		}
		public List<SignalAssignementContext> signalAssignement() {
			return getRuleContexts(SignalAssignementContext.class);
		}
		public SignalAssignementContext signalAssignement(int i) {
			return getRuleContext(SignalAssignementContext.class,i);
		}
		public List<PropertyDefinitionContext> propertyDefinition() {
			return getRuleContexts(PropertyDefinitionContext.class);
		}
		public PropertyDefinitionContext propertyDefinition(int i) {
			return getRuleContext(PropertyDefinitionContext.class,i);
		}
		public ObjectInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterObjectInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitObjectInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitObjectInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectInitializerContext objectInitializer() throws RecognitionException {
		ObjectInitializerContext _localctx = new ObjectInitializerContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_objectInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(LBRACE);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(41);
				objectIdentifier();
				}
			}

			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ON) | (1L << Identifier) | (1L << ObjectType))) != 0)) {
				{
				setState(47);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ObjectType:
					{
					setState(44);
					objectDefinition();
					}
					break;
				case ON:
					{
					setState(45);
					signalAssignement();
					}
					break;
				case Identifier:
					{
					setState(46);
					propertyDefinition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(RBRACE);
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

	public static class ObjectIdentifierContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PineScript.ID, 0); }
		public TerminalNode COLON() { return getToken(PineScript.COLON, 0); }
		public TerminalNode Identifier() { return getToken(PineScript.Identifier, 0); }
		public TerminalNode SEMICOLON() { return getToken(PineScript.SEMICOLON, 0); }
		public ObjectIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterObjectIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitObjectIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitObjectIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectIdentifierContext objectIdentifier() throws RecognitionException {
		ObjectIdentifierContext _localctx = new ObjectIdentifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_objectIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(ID);
			setState(55);
			match(COLON);
			setState(56);
			match(Identifier);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(57);
				match(SEMICOLON);
				}
			}

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

	public static class SignalAssignementContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(PineScript.ON, 0); }
		public TerminalNode Identifier() { return getToken(PineScript.Identifier, 0); }
		public TerminalNode COLON() { return getToken(PineScript.COLON, 0); }
		public CallableExpressionContext callableExpression() {
			return getRuleContext(CallableExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PineScript.SEMICOLON, 0); }
		public SignalAssignementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signalAssignement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterSignalAssignement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitSignalAssignement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitSignalAssignement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignalAssignementContext signalAssignement() throws RecognitionException {
		SignalAssignementContext _localctx = new SignalAssignementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_signalAssignement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(ON);
			setState(61);
			match(Identifier);
			setState(62);
			match(COLON);
			setState(63);
			callableExpression();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(64);
				match(SEMICOLON);
				}
			}

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

	public static class PropertyDefinitionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PineScript.Identifier, 0); }
		public TerminalNode COLON() { return getToken(PineScript.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PineScript.SEMICOLON, 0); }
		public PropertyDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterPropertyDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitPropertyDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitPropertyDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyDefinitionContext propertyDefinition() throws RecognitionException {
		PropertyDefinitionContext _localctx = new PropertyDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_propertyDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(Identifier);
			setState(68);
			match(COLON);
			setState(69);
			expression(0);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(70);
				match(SEMICOLON);
				}
			}

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

	public static class ExpressionContext extends ParserRuleContext {
		public PrimitiveExpressionContext primitiveExpression() {
			return getRuleContext(PrimitiveExpressionContext.class,0);
		}
		public ObjectPropertyExpressionContext objectPropertyExpression() {
			return getRuleContext(ObjectPropertyExpressionContext.class,0);
		}
		public CallableExpressionContext callableExpression() {
			return getRuleContext(CallableExpressionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryOperationContext binaryOperation() {
			return getRuleContext(BinaryOperationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(74);
				primitiveExpression();
				}
				break;
			case 2:
				{
				setState(75);
				objectPropertyExpression();
				}
				break;
			case 3:
				{
				setState(76);
				callableExpression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(79);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(80);
					binaryOperation();
					setState(81);
					expression(3);
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class BinaryOperationContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(PineScript.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PineScript.MINUS, 0); }
		public TerminalNode MULTI() { return getToken(PineScript.MULTI, 0); }
		public TerminalNode DIV() { return getToken(PineScript.DIV, 0); }
		public TerminalNode REMAINDER() { return getToken(PineScript.REMAINDER, 0); }
		public TerminalNode EQ() { return getToken(PineScript.EQ, 0); }
		public TerminalNode AND() { return getToken(PineScript.AND, 0); }
		public TerminalNode OR() { return getToken(PineScript.OR, 0); }
		public BinaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterBinaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitBinaryOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitBinaryOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOperationContext binaryOperation() throws RecognitionException {
		BinaryOperationContext _localctx = new BinaryOperationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_binaryOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << PLUS) | (1L << MINUS) | (1L << MULTI) | (1L << DIV) | (1L << REMAINDER) | (1L << AND) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class ObjectPropertyExpressionContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(PineScript.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PineScript.Identifier, i);
		}
		public TerminalNode DOT() { return getToken(PineScript.DOT, 0); }
		public ObjectPropertyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectPropertyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterObjectPropertyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitObjectPropertyExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitObjectPropertyExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectPropertyExpressionContext objectPropertyExpression() throws RecognitionException {
		ObjectPropertyExpressionContext _localctx = new ObjectPropertyExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_objectPropertyExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(Identifier);
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(91);
				match(DOT);
				setState(92);
				match(Identifier);
				}
				break;
			}
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

	public static class PrimitiveExpressionContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(PineScript.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PineScript.FALSE, 0); }
		public TerminalNode IntegerLiteral() { return getToken(PineScript.IntegerLiteral, 0); }
		public IntegerSuffixContext integerSuffix() {
			return getRuleContext(IntegerSuffixContext.class,0);
		}
		public TerminalNode FloatLiteral() { return getToken(PineScript.FloatLiteral, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public PrimitiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterPrimitiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitPrimitiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitPrimitiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveExpressionContext primitiveExpression() throws RecognitionException {
		PrimitiveExpressionContext _localctx = new PrimitiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_primitiveExpression);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(FALSE);
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(IntegerLiteral);
				setState(99);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(98);
					integerSuffix();
					}
					break;
				}
				}
				break;
			case FloatLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				match(FloatLiteral);
				}
				break;
			case DOUBLE_QUOTE_OPEN:
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				stringLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode DOUBLE_QUOTE_OPEN() { return getToken(PineScript.DOUBLE_QUOTE_OPEN, 0); }
		public TerminalNode STRING() { return getToken(PineScript.STRING, 0); }
		public TerminalNode DOUBLE_QUOTE_CLOSE() { return getToken(PineScript.DOUBLE_QUOTE_CLOSE, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(DOUBLE_QUOTE_OPEN);
			setState(106);
			match(STRING);
			setState(107);
			match(DOUBLE_QUOTE_CLOSE);
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

	public static class IntegerSuffixContext extends ParserRuleContext {
		public TerminalNode SUFFIX_DP() { return getToken(PineScript.SUFFIX_DP, 0); }
		public TerminalNode SUFFIX_PX() { return getToken(PineScript.SUFFIX_PX, 0); }
		public IntegerSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterIntegerSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitIntegerSuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitIntegerSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerSuffixContext integerSuffix() throws RecognitionException {
		IntegerSuffixContext _localctx = new IntegerSuffixContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_integerSuffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !(_la==SUFFIX_DP || _la==SUFFIX_PX) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class CallableExpressionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PineScript.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(PineScript.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PineScript.RPAREN, 0); }
		public CallableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callableExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterCallableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitCallableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitCallableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallableExpressionContext callableExpression() throws RecognitionException {
		CallableExpressionContext _localctx = new CallableExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_callableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(Identifier);
			setState(112);
			match(LPAREN);
			setState(113);
			match(RPAREN);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PineScript.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PineScript.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			expression(0);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(116);
				match(COMMA);
				setState(117);
				expression(0);
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+~\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\5\4)\n\4\3\5\3\5\5\5-\n\5\3\5\3\5\3\5\7\5\62\n\5\f\5\16\5\65\13\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\5\6=\n\6\3\7\3\7\3\7\3\7\3\7\5\7D\n\7\3\b\3\b"+
		"\3\b\3\b\5\bJ\n\b\3\t\3\t\3\t\3\t\5\tP\n\t\3\t\3\t\3\t\3\t\7\tV\n\t\f"+
		"\t\16\tY\13\t\3\n\3\n\3\13\3\13\3\13\5\13`\n\13\3\f\3\f\3\f\3\f\5\ff\n"+
		"\f\3\f\3\f\5\fj\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\7\20y\n\20\f\20\16\20|\13\20\3\20\2\3\20\21\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36\2\4\4\2\16\16\32 \3\2\4\5\2\u0080\2 \3\2\2\2"+
		"\4#\3\2\2\2\6%\3\2\2\2\b*\3\2\2\2\n8\3\2\2\2\f>\3\2\2\2\16E\3\2\2\2\20"+
		"O\3\2\2\2\22Z\3\2\2\2\24\\\3\2\2\2\26i\3\2\2\2\30k\3\2\2\2\32o\3\2\2\2"+
		"\34q\3\2\2\2\36u\3\2\2\2 !\5\4\3\2!\"\7\2\2\3\"\3\3\2\2\2#$\5\6\4\2$\5"+
		"\3\2\2\2%&\7\"\2\2&(\5\b\5\2\')\7\24\2\2(\'\3\2\2\2()\3\2\2\2)\7\3\2\2"+
		"\2*,\7\26\2\2+-\5\n\6\2,+\3\2\2\2,-\3\2\2\2-\63\3\2\2\2.\62\5\6\4\2/\62"+
		"\5\f\7\2\60\62\5\16\b\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\65\3"+
		"\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7"+
		"\27\2\2\67\t\3\2\2\289\7\6\2\29:\7\25\2\2:<\7!\2\2;=\7\24\2\2<;\3\2\2"+
		"\2<=\3\2\2\2=\13\3\2\2\2>?\7\3\2\2?@\7!\2\2@A\7\25\2\2AC\5\34\17\2BD\7"+
		"\24\2\2CB\3\2\2\2CD\3\2\2\2D\r\3\2\2\2EF\7!\2\2FG\7\25\2\2GI\5\20\t\2"+
		"HJ\7\24\2\2IH\3\2\2\2IJ\3\2\2\2J\17\3\2\2\2KL\b\t\1\2LP\5\26\f\2MP\5\24"+
		"\13\2NP\5\34\17\2OK\3\2\2\2OM\3\2\2\2ON\3\2\2\2PW\3\2\2\2QR\f\4\2\2RS"+
		"\5\22\n\2ST\5\20\t\5TV\3\2\2\2UQ\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2"+
		"X\21\3\2\2\2YW\3\2\2\2Z[\t\2\2\2[\23\3\2\2\2\\_\7!\2\2]^\7\7\2\2^`\7!"+
		"\2\2_]\3\2\2\2_`\3\2\2\2`\25\3\2\2\2aj\7\f\2\2bj\7\r\2\2ce\7&\2\2df\5"+
		"\32\16\2ed\3\2\2\2ef\3\2\2\2fj\3\2\2\2gj\7\'\2\2hj\5\30\r\2ia\3\2\2\2"+
		"ib\3\2\2\2ic\3\2\2\2ig\3\2\2\2ih\3\2\2\2j\27\3\2\2\2kl\7#\2\2lm\7%\2\2"+
		"mn\7$\2\2n\31\3\2\2\2op\t\3\2\2p\33\3\2\2\2qr\7!\2\2rs\7\b\2\2st\7\t\2"+
		"\2t\35\3\2\2\2uz\5\20\t\2vw\7\n\2\2wy\5\20\t\2xv\3\2\2\2y|\3\2\2\2zx\3"+
		"\2\2\2z{\3\2\2\2{\37\3\2\2\2|z\3\2\2\2\17(,\61\63<CIOW_eiz";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}