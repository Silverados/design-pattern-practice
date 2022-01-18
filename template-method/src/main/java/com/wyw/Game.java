package com.wyw;

public class Game {
    private SubtleMethod method;

    public Game(SubtleMethod method) {
        this.method = method;
    }

    public void changeMethod(SubtleMethod method) {
        this.method = method;
    }

    public void startGame() {
        method.startGame();
    }
}
