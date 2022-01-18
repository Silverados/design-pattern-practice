package com.wyw;

import java.security.SecureRandom;

public abstract class GameLoop {

    protected volatile GameStatus status;

    protected final GameController controller;

    private Thread gameThread;

    public GameLoop() {
        controller = new GameController();
        status = GameStatus.STOPPED;
    }

    public void run() {
        status = GameStatus.RUNNING;
        gameThread = new Thread(this::processGameLoop);
        gameThread.start();
    }

    public void stop() {
        status = GameStatus.STOPPED;
    }

    public boolean isGameRunning() {
        return status == GameStatus.RUNNING;
    }

    protected void processInput() {
        try {
            var lag = new SecureRandom().nextInt(200) + 50;
            Thread.sleep(lag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void render() {
        var position = controller.getBulletPosition();
        System.out.println("current position: " + position);
    }

    protected abstract void processGameLoop();
}
