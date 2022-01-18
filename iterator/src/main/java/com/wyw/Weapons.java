package com.wyw;

import java.util.List;

public class Weapons {
    private final List<Item> items;

    public Weapons() {
        items = List.of(
                new Item("ECLIPSE"), // 星蚀
                new Item("IMMORTAL SHIELDBOW"), // 不朽盾弓
                new Item("FORCE OF NATURE") // 自然之力
        );
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor < items.size();
            }

            @Override
            public Item next() {
                return items.get(cursor++);
            }
        };
    }

}
