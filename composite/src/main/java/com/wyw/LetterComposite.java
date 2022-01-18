package com.wyw;

import java.util.ArrayList;
import java.util.List;

public abstract class LetterComposite {

    private final List<LetterComposite> children = new ArrayList<>();

    public void add(LetterComposite letterComposite) {
        children.add(letterComposite);
    }

    protected void printThisBefore() {}

    protected void printThisAfter() {}

    public void print() {
        printThisBefore();
        children.forEach(LetterComposite::print);
        printThisAfter();
    }
}
