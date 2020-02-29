// Generated from PineScript.g4 by ANTLR 4.8

    package com.flex.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PineScriptParser}.
 */
public interface PineScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PineScriptParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PineScriptParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#import_}.
	 * @param ctx the parse tree
	 */
	void enterImport_(PineScriptParser.Import_Context ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#import_}.
	 * @param ctx the parse tree
	 */
	void exitImport_(PineScriptParser.Import_Context ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#importIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterImportIdentifier(PineScriptParser.ImportIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#importIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitImportIdentifier(PineScriptParser.ImportIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#rootMember}.
	 * @param ctx the parse tree
	 */
	void enterRootMember(PineScriptParser.RootMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#rootMember}.
	 * @param ctx the parse tree
	 */
	void exitRootMember(PineScriptParser.RootMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#objectDefinition}.
	 * @param ctx the parse tree
	 */
	void enterObjectDefinition(PineScriptParser.ObjectDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#objectDefinition}.
	 * @param ctx the parse tree
	 */
	void exitObjectDefinition(PineScriptParser.ObjectDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#objectInitializer}.
	 * @param ctx the parse tree
	 */
	void enterObjectInitializer(PineScriptParser.ObjectInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#objectInitializer}.
	 * @param ctx the parse tree
	 */
	void exitObjectInitializer(PineScriptParser.ObjectInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#objectMember}.
	 * @param ctx the parse tree
	 */
	void enterObjectMember(PineScriptParser.ObjectMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#objectMember}.
	 * @param ctx the parse tree
	 */
	void exitObjectMember(PineScriptParser.ObjectMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#propertyAssignement}.
	 * @param ctx the parse tree
	 */
	void enterPropertyAssignement(PineScriptParser.PropertyAssignementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#propertyAssignement}.
	 * @param ctx the parse tree
	 */
	void exitPropertyAssignement(PineScriptParser.PropertyAssignementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PineScriptParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PineScriptParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableStatement(PineScriptParser.VariableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableStatement(PineScriptParser.VariableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#variableDeclarationKind}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationKind(PineScriptParser.VariableDeclarationKindContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#variableDeclarationKind}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationKind(PineScriptParser.VariableDeclarationKindContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationList(PineScriptParser.VariableDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationList(PineScriptParser.VariableDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(PineScriptParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(PineScriptParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void enterInitialiser(PineScriptParser.InitialiserContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void exitInitialiser(PineScriptParser.InitialiserContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#debuggerStatement}.
	 * @param ctx the parse tree
	 */
	void enterDebuggerStatement(PineScriptParser.DebuggerStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#debuggerStatement}.
	 * @param ctx the parse tree
	 */
	void exitDebuggerStatement(PineScriptParser.DebuggerStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(PineScriptParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(PineScriptParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(PineScriptParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(PineScriptParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(PineScriptParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(PineScriptParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(PineScriptParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(PineScriptParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#labelledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabelledStatement(PineScriptParser.LabelledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#labelledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabelledStatement(PineScriptParser.LabelledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(PineScriptParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(PineScriptParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(PineScriptParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(PineScriptParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(PineScriptParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(PineScriptParser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#catch_}.
	 * @param ctx the parse tree
	 */
	void enterCatch_(PineScriptParser.Catch_Context ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#catch_}.
	 * @param ctx the parse tree
	 */
	void exitCatch_(PineScriptParser.Catch_Context ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#finally_}.
	 * @param ctx the parse tree
	 */
	void enterFinally_(PineScriptParser.Finally_Context ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#finally_}.
	 * @param ctx the parse tree
	 */
	void exitFinally_(PineScriptParser.Finally_Context ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PineScriptParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PineScriptParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(PineScriptParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(PineScriptParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void enterCaseClause(PineScriptParser.CaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void exitCaseClause(PineScriptParser.CaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void enterDefaultClause(PineScriptParser.DefaultClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void exitDefaultClause(PineScriptParser.DefaultClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(PineScriptParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(PineScriptParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(PineScriptParser.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(PineScriptParser.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(PineScriptParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(PineScriptParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#statementListOpt}.
	 * @param ctx the parse tree
	 */
	void enterStatementListOpt(PineScriptParser.StatementListOptContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#statementListOpt}.
	 * @param ctx the parse tree
	 */
	void exitStatementListOpt(PineScriptParser.StatementListOptContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(PineScriptParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(PineScriptParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(PineScriptParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(PineScriptParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PineScriptParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PineScriptParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSideExpression(PineScriptParser.LeftHandSideExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSideExpression(PineScriptParser.LeftHandSideExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#callExpression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpression(PineScriptParser.CallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#callExpression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpression(PineScriptParser.CallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(PineScriptParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(PineScriptParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#memberExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpression(PineScriptParser.MemberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#memberExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpression(PineScriptParser.MemberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(PineScriptParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(PineScriptParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#propertyIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterPropertyIdentifier(PineScriptParser.PropertyIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#propertyIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitPropertyIdentifier(PineScriptParser.PropertyIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(PineScriptParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(PineScriptParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(PineScriptParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(PineScriptParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(PineScriptParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(PineScriptParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#sourceElement}.
	 * @param ctx the parse tree
	 */
	void enterSourceElement(PineScriptParser.SourceElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#sourceElement}.
	 * @param ctx the parse tree
	 */
	void exitSourceElement(PineScriptParser.SourceElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(PineScriptParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(PineScriptParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(PineScriptParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(PineScriptParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#ternaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(PineScriptParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#ternaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(PineScriptParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(PineScriptParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(PineScriptParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(PineScriptParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(PineScriptParser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(PineScriptParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(PineScriptParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#reservedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterReservedIdentifier(PineScriptParser.ReservedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#reservedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitReservedIdentifier(PineScriptParser.ReservedIdentifierContext ctx);
}