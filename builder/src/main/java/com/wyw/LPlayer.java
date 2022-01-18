package com.wyw;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class LPlayer {
    private Hero hero;
    private Skill skill;
    private int talent;
}
