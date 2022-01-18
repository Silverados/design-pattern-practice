package com.wyw;

public abstract class SubtleMethod {

    public abstract void chooseMode();

    public abstract void inviteFriends();

    public void startGame() {
        chooseMode();
        inviteFriends();
        System.out.println("game stated!");
    }
}
