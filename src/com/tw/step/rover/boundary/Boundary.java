package com.tw.step.rover.boundary;

import com.tw.step.rover.position.Coordinate;

public interface Boundary {
    boolean contains(Coordinate coord);
}
