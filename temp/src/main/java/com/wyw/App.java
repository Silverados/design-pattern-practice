package com.wyw;

public class App {
    public static void main(String[] args) {
//        test(new String[]{"a", "a", "b"});
        System.out.println(makeFancyString("leeet co de"));
    }

    public static long makeFancyString(String s) {
        return s.chars().filter(c -> c == ' ').count();
    }



}
