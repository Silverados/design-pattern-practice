package com.wyw;

public class App {
    public static void main(String[] args) {
        Shaco shaco = new Shaco("Shaco", 1000, 200, 100);
        System.out.println(shaco);

        Shaco clone = shaco.clone();
        System.out.println("After clone:");
        System.out.println(shaco);
        System.out.println(clone);
    }
}
