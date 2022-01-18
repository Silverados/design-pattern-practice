package com.wyw;

import java.util.function.Supplier;

public class Holder {

    private Supplier<HeavyObject> heavy = this::createAndCacheHeavy;

    public HeavyObject getHeavyObject() {
        return heavy.get();
    }

    private synchronized HeavyObject createAndCacheHeavy() {
        class HeavyFactory implements Supplier<HeavyObject> {
            private final HeavyObject instance = new HeavyObject();

            @Override
            public HeavyObject get() {
                return instance;
            }
        }


        if (!(heavy instanceof HeavyFactory)) {
            heavy = new HeavyFactory();
        }

        return heavy.get();
    }
}
