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
	 * Visit a parse tree produced by {@link PineScriptParser#objectIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectIdentifier(PineScriptParser.ObjectIdentifierContext ctx);
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
	 * Visit a parse tree produced by {@link PineScriptParser#assignExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(PineScriptParser.AssignExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#objectPropertyExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectPropertyExpression(PineScriptParser.ObjectPropertyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression(PineScriptParser.PrimitiveExpressionContext ctx);
}