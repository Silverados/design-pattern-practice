package com.wyw;

public record Wizard(String name) {

    @Override
    public String toString() {
        return name;
    }
}
