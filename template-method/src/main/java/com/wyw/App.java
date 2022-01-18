package com.wyw;

public class App {
    public static void main(String[] args) {
        Game game = new Game(new SoloQMethod());
        game.startGame();

        game.changeMethod(new DuoQMethod());
        game.startGame();
    }
}
