package com.wyw;

import java.util.Stack;

public class App {
    public static void main(String[] args) {
        final var tokenString = "4 3 1 - 1 + *";

        var stack = new Stack<Expression>();
        var tokenList = tokenString.split(" ");
        for (var s : tokenList) {
            if (isOperator(s)) {
                // when an operator is encountered we expect that the numbers can be popped from the top of
                // the stack
                var rightExpression = stack.pop();
                var leftExpression = stack.pop();
                System.out.printf("popped from stack left: %s right: %s\n",
                        leftExpression.interpret(), rightExpression.interpret());
                var operator = getOperatorInstance(s, leftExpression, rightExpression);
                System.out.printf("operator: %s\n", operator);
                var result = operator.interpret();
                // the operation result is pushed on top of the stack
                var resultExpression = new NumberExpression(result);
                stack.push(resultExpression);
                System.out.printf("push result to stack: %s\n", resultExpression.interpret());
            } else {
                // numbers are pushed on top of the stack
                var i = new NumberExpression(s);
                stack.push(i);
                System.out.printf("push to stack: %s\n", i.interpret());
            }
        }
        // in the end, the final result lies on top of the stack
        System.out.printf("result: %s\n", stack.pop().interpret());
    }

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }

    public static Expression getOperatorInstance(String s, Expression left, Expression right) {
        switch (s) {
            case "+":
                return new PlusExpression(left, right);
            case "-":
                return new MinusExpression(left, right);
            default:
                return new MultiplyExpression(left, right);
        }
    }
}
