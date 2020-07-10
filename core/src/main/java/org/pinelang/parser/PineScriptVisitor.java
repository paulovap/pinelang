// Generated from PineScript.g4 by ANTLR 4.8

    package org.pinelang.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PineScript}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PineScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PineScript#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PineScript.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#rootMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootMember(PineScript.RootMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#objectDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDefinition(PineScript.ObjectDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#objectInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInitializer(PineScript.ObjectInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#objectIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectIdentifier(PineScript.ObjectIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#signalAssignement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignalAssignement(PineScript.SignalAssignementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#propertyDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyDefinition(PineScript.PropertyDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PineScript.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#binaryOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperation(PineScript.BinaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#objectPropertyExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectPropertyExpression(PineScript.ObjectPropertyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression(PineScript.PrimitiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(PineScript.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#integerSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerSuffix(PineScript.IntegerSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#callableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallableExpression(PineScript.CallableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PineScript#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(PineScript.ArgumentsContext ctx);
}