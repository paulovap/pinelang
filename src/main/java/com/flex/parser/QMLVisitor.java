// Generated from QML.g4 by ANTLR 4.7.1

    package com.flex.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QMLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QMLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(QMLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#import_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_(QMLParser.Import_Context ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#importIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportIdentifier(QMLParser.ImportIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#importAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportAlias(QMLParser.ImportAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#rootMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootMember(QMLParser.RootMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#objectDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDefinition(QMLParser.ObjectDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#objectInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInitializer(QMLParser.ObjectInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#objectMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectMember(QMLParser.ObjectMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#declaredPropertyScriptStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaredPropertyScriptStatement(QMLParser.DeclaredPropertyScriptStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#propertyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyDeclaration(QMLParser.PropertyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#propertyDeclarationAndAssignObjectDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyDeclarationAndAssignObjectDefinition(QMLParser.PropertyDeclarationAndAssignObjectDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#propertyDeclarationAndAssignScriptStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyDeclarationAndAssignScriptStatement(QMLParser.PropertyDeclarationAndAssignScriptStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#propertyModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyModifier(QMLParser.PropertyModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(QMLParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#propertyType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyType(QMLParser.PropertyTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#arrayMemberList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayMemberList(QMLParser.ArrayMemberListContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#scriptStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptStatement(QMLParser.ScriptStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(QMLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#variableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableStatement(QMLParser.VariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#variableDeclarationKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationKind(QMLParser.VariableDeclarationKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationList(QMLParser.VariableDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(QMLParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#initialiser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialiser(QMLParser.InitialiserContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#debuggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDebuggerStatement(QMLParser.DebuggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(QMLParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(QMLParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(QMLParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(QMLParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#labelledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelledStatement(QMLParser.LabelledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(QMLParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(QMLParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(QMLParser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#catch_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatch_(QMLParser.Catch_Context ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#finally_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinally_(QMLParser.Finally_Context ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(QMLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(QMLParser.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#caseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseClause(QMLParser.CaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(QMLParser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(QMLParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#withStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStatement(QMLParser.WithStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(QMLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#statementListOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementListOpt(QMLParser.StatementListOptContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(QMLParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(QMLParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(QMLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSideExpression(QMLParser.LeftHandSideExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#callExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(QMLParser.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(QMLParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#memberExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpression(QMLParser.MemberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(QMLParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#propertyIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier(QMLParser.PropertyIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#functionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(QMLParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(QMLParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(QMLParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#sourceElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceElement(QMLParser.SourceElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(QMLParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(QMLParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#ternaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(QMLParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#binaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(QMLParser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#binaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(QMLParser.BinaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(QMLParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QMLParser#reservedIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReservedIdentifier(QMLParser.ReservedIdentifierContext ctx);
}