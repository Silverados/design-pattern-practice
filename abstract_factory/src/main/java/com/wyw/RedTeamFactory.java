package com.wyw;

public class RedTeamFactory implements TeamFactory {
    @Override
    public Soldier createSoldier() {
        return new RedSoldier();
    }

    @Override
    public Turret createTurret() {
        return new RedTurret();
    }

    @Override
    public Inhibitor createInhibitor() {
        return new RedInhibitor();
    }
}
