package com.wyw;

public class PoisonPotion implements Potion{
    @Override
    public void drink() {
        System.out.println("Poison");
    }
}
