// Generated from PineScript.g4 by ANTLR 4.8

    package com.flex.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PineScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SUFFIX_DP=1, SUFFIX_PX=2, ID=3, DOT=4, LPAREN=5, RPAREN=6, COMMA=7, NULL=8, 
		TRUE=9, FALSE=10, EQ=11, LBRACKET=12, RBRACKET=13, AND_AND=14, OR_OR=15, 
		QUESTION=16, SEMICOLON=17, COLON=18, LBRACE=19, RBRACE=20, RETURN=21, 
		IMPORT=22, PLUS=23, MINUS=24, MULTI=25, DIV=26, REMAINDER=27, Identifier=28, 
		ObjectDeclaration=29, IntegerLiteral=30, FloatLiteral=31, StringLiteral=32, 
		WS=33, COMMENT=34, LINE_COMMENT=35, LineTerminator=36;
	public static final int
		RULE_program = 0, RULE_rootMember = 1, RULE_objectDefinition = 2, RULE_objectInitializer = 3, 
		RULE_objectIdentifier = 4, RULE_objectMember = 5, RULE_propertyAssignement = 6, 
		RULE_expression = 7, RULE_binaryOperation = 8, RULE_objectPropertyExpression = 9, 
		RULE_primitiveExpression = 10, RULE_functionExpression = 11, RULE_arguments = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "rootMember", "objectDefinition", "objectInitializer", "objectIdentifier", 
			"objectMember", "propertyAssignement", "expression", "binaryOperation", 
			"objectPropertyExpression", "primitiveExpression", "functionExpression", 
			"arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'dp'", "'px'", "'id'", "'.'", "'('", "')'", "','", "'null'", "'true'", 
			"'false'", "'='", "'['", "']'", "'&&'", "'||'", "'?'", "';'", "':'", 
			"'{'", "'}'", "'return'", "'import'", "'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SUFFIX_DP", "SUFFIX_PX", "ID", "DOT", "LPAREN", "RPAREN", "COMMA", 
			"NULL", "TRUE", "FALSE", "EQ", "LBRACKET", "RBRACKET", "AND_AND", "OR_OR", 
			"QUESTION", "SEMICOLON", "COLON", "LBRACE", "RBRACE", "RETURN", "IMPORT", 
			"PLUS", "MINUS", "MULTI", "DIV", "REMAINDER", "Identifier", "ObjectDeclaration", 
			"IntegerLiteral", "FloatLiteral", "StringLiteral", "WS", "COMMENT", "LINE_COMMENT", 
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

	public PineScriptParser(TokenStream input) {
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
			setState(26);
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
			setState(28);
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
		public TerminalNode ObjectDeclaration() { return getToken(PineScriptParser.ObjectDeclaration, 0); }
		public ObjectInitializerContext objectInitializer() {
			return getRuleContext(ObjectInitializerContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
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
			setState(30);
			match(ObjectDeclaration);
			setState(31);
			objectInitializer();
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(32);
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
		public TerminalNode LBRACE() { return getToken(PineScriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PineScriptParser.RBRACE, 0); }
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
			setState(35);
			match(LBRACE);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(36);
				objectIdentifier();
				}
			}

			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier || _la==ObjectDeclaration) {
				{
				{
				setState(39);
				objectMember();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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
		public TerminalNode ID() { return getToken(PineScriptParser.ID, 0); }
		public TerminalNode COLON() { return getToken(PineScriptParser.COLON, 0); }
		public TerminalNode Identifier() { return getToken(PineScriptParser.Identifier, 0); }
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
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
			setState(47);
			match(ID);
			setState(48);
			match(COLON);
			setState(49);
			match(Identifier);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(50);
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
		public PropertyAssignementContext propertyAssignement() {
			return getRuleContext(PropertyAssignementContext.class,0);
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
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ObjectDeclaration:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				objectDefinition();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				propertyAssignement();
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

	public static class PropertyAssignementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PineScriptParser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(PineScriptParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
		public PropertyAssignementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyAssignement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterPropertyAssignement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitPropertyAssignement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitPropertyAssignement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyAssignementContext propertyAssignement() throws RecognitionException {
		PropertyAssignementContext _localctx = new PropertyAssignementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_propertyAssignement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(Identifier);
			setState(58);
			match(COLON);
			setState(59);
			expression(0);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(60);
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
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case IntegerLiteral:
			case FloatLiteral:
			case StringLiteral:
				{
				setState(64);
				primitiveExpression();
				}
				break;
			case Identifier:
				{
				setState(65);
				objectPropertyExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(68);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(69);
					binaryOperation();
					setState(70);
					expression(2);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public TerminalNode PLUS() { return getToken(PineScriptParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PineScriptParser.MINUS, 0); }
		public TerminalNode MULTI() { return getToken(PineScriptParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(PineScriptParser.DIV, 0); }
		public TerminalNode REMAINDER() { return getToken(PineScriptParser.REMAINDER, 0); }
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
			setState(77);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULTI) | (1L << DIV) | (1L << REMAINDER))) != 0)) ) {
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
		public List<TerminalNode> Identifier() { return getTokens(PineScriptParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PineScriptParser.Identifier, i);
		}
		public TerminalNode DOT() { return getToken(PineScriptParser.DOT, 0); }
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
			setState(79);
			match(Identifier);
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(80);
				match(DOT);
				setState(81);
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
		public TerminalNode TRUE() { return getToken(PineScriptParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PineScriptParser.FALSE, 0); }
		public TerminalNode IntegerLiteral() { return getToken(PineScriptParser.IntegerLiteral, 0); }
		public TerminalNode FloatLiteral() { return getToken(PineScriptParser.FloatLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(PineScriptParser.StringLiteral, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << IntegerLiteral) | (1L << FloatLiteral) | (1L << StringLiteral))) != 0)) ) {
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

	public static class FunctionExpressionContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PineScriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PineScriptParser.RBRACE, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitFunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionExpressionContext functionExpression() throws RecognitionException {
		FunctionExpressionContext _localctx = new FunctionExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(LBRACE);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << FloatLiteral) | (1L << StringLiteral))) != 0)) {
				{
				setState(87);
				arguments();
				}
			}

			setState(90);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PineScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PineScriptParser.COMMA, i);
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
		enterRule(_localctx, 24, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			expression(0);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(93);
				match(COMMA);
				setState(94);
				expression(0);
				}
				}
				setState(99);
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
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&g\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\4\5\4$\n\4\3\5\3\5\5"+
		"\5(\n\5\3\5\7\5+\n\5\f\5\16\5.\13\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6\66\n\6"+
		"\3\7\3\7\5\7:\n\7\3\b\3\b\3\b\3\b\5\b@\n\b\3\t\3\t\3\t\5\tE\n\t\3\t\3"+
		"\t\3\t\3\t\7\tK\n\t\f\t\16\tN\13\t\3\n\3\n\3\13\3\13\3\13\5\13U\n\13\3"+
		"\f\3\f\3\r\3\r\5\r[\n\r\3\r\3\r\3\16\3\16\3\16\7\16b\n\16\f\16\16\16e"+
		"\13\16\3\16\2\3\20\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4\3\2\31\35\4"+
		"\2\13\f \"\2d\2\34\3\2\2\2\4\36\3\2\2\2\6 \3\2\2\2\b%\3\2\2\2\n\61\3\2"+
		"\2\2\f9\3\2\2\2\16;\3\2\2\2\20D\3\2\2\2\22O\3\2\2\2\24Q\3\2\2\2\26V\3"+
		"\2\2\2\30X\3\2\2\2\32^\3\2\2\2\34\35\5\4\3\2\35\3\3\2\2\2\36\37\5\6\4"+
		"\2\37\5\3\2\2\2 !\7\37\2\2!#\5\b\5\2\"$\7\23\2\2#\"\3\2\2\2#$\3\2\2\2"+
		"$\7\3\2\2\2%\'\7\25\2\2&(\5\n\6\2\'&\3\2\2\2\'(\3\2\2\2(,\3\2\2\2)+\5"+
		"\f\7\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60"+
		"\7\26\2\2\60\t\3\2\2\2\61\62\7\5\2\2\62\63\7\24\2\2\63\65\7\36\2\2\64"+
		"\66\7\23\2\2\65\64\3\2\2\2\65\66\3\2\2\2\66\13\3\2\2\2\67:\5\6\4\28:\5"+
		"\16\b\29\67\3\2\2\298\3\2\2\2:\r\3\2\2\2;<\7\36\2\2<=\7\24\2\2=?\5\20"+
		"\t\2>@\7\23\2\2?>\3\2\2\2?@\3\2\2\2@\17\3\2\2\2AB\b\t\1\2BE\5\26\f\2C"+
		"E\5\24\13\2DA\3\2\2\2DC\3\2\2\2EL\3\2\2\2FG\f\3\2\2GH\5\22\n\2HI\5\20"+
		"\t\4IK\3\2\2\2JF\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\21\3\2\2\2NL\3"+
		"\2\2\2OP\t\2\2\2P\23\3\2\2\2QT\7\36\2\2RS\7\6\2\2SU\7\36\2\2TR\3\2\2\2"+
		"TU\3\2\2\2U\25\3\2\2\2VW\t\3\2\2W\27\3\2\2\2XZ\7\25\2\2Y[\5\32\16\2ZY"+
		"\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\26\2\2]\31\3\2\2\2^c\5\20\t\2_`\7\t"+
		"\2\2`b\5\20\t\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\33\3\2\2\2ec"+
		"\3\2\2\2\r#\',\659?DLTZc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}