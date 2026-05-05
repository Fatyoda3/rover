package com.tw.step.rover.rover;

import com.tw.step.rover.boundary.InfinitePlateau;
import com.tw.step.rover.boundary.Plateau;
import com.tw.step.rover.position.Coordinate;
import com.tw.step.rover.position.Direction;
import com.tw.step.rover.position.Navigator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;

class LiveRoverStateTest {
    @Test
    void shouldTurnAndStayLive() {
        Rover rover = new Rover(new Coordinate(1, 1), Direction.N);
        LiveRoverState state = new LiveRoverState(rover);

        RoverState nextState = state.turnLeft(Navigator.create(), new InfinitePlateau());

        assertSame(state, nextState);
        assertEquals("1 1 W", rover.toString());
    }

    @Test
    void shouldMoveAndStayLiveWithinBoundary() {
        Rover rover = new Rover(new Coordinate(1, 1), Direction.N);
        LiveRoverState state = new LiveRoverState(rover);

        RoverState nextState = state.move(Navigator.create(), new InfinitePlateau());

        assertSame(state, nextState);
        assertEquals("1 2 N", rover.toString());
    }

    @Test
    void shouldBecomeDeadWhenRoverStartsOutsideBoundary() {
        Rover rover = new Rover(new Coordinate(5, 5), Direction.N);
        LiveRoverState state = new LiveRoverState(rover);

        RoverState nextState = state.move(Navigator.create(), new Plateau(new Coordinate(0, 0), new Coordinate(2, 2)));

        assertInstanceOf(DeadRoverState.class, nextState);
        assertEquals("5 5 N", rover.toString());
    }

    @Test
    void shouldBecomeDeadWhenRoverIsOutsideBoundary() {
        Rover rover = new Rover(new Coordinate(4, 4), Direction.N);
        LiveRoverState state = new LiveRoverState(rover);

        RoverState nextState = state.move(Navigator.create(), new Plateau(new Coordinate(0, 0), new Coordinate(5, 5)));

        assertInstanceOf(LiveRoverState.class, nextState);
        assertEquals("4 5 N", rover.toString());

        RoverState nextState2 = nextState.move(Navigator.create(), new Plateau(new Coordinate(0, 0), new Coordinate(5, 5)));

        assertInstanceOf(DeadRoverState.class, nextState2);
        assertEquals("4 5 N", rover.toString());
        assertInstanceOf(DeadRoverState.class, nextState2);

        RoverState nextState3 = nextState2.move(Navigator.create(), new Plateau(new Coordinate(0, 0), new Coordinate(5, 5)));
        assertEquals("4 5 N", rover.toString());
        assertInstanceOf(DeadRoverState.class, nextState2);
/*Repeated but needed for now to test and understand the code flow */

    }

}
