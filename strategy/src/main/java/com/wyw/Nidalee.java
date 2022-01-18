package com.wyw;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class Nidalee {
    private Strategy strategy;
    private State state;

    public Nidalee() {
        changeState(State.HUMAN);
    }

    public void changeState(State state) {
        if (this.state != state) {
            this.state = state;
            strategy = state.getConstructor().get();
        }
    }

    @AllArgsConstructor
    @Getter
    public enum State {
        HUMAN(HumanStrategy::new),
        COUGAR(CougarStrategy::new);

        private Supplier<Strategy> constructor;
    }
}
