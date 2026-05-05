package com.tw.step.rover.boundary;

import com.tw.step.rover.position.Coordinate;

public class InfinitePlateau implements Boundary {
    @Override
    public boolean contains(Coordinate coord) {
        return true;
    }
    public Boundary createPlateau(Coordinate bottomLeft, Coordinate topRight){
        return this;
    }
}
