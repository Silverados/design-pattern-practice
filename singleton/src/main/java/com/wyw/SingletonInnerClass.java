package com.wyw;

public class SingletonInnerClass {

    private SingletonInnerClass() {}

    public SingletonInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }
}
