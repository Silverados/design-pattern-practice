package com.wyw;

import lombok.AllArgsConstructor;

import java.util.function.Supplier;

@AllArgsConstructor
public enum HeroType {
    EZ(EZ::new),
    JS(JS::new),
    LULU(LuLu::new);

    private Supplier<Hero> constructor;

    public Supplier<Hero> getConstructor() {
        return constructor;
    }
}
