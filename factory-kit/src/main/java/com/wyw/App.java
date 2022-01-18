package com.wyw;

public class App {
    public static void main(String[] args) {
        var factory = WeaponFactory.factory(builder -> {
            builder.add(WeaponType.BOW, Bow::new);
            builder.add(WeaponType.AXE, Axe::new);
            builder.add(WeaponType.SWORD, Sword::new);
        });

        var axe = factory.create(WeaponType.AXE);
        System.out.println(axe.toString());

        var sword = factory.create(WeaponType.SWORD);
        System.out.println(sword.toString());
    }
}
