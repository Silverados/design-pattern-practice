package com.wyw;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Target {

    private Size size;
    private Visibility visibility;

    public void printStatus() {
        System.out.println("size: " + size + " visibility: " + visibility);
    }

    public void changeSize() {
        var oldSize = getSize() == Size.NORMAL ? Size.SMALL : Size.NORMAL;
        setSize(oldSize);
    }

    public void changeVisibility() {
        var visible = getVisibility() == Visibility.INVISIBLE ? Visibility.VISIBLE :Visibility.INVISIBLE;
        setVisibility(visible);
    }
}
