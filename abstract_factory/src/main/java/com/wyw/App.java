package com.wyw;

public class App {
    private static Team team = new Team();

    public static void main(String[] args) {
        createTeam(TeamType.BLUE);
        System.out.println(team.getSoldier().description());
        System.out.println(team.getTurret().description());
        System.out.println(team.getInhibitor().description());

        createTeam(TeamType.RED);
        System.out.println(team.getSoldier().description());
        System.out.println(team.getTurret().description());
        System.out.println(team.getInhibitor().description());
    }

    public static Team createTeam(TeamType teamType) {
        TeamFactory factory = FactoryMaker.createFactory(teamType);
        team.setSoldier(factory.createSoldier());
        team.setInhibitor(factory.createInhibitor());
        team.setTurret(factory.createTurret());
        return team;
    }
}
