package com.wyw;

public class FixedStepGameLoop extends GameLoop{

    public static final long MS_PER_FRAME = 20;

    @Override
    protected void processGameLoop() {
        var previousTime = System.currentTimeMillis();
        var lag = 0L;
        while (isGameRunning()) {
            var currentTime = System.currentTimeMillis();
            var elapsedTime = currentTime - previousTime;
            previousTime = currentTime;
            lag += elapsedTime;

            processInput();

            while (lag >= MS_PER_FRAME) {
                update();
                lag -= MS_PER_FRAME;
            }

            render();
        }
    }

    private void update() {
        controller.moveBullet(0.5f * MS_PER_FRAME / 1000);
    }
}
