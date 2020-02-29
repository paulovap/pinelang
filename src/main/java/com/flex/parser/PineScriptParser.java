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
		ENUM=1, PROPERTY=2, READONLY=3, DOT=4, SIGNAL=5, DEBUGGER=6, THROW=7, 
		CONTINUE=8, INSTANCEOF=9, ON=10, LET=11, CONST=12, DO=13, WHILE=14, FOR=15, 
		BREAK=16, TRY=17, CATCH=18, FINALLY=19, CASE=20, DEFAULT=21, SWITCH=22, 
		WITH=23, IF=24, ELSE=25, GET=26, SET=27, FUNCTION=28, LPAREN=29, RPAREN=30, 
		COMMA=31, DELETE=32, VOID=33, TYPEOF=34, PLUS_PLUS=35, MINUS_MINUS=36, 
		TILDE=37, NOT=38, STAR=39, REMAINDER=40, REMAINDER_EQ=41, PLUS=42, PLUS_EQ=43, 
		MINUS_EQ=44, MINUS=45, IN=46, LT=47, LT_LT=48, GT=49, GT_GT=50, GT_GT_GT=51, 
		LE=52, GE=53, LLEQ=54, GGEQ=55, GGGEQ=56, AND_EQ=57, XOR_EQ=58, OR_EQ=59, 
		EQ_EQ=60, EQ_EQ_EQ=61, STAR_EQ=62, NOT_EQ=63, NOT_EQ_EQ=64, THIS=65, NULL=66, 
		TRUE=67, FALSE=68, EQ=69, DIVIDE_=70, DIVIDE_EQ=71, LBRACKET=72, RBRACKET=73, 
		NEW=74, XOR=75, AND=76, OR=77, AND_AND=78, OR_OR=79, QUESTION=80, SEMICOLON=81, 
		COLON=82, LBRACE=83, RBRACE=84, RETURN=85, IMPORT=86, PRAGMA=87, AS=88, 
		JsIdentifier=89, Identifier=90, VAR=91, IntegerLiteral=92, FloatLiteral=93, 
		StringLiteral=94, LineTerminator=95, WS=96, COMMENT=97, LINE_COMMENT=98, 
		NumericLiteral=99;
	public static final int
		RULE_program = 0, RULE_import_ = 1, RULE_importIdentifier = 2, RULE_rootMember = 3, 
		RULE_objectDefinition = 4, RULE_objectInitializer = 5, RULE_objectMember = 6, 
		RULE_propertyAssignement = 7, RULE_statement = 8, RULE_variableStatement = 9, 
		RULE_variableDeclarationKind = 10, RULE_variableDeclarationList = 11, 
		RULE_variableDeclaration = 12, RULE_initialiser = 13, RULE_debuggerStatement = 14, 
		RULE_throwStatement = 15, RULE_continueStatement = 16, RULE_iterationStatement = 17, 
		RULE_assignmentOperator = 18, RULE_labelledStatement = 19, RULE_breakStatement = 20, 
		RULE_returnStatement = 21, RULE_tryStatement = 22, RULE_catch_ = 23, RULE_finally_ = 24, 
		RULE_block = 25, RULE_caseBlock = 26, RULE_caseClause = 27, RULE_defaultClause = 28, 
		RULE_switchStatement = 29, RULE_withStatement = 30, RULE_ifStatement = 31, 
		RULE_statementListOpt = 32, RULE_statementList = 33, RULE_emptyStatement = 34, 
		RULE_expression = 35, RULE_leftHandSideExpression = 36, RULE_callExpression = 37, 
		RULE_newExpression = 38, RULE_memberExpression = 39, RULE_argumentList = 40, 
		RULE_propertyIdentifier = 41, RULE_functionExpression = 42, RULE_formalParameterList = 43, 
		RULE_functionBody = 44, RULE_sourceElement = 45, RULE_functionDeclaration = 46, 
		RULE_primaryExpression = 47, RULE_ternaryExpression = 48, RULE_binaryExpression = 49, 
		RULE_binaryOp = 50, RULE_unaryExpression = 51, RULE_reservedIdentifier = 52;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "import_", "importIdentifier", "rootMember", "objectDefinition", 
			"objectInitializer", "objectMember", "propertyAssignement", "statement", 
			"variableStatement", "variableDeclarationKind", "variableDeclarationList", 
			"variableDeclaration", "initialiser", "debuggerStatement", "throwStatement", 
			"continueStatement", "iterationStatement", "assignmentOperator", "labelledStatement", 
			"breakStatement", "returnStatement", "tryStatement", "catch_", "finally_", 
			"block", "caseBlock", "caseClause", "defaultClause", "switchStatement", 
			"withStatement", "ifStatement", "statementListOpt", "statementList", 
			"emptyStatement", "expression", "leftHandSideExpression", "callExpression", 
			"newExpression", "memberExpression", "argumentList", "propertyIdentifier", 
			"functionExpression", "formalParameterList", "functionBody", "sourceElement", 
			"functionDeclaration", "primaryExpression", "ternaryExpression", "binaryExpression", 
			"binaryOp", "unaryExpression", "reservedIdentifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'enum'", "'property'", "'readonly'", "'.'", "'signal'", "'debbuger'", 
			"'throw'", "'continue'", "'instanceof'", "'on'", "'let'", "'const'", 
			"'do'", "'while'", "'for'", "'break'", "'try'", "'catch'", "'finally'", 
			"'case'", "'default'", "'switch'", "'with'", "'if'", "'else'", "'get'", 
			"'set'", "'function'", "'('", "')'", "','", "'delete'", "'void'", "'typeof'", 
			"'++'", "'--'", "'~'", "'!'", "'*'", "'%'", "'%='", "'+'", "'+='", "'-='", 
			"'-'", "'in'", "'<'", "'<<'", "'>'", "'>>'", "'>>>'", "'<='", "'>='", 
			"'<<='", "'>>='", "'>>>='", "'&='", "'^='", "'|='", "'=='", "'==='", 
			"'*='", "'!='", "'!=='", "'this'", "'null'", "'true'", "'false'", "'='", 
			"'/'", "'/='", "'['", "']'", "'new'", "'^'", "'&'", "'|'", "'&&'", "'||'", 
			"'?'", "';'", "':'", "'{'", "'}'", "'return'", "'import'", "'pragma'", 
			"'as'", null, null, "'var'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ENUM", "PROPERTY", "READONLY", "DOT", "SIGNAL", "DEBUGGER", "THROW", 
			"CONTINUE", "INSTANCEOF", "ON", "LET", "CONST", "DO", "WHILE", "FOR", 
			"BREAK", "TRY", "CATCH", "FINALLY", "CASE", "DEFAULT", "SWITCH", "WITH", 
			"IF", "ELSE", "GET", "SET", "FUNCTION", "LPAREN", "RPAREN", "COMMA", 
			"DELETE", "VOID", "TYPEOF", "PLUS_PLUS", "MINUS_MINUS", "TILDE", "NOT", 
			"STAR", "REMAINDER", "REMAINDER_EQ", "PLUS", "PLUS_EQ", "MINUS_EQ", "MINUS", 
			"IN", "LT", "LT_LT", "GT", "GT_GT", "GT_GT_GT", "LE", "GE", "LLEQ", "GGEQ", 
			"GGGEQ", "AND_EQ", "XOR_EQ", "OR_EQ", "EQ_EQ", "EQ_EQ_EQ", "STAR_EQ", 
			"NOT_EQ", "NOT_EQ_EQ", "THIS", "NULL", "TRUE", "FALSE", "EQ", "DIVIDE_", 
			"DIVIDE_EQ", "LBRACKET", "RBRACKET", "NEW", "XOR", "AND", "OR", "AND_AND", 
			"OR_OR", "QUESTION", "SEMICOLON", "COLON", "LBRACE", "RBRACE", "RETURN", 
			"IMPORT", "PRAGMA", "AS", "JsIdentifier", "Identifier", "VAR", "IntegerLiteral", 
			"FloatLiteral", "StringLiteral", "LineTerminator", "WS", "COMMENT", "LINE_COMMENT", 
			"NumericLiteral"
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
		public List<Import_Context> import_() {
			return getRuleContexts(Import_Context.class);
		}
		public Import_Context import_(int i) {
			return getRuleContext(Import_Context.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(106);
				import_();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
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

	public static class Import_Context extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(PineScriptParser.IMPORT, 0); }
		public ImportIdentifierContext importIdentifier() {
			return getRuleContext(ImportIdentifierContext.class,0);
		}
		public TerminalNode NumericLiteral() { return getToken(PineScriptParser.NumericLiteral, 0); }
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
		public Import_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterImport_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitImport_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitImport_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_Context import_() throws RecognitionException {
		Import_Context _localctx = new Import_Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_import_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(IMPORT);
			setState(115);
			importIdentifier();
			setState(116);
			match(NumericLiteral);
			setState(117);
			match(SEMICOLON);
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

	public static class ImportIdentifierContext extends ParserRuleContext {
		public TerminalNode JsIdentifier() { return getToken(PineScriptParser.JsIdentifier, 0); }
		public TerminalNode StringLiteral() { return getToken(PineScriptParser.StringLiteral, 0); }
		public ImportIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterImportIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitImportIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitImportIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportIdentifierContext importIdentifier() throws RecognitionException {
		ImportIdentifierContext _localctx = new ImportIdentifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !(_la==JsIdentifier || _la==StringLiteral) ) {
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
		enterRule(_localctx, 6, RULE_rootMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
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
		public TerminalNode JsIdentifier() { return getToken(PineScriptParser.JsIdentifier, 0); }
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
		enterRule(_localctx, 8, RULE_objectDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(JsIdentifier);
			setState(124);
			objectInitializer();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(125);
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
		enterRule(_localctx, 10, RULE_objectInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(LBRACE);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==JsIdentifier) {
				{
				{
				setState(129);
				objectMember();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
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
		enterRule(_localctx, 12, RULE_objectMember);
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				objectDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				propertyAssignement();
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

	public static class PropertyAssignementContext extends ParserRuleContext {
		public TerminalNode JsIdentifier() { return getToken(PineScriptParser.JsIdentifier, 0); }
		public TerminalNode COLON() { return getToken(PineScriptParser.COLON, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
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
		enterRule(_localctx, 14, RULE_propertyAssignement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(JsIdentifier);
			setState(142);
			match(COLON);
			setState(143);
			primaryExpression();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(144);
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

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariableStatementContext variableStatement() {
			return getRuleContext(VariableStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public WithStatementContext withStatement() {
			return getRuleContext(WithStatementContext.class,0);
		}
		public LabelledStatementContext labelledStatement() {
			return getRuleContext(LabelledStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public DebuggerStatementContext debuggerStatement() {
			return getRuleContext(DebuggerStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				block();
				}
				break;
			case LET:
			case CONST:
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				variableStatement();
				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				emptyStatement();
				}
				break;
			case FUNCTION:
			case TRUE:
			case FALSE:
			case NEW:
			case IntegerLiteral:
			case FloatLiteral:
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				expression();
				setState(152);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(151);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				ifStatement();
				}
				break;
			case DO:
			case WHILE:
			case FOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(155);
				iterationStatement();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 7);
				{
				setState(156);
				continueStatement();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 8);
				{
				setState(157);
				breakStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 9);
				{
				setState(158);
				returnStatement();
				}
				break;
			case WITH:
				enterOuterAlt(_localctx, 10);
				{
				setState(159);
				withStatement();
				}
				break;
			case JsIdentifier:
				enterOuterAlt(_localctx, 11);
				{
				setState(160);
				labelledStatement();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 12);
				{
				setState(161);
				switchStatement();
				}
				break;
			case THROW:
				enterOuterAlt(_localctx, 13);
				{
				setState(162);
				throwStatement();
				}
				break;
			case TRY:
				enterOuterAlt(_localctx, 14);
				{
				setState(163);
				tryStatement();
				}
				break;
			case DEBUGGER:
				enterOuterAlt(_localctx, 15);
				{
				setState(164);
				debuggerStatement();
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

	public static class VariableStatementContext extends ParserRuleContext {
		public VariableDeclarationKindContext variableDeclarationKind() {
			return getRuleContext(VariableDeclarationKindContext.class,0);
		}
		public VariableDeclarationListContext variableDeclarationList() {
			return getRuleContext(VariableDeclarationListContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
		public VariableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterVariableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitVariableStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitVariableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableStatementContext variableStatement() throws RecognitionException {
		VariableStatementContext _localctx = new VariableStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			variableDeclarationKind();
			setState(168);
			variableDeclarationList(0);
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(169);
				match(SEMICOLON);
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

	public static class VariableDeclarationKindContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(PineScriptParser.LET, 0); }
		public TerminalNode CONST() { return getToken(PineScriptParser.CONST, 0); }
		public TerminalNode VAR() { return getToken(PineScriptParser.VAR, 0); }
		public VariableDeclarationKindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationKind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterVariableDeclarationKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitVariableDeclarationKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitVariableDeclarationKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationKindContext variableDeclarationKind() throws RecognitionException {
		VariableDeclarationKindContext _localctx = new VariableDeclarationKindContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableDeclarationKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_la = _input.LA(1);
			if ( !(_la==LET || _la==CONST || _la==VAR) ) {
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

	public static class VariableDeclarationListContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableDeclarationListContext variableDeclarationList() {
			return getRuleContext(VariableDeclarationListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PineScriptParser.COMMA, 0); }
		public VariableDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterVariableDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitVariableDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitVariableDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationListContext variableDeclarationList() throws RecognitionException {
		return variableDeclarationList(0);
	}

	private VariableDeclarationListContext variableDeclarationList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariableDeclarationListContext _localctx = new VariableDeclarationListContext(_ctx, _parentState);
		VariableDeclarationListContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_variableDeclarationList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(175);
			variableDeclaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VariableDeclarationListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_variableDeclarationList);
					setState(177);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(178);
					match(COMMA);
					setState(179);
					variableDeclaration();
					}
					} 
				}
				setState(184);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode JsIdentifier() { return getToken(PineScriptParser.JsIdentifier, 0); }
		public List<InitialiserContext> initialiser() {
			return getRuleContexts(InitialiserContext.class);
		}
		public InitialiserContext initialiser(int i) {
			return getRuleContext(InitialiserContext.class,i);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variableDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(JsIdentifier);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(186);
					initialiser();
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class InitialiserContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(PineScriptParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitialiserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialiser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterInitialiser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitInitialiser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitInitialiser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialiserContext initialiser() throws RecognitionException {
		InitialiserContext _localctx = new InitialiserContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_initialiser);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(EQ);
			setState(193);
			expression();
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

	public static class DebuggerStatementContext extends ParserRuleContext {
		public TerminalNode DEBUGGER() { return getToken(PineScriptParser.DEBUGGER, 0); }
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
		public DebuggerStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_debuggerStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterDebuggerStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitDebuggerStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitDebuggerStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DebuggerStatementContext debuggerStatement() throws RecognitionException {
		DebuggerStatementContext _localctx = new DebuggerStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_debuggerStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(DEBUGGER);
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(196);
				match(SEMICOLON);
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

	public static class ThrowStatementContext extends ParserRuleContext {
		public TerminalNode THROW() { return getToken(PineScriptParser.THROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitThrowStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitThrowStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(THROW);
			setState(200);
			expression();
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(201);
				match(SEMICOLON);
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

	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(PineScriptParser.CONTINUE, 0); }
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
		public TerminalNode JsIdentifier() { return getToken(PineScriptParser.JsIdentifier, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_continueStatement);
		try {
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(CONTINUE);
				setState(206);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(205);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(CONTINUE);
				setState(209);
				match(JsIdentifier);
				setState(211);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(210);
					match(SEMICOLON);
					}
					break;
				}
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

	public static class IterationStatementContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(PineScriptParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(PineScriptParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(PineScriptParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PineScriptParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
		public TerminalNode FOR() { return getToken(PineScriptParser.FOR, 0); }
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public TerminalNode IN() { return getToken(PineScriptParser.IN, 0); }
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_iterationStatement);
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DO:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(DO);
				setState(216);
				statement();
				setState(217);
				match(WHILE);
				setState(218);
				match(LPAREN);
				setState(219);
				expression();
				setState(220);
				match(RPAREN);
				setState(222);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(221);
					match(SEMICOLON);
					}
					break;
				}
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				match(WHILE);
				setState(225);
				match(LPAREN);
				setState(226);
				expression();
				setState(227);
				match(RPAREN);
				setState(228);
				statement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				match(FOR);
				setState(231);
				match(LPAREN);
				setState(232);
				leftHandSideExpression();
				setState(233);
				match(IN);
				setState(234);
				expression();
				setState(235);
				match(RPAREN);
				setState(236);
				statement();
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

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(PineScriptParser.EQ, 0); }
		public TerminalNode STAR_EQ() { return getToken(PineScriptParser.STAR_EQ, 0); }
		public TerminalNode DIVIDE_EQ() { return getToken(PineScriptParser.DIVIDE_EQ, 0); }
		public TerminalNode REMAINDER_EQ() { return getToken(PineScriptParser.REMAINDER_EQ, 0); }
		public TerminalNode PLUS_EQ() { return getToken(PineScriptParser.PLUS_EQ, 0); }
		public TerminalNode MINUS_EQ() { return getToken(PineScriptParser.MINUS_EQ, 0); }
		public TerminalNode LLEQ() { return getToken(PineScriptParser.LLEQ, 0); }
		public TerminalNode GGEQ() { return getToken(PineScriptParser.GGEQ, 0); }
		public TerminalNode GGGEQ() { return getToken(PineScriptParser.GGGEQ, 0); }
		public TerminalNode AND_EQ() { return getToken(PineScriptParser.AND_EQ, 0); }
		public TerminalNode XOR_EQ() { return getToken(PineScriptParser.XOR_EQ, 0); }
		public TerminalNode OR_EQ() { return getToken(PineScriptParser.OR_EQ, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitAssignmentOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitAssignmentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_la = _input.LA(1);
			if ( !(((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & ((1L << (REMAINDER_EQ - 41)) | (1L << (PLUS_EQ - 41)) | (1L << (MINUS_EQ - 41)) | (1L << (LLEQ - 41)) | (1L << (GGEQ - 41)) | (1L << (GGGEQ - 41)) | (1L << (AND_EQ - 41)) | (1L << (XOR_EQ - 41)) | (1L << (OR_EQ - 41)) | (1L << (STAR_EQ - 41)) | (1L << (EQ - 41)) | (1L << (DIVIDE_EQ - 41)))) != 0)) ) {
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

	public static class LabelledStatementContext extends ParserRuleContext {
		public TerminalNode JsIdentifier() { return getToken(PineScriptParser.JsIdentifier, 0); }
		public TerminalNode COLON() { return getToken(PineScriptParser.COLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LabelledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterLabelledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitLabelledStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitLabelledStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelledStatementContext labelledStatement() throws RecognitionException {
		LabelledStatementContext _localctx = new LabelledStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_labelledStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(JsIdentifier);
			setState(243);
			match(COLON);
			setState(244);
			statement();
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

	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(PineScriptParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(BREAK);
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(247);
				match(SEMICOLON);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(PineScriptParser.RETURN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_returnStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(RETURN);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(251);
					expression();
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(257);
				match(SEMICOLON);
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

	public static class TryStatementContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(PineScriptParser.TRY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Catch_Context catch_() {
			return getRuleContext(Catch_Context.class,0);
		}
		public Finally_Context finally_() {
			return getRuleContext(Finally_Context.class,0);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitTryStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitTryStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_tryStatement);
		try {
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				match(TRY);
				setState(261);
				block();
				setState(262);
				catch_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(TRY);
				setState(265);
				block();
				setState(266);
				finally_();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(268);
				match(TRY);
				setState(269);
				block();
				setState(270);
				catch_();
				setState(271);
				finally_();
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

	public static class Catch_Context extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(PineScriptParser.CATCH, 0); }
		public TerminalNode LPAREN() { return getToken(PineScriptParser.LPAREN, 0); }
		public TerminalNode JsIdentifier() { return getToken(PineScriptParser.JsIdentifier, 0); }
		public TerminalNode RPAREN() { return getToken(PineScriptParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Catch_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catch_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterCatch_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitCatch_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitCatch_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Catch_Context catch_() throws RecognitionException {
		Catch_Context _localctx = new Catch_Context(_ctx, getState());
		enterRule(_localctx, 46, RULE_catch_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(CATCH);
			setState(276);
			match(LPAREN);
			setState(277);
			match(JsIdentifier);
			setState(278);
			match(RPAREN);
			setState(279);
			block();
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

	public static class Finally_Context extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(PineScriptParser.FINALLY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Finally_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finally_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterFinally_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitFinally_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitFinally_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Finally_Context finally_() throws RecognitionException {
		Finally_Context _localctx = new Finally_Context(_ctx, getState());
		enterRule(_localctx, 48, RULE_finally_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(FINALLY);
			setState(282);
			block();
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PineScriptParser.LBRACE, 0); }
		public StatementListOptContext statementListOpt() {
			return getRuleContext(StatementListOptContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(PineScriptParser.RBRACE, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(LBRACE);
			setState(285);
			statementListOpt();
			setState(286);
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

	public static class CaseBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PineScriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PineScriptParser.RBRACE, 0); }
		public List<CaseClauseContext> caseClause() {
			return getRuleContexts(CaseClauseContext.class);
		}
		public CaseClauseContext caseClause(int i) {
			return getRuleContext(CaseClauseContext.class,i);
		}
		public DefaultClauseContext defaultClause() {
			return getRuleContext(DefaultClauseContext.class,0);
		}
		public CaseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterCaseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitCaseBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitCaseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseBlockContext caseBlock() throws RecognitionException {
		CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_caseBlock);
		int _la;
		try {
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(LBRACE);
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE) {
					{
					{
					setState(289);
					caseClause();
					}
					}
					setState(294);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(295);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				match(LBRACE);
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE) {
					{
					{
					setState(297);
					caseClause();
					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(303);
				defaultClause();
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE) {
					{
					{
					setState(304);
					caseClause();
					}
					}
					setState(309);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(310);
				match(RBRACE);
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

	public static class CaseClauseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(PineScriptParser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PineScriptParser.COLON, 0); }
		public StatementListOptContext statementListOpt() {
			return getRuleContext(StatementListOptContext.class,0);
		}
		public CaseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterCaseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitCaseClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitCaseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseClauseContext caseClause() throws RecognitionException {
		CaseClauseContext _localctx = new CaseClauseContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_caseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(CASE);
			setState(315);
			expression();
			setState(316);
			match(COLON);
			setState(317);
			statementListOpt();
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

	public static class DefaultClauseContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(PineScriptParser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(PineScriptParser.COLON, 0); }
		public StatementListOptContext statementListOpt() {
			return getRuleContext(StatementListOptContext.class,0);
		}
		public DefaultClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterDefaultClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitDefaultClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitDefaultClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultClauseContext defaultClause() throws RecognitionException {
		DefaultClauseContext _localctx = new DefaultClauseContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_defaultClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(DEFAULT);
			setState(320);
			match(COLON);
			setState(321);
			statementListOpt();
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

	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(PineScriptParser.SWITCH, 0); }
		public TerminalNode LPAREN() { return getToken(PineScriptParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PineScriptParser.RPAREN, 0); }
		public CaseBlockContext caseBlock() {
			return getRuleContext(CaseBlockContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(SWITCH);
			setState(324);
			match(LPAREN);
			setState(325);
			expression();
			setState(326);
			match(RPAREN);
			setState(327);
			caseBlock();
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

	public static class WithStatementContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(PineScriptParser.WITH, 0); }
		public TerminalNode LPAREN() { return getToken(PineScriptParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PineScriptParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WithStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterWithStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitWithStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitWithStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithStatementContext withStatement() throws RecognitionException {
		WithStatementContext _localctx = new WithStatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_withStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(WITH);
			setState(330);
			match(LPAREN);
			setState(331);
			expression();
			setState(332);
			match(RPAREN);
			setState(333);
			statement();
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(PineScriptParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(PineScriptParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PineScriptParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(PineScriptParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_ifStatement);
		try {
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(335);
				match(IF);
				setState(336);
				match(LPAREN);
				setState(337);
				expression();
				setState(338);
				match(RPAREN);
				setState(339);
				statement();
				setState(340);
				match(ELSE);
				setState(341);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				match(IF);
				setState(344);
				match(LPAREN);
				setState(345);
				expression();
				setState(346);
				match(RPAREN);
				setState(347);
				statement();
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

	public static class StatementListOptContext extends ParserRuleContext {
		public List<StatementListContext> statementList() {
			return getRuleContexts(StatementListContext.class);
		}
		public StatementListContext statementList(int i) {
			return getRuleContext(StatementListContext.class,i);
		}
		public StatementListOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementListOpt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterStatementListOpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitStatementListOpt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitStatementListOpt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListOptContext statementListOpt() throws RecognitionException {
		StatementListOptContext _localctx = new StatementListOptContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_statementListOpt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEBUGGER) | (1L << THROW) | (1L << CONTINUE) | (1L << LET) | (1L << CONST) | (1L << DO) | (1L << WHILE) | (1L << FOR) | (1L << BREAK) | (1L << TRY) | (1L << SWITCH) | (1L << WITH) | (1L << IF) | (1L << FUNCTION))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (TRUE - 67)) | (1L << (FALSE - 67)) | (1L << (NEW - 67)) | (1L << (SEMICOLON - 67)) | (1L << (LBRACE - 67)) | (1L << (RETURN - 67)) | (1L << (JsIdentifier - 67)) | (1L << (VAR - 67)) | (1L << (IntegerLiteral - 67)) | (1L << (FloatLiteral - 67)) | (1L << (StringLiteral - 67)))) != 0)) {
				{
				{
				setState(351);
				statementList();
				}
				}
				setState(356);
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

	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_statementList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(358); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(357);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(360); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(PineScriptParser.SEMICOLON, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(SEMICOLON);
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
		public BinaryExpressionContext binaryExpression() {
			return getRuleContext(BinaryExpressionContext.class,0);
		}
		public TernaryExpressionContext ternaryExpression() {
			return getRuleContext(TernaryExpressionContext.class,0);
		}
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_expression);
		try {
			setState(370);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				binaryExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				ternaryExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(366);
				leftHandSideExpression();
				setState(367);
				assignmentOperator();
				setState(368);
				expression();
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

	public static class LeftHandSideExpressionContext extends ParserRuleContext {
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public CallExpressionContext callExpression() {
			return getRuleContext(CallExpressionContext.class,0);
		}
		public LeftHandSideExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSideExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterLeftHandSideExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitLeftHandSideExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitLeftHandSideExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftHandSideExpressionContext leftHandSideExpression() throws RecognitionException {
		LeftHandSideExpressionContext _localctx = new LeftHandSideExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_leftHandSideExpression);
		try {
			setState(374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				newExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				callExpression(0);
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

	public static class CallExpressionContext extends ParserRuleContext {
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PineScriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PineScriptParser.RPAREN, 0); }
		public List<ArgumentListContext> argumentList() {
			return getRuleContexts(ArgumentListContext.class);
		}
		public ArgumentListContext argumentList(int i) {
			return getRuleContext(ArgumentListContext.class,i);
		}
		public CallExpressionContext callExpression() {
			return getRuleContext(CallExpressionContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(PineScriptParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(PineScriptParser.RBRACKET, 0); }
		public TerminalNode DOT() { return getToken(PineScriptParser.DOT, 0); }
		public PropertyIdentifierContext propertyIdentifier() {
			return getRuleContext(PropertyIdentifierContext.class,0);
		}
		public CallExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallExpressionContext callExpression() throws RecognitionException {
		return callExpression(0);
	}

	private CallExpressionContext callExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CallExpressionContext _localctx = new CallExpressionContext(_ctx, _parentState);
		CallExpressionContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_callExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(377);
			memberExpression(0);
			setState(378);
			match(LPAREN);
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (TRUE - 67)) | (1L << (FALSE - 67)) | (1L << (NEW - 67)) | (1L << (IntegerLiteral - 67)) | (1L << (FloatLiteral - 67)) | (1L << (StringLiteral - 67)))) != 0)) {
				{
				{
				setState(379);
				argumentList(0);
				}
				}
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(385);
			match(RPAREN);
			}
			_ctx.stop = _input.LT(-1);
			setState(406);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(404);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new CallExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_callExpression);
						setState(387);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(388);
						match(LPAREN);
						setState(392);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==FUNCTION || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (TRUE - 67)) | (1L << (FALSE - 67)) | (1L << (NEW - 67)) | (1L << (IntegerLiteral - 67)) | (1L << (FloatLiteral - 67)) | (1L << (StringLiteral - 67)))) != 0)) {
							{
							{
							setState(389);
							argumentList(0);
							}
							}
							setState(394);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(395);
						match(RPAREN);
						}
						break;
					case 2:
						{
						_localctx = new CallExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_callExpression);
						setState(396);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(397);
						match(LBRACKET);
						setState(398);
						expression();
						setState(399);
						match(RBRACKET);
						}
						break;
					case 3:
						{
						_localctx = new CallExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_callExpression);
						setState(401);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(402);
						match(DOT);
						setState(403);
						propertyIdentifier();
						}
						break;
					}
					} 
				}
				setState(408);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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

	public static class NewExpressionContext extends ParserRuleContext {
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public TerminalNode NEW() { return getToken(PineScriptParser.NEW, 0); }
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public NewExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpressionContext newExpression() throws RecognitionException {
		NewExpressionContext _localctx = new NewExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_newExpression);
		try {
			setState(412);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(409);
				memberExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(410);
				match(NEW);
				setState(411);
				newExpression();
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

	public static class MemberExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public FunctionExpressionContext functionExpression() {
			return getRuleContext(FunctionExpressionContext.class,0);
		}
		public TerminalNode NEW() { return getToken(PineScriptParser.NEW, 0); }
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PineScriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PineScriptParser.RPAREN, 0); }
		public List<ArgumentListContext> argumentList() {
			return getRuleContexts(ArgumentListContext.class);
		}
		public ArgumentListContext argumentList(int i) {
			return getRuleContext(ArgumentListContext.class,i);
		}
		public TerminalNode LBRACKET() { return getToken(PineScriptParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(PineScriptParser.RBRACKET, 0); }
		public TerminalNode DOT() { return getToken(PineScriptParser.DOT, 0); }
		public PropertyIdentifierContext propertyIdentifier() {
			return getRuleContext(PropertyIdentifierContext.class,0);
		}
		public MemberExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterMemberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitMemberExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitMemberExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberExpressionContext memberExpression() throws RecognitionException {
		return memberExpression(0);
	}

	private MemberExpressionContext memberExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MemberExpressionContext _localctx = new MemberExpressionContext(_ctx, _parentState);
		MemberExpressionContext _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_memberExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case IntegerLiteral:
			case FloatLiteral:
			case StringLiteral:
				{
				setState(415);
				primaryExpression();
				}
				break;
			case FUNCTION:
				{
				setState(416);
				functionExpression();
				}
				break;
			case NEW:
				{
				setState(417);
				match(NEW);
				setState(418);
				memberExpression(0);
				setState(419);
				match(LPAREN);
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FUNCTION || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (TRUE - 67)) | (1L << (FALSE - 67)) | (1L << (NEW - 67)) | (1L << (IntegerLiteral - 67)) | (1L << (FloatLiteral - 67)) | (1L << (StringLiteral - 67)))) != 0)) {
					{
					{
					setState(420);
					argumentList(0);
					}
					}
					setState(425);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(426);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(440);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(438);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new MemberExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_memberExpression);
						setState(430);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(431);
						match(LBRACKET);
						setState(432);
						expression();
						setState(433);
						match(RBRACKET);
						}
						break;
					case 2:
						{
						_localctx = new MemberExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_memberExpression);
						setState(435);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(436);
						match(DOT);
						setState(437);
						propertyIdentifier();
						}
						break;
					}
					} 
				}
				setState(442);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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

	public static class ArgumentListContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PineScriptParser.COMMA, 0); }
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		return argumentList(0);
	}

	private ArgumentListContext argumentList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, _parentState);
		ArgumentListContext _prevctx = _localctx;
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_argumentList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(444);
			expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(451);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_argumentList);
					setState(446);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(447);
					match(COMMA);
					setState(448);
					expression();
					}
					} 
				}
				setState(453);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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

	public static class PropertyIdentifierContext extends ParserRuleContext {
		public TerminalNode JsIdentifier() { return getToken(PineScriptParser.JsIdentifier, 0); }
		public ReservedIdentifierContext reservedIdentifier() {
			return getRuleContext(ReservedIdentifierContext.class,0);
		}
		public PropertyIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterPropertyIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitPropertyIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitPropertyIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyIdentifierContext propertyIdentifier() throws RecognitionException {
		PropertyIdentifierContext _localctx = new PropertyIdentifierContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_propertyIdentifier);
		try {
			setState(456);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JsIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				match(JsIdentifier);
				}
				break;
			case ENUM:
			case DEBUGGER:
			case THROW:
			case CONTINUE:
			case INSTANCEOF:
			case LET:
			case CONST:
			case DO:
			case WHILE:
			case FOR:
			case BREAK:
			case TRY:
			case CATCH:
			case FINALLY:
			case CASE:
			case DEFAULT:
			case SWITCH:
			case WITH:
			case IF:
			case ELSE:
			case FUNCTION:
			case DELETE:
			case VOID:
			case TYPEOF:
			case IN:
			case THIS:
			case NULL:
			case TRUE:
			case FALSE:
			case NEW:
			case RETURN:
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(455);
				reservedIdentifier();
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

	public static class FunctionExpressionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(PineScriptParser.FUNCTION, 0); }
		public TerminalNode JsIdentifier() { return getToken(PineScriptParser.JsIdentifier, 0); }
		public TerminalNode LPAREN() { return getToken(PineScriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PineScriptParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(PineScriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PineScriptParser.RBRACE, 0); }
		public List<FormalParameterListContext> formalParameterList() {
			return getRuleContexts(FormalParameterListContext.class);
		}
		public FormalParameterListContext formalParameterList(int i) {
			return getRuleContext(FormalParameterListContext.class,i);
		}
		public List<FunctionBodyContext> functionBody() {
			return getRuleContexts(FunctionBodyContext.class);
		}
		public FunctionBodyContext functionBody(int i) {
			return getRuleContext(FunctionBodyContext.class,i);
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
		enterRule(_localctx, 84, RULE_functionExpression);
		int _la;
		try {
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(458);
				match(FUNCTION);
				setState(459);
				match(JsIdentifier);
				setState(460);
				match(LPAREN);
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==JsIdentifier) {
					{
					{
					setState(461);
					formalParameterList(0);
					}
					}
					setState(466);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(467);
				match(RPAREN);
				setState(468);
				match(LBRACE);
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEBUGGER) | (1L << THROW) | (1L << CONTINUE) | (1L << LET) | (1L << CONST) | (1L << DO) | (1L << WHILE) | (1L << FOR) | (1L << BREAK) | (1L << TRY) | (1L << SWITCH) | (1L << WITH) | (1L << IF) | (1L << FUNCTION))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (TRUE - 67)) | (1L << (FALSE - 67)) | (1L << (NEW - 67)) | (1L << (SEMICOLON - 67)) | (1L << (LBRACE - 67)) | (1L << (RETURN - 67)) | (1L << (JsIdentifier - 67)) | (1L << (VAR - 67)) | (1L << (IntegerLiteral - 67)) | (1L << (FloatLiteral - 67)) | (1L << (StringLiteral - 67)))) != 0)) {
					{
					{
					setState(469);
					functionBody();
					}
					}
					setState(474);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(475);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(476);
				match(FUNCTION);
				setState(477);
				match(LPAREN);
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==JsIdentifier) {
					{
					{
					setState(478);
					formalParameterList(0);
					}
					}
					setState(483);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(484);
				match(RPAREN);
				setState(485);
				match(LBRACE);
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEBUGGER) | (1L << THROW) | (1L << CONTINUE) | (1L << LET) | (1L << CONST) | (1L << DO) | (1L << WHILE) | (1L << FOR) | (1L << BREAK) | (1L << TRY) | (1L << SWITCH) | (1L << WITH) | (1L << IF) | (1L << FUNCTION))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (TRUE - 67)) | (1L << (FALSE - 67)) | (1L << (NEW - 67)) | (1L << (SEMICOLON - 67)) | (1L << (LBRACE - 67)) | (1L << (RETURN - 67)) | (1L << (JsIdentifier - 67)) | (1L << (VAR - 67)) | (1L << (IntegerLiteral - 67)) | (1L << (FloatLiteral - 67)) | (1L << (StringLiteral - 67)))) != 0)) {
					{
					{
					setState(486);
					functionBody();
					}
					}
					setState(491);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(492);
				match(RBRACE);
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

	public static class FormalParameterListContext extends ParserRuleContext {
		public TerminalNode JsIdentifier() { return getToken(PineScriptParser.JsIdentifier, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PineScriptParser.COMMA, 0); }
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		return formalParameterList(0);
	}

	private FormalParameterListContext formalParameterList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, _parentState);
		FormalParameterListContext _prevctx = _localctx;
		int _startState = 86;
		enterRecursionRule(_localctx, 86, RULE_formalParameterList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(496);
			match(JsIdentifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(503);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FormalParameterListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_formalParameterList);
					setState(498);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(499);
					match(COMMA);
					setState(500);
					match(JsIdentifier);
					}
					} 
				}
				setState(505);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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

	public static class FunctionBodyContext extends ParserRuleContext {
		public List<SourceElementContext> sourceElement() {
			return getRuleContexts(SourceElementContext.class);
		}
		public SourceElementContext sourceElement(int i) {
			return getRuleContext(SourceElementContext.class,i);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitFunctionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitFunctionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_functionBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(507); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(506);
					sourceElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(509); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class SourceElementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public SourceElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterSourceElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitSourceElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitSourceElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceElementContext sourceElement() throws RecognitionException {
		SourceElementContext _localctx = new SourceElementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_sourceElement);
		try {
			setState(513);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(511);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(512);
				functionDeclaration();
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(PineScriptParser.FUNCTION, 0); }
		public TerminalNode JsIdentifier() { return getToken(PineScriptParser.JsIdentifier, 0); }
		public TerminalNode LPAREN() { return getToken(PineScriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PineScriptParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(PineScriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PineScriptParser.RBRACE, 0); }
		public List<FormalParameterListContext> formalParameterList() {
			return getRuleContexts(FormalParameterListContext.class);
		}
		public FormalParameterListContext formalParameterList(int i) {
			return getRuleContext(FormalParameterListContext.class,i);
		}
		public List<FunctionBodyContext> functionBody() {
			return getRuleContexts(FunctionBodyContext.class);
		}
		public FunctionBodyContext functionBody(int i) {
			return getRuleContext(FunctionBodyContext.class,i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			match(FUNCTION);
			setState(516);
			match(JsIdentifier);
			setState(517);
			match(LPAREN);
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==JsIdentifier) {
				{
				{
				setState(518);
				formalParameterList(0);
				}
				}
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(524);
			match(RPAREN);
			setState(525);
			match(LBRACE);
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEBUGGER) | (1L << THROW) | (1L << CONTINUE) | (1L << LET) | (1L << CONST) | (1L << DO) | (1L << WHILE) | (1L << FOR) | (1L << BREAK) | (1L << TRY) | (1L << SWITCH) | (1L << WITH) | (1L << IF) | (1L << FUNCTION))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (TRUE - 67)) | (1L << (FALSE - 67)) | (1L << (NEW - 67)) | (1L << (SEMICOLON - 67)) | (1L << (LBRACE - 67)) | (1L << (RETURN - 67)) | (1L << (JsIdentifier - 67)) | (1L << (VAR - 67)) | (1L << (IntegerLiteral - 67)) | (1L << (FloatLiteral - 67)) | (1L << (StringLiteral - 67)))) != 0)) {
				{
				{
				setState(526);
				functionBody();
				}
				}
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(532);
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

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(PineScriptParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PineScriptParser.FALSE, 0); }
		public TerminalNode IntegerLiteral() { return getToken(PineScriptParser.IntegerLiteral, 0); }
		public TerminalNode FloatLiteral() { return getToken(PineScriptParser.FloatLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(PineScriptParser.StringLiteral, 0); }
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_primaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			_la = _input.LA(1);
			if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (TRUE - 67)) | (1L << (FALSE - 67)) | (1L << (IntegerLiteral - 67)) | (1L << (FloatLiteral - 67)) | (1L << (StringLiteral - 67)))) != 0)) ) {
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

	public static class TernaryExpressionContext extends ParserRuleContext {
		public BinaryExpressionContext binaryExpression() {
			return getRuleContext(BinaryExpressionContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(PineScriptParser.QUESTION, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COLON() { return getToken(PineScriptParser.COLON, 0); }
		public TernaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterTernaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitTernaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernaryExpressionContext ternaryExpression() throws RecognitionException {
		TernaryExpressionContext _localctx = new TernaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_ternaryExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			binaryExpression(0);
			setState(537);
			match(QUESTION);
			setState(538);
			expression();
			setState(539);
			match(COLON);
			setState(540);
			expression();
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

	public static class BinaryExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public BinaryExpressionContext binaryExpression() {
			return getRuleContext(BinaryExpressionContext.class,0);
		}
		public BinaryOpContext binaryOp() {
			return getRuleContext(BinaryOpContext.class,0);
		}
		public BinaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterBinaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitBinaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitBinaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryExpressionContext binaryExpression() throws RecognitionException {
		return binaryExpression(0);
	}

	private BinaryExpressionContext binaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BinaryExpressionContext _localctx = new BinaryExpressionContext(_ctx, _parentState);
		BinaryExpressionContext _prevctx = _localctx;
		int _startState = 98;
		enterRecursionRule(_localctx, 98, RULE_binaryExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(543);
			unaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(551);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_binaryExpression);
					setState(545);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(546);
					binaryOp();
					setState(547);
					unaryExpression();
					}
					} 
				}
				setState(553);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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

	public static class BinaryOpContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PineScriptParser.STAR, 0); }
		public TerminalNode DIVIDE_() { return getToken(PineScriptParser.DIVIDE_, 0); }
		public TerminalNode REMAINDER() { return getToken(PineScriptParser.REMAINDER, 0); }
		public TerminalNode PLUS() { return getToken(PineScriptParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PineScriptParser.MINUS, 0); }
		public TerminalNode LT_LT() { return getToken(PineScriptParser.LT_LT, 0); }
		public TerminalNode GT_GT() { return getToken(PineScriptParser.GT_GT, 0); }
		public TerminalNode GT_GT_GT() { return getToken(PineScriptParser.GT_GT_GT, 0); }
		public TerminalNode LT() { return getToken(PineScriptParser.LT, 0); }
		public TerminalNode GT() { return getToken(PineScriptParser.GT, 0); }
		public TerminalNode LE() { return getToken(PineScriptParser.LE, 0); }
		public TerminalNode GE() { return getToken(PineScriptParser.GE, 0); }
		public TerminalNode INSTANCEOF() { return getToken(PineScriptParser.INSTANCEOF, 0); }
		public TerminalNode IN() { return getToken(PineScriptParser.IN, 0); }
		public TerminalNode EQ_EQ() { return getToken(PineScriptParser.EQ_EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(PineScriptParser.NOT_EQ, 0); }
		public TerminalNode EQ_EQ_EQ() { return getToken(PineScriptParser.EQ_EQ_EQ, 0); }
		public TerminalNode NOT_EQ_EQ() { return getToken(PineScriptParser.NOT_EQ_EQ, 0); }
		public TerminalNode AND() { return getToken(PineScriptParser.AND, 0); }
		public TerminalNode XOR() { return getToken(PineScriptParser.XOR, 0); }
		public TerminalNode OR() { return getToken(PineScriptParser.OR, 0); }
		public TerminalNode AND_AND() { return getToken(PineScriptParser.AND_AND, 0); }
		public TerminalNode OR_OR() { return getToken(PineScriptParser.OR_OR, 0); }
		public BinaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitBinaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitBinaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOpContext binaryOp() throws RecognitionException {
		BinaryOpContext _localctx = new BinaryOpContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_binaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INSTANCEOF) | (1L << STAR) | (1L << REMAINDER) | (1L << PLUS) | (1L << MINUS) | (1L << IN) | (1L << LT) | (1L << LT_LT) | (1L << GT) | (1L << GT_GT) | (1L << GT_GT_GT) | (1L << LE) | (1L << GE) | (1L << EQ_EQ) | (1L << EQ_EQ_EQ) | (1L << NOT_EQ))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NOT_EQ_EQ - 64)) | (1L << (DIVIDE_ - 64)) | (1L << (XOR - 64)) | (1L << (AND - 64)) | (1L << (OR - 64)) | (1L << (AND_AND - 64)) | (1L << (OR_OR - 64)))) != 0)) ) {
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

	public static class UnaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_unaryExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			primaryExpression();
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

	public static class ReservedIdentifierContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(PineScriptParser.BREAK, 0); }
		public TerminalNode CASE() { return getToken(PineScriptParser.CASE, 0); }
		public TerminalNode CATCH() { return getToken(PineScriptParser.CATCH, 0); }
		public TerminalNode CONTINUE() { return getToken(PineScriptParser.CONTINUE, 0); }
		public TerminalNode DEFAULT() { return getToken(PineScriptParser.DEFAULT, 0); }
		public TerminalNode DELETE() { return getToken(PineScriptParser.DELETE, 0); }
		public TerminalNode DO() { return getToken(PineScriptParser.DO, 0); }
		public TerminalNode ELSE() { return getToken(PineScriptParser.ELSE, 0); }
		public TerminalNode ENUM() { return getToken(PineScriptParser.ENUM, 0); }
		public TerminalNode FALSE() { return getToken(PineScriptParser.FALSE, 0); }
		public TerminalNode FINALLY() { return getToken(PineScriptParser.FINALLY, 0); }
		public TerminalNode FOR() { return getToken(PineScriptParser.FOR, 0); }
		public TerminalNode FUNCTION() { return getToken(PineScriptParser.FUNCTION, 0); }
		public TerminalNode IF() { return getToken(PineScriptParser.IF, 0); }
		public TerminalNode IN() { return getToken(PineScriptParser.IN, 0); }
		public TerminalNode INSTANCEOF() { return getToken(PineScriptParser.INSTANCEOF, 0); }
		public TerminalNode NEW() { return getToken(PineScriptParser.NEW, 0); }
		public TerminalNode NULL() { return getToken(PineScriptParser.NULL, 0); }
		public TerminalNode RETURN() { return getToken(PineScriptParser.RETURN, 0); }
		public TerminalNode SWITCH() { return getToken(PineScriptParser.SWITCH, 0); }
		public TerminalNode THIS() { return getToken(PineScriptParser.THIS, 0); }
		public TerminalNode THROW() { return getToken(PineScriptParser.THROW, 0); }
		public TerminalNode TRUE() { return getToken(PineScriptParser.TRUE, 0); }
		public TerminalNode TRY() { return getToken(PineScriptParser.TRY, 0); }
		public TerminalNode TYPEOF() { return getToken(PineScriptParser.TYPEOF, 0); }
		public TerminalNode VAR() { return getToken(PineScriptParser.VAR, 0); }
		public TerminalNode VOID() { return getToken(PineScriptParser.VOID, 0); }
		public TerminalNode WHILE() { return getToken(PineScriptParser.WHILE, 0); }
		public TerminalNode CONST() { return getToken(PineScriptParser.CONST, 0); }
		public TerminalNode LET() { return getToken(PineScriptParser.LET, 0); }
		public TerminalNode DEBUGGER() { return getToken(PineScriptParser.DEBUGGER, 0); }
		public TerminalNode WITH() { return getToken(PineScriptParser.WITH, 0); }
		public ReservedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reservedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).enterReservedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PineScriptListener ) ((PineScriptListener)listener).exitReservedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PineScriptVisitor ) return ((PineScriptVisitor<? extends T>)visitor).visitReservedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReservedIdentifierContext reservedIdentifier() throws RecognitionException {
		ReservedIdentifierContext _localctx = new ReservedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_reservedIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENUM) | (1L << DEBUGGER) | (1L << THROW) | (1L << CONTINUE) | (1L << INSTANCEOF) | (1L << LET) | (1L << CONST) | (1L << DO) | (1L << WHILE) | (1L << FOR) | (1L << BREAK) | (1L << TRY) | (1L << CATCH) | (1L << FINALLY) | (1L << CASE) | (1L << DEFAULT) | (1L << SWITCH) | (1L << WITH) | (1L << IF) | (1L << ELSE) | (1L << FUNCTION) | (1L << DELETE) | (1L << VOID) | (1L << TYPEOF) | (1L << IN))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (THIS - 65)) | (1L << (NULL - 65)) | (1L << (TRUE - 65)) | (1L << (FALSE - 65)) | (1L << (NEW - 65)) | (1L << (RETURN - 65)) | (1L << (VAR - 65)))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return variableDeclarationList_sempred((VariableDeclarationListContext)_localctx, predIndex);
		case 37:
			return callExpression_sempred((CallExpressionContext)_localctx, predIndex);
		case 39:
			return memberExpression_sempred((MemberExpressionContext)_localctx, predIndex);
		case 40:
			return argumentList_sempred((ArgumentListContext)_localctx, predIndex);
		case 43:
			return formalParameterList_sempred((FormalParameterListContext)_localctx, predIndex);
		case 49:
			return binaryExpression_sempred((BinaryExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean variableDeclarationList_sempred(VariableDeclarationListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean callExpression_sempred(CallExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean memberExpression_sempred(MemberExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean argumentList_sempred(ArgumentListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean formalParameterList_sempred(FormalParameterListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean binaryExpression_sempred(BinaryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3e\u0233\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\3\2\7\2n\n\2\f\2\16\2q\13\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\5\6\u0081\n\6\3\7\3\7\7\7\u0085"+
		"\n\7\f\7\16\7\u0088\13\7\3\7\3\7\3\b\3\b\5\b\u008e\n\b\3\t\3\t\3\t\3\t"+
		"\5\t\u0094\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u009b\n\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a8\n\n\3\13\3\13\3\13\5\13\u00ad\n\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00b7\n\r\f\r\16\r\u00ba\13\r\3\16"+
		"\3\16\7\16\u00be\n\16\f\16\16\16\u00c1\13\16\3\17\3\17\3\17\3\20\3\20"+
		"\5\20\u00c8\n\20\3\21\3\21\3\21\5\21\u00cd\n\21\3\22\3\22\5\22\u00d1\n"+
		"\22\3\22\3\22\3\22\5\22\u00d6\n\22\5\22\u00d8\n\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u00e1\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00f1\n\23\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\5\26\u00fb\n\26\3\27\3\27\7\27\u00ff\n\27\f\27\16\27\u0102"+
		"\13\27\3\27\5\27\u0105\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\5\30\u0114\n\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\7\34\u0125\n\34\f\34\16"+
		"\34\u0128\13\34\3\34\3\34\3\34\7\34\u012d\n\34\f\34\16\34\u0130\13\34"+
		"\3\34\3\34\7\34\u0134\n\34\f\34\16\34\u0137\13\34\3\34\3\34\5\34\u013b"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\5!\u0160\n!\3\"\7\"\u0163\n\"\f\"\16\"\u0166\13\"\3#\6#\u0169\n#\r#"+
		"\16#\u016a\3$\3$\3%\3%\3%\3%\3%\3%\5%\u0175\n%\3&\3&\5&\u0179\n&\3\'\3"+
		"\'\3\'\3\'\7\'\u017f\n\'\f\'\16\'\u0182\13\'\3\'\3\'\3\'\3\'\3\'\7\'\u0189"+
		"\n\'\f\'\16\'\u018c\13\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0197"+
		"\n\'\f\'\16\'\u019a\13\'\3(\3(\3(\5(\u019f\n(\3)\3)\3)\3)\3)\3)\3)\7)"+
		"\u01a8\n)\f)\16)\u01ab\13)\3)\3)\5)\u01af\n)\3)\3)\3)\3)\3)\3)\3)\3)\7"+
		")\u01b9\n)\f)\16)\u01bc\13)\3*\3*\3*\3*\3*\3*\7*\u01c4\n*\f*\16*\u01c7"+
		"\13*\3+\3+\5+\u01cb\n+\3,\3,\3,\3,\7,\u01d1\n,\f,\16,\u01d4\13,\3,\3,"+
		"\3,\7,\u01d9\n,\f,\16,\u01dc\13,\3,\3,\3,\3,\7,\u01e2\n,\f,\16,\u01e5"+
		"\13,\3,\3,\3,\7,\u01ea\n,\f,\16,\u01ed\13,\3,\5,\u01f0\n,\3-\3-\3-\3-"+
		"\3-\3-\7-\u01f8\n-\f-\16-\u01fb\13-\3.\6.\u01fe\n.\r.\16.\u01ff\3/\3/"+
		"\5/\u0204\n/\3\60\3\60\3\60\3\60\7\60\u020a\n\60\f\60\16\60\u020d\13\60"+
		"\3\60\3\60\3\60\7\60\u0212\n\60\f\60\16\60\u0215\13\60\3\60\3\60\3\61"+
		"\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\7\63\u0228\n\63\f\63\16\63\u022b\13\63\3\64\3\64\3\65\3\65\3\66\3\66"+
		"\3\66\2\b\30LPRXd\67\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhj\2\b\4\2[[``\4\2\r\16]]\b\2++-.8="+
		"@@GGII\4\2EF^`\n\2\13\13)*,,/\67>?ABHHMQ\f\2\3\3\b\13\r\33\36\36\"$\60"+
		"\60CFLLWW]]\2\u0243\2o\3\2\2\2\4t\3\2\2\2\6y\3\2\2\2\b{\3\2\2\2\n}\3\2"+
		"\2\2\f\u0082\3\2\2\2\16\u008d\3\2\2\2\20\u008f\3\2\2\2\22\u00a7\3\2\2"+
		"\2\24\u00a9\3\2\2\2\26\u00ae\3\2\2\2\30\u00b0\3\2\2\2\32\u00bb\3\2\2\2"+
		"\34\u00c2\3\2\2\2\36\u00c5\3\2\2\2 \u00c9\3\2\2\2\"\u00d7\3\2\2\2$\u00f0"+
		"\3\2\2\2&\u00f2\3\2\2\2(\u00f4\3\2\2\2*\u00f8\3\2\2\2,\u00fc\3\2\2\2."+
		"\u0113\3\2\2\2\60\u0115\3\2\2\2\62\u011b\3\2\2\2\64\u011e\3\2\2\2\66\u013a"+
		"\3\2\2\28\u013c\3\2\2\2:\u0141\3\2\2\2<\u0145\3\2\2\2>\u014b\3\2\2\2@"+
		"\u015f\3\2\2\2B\u0164\3\2\2\2D\u0168\3\2\2\2F\u016c\3\2\2\2H\u0174\3\2"+
		"\2\2J\u0178\3\2\2\2L\u017a\3\2\2\2N\u019e\3\2\2\2P\u01ae\3\2\2\2R\u01bd"+
		"\3\2\2\2T\u01ca\3\2\2\2V\u01ef\3\2\2\2X\u01f1\3\2\2\2Z\u01fd\3\2\2\2\\"+
		"\u0203\3\2\2\2^\u0205\3\2\2\2`\u0218\3\2\2\2b\u021a\3\2\2\2d\u0220\3\2"+
		"\2\2f\u022c\3\2\2\2h\u022e\3\2\2\2j\u0230\3\2\2\2ln\5\4\3\2ml\3\2\2\2"+
		"nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\5\b\5\2s\3\3\2\2"+
		"\2tu\7X\2\2uv\5\6\4\2vw\7e\2\2wx\7S\2\2x\5\3\2\2\2yz\t\2\2\2z\7\3\2\2"+
		"\2{|\5\n\6\2|\t\3\2\2\2}~\7[\2\2~\u0080\5\f\7\2\177\u0081\7S\2\2\u0080"+
		"\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\13\3\2\2\2\u0082\u0086\7U\2\2\u0083"+
		"\u0085\5\16\b\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3"+
		"\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008a\7V\2\2\u008a\r\3\2\2\2\u008b\u008e\5\n\6\2\u008c\u008e\5\20\t\2"+
		"\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\17\3\2\2\2\u008f\u0090"+
		"\7[\2\2\u0090\u0091\7T\2\2\u0091\u0093\5`\61\2\u0092\u0094\7S\2\2\u0093"+
		"\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094\21\3\2\2\2\u0095\u00a8\5\64\33"+
		"\2\u0096\u00a8\5\24\13\2\u0097\u00a8\5F$\2\u0098\u009a\5H%\2\u0099\u009b"+
		"\7S\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u00a8\3\2\2\2\u009c"+
		"\u00a8\5@!\2\u009d\u00a8\5$\23\2\u009e\u00a8\5\"\22\2\u009f\u00a8\5*\26"+
		"\2\u00a0\u00a8\5,\27\2\u00a1\u00a8\5> \2\u00a2\u00a8\5(\25\2\u00a3\u00a8"+
		"\5<\37\2\u00a4\u00a8\5 \21\2\u00a5\u00a8\5.\30\2\u00a6\u00a8\5\36\20\2"+
		"\u00a7\u0095\3\2\2\2\u00a7\u0096\3\2\2\2\u00a7\u0097\3\2\2\2\u00a7\u0098"+
		"\3\2\2\2\u00a7\u009c\3\2\2\2\u00a7\u009d\3\2\2\2\u00a7\u009e\3\2\2\2\u00a7"+
		"\u009f\3\2\2\2\u00a7\u00a0\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a7\u00a2\3\2"+
		"\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a6\3\2\2\2\u00a8\23\3\2\2\2\u00a9\u00aa\5\26\f\2\u00aa\u00ac\5\30"+
		"\r\2\u00ab\u00ad\7S\2\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\25\3\2\2\2\u00ae\u00af\t\3\2\2\u00af\27\3\2\2\2\u00b0\u00b1\b\r\1\2\u00b1"+
		"\u00b2\5\32\16\2\u00b2\u00b8\3\2\2\2\u00b3\u00b4\f\3\2\2\u00b4\u00b5\7"+
		"!\2\2\u00b5\u00b7\5\32\16\2\u00b6\u00b3\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\31\3\2\2\2\u00ba\u00b8\3\2\2"+
		"\2\u00bb\u00bf\7[\2\2\u00bc\u00be\5\34\17\2\u00bd\u00bc\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\33\3\2\2"+
		"\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7G\2\2\u00c3\u00c4\5H%\2\u00c4\35\3"+
		"\2\2\2\u00c5\u00c7\7\b\2\2\u00c6\u00c8\7S\2\2\u00c7\u00c6\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\37\3\2\2\2\u00c9\u00ca\7\t\2\2\u00ca\u00cc\5H%\2"+
		"\u00cb\u00cd\7S\2\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd!\3\2"+
		"\2\2\u00ce\u00d0\7\n\2\2\u00cf\u00d1\7S\2\2\u00d0\u00cf\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d8\3\2\2\2\u00d2\u00d3\7\n\2\2\u00d3\u00d5\7["+
		"\2\2\u00d4\u00d6\7S\2\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d8\3\2\2\2\u00d7\u00ce\3\2\2\2\u00d7\u00d2\3\2\2\2\u00d8#\3\2\2\2"+
		"\u00d9\u00da\7\17\2\2\u00da\u00db\5\22\n\2\u00db\u00dc\7\20\2\2\u00dc"+
		"\u00dd\7\37\2\2\u00dd\u00de\5H%\2\u00de\u00e0\7 \2\2\u00df\u00e1\7S\2"+
		"\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00f1\3\2\2\2\u00e2\u00e3"+
		"\7\20\2\2\u00e3\u00e4\7\37\2\2\u00e4\u00e5\5H%\2\u00e5\u00e6\7 \2\2\u00e6"+
		"\u00e7\5\22\n\2\u00e7\u00f1\3\2\2\2\u00e8\u00e9\7\21\2\2\u00e9\u00ea\7"+
		"\37\2\2\u00ea\u00eb\5J&\2\u00eb\u00ec\7\60\2\2\u00ec\u00ed\5H%\2\u00ed"+
		"\u00ee\7 \2\2\u00ee\u00ef\5\22\n\2\u00ef\u00f1\3\2\2\2\u00f0\u00d9\3\2"+
		"\2\2\u00f0\u00e2\3\2\2\2\u00f0\u00e8\3\2\2\2\u00f1%\3\2\2\2\u00f2\u00f3"+
		"\t\4\2\2\u00f3\'\3\2\2\2\u00f4\u00f5\7[\2\2\u00f5\u00f6\7T\2\2\u00f6\u00f7"+
		"\5\22\n\2\u00f7)\3\2\2\2\u00f8\u00fa\7\22\2\2\u00f9\u00fb\7S\2\2\u00fa"+
		"\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb+\3\2\2\2\u00fc\u0100\7W\2\2\u00fd"+
		"\u00ff\5H%\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2"+
		"\2\u0100\u0101\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0105"+
		"\7S\2\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105-\3\2\2\2\u0106\u0107"+
		"\7\23\2\2\u0107\u0108\5\64\33\2\u0108\u0109\5\60\31\2\u0109\u0114\3\2"+
		"\2\2\u010a\u010b\7\23\2\2\u010b\u010c\5\64\33\2\u010c\u010d\5\62\32\2"+
		"\u010d\u0114\3\2\2\2\u010e\u010f\7\23\2\2\u010f\u0110\5\64\33\2\u0110"+
		"\u0111\5\60\31\2\u0111\u0112\5\62\32\2\u0112\u0114\3\2\2\2\u0113\u0106"+
		"\3\2\2\2\u0113\u010a\3\2\2\2\u0113\u010e\3\2\2\2\u0114/\3\2\2\2\u0115"+
		"\u0116\7\24\2\2\u0116\u0117\7\37\2\2\u0117\u0118\7[\2\2\u0118\u0119\7"+
		" \2\2\u0119\u011a\5\64\33\2\u011a\61\3\2\2\2\u011b\u011c\7\25\2\2\u011c"+
		"\u011d\5\64\33\2\u011d\63\3\2\2\2\u011e\u011f\7U\2\2\u011f\u0120\5B\""+
		"\2\u0120\u0121\7V\2\2\u0121\65\3\2\2\2\u0122\u0126\7U\2\2\u0123\u0125"+
		"\58\35\2\u0124\u0123\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0129\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u013b\7V"+
		"\2\2\u012a\u012e\7U\2\2\u012b\u012d\58\35\2\u012c\u012b\3\2\2\2\u012d"+
		"\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2"+
		"\2\2\u0130\u012e\3\2\2\2\u0131\u0135\5:\36\2\u0132\u0134\58\35\2\u0133"+
		"\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2"+
		"\2\2\u0136\u0138\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\7V\2\2\u0139"+
		"\u013b\3\2\2\2\u013a\u0122\3\2\2\2\u013a\u012a\3\2\2\2\u013b\67\3\2\2"+
		"\2\u013c\u013d\7\26\2\2\u013d\u013e\5H%\2\u013e\u013f\7T\2\2\u013f\u0140"+
		"\5B\"\2\u01409\3\2\2\2\u0141\u0142\7\27\2\2\u0142\u0143\7T\2\2\u0143\u0144"+
		"\5B\"\2\u0144;\3\2\2\2\u0145\u0146\7\30\2\2\u0146\u0147\7\37\2\2\u0147"+
		"\u0148\5H%\2\u0148\u0149\7 \2\2\u0149\u014a\5\66\34\2\u014a=\3\2\2\2\u014b"+
		"\u014c\7\31\2\2\u014c\u014d\7\37\2\2\u014d\u014e\5H%\2\u014e\u014f\7 "+
		"\2\2\u014f\u0150\5\22\n\2\u0150?\3\2\2\2\u0151\u0152\7\32\2\2\u0152\u0153"+
		"\7\37\2\2\u0153\u0154\5H%\2\u0154\u0155\7 \2\2\u0155\u0156\5\22\n\2\u0156"+
		"\u0157\7\33\2\2\u0157\u0158\5\22\n\2\u0158\u0160\3\2\2\2\u0159\u015a\7"+
		"\32\2\2\u015a\u015b\7\37\2\2\u015b\u015c\5H%\2\u015c\u015d\7 \2\2\u015d"+
		"\u015e\5\22\n\2\u015e\u0160\3\2\2\2\u015f\u0151\3\2\2\2\u015f\u0159\3"+
		"\2\2\2\u0160A\3\2\2\2\u0161\u0163\5D#\2\u0162\u0161\3\2\2\2\u0163\u0166"+
		"\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165C\3\2\2\2\u0166"+
		"\u0164\3\2\2\2\u0167\u0169\5\22\n\2\u0168\u0167\3\2\2\2\u0169\u016a\3"+
		"\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016bE\3\2\2\2\u016c\u016d"+
		"\7S\2\2\u016dG\3\2\2\2\u016e\u0175\5d\63\2\u016f\u0175\5b\62\2\u0170\u0171"+
		"\5J&\2\u0171\u0172\5&\24\2\u0172\u0173\5H%\2\u0173\u0175\3\2\2\2\u0174"+
		"\u016e\3\2\2\2\u0174\u016f\3\2\2\2\u0174\u0170\3\2\2\2\u0175I\3\2\2\2"+
		"\u0176\u0179\5N(\2\u0177\u0179\5L\'\2\u0178\u0176\3\2\2\2\u0178\u0177"+
		"\3\2\2\2\u0179K\3\2\2\2\u017a\u017b\b\'\1\2\u017b\u017c\5P)\2\u017c\u0180"+
		"\7\37\2\2\u017d\u017f\5R*\2\u017e\u017d\3\2\2\2\u017f\u0182\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0180\3\2"+
		"\2\2\u0183\u0184\7 \2\2\u0184\u0198\3\2\2\2\u0185\u0186\f\5\2\2\u0186"+
		"\u018a\7\37\2\2\u0187\u0189\5R*\2\u0188\u0187\3\2\2\2\u0189\u018c\3\2"+
		"\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018d\3\2\2\2\u018c"+
		"\u018a\3\2\2\2\u018d\u0197\7 \2\2\u018e\u018f\f\4\2\2\u018f\u0190\7J\2"+
		"\2\u0190\u0191\5H%\2\u0191\u0192\7K\2\2\u0192\u0197\3\2\2\2\u0193\u0194"+
		"\f\3\2\2\u0194\u0195\7\6\2\2\u0195\u0197\5T+\2\u0196\u0185\3\2\2\2\u0196"+
		"\u018e\3\2\2\2\u0196\u0193\3\2\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2"+
		"\2\2\u0198\u0199\3\2\2\2\u0199M\3\2\2\2\u019a\u0198\3\2\2\2\u019b\u019f"+
		"\5P)\2\u019c\u019d\7L\2\2\u019d\u019f\5N(\2\u019e\u019b\3\2\2\2\u019e"+
		"\u019c\3\2\2\2\u019fO\3\2\2\2\u01a0\u01a1\b)\1\2\u01a1\u01af\5`\61\2\u01a2"+
		"\u01af\5V,\2\u01a3\u01a4\7L\2\2\u01a4\u01a5\5P)\2\u01a5\u01a9\7\37\2\2"+
		"\u01a6\u01a8\5R*\2\u01a7\u01a6\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7"+
		"\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac"+
		"\u01ad\7 \2\2\u01ad\u01af\3\2\2\2\u01ae\u01a0\3\2\2\2\u01ae\u01a2\3\2"+
		"\2\2\u01ae\u01a3\3\2\2\2\u01af\u01ba\3\2\2\2\u01b0\u01b1\f\5\2\2\u01b1"+
		"\u01b2\7J\2\2\u01b2\u01b3\5H%\2\u01b3\u01b4\7K\2\2\u01b4\u01b9\3\2\2\2"+
		"\u01b5\u01b6\f\4\2\2\u01b6\u01b7\7\6\2\2\u01b7\u01b9\5T+\2\u01b8\u01b0"+
		"\3\2\2\2\u01b8\u01b5\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01bbQ\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01be\b*\1\2\u01be"+
		"\u01bf\5H%\2\u01bf\u01c5\3\2\2\2\u01c0\u01c1\f\3\2\2\u01c1\u01c2\7!\2"+
		"\2\u01c2\u01c4\5H%\2\u01c3\u01c0\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3"+
		"\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6S\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8"+
		"\u01cb\7[\2\2\u01c9\u01cb\5j\66\2\u01ca\u01c8\3\2\2\2\u01ca\u01c9\3\2"+
		"\2\2\u01cbU\3\2\2\2\u01cc\u01cd\7\36\2\2\u01cd\u01ce\7[\2\2\u01ce\u01d2"+
		"\7\37\2\2\u01cf\u01d1\5X-\2\u01d0\u01cf\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2"+
		"\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01d2\3\2"+
		"\2\2\u01d5\u01d6\7 \2\2\u01d6\u01da\7U\2\2\u01d7\u01d9\5Z.\2\u01d8\u01d7"+
		"\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db"+
		"\u01dd\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd\u01f0\7V\2\2\u01de\u01df\7\36"+
		"\2\2\u01df\u01e3\7\37\2\2\u01e0\u01e2\5X-\2\u01e1\u01e0\3\2\2\2\u01e2"+
		"\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e6\3\2"+
		"\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e7\7 \2\2\u01e7\u01eb\7U\2\2\u01e8\u01ea"+
		"\5Z.\2\u01e9\u01e8\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb"+
		"\u01ec\3\2\2\2\u01ec\u01ee\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01f0\7V"+
		"\2\2\u01ef\u01cc\3\2\2\2\u01ef\u01de\3\2\2\2\u01f0W\3\2\2\2\u01f1\u01f2"+
		"\b-\1\2\u01f2\u01f3\7[\2\2\u01f3\u01f9\3\2\2\2\u01f4\u01f5\f\3\2\2\u01f5"+
		"\u01f6\7!\2\2\u01f6\u01f8\7[\2\2\u01f7\u01f4\3\2\2\2\u01f8\u01fb\3\2\2"+
		"\2\u01f9\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01faY\3\2\2\2\u01fb\u01f9"+
		"\3\2\2\2\u01fc\u01fe\5\\/\2\u01fd\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff"+
		"\u01fd\3\2\2\2\u01ff\u0200\3\2\2\2\u0200[\3\2\2\2\u0201\u0204\5\22\n\2"+
		"\u0202\u0204\5^\60\2\u0203\u0201\3\2\2\2\u0203\u0202\3\2\2\2\u0204]\3"+
		"\2\2\2\u0205\u0206\7\36\2\2\u0206\u0207\7[\2\2\u0207\u020b\7\37\2\2\u0208"+
		"\u020a\5X-\2\u0209\u0208\3\2\2\2\u020a\u020d\3\2\2\2\u020b\u0209\3\2\2"+
		"\2\u020b\u020c\3\2\2\2\u020c\u020e\3\2\2\2\u020d\u020b\3\2\2\2\u020e\u020f"+
		"\7 \2\2\u020f\u0213\7U\2\2\u0210\u0212\5Z.\2\u0211\u0210\3\2\2\2\u0212"+
		"\u0215\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0216\3\2"+
		"\2\2\u0215\u0213\3\2\2\2\u0216\u0217\7V\2\2\u0217_\3\2\2\2\u0218\u0219"+
		"\t\5\2\2\u0219a\3\2\2\2\u021a\u021b\5d\63\2\u021b\u021c\7R\2\2\u021c\u021d"+
		"\5H%\2\u021d\u021e\7T\2\2\u021e\u021f\5H%\2\u021fc\3\2\2\2\u0220\u0221"+
		"\b\63\1\2\u0221\u0222\5h\65\2\u0222\u0229\3\2\2\2\u0223\u0224\f\3\2\2"+
		"\u0224\u0225\5f\64\2\u0225\u0226\5h\65\2\u0226\u0228\3\2\2\2\u0227\u0223"+
		"\3\2\2\2\u0228\u022b\3\2\2\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a"+
		"e\3\2\2\2\u022b\u0229\3\2\2\2\u022c\u022d\t\6\2\2\u022dg\3\2\2\2\u022e"+
		"\u022f\5`\61\2\u022fi\3\2\2\2\u0230\u0231\t\7\2\2\u0231k\3\2\2\2\66o\u0080"+
		"\u0086\u008d\u0093\u009a\u00a7\u00ac\u00b8\u00bf\u00c7\u00cc\u00d0\u00d5"+
		"\u00d7\u00e0\u00f0\u00fa\u0100\u0104\u0113\u0126\u012e\u0135\u013a\u015f"+
		"\u0164\u016a\u0174\u0178\u0180\u018a\u0196\u0198\u019e\u01a9\u01ae\u01b8"+
		"\u01ba\u01c5\u01ca\u01d2\u01da\u01e3\u01eb\u01ef\u01f9\u01ff\u0203\u020b"+
		"\u0213\u0229";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}