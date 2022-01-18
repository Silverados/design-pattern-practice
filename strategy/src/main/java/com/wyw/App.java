package com.wyw;

public class App {
    public static void main(String[] args) {
        Nidalee nidalee = new Nidalee();
        System.out.println(nidalee.getStrategy().Q());
        System.out.println(nidalee.getStrategy().W());
        System.out.println(nidalee.getStrategy().E());

        nidalee.changeState(Nidalee.State.COUGAR);
        System.out.println(nidalee.getStrategy().Q());
        System.out.println(nidalee.getStrategy().W());
        System.out.println(nidalee.getStrategy().E());
    }
}
