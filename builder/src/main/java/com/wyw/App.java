package com.wyw;

public class App {
    public static void main(String[] args) {
        var player = new Player.Builder().hero(Hero.EZ)
                .skill(Skill.FLASH)
                .build();
        System.out.println(player);

        player = new Player.Builder().hero(Hero.JS)
                .talent(1)
                .build();
        System.out.println(player);

        var player2 = new LPlayer.LPlayerBuilder().hero(Hero.JS)
                .skill(Skill.FLASH)
                .talent(1)
                .build();
        System.out.println(player2);
    }
}
