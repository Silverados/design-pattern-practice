package com.wyw;

public class App {
    public static void main(String[] args) {
        var hero = HeroFactory.newHero(HeroType.EZ);
        System.out.println(hero.description());

        hero = HeroFactory.newHero(HeroType.JS);
        System.out.println(hero.description());
    }
}
