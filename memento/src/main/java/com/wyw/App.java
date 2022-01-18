package com.wyw;

import java.util.Stack;

public class App {
    public static void main(String[] args) {
        var states = new Stack<StarMemento>();


        var star = new Star(StarType.SUN, 10000000, 500000);
        System.out.println(star);
        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star);
        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star);
        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star);
        states.add(star.getMemento());
        star.timePasses();
        System.out.println(star);
        while (states.size() > 0) {
            star.setMemento(states.pop());
            System.out.println(star);
        }

    }
}
