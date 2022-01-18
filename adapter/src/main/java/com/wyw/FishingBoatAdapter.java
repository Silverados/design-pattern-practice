package com.wyw;

public class FishingBoatAdapter implements RowingBoat{

    private final FishingBoat boat = new FishingBoat();

    @Override
    public void row() {
        boat.sail();
    }
}
