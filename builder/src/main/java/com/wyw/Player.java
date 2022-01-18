package com.wyw;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Player {
    private Hero hero;
    private Skill skill;
    private int talent;

    public Player(Builder builder) {
        hero = builder.hero;
        skill = builder.skill;
        talent = builder.talent;
    }

    public static class Builder{
        private Hero hero;
        private Skill skill;
        private int talent;

        public Builder() {}

        public Builder hero(Hero hero) {
            this.hero = hero;
            return this;
        }

        public Builder skill(Skill skill) {
            this.skill = skill;
            return this;
        }

        public Builder talent(int talent) {
            this.talent = talent;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}
