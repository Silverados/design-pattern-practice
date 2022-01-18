package com.wyw;

public class CougarStrategy implements Strategy{
    @Override
    public String Q() {
        return "cougar: take down";
    }

    @Override
    public String W() {
        return "cougar: pounce";
    }

    @Override
    public String E() {
        return "cougar: swipe";
    }
}
