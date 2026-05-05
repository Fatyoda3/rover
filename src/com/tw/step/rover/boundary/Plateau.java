package com.tw.step.rover.boundary;

import com.tw.step.rover.position.Coordinate;

public class Plateau implements Boundary {
    private Coordinate bottomLeft;
    private Coordinate topRight;

    public Plateau(Coordinate bottomLeft, Coordinate topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    @Override
    public boolean contains(Coordinate coord) {
        return coord.isWithin(bottomLeft, topRight);
    }

    public boolean isWithinNextPosition(Coordinate coord) {
        return coord.isWithin(bottomLeft, topRight);
    }

    public Plateau createPlateau(Coordinate bottomLeft, Coordinate topRight) {
//        this.bottomLeft = bottomLeft;
//        this.topRight = topRight;
        return new Plateau(bottomLeft , topRight);
    }
}
