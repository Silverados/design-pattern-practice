package com.wyw;

public class App {
    public static void main(String[] args) {
        Weapons weapons = new Weapons();
        Iterator<Item> iterator = weapons.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
