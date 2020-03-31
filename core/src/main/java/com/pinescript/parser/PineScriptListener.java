// Generated from PineScript.g4 by ANTLR 4.8

    package com.pinescript.parser;

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
	 * Enter a parse tree produced by {@link PineScriptParser#objectIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterObjectIdentifier(PineScriptParser.ObjectIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#objectIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitObjectIdentifier(PineScriptParser.ObjectIdentifierContext ctx);
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
	 * Enter a parse tree produced by {@link PineScriptParser#signalAssignement}.
	 * @param ctx the parse tree
	 */
	void enterSignalAssignement(PineScriptParser.SignalAssignementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#signalAssignement}.
	 * @param ctx the parse tree
	 */
	void exitSignalAssignement(PineScriptParser.SignalAssignementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#propertyDefinition}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDefinition(PineScriptParser.PropertyDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#propertyDefinition}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDefinition(PineScriptParser.PropertyDefinitionContext ctx);
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
	 * Enter a parse tree produced by {@link PineScriptParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(PineScriptParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(PineScriptParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#objectPropertyExpression}.
	 * @param ctx the parse tree
	 */
	void enterObjectPropertyExpression(PineScriptParser.ObjectPropertyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#objectPropertyExpression}.
	 * @param ctx the parse tree
	 */
	void exitObjectPropertyExpression(PineScriptParser.ObjectPropertyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveExpression(PineScriptParser.PrimitiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveExpression(PineScriptParser.PrimitiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#integerSuffix}.
	 * @param ctx the parse tree
	 */
	void enterIntegerSuffix(PineScriptParser.IntegerSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#integerSuffix}.
	 * @param ctx the parse tree
	 */
	void exitIntegerSuffix(PineScriptParser.IntegerSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#callableExpression}.
	 * @param ctx the parse tree
	 */
	void enterCallableExpression(PineScriptParser.CallableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#callableExpression}.
	 * @param ctx the parse tree
	 */
	void exitCallableExpression(PineScriptParser.CallableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PineScriptParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(PineScriptParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(PineScriptParser.ArgumentsContext ctx);
}