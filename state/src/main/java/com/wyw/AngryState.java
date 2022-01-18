package com.wyw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AngryState implements State{

    private final Mammoth mammoth;

    @Override
    public void onEnterState() {
        System.out.println(mammoth + " is furious!");
    }

    @Override
    public void observer() {
        System.out.println(mammoth + " gets angry!");
    }
}
