package com.wyw;

import java.util.function.Supplier;

public interface Builder {
    void add(WeaponType type, Supplier<Weapon> supplier);
}
