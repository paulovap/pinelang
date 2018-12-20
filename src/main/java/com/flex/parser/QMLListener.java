// Generated from QML.g4 by ANTLR 4.7.1

    package com.flex.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QMLParser}.
 */
public interface QMLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QMLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(QMLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(QMLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#import_}.
	 * @param ctx the parse tree
	 */
	void enterImport_(QMLParser.Import_Context ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#import_}.
	 * @param ctx the parse tree
	 */
	void exitImport_(QMLParser.Import_Context ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#importIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterImportIdentifier(QMLParser.ImportIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#importIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitImportIdentifier(QMLParser.ImportIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#importAlias}.
	 * @param ctx the parse tree
	 */
	void enterImportAlias(QMLParser.ImportAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#importAlias}.
	 * @param ctx the parse tree
	 */
	void exitImportAlias(QMLParser.ImportAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#rootMember}.
	 * @param ctx the parse tree
	 */
	void enterRootMember(QMLParser.RootMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#rootMember}.
	 * @param ctx the parse tree
	 */
	void exitRootMember(QMLParser.RootMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#objectDefinition}.
	 * @param ctx the parse tree
	 */
	void enterObjectDefinition(QMLParser.ObjectDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#objectDefinition}.
	 * @param ctx the parse tree
	 */
	void exitObjectDefinition(QMLParser.ObjectDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#objectInitializer}.
	 * @param ctx the parse tree
	 */
	void enterObjectInitializer(QMLParser.ObjectInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#objectInitializer}.
	 * @param ctx the parse tree
	 */
	void exitObjectInitializer(QMLParser.ObjectInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#objectMember}.
	 * @param ctx the parse tree
	 */
	void enterObjectMember(QMLParser.ObjectMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#objectMember}.
	 * @param ctx the parse tree
	 */
	void exitObjectMember(QMLParser.ObjectMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#declaredPropertyScriptStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaredPropertyScriptStatement(QMLParser.DeclaredPropertyScriptStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#declaredPropertyScriptStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaredPropertyScriptStatement(QMLParser.DeclaredPropertyScriptStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDeclaration(QMLParser.PropertyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDeclaration(QMLParser.PropertyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#propertyDeclarationAndAssignObjectDefinition}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDeclarationAndAssignObjectDefinition(QMLParser.PropertyDeclarationAndAssignObjectDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#propertyDeclarationAndAssignObjectDefinition}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDeclarationAndAssignObjectDefinition(QMLParser.PropertyDeclarationAndAssignObjectDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#propertyDeclarationAndAssignScriptStatement}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDeclarationAndAssignScriptStatement(QMLParser.PropertyDeclarationAndAssignScriptStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#propertyDeclarationAndAssignScriptStatement}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDeclarationAndAssignScriptStatement(QMLParser.PropertyDeclarationAndAssignScriptStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#propertyModifier}.
	 * @param ctx the parse tree
	 */
	void enterPropertyModifier(QMLParser.PropertyModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#propertyModifier}.
	 * @param ctx the parse tree
	 */
	void exitPropertyModifier(QMLParser.PropertyModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(QMLParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(QMLParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#propertyType}.
	 * @param ctx the parse tree
	 */
	void enterPropertyType(QMLParser.PropertyTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#propertyType}.
	 * @param ctx the parse tree
	 */
	void exitPropertyType(QMLParser.PropertyTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#arrayMemberList}.
	 * @param ctx the parse tree
	 */
	void enterArrayMemberList(QMLParser.ArrayMemberListContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#arrayMemberList}.
	 * @param ctx the parse tree
	 */
	void exitArrayMemberList(QMLParser.ArrayMemberListContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#scriptStatement}.
	 * @param ctx the parse tree
	 */
	void enterScriptStatement(QMLParser.ScriptStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#scriptStatement}.
	 * @param ctx the parse tree
	 */
	void exitScriptStatement(QMLParser.ScriptStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(QMLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(QMLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableStatement(QMLParser.VariableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableStatement(QMLParser.VariableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#variableDeclarationKind}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationKind(QMLParser.VariableDeclarationKindContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#variableDeclarationKind}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationKind(QMLParser.VariableDeclarationKindContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationList(QMLParser.VariableDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationList(QMLParser.VariableDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(QMLParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(QMLParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void enterInitialiser(QMLParser.InitialiserContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void exitInitialiser(QMLParser.InitialiserContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#debuggerStatement}.
	 * @param ctx the parse tree
	 */
	void enterDebuggerStatement(QMLParser.DebuggerStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#debuggerStatement}.
	 * @param ctx the parse tree
	 */
	void exitDebuggerStatement(QMLParser.DebuggerStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(QMLParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(QMLParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(QMLParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(QMLParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(QMLParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(QMLParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(QMLParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(QMLParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#labelledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabelledStatement(QMLParser.LabelledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#labelledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabelledStatement(QMLParser.LabelledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(QMLParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(QMLParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(QMLParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(QMLParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(QMLParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(QMLParser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#catch_}.
	 * @param ctx the parse tree
	 */
	void enterCatch_(QMLParser.Catch_Context ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#catch_}.
	 * @param ctx the parse tree
	 */
	void exitCatch_(QMLParser.Catch_Context ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#finally_}.
	 * @param ctx the parse tree
	 */
	void enterFinally_(QMLParser.Finally_Context ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#finally_}.
	 * @param ctx the parse tree
	 */
	void exitFinally_(QMLParser.Finally_Context ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(QMLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(QMLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(QMLParser.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(QMLParser.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void enterCaseClause(QMLParser.CaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void exitCaseClause(QMLParser.CaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void enterDefaultClause(QMLParser.DefaultClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void exitDefaultClause(QMLParser.DefaultClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(QMLParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(QMLParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(QMLParser.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(QMLParser.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(QMLParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(QMLParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#statementListOpt}.
	 * @param ctx the parse tree
	 */
	void enterStatementListOpt(QMLParser.StatementListOptContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#statementListOpt}.
	 * @param ctx the parse tree
	 */
	void exitStatementListOpt(QMLParser.StatementListOptContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(QMLParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(QMLParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(QMLParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(QMLParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(QMLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(QMLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSideExpression(QMLParser.LeftHandSideExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#leftHandSideExpression}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSideExpression(QMLParser.LeftHandSideExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#callExpression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpression(QMLParser.CallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#callExpression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpression(QMLParser.CallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(QMLParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(QMLParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#memberExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpression(QMLParser.MemberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#memberExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpression(QMLParser.MemberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(QMLParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(QMLParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#propertyIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterPropertyIdentifier(QMLParser.PropertyIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#propertyIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitPropertyIdentifier(QMLParser.PropertyIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(QMLParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(QMLParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(QMLParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(QMLParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(QMLParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(QMLParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#sourceElement}.
	 * @param ctx the parse tree
	 */
	void enterSourceElement(QMLParser.SourceElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#sourceElement}.
	 * @param ctx the parse tree
	 */
	void exitSourceElement(QMLParser.SourceElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(QMLParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(QMLParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(QMLParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(QMLParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#ternaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(QMLParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#ternaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(QMLParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(QMLParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(QMLParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(QMLParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(QMLParser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(QMLParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(QMLParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QMLParser#reservedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterReservedIdentifier(QMLParser.ReservedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QMLParser#reservedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitReservedIdentifier(QMLParser.ReservedIdentifierContext ctx);
}