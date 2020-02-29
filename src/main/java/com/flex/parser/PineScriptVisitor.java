// Generated from PineScript.g4 by ANTLR 4.8

    package com.flex.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PineScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PineScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PineScriptParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#import_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_(PineScriptParser.Import_Context ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#importIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportIdentifier(PineScriptParser.ImportIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#rootMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootMember(PineScriptParser.RootMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#objectDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDefinition(PineScriptParser.ObjectDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#objectInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInitializer(PineScriptParser.ObjectInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#objectMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectMember(PineScriptParser.ObjectMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#propertyAssignement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyAssignement(PineScriptParser.PropertyAssignementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PineScriptParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#variableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableStatement(PineScriptParser.VariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#variableDeclarationKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationKind(PineScriptParser.VariableDeclarationKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationList(PineScriptParser.VariableDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(PineScriptParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#initialiser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialiser(PineScriptParser.InitialiserContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#debuggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDebuggerStatement(PineScriptParser.DebuggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(PineScriptParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(PineScriptParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(PineScriptParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(PineScriptParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#labelledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelledStatement(PineScriptParser.LabelledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(PineScriptParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(PineScriptParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(PineScriptParser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#catch_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatch_(PineScriptParser.Catch_Context ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#finally_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinally_(PineScriptParser.Finally_Context ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PineScriptParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(PineScriptParser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#caseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseClause(PineScriptParser.CaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(PineScriptParser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(PineScriptParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#withStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStatement(PineScriptParser.WithStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PineScriptParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#statementListOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementListOpt(PineScriptParser.StatementListOptContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(PineScriptParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(PineScriptParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PineScriptParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSideExpression(PineScriptParser.LeftHandSideExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#callExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(PineScriptParser.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(PineScriptParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#memberExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpression(PineScriptParser.MemberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(PineScriptParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#propertyIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier(PineScriptParser.PropertyIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#functionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(PineScriptParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(PineScriptParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(PineScriptParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#sourceElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceElement(PineScriptParser.SourceElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(PineScriptParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(PineScriptParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#ternaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(PineScriptParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#binaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(PineScriptParser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#binaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(PineScriptParser.BinaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(PineScriptParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#reservedIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReservedIdentifier(PineScriptParser.ReservedIdentifierContext ctx);
}