package com.wyw;

public class App {
    public static void main(String[] args) {
        var facade = new DwarvenGoldmineFacade();
        facade.startNewDays();
        facade.digOutGold();
        facade.endDay();
    }
}
