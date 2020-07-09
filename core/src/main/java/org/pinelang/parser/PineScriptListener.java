// Generated from PineScript.g4 by ANTLR 4.8

    package org.pinelang.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PineScript}.
 */
public interface PineScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PineScript#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PineScript.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PineScript.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#rootMember}.
	 * @param ctx the parse tree
	 */
	void enterRootMember(PineScript.RootMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#rootMember}.
	 * @param ctx the parse tree
	 */
	void exitRootMember(PineScript.RootMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#objectDefinition}.
	 * @param ctx the parse tree
	 */
	void enterObjectDefinition(PineScript.ObjectDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#objectDefinition}.
	 * @param ctx the parse tree
	 */
	void exitObjectDefinition(PineScript.ObjectDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#objectInitializer}.
	 * @param ctx the parse tree
	 */
	void enterObjectInitializer(PineScript.ObjectInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#objectInitializer}.
	 * @param ctx the parse tree
	 */
	void exitObjectInitializer(PineScript.ObjectInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#objectIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterObjectIdentifier(PineScript.ObjectIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#objectIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitObjectIdentifier(PineScript.ObjectIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#objectMember}.
	 * @param ctx the parse tree
	 */
	void enterObjectMember(PineScript.ObjectMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#objectMember}.
	 * @param ctx the parse tree
	 */
	void exitObjectMember(PineScript.ObjectMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#signalAssignement}.
	 * @param ctx the parse tree
	 */
	void enterSignalAssignement(PineScript.SignalAssignementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#signalAssignement}.
	 * @param ctx the parse tree
	 */
	void exitSignalAssignement(PineScript.SignalAssignementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#propertyDefinition}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDefinition(PineScript.PropertyDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#propertyDefinition}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDefinition(PineScript.PropertyDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PineScript.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PineScript.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(PineScript.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(PineScript.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#objectPropertyExpression}.
	 * @param ctx the parse tree
	 */
	void enterObjectPropertyExpression(PineScript.ObjectPropertyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#objectPropertyExpression}.
	 * @param ctx the parse tree
	 */
	void exitObjectPropertyExpression(PineScript.ObjectPropertyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveExpression(PineScript.PrimitiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveExpression(PineScript.PrimitiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(PineScript.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(PineScript.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#integerSuffix}.
	 * @param ctx the parse tree
	 */
	void enterIntegerSuffix(PineScript.IntegerSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#integerSuffix}.
	 * @param ctx the parse tree
	 */
	void exitIntegerSuffix(PineScript.IntegerSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#callableExpression}.
	 * @param ctx the parse tree
	 */
	void enterCallableExpression(PineScript.CallableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#callableExpression}.
	 * @param ctx the parse tree
	 */
	void exitCallableExpression(PineScript.CallableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScript#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(PineScript.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScript#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(PineScript.ArgumentsContext ctx);
}