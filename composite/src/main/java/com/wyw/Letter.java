package com.wyw;

public class Letter extends LetterComposite {

    private final char character;

    public Letter(char letter) {
        character = letter;
    }

    @Override
    protected void printThisBefore() {
        System.out.print(character);
    }
}
