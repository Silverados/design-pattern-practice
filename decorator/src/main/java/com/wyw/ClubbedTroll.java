package com.wyw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClubbedTroll implements Troll{

    private final Troll decorated;

    @Override
    public void attack() {
        decorated.attack();
        System.out.println("The troll swings at you with a club");
    }

    @Override
    public int getAttackPower() {
        return decorated.getAttackPower() + 10;
    }

    @Override
    public void fleeBattle() {
        decorated.fleeBattle();
    }
}
