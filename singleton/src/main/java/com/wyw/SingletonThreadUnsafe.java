package com.wyw;

public class SingletonThreadUnsafe {
    private SingletonThreadUnsafe() {}

    private static SingletonThreadUnsafe instance;

    public static SingletonThreadUnsafe getInstance() {
        if (instance == null) {
            instance = new SingletonThreadUnsafe();
        }

        return instance;
    }
}
