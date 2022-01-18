package com.wyw;

public class SingletonThreadSafe {
    private SingletonThreadSafe() {
    }

    private static volatile SingletonThreadSafe instance;

    public static SingletonThreadSafe getInstance() {
        if (instance == null) {
            synchronized (SingletonThreadSafe.class) {
                if (instance == null) {
                    instance = new SingletonThreadSafe();
                }
            }
        }

        return instance;
    }
}
