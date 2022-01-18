package com.wyw;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Star {
    private StarType type;
    private int ageYears;
    private int massTons;

    public void timePasses() {
        ageYears *= 2;
        massTons *= 8;

        if (type == StarType.DEAD) {
            ageYears *= 2;
            massTons = 0;
        }
        type = switch (type) {
            case RED_GIANT -> StarType.WHITE_DWARF;
            case SUN -> StarType.RED_GIANT;
            case SUPERNOVA -> StarType.DEAD;
            case WHITE_DWARF -> StarType.SUPERNOVA;
            default -> type;
        };
    }

    StarMemento getMemento() {
        var state = new StarMementoInternal();
        state.setAgeYears(ageYears);
        state.setMassTons(massTons);
        state.setType(type);
        return state;
    }

    void setMemento(StarMemento memento) {
        var state = (StarMementoInternal) memento;
        this.type = state.getType();
        this.massTons = state.massTons;
        this.ageYears = state.ageYears;
    }

    @Override
    public String toString() {
        return "Star{" +
                "type=" + type +
                ", ageYears=" + ageYears +
                ", massTons=" + massTons +
                '}';
    }

    @Getter
    @Setter
    private static class StarMementoInternal implements StarMemento {
        private StarType type;
        private int ageYears;
        private int massTons;
    }
}
