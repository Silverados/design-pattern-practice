package com.wyw;

public class SingletonDoubleCheckLocking {
    private SingletonDoubleCheckLocking() {}

    private static volatile SingletonDoubleCheckLocking instance;

    public static SingletonDoubleCheckLocking getInstance() {
        var result = instance;
        if (result == null) {
            synchronized (SingletonDoubleCheckLocking.class) {
                result = instance;
                if (result == null) {
                    instance = result = new SingletonDoubleCheckLocking();
                }
            }
        }
        return result;
    }
}
