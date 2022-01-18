package com.wyw;

import java.util.concurrent.TimeUnit;

public class HeavyObject {

    public HeavyObject() {
        System.out.println("Creating HeavyObject ...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("... HeavyObject created");
    }
}
