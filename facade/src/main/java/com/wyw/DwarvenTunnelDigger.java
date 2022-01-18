package com.wyw;

public class DwarvenTunnelDigger extends DwarvenMineWorker{
    @Override
    public void work() {
        System.out.println(name() + " creates anther promising tunnel.");
    }

    @Override
    public String name() {
        return "Dwarven tunnel digger";
    }
}
