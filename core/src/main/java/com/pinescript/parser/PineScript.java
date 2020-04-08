// Generated from PineScript.g4 by ANTLR 4.8

    package com.pinescript.parser;

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
		OR=30, DOUBLE_QUOTE_OPEN=31, Identifier=32, ObjectType=33, IntegerLiteral=34, 
		FloatLiteral=35, DOUBLE_QUOTE_CLOSE=36, DoubleQuoteString=37, WS=38, COMMENT=39, 
		LINE_COMMENT=40, LineTerminator=41;
	public static final int
		RULE_program = 0, RULE_rootMember = 1, RULE_objectDefinition = 2, RULE_objectInitializer = 3, 
		RULE_objectIdentifier = 4, RULE_objectMember = 5, RULE_signalAssignement = 6, 
		RULE_propertyDefinition = 7, RULE_expression = 8, RULE_binaryOperation = 9, 
		RULE_objectPropertyExpression = 10, RULE_primitiveExpression = 11, RULE_stringLiteral = 12, 
		RULE_integerSuffix = 13, RULE_callableExpression = 14, RULE_arguments = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "rootMember", "objectDefinition", "objectInitializer", "objectIdentifier", 
			"objectMember", "signalAssignement", "propertyDefinition", "expression", 
			"binaryOperation", "objectPropertyExpression", "primitiveExpression", 
			"stringLiteral", "integerSuffix", "callableExpression", "arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'on'", "'dp'", "'px'", "'id'", "'.'", "'('", "')'", "','", "'null'", 
			"'true'", "'false'", "'='", "'['", "']'", "'&&'", "'||'", "'?'", "';'", 
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
			"DOUBLE_QUOTE_OPEN", "Identifier", "ObjectType", "IntegerLiteral", "FloatLiteral", 
			"DOUBLE_QUOTE_CLOSE", "DoubleQuoteString", "WS", "COMMENT", "LINE_COMMENT", 
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
			setState(32);
			rootMember();
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
			setState(34);
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
			setState(36);
			match(ObjectType);
			setState(37);
			objectInitializer();
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(38);
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
		public List<ObjectMemberContext> objectMember() {
			return getRuleContexts(ObjectMemberContext.class);
		}
		public ObjectMemberContext objectMember(int i) {
			return getRuleContext(ObjectMemberContext.class,i);
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
			setState(41);
			match(LBRACE);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(42);
				objectIdentifier();
				}
			}

			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ON) | (1L << Identifier) | (1L << ObjectType))) != 0)) {
				{
				{
				setState(45);
				objectMember();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
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
			setState(53);
			match(ID);
			setState(54);
			match(COLON);
			setState(55);
			match(Identifier);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(56);
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

	public static class ObjectMemberContext extends ParserRuleContext {
		public ObjectDefinitionContext objectDefinition() {
			return getRuleContext(ObjectDefinitionContext.class,0);
		}
		public SignalAssignementContext signalAssignement() {
			return getRuleContext(SignalAssignementContext.class,0);
		}
		public PropertyDefinitionContext propertyDefinition() {
			return getRuleContext(PropertyDefinitionContext.class,0);
		}
		public ObjectMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterObjectMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitObjectMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitObjectMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectMemberContext objectMember() throws RecognitionException {
		ObjectMemberContext _localctx = new ObjectMemberContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_objectMember);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ObjectType:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				objectDefinition();
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				signalAssignement();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				propertyDefinition();
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
		enterRule(_localctx, 12, RULE_signalAssignement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(ON);
			setState(65);
			match(Identifier);
			setState(66);
			match(COLON);
			setState(67);
			callableExpression();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(68);
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
		enterRule(_localctx, 14, RULE_propertyDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(Identifier);
			setState(72);
			match(COLON);
			setState(73);
			expression(0);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(74);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(78);
				primitiveExpression();
				}
				break;
			case 2:
				{
				setState(79);
				objectPropertyExpression();
				}
				break;
			case 3:
				{
				setState(80);
				callableExpression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(89);
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
					setState(83);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(84);
					binaryOperation();
					setState(85);
					expression(3);
					}
					} 
				}
				setState(91);
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
		enterRule(_localctx, 18, RULE_binaryOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULTI) | (1L << DIV) | (1L << REMAINDER) | (1L << AND) | (1L << OR))) != 0)) ) {
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
		enterRule(_localctx, 20, RULE_objectPropertyExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(Identifier);
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(95);
				match(DOT);
				setState(96);
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
		enterRule(_localctx, 22, RULE_primitiveExpression);
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(FALSE);
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				match(IntegerLiteral);
				setState(103);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(102);
					integerSuffix();
					}
					break;
				}
				}
				break;
			case FloatLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				match(FloatLiteral);
				}
				break;
			case DOUBLE_QUOTE_OPEN:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
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
		public TerminalNode DoubleQuoteString() { return getToken(PineScript.DoubleQuoteString, 0); }
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
		enterRule(_localctx, 24, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(DOUBLE_QUOTE_OPEN);
			setState(110);
			match(DoubleQuoteString);
			setState(111);
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
		enterRule(_localctx, 26, RULE_integerSuffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
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
		enterRule(_localctx, 28, RULE_callableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(Identifier);
			setState(116);
			match(LPAREN);
			setState(117);
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
		enterRule(_localctx, 30, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			expression(0);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(120);
				match(COMMA);
				setState(121);
				expression(0);
				}
				}
				setState(126);
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
		case 8:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u0082\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\5\4*\n\4\3\5\3\5\5\5.\n\5\3\5\7\5\61\n\5\f\5\16\5\64"+
		"\13\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6<\n\6\3\7\3\7\3\7\5\7A\n\7\3\b\3\b\3"+
		"\b\3\b\3\b\5\bH\n\b\3\t\3\t\3\t\3\t\5\tN\n\t\3\n\3\n\3\n\3\n\5\nT\n\n"+
		"\3\n\3\n\3\n\3\n\7\nZ\n\n\f\n\16\n]\13\n\3\13\3\13\3\f\3\f\3\f\5\fd\n"+
		"\f\3\r\3\r\3\r\3\r\5\rj\n\r\3\r\3\r\5\rn\n\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21}\n\21\f\21\16\21\u0080\13"+
		"\21\3\21\2\3\22\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\4\3\2\32"+
		" \3\2\4\5\2\u0083\2\"\3\2\2\2\4$\3\2\2\2\6&\3\2\2\2\b+\3\2\2\2\n\67\3"+
		"\2\2\2\f@\3\2\2\2\16B\3\2\2\2\20I\3\2\2\2\22S\3\2\2\2\24^\3\2\2\2\26`"+
		"\3\2\2\2\30m\3\2\2\2\32o\3\2\2\2\34s\3\2\2\2\36u\3\2\2\2 y\3\2\2\2\"#"+
		"\5\4\3\2#\3\3\2\2\2$%\5\6\4\2%\5\3\2\2\2&\'\7#\2\2\')\5\b\5\2(*\7\24\2"+
		"\2)(\3\2\2\2)*\3\2\2\2*\7\3\2\2\2+-\7\26\2\2,.\5\n\6\2-,\3\2\2\2-.\3\2"+
		"\2\2.\62\3\2\2\2/\61\5\f\7\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62"+
		"\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\7\27\2\2\66\t\3\2\2\2\67"+
		"8\7\6\2\289\7\25\2\29;\7\"\2\2:<\7\24\2\2;:\3\2\2\2;<\3\2\2\2<\13\3\2"+
		"\2\2=A\5\6\4\2>A\5\16\b\2?A\5\20\t\2@=\3\2\2\2@>\3\2\2\2@?\3\2\2\2A\r"+
		"\3\2\2\2BC\7\3\2\2CD\7\"\2\2DE\7\25\2\2EG\5\36\20\2FH\7\24\2\2GF\3\2\2"+
		"\2GH\3\2\2\2H\17\3\2\2\2IJ\7\"\2\2JK\7\25\2\2KM\5\22\n\2LN\7\24\2\2ML"+
		"\3\2\2\2MN\3\2\2\2N\21\3\2\2\2OP\b\n\1\2PT\5\30\r\2QT\5\26\f\2RT\5\36"+
		"\20\2SO\3\2\2\2SQ\3\2\2\2SR\3\2\2\2T[\3\2\2\2UV\f\4\2\2VW\5\24\13\2WX"+
		"\5\22\n\5XZ\3\2\2\2YU\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\23\3\2"+
		"\2\2][\3\2\2\2^_\t\2\2\2_\25\3\2\2\2`c\7\"\2\2ab\7\7\2\2bd\7\"\2\2ca\3"+
		"\2\2\2cd\3\2\2\2d\27\3\2\2\2en\7\f\2\2fn\7\r\2\2gi\7$\2\2hj\5\34\17\2"+
		"ih\3\2\2\2ij\3\2\2\2jn\3\2\2\2kn\7%\2\2ln\5\32\16\2me\3\2\2\2mf\3\2\2"+
		"\2mg\3\2\2\2mk\3\2\2\2ml\3\2\2\2n\31\3\2\2\2op\7!\2\2pq\7\'\2\2qr\7&\2"+
		"\2r\33\3\2\2\2st\t\3\2\2t\35\3\2\2\2uv\7\"\2\2vw\7\b\2\2wx\7\t\2\2x\37"+
		"\3\2\2\2y~\5\22\n\2z{\7\n\2\2{}\5\22\n\2|z\3\2\2\2}\u0080\3\2\2\2~|\3"+
		"\2\2\2~\177\3\2\2\2\177!\3\2\2\2\u0080~\3\2\2\2\17)-\62;@GMS[cim~";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}