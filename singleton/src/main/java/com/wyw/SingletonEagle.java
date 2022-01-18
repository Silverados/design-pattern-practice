package com.wyw;

public class SingletonEagle {
    private SingletonEagle() {}

    private static final SingletonEagle INSTANCE = new SingletonEagle();

    public static SingletonEagle getInstance() {
        return INSTANCE;
    }
}
