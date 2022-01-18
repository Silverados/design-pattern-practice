package com.wyw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MultiplyExpression extends Expression{

    private final Expression leftExpression;
    private final Expression rightExpression;

    @Override
    public int interpret() {
        return leftExpression.interpret() * rightExpression.interpret();
    }

    @Override
    public String toString() {
        return "*";
    }
}
