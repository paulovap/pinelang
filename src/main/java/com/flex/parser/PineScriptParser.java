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
		IMPORT=22, Identifier=23, ObjectDeclaration=24, IntegerLiteral=25, FloatLiteral=26, 
		StringLiteral=27, WS=28, COMMENT=29, LINE_COMMENT=30, LineTerminator=31;
	public static final int
		RULE_program = 0, RULE_rootMember = 1, RULE_objectDefinition = 2, RULE_objectInitializer = 3, 
		RULE_objectIdentifier = 4, RULE_objectMember = 5, RULE_propertyAssignement = 6, 
		RULE_assignExpression = 7, RULE_objectPropertyExpression = 8, RULE_primitiveExpression = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "rootMember", "objectDefinition", "objectInitializer", "objectIdentifier", 
			"objectMember", "propertyAssignement", "assignExpression", "objectPropertyExpression", 
			"primitiveExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'dp'", "'px'", "'id'", "'.'", "'('", "')'", "','", "'null'", "'true'", 
			"'false'", "'='", "'['", "']'", "'&&'", "'||'", "'?'", "';'", "':'", 
			"'{'", "'}'", "'return'", "'import'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SUFFIX_DP", "SUFFIX_PX", "ID", "DOT", "LPAREN", "RPAREN", "COMMA", 
			"NULL", "TRUE", "FALSE", "EQ", "LBRACKET", "RBRACKET", "AND_AND", "OR_OR", 
			"QUESTION", "SEMICOLON", "COLON", "LBRACE", "RBRACE", "RETURN", "IMPORT", 
			"Identifier", "ObjectDeclaration", "IntegerLiteral", "FloatLiteral", 
			"StringLiteral", "WS", "COMMENT", "LINE_COMMENT", "LineTerminator"
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
			setState(20);
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
			setState(22);
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
			setState(24);
			match(ObjectDeclaration);
			setState(25);
			objectInitializer();
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(26);
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
			setState(29);
			match(LBRACE);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(30);
				objectIdentifier();
				}
			}

			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier || _la==ObjectDeclaration) {
				{
				{
				setState(33);
				objectMember();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
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
			setState(41);
			match(ID);
			setState(42);
			match(COLON);
			setState(43);
			match(Identifier);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(44);
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
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ObjectDeclaration:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				objectDefinition();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
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
		public AssignExpressionContext assignExpression() {
			return getRuleContext(AssignExpressionContext.class,0);
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
			setState(51);
			match(Identifier);
			setState(52);
			match(COLON);
			setState(53);
			assignExpression();
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(54);
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

	public static class AssignExpressionContext extends ParserRuleContext {
		public PrimitiveExpressionContext primitiveExpression() {
			return getRuleContext(PrimitiveExpressionContext.class,0);
		}
		public ObjectPropertyExpressionContext objectPropertyExpression() {
			return getRuleContext(ObjectPropertyExpressionContext.class,0);
		}
		public AssignExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterAssignExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitAssignExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitAssignExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignExpressionContext assignExpression() throws RecognitionException {
		AssignExpressionContext _localctx = new AssignExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignExpression);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case IntegerLiteral:
			case FloatLiteral:
			case StringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				primitiveExpression();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				objectPropertyExpression();
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
		enterRule(_localctx, 16, RULE_objectPropertyExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(Identifier);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(62);
				match(DOT);
				setState(63);
				match(Identifier);
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
		enterRule(_localctx, 18, RULE_primitiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!G\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\4\5\4\36\n\4\3\5\3\5\5\5\"\n\5\3\5\7\5%\n\5\f\5"+
		"\16\5(\13\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6\60\n\6\3\7\3\7\5\7\64\n\7\3\b"+
		"\3\b\3\b\3\b\5\b:\n\b\3\t\3\t\5\t>\n\t\3\n\3\n\3\n\5\nC\n\n\3\13\3\13"+
		"\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\3\4\2\13\f\33\35\2D\2\26\3\2\2\2"+
		"\4\30\3\2\2\2\6\32\3\2\2\2\b\37\3\2\2\2\n+\3\2\2\2\f\63\3\2\2\2\16\65"+
		"\3\2\2\2\20=\3\2\2\2\22?\3\2\2\2\24D\3\2\2\2\26\27\5\4\3\2\27\3\3\2\2"+
		"\2\30\31\5\6\4\2\31\5\3\2\2\2\32\33\7\32\2\2\33\35\5\b\5\2\34\36\7\23"+
		"\2\2\35\34\3\2\2\2\35\36\3\2\2\2\36\7\3\2\2\2\37!\7\25\2\2 \"\5\n\6\2"+
		"! \3\2\2\2!\"\3\2\2\2\"&\3\2\2\2#%\5\f\7\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2"+
		"\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\7\26\2\2*\t\3\2\2\2+,\7\5\2\2,-\7"+
		"\24\2\2-/\7\31\2\2.\60\7\23\2\2/.\3\2\2\2/\60\3\2\2\2\60\13\3\2\2\2\61"+
		"\64\5\6\4\2\62\64\5\16\b\2\63\61\3\2\2\2\63\62\3\2\2\2\64\r\3\2\2\2\65"+
		"\66\7\31\2\2\66\67\7\24\2\2\679\5\20\t\28:\7\23\2\298\3\2\2\29:\3\2\2"+
		"\2:\17\3\2\2\2;>\5\24\13\2<>\5\22\n\2=;\3\2\2\2=<\3\2\2\2>\21\3\2\2\2"+
		"?B\7\31\2\2@A\7\6\2\2AC\7\31\2\2B@\3\2\2\2BC\3\2\2\2C\23\3\2\2\2DE\t\2"+
		"\2\2E\25\3\2\2\2\n\35!&/\639=B";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}