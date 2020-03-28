// Generated from PineScript.g4 by ANTLR 4.8

    package com.pinescript.parser;

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
	 * Visit a parse tree produced by {@link PineScriptParser#signalAssignement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignalAssignement(PineScriptParser.SignalAssignementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#propertyAssignement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyAssignement(PineScriptParser.PropertyAssignementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PineScriptParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#binaryOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperation(PineScriptParser.BinaryOperationContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#integerSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerSuffix(PineScriptParser.IntegerSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#callableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallableExpression(PineScriptParser.CallableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScriptParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(PineScriptParser.ArgumentsContext ctx);
}