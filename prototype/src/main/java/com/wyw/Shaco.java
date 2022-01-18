package com.wyw;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Shaco implements Cloneable{
    private String name;
    private double hp;
    private double mana;
    private double attack;

    @Override
    public Shaco clone() {
        try {
            Shaco clone = (Shaco) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            clone.name = "clone->" + name;
            clone.attack = clone.attack / 2;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
