package com.wyw;

import java.util.Arrays;

public abstract class Unit {

    private final Unit[] children;

    public Unit(Unit... children) {
        this.children = children;
    }

    public void accept(UnitVisitor visitor) {
        Arrays.stream(children).forEach(
                children -> children.accept(visitor)
        );
    }
}
