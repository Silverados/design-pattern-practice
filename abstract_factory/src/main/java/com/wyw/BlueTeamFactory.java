package com.wyw;

public class BlueTeamFactory implements TeamFactory {
    @Override
    public Soldier createSoldier() {
        return new BlueSoldier();
    }

    @Override
    public Turret createTurret() {
        return new BlueTurret();
    }

    @Override
    public Inhibitor createInhibitor() {
        return new BlueInhibitor();
    }
}
