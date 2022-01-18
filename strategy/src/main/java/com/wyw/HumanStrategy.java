package com.wyw;

public class HumanStrategy implements Strategy{
    @Override
    public String Q() {
        return "Human: throws a spiked javelin";
    }

    @Override
    public String W() {
        return "Human: lays a trap";
    }

    @Override
    public String E() {
        return "Human: heal";
    }
}
