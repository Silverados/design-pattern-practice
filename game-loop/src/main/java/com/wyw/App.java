package com.wyw;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        var gameLoop = new FixedStepGameLoop();
        gameLoop.run();
        TimeUnit.SECONDS.sleep(2);
        gameLoop.stop();
    }
}
