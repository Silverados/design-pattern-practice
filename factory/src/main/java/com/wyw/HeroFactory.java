package com.wyw;

public class HeroFactory {
    public static Hero newHero(HeroType heroType) {
        return heroType.getConstructor().get();
    }
}
