package com.wyw;

public class SoloQMethod extends SubtleMethod{

    @Override
    public void chooseMode() {
        System.out.println("Choose rank mode!");
    }

    @Override
    public void inviteFriends() {
        System.out.println("Solo queue, so not invited friends!");
    }
}
