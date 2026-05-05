package com.tw.step.rover.position;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {
    @Test
    void shouldAddTwoCoordinates() {
        Coordinate coordinate = new Coordinate(0, 0);
        Coordinate offset = new Coordinate(1, 2);
        Coordinate newCoordinate = coordinate.add(offset);
        assertEquals(new Coordinate(1, 2), newCoordinate);
    }

    @Test
    void shouldCheckWhetherCoordinateIsWithinInclusiveBounds() {
        Coordinate coordinate = new Coordinate(2, 3);

        assertTrue(coordinate.isWithin(new Coordinate(0, 0), new Coordinate(2, 3)));
        assertFalse(coordinate.isWithin(new Coordinate(3, 0), new Coordinate(4, 4)));
    }

    @Test
    void shouldConvertCoordinateToString() {
        assertEquals("4 -1", new Coordinate(4, -1).toString());
    }
}
