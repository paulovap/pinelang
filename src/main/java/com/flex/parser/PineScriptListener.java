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
	 * Enter a parse tree produced by {@link PineScriptParser#assignExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(PineScriptParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PineScriptParser#assignExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(PineScriptParser.AssignExpressionContext ctx);
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
}