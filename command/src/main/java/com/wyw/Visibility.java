package com.wyw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Visibility {

    VISIBLE("visible"),
    INVISIBLE("invvisible");

    private final String title;

    @Override
    public String toString() {
        return title;
    }
}
