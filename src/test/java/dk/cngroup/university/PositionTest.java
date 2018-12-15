package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

	@Test
	void getNeighbourSouth() {
		Position position = new Position(0, 0);
		Position result = position.getNeighbour(Direction.SOUTH);
		assertEquals(new Position(1,0), result, "New position should be 1,0");
	}

	@Test
	void getNeighbourEast() {
		Position position = new Position(0, 0);
		Position result = position.getNeighbour(Direction.EAST);
		assertEquals(new Position(0,1), result, "New position should be 0,1");
	}

    @Test
    void getNeighbourNorth() {
        Position position = new Position(0, 0);
        Position result = position.getNeighbour(Direction.NORTH);
        assertEquals(new Position(-1,0), result, "New position should be -1,0");
    }

    @Test
    void getNeighbourWest() {
        Position position = new Position(0, 0);
        Position result = position.getNeighbour(Direction.WEST);
        assertEquals(new Position(0,-1), result, "New position should be 0,-1");
    }
}