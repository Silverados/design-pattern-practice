package com.wyw;

public class App {
    public static void main(String[] args) {
        var proxy = new WizardTowerProxy(new IvoryTower());
        proxy.enter(new Wizard("1 wizard"));
        proxy.enter(new Wizard("2 wizard"));
        proxy.enter(new Wizard("3 wizard"));
        proxy.enter(new Wizard("4 wizard"));
        proxy.enter(new Wizard("5 wizard"));
    }
}
