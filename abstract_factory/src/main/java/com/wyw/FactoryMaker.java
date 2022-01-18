package com.wyw;

public class FactoryMaker {
    public static TeamFactory createFactory(TeamType teamType) {
        return switch (teamType) {
            case BLUE -> new BlueTeamFactory();
            case RED -> new RedTeamFactory();
            default -> throw new IllegalArgumentException("teamType not exists");
        };
    }
}
