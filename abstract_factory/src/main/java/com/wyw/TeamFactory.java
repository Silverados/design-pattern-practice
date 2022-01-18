package com.wyw;

public interface TeamFactory {
    Soldier createSoldier();
    Turret createTurret();
    Inhibitor createInhibitor();
}
