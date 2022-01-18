package com.wyw;

import java.util.EnumMap;
import java.util.Map;

public class PotionFactory {
    private final Map<PotionType, Potion> potions;

    public PotionFactory() {
        potions = new EnumMap<>(PotionType.class);
    }

    Potion createPotion(PotionType type) {
        var potion = potions.get(type);
        if (potion == null) {
            potion = switch (type) {
                case HEALING -> new HealingPotion();
                case HOLY_WATER -> new HolyWaterPotion();
                case INVISIBILITY -> new InvisibilityPotion();
                case POISON -> new PoisonPotion();
                case STRENGTH -> new StrengthPotion();
            };
            potions.put(type, potion);
        }

        return potion;
    }
}
