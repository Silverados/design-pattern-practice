package com.wyw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PeacefulState implements State {
    private final Mammoth mammoth;


    @Override
    public void onEnterState() {
        System.out.println(mammoth + " is calm and peaceful.");
    }

    @Override
    public void observer() {
        System.out.println(mammoth + " calms down.");
    }
}
