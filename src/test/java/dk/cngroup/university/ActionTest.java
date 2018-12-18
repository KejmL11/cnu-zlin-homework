package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {

	@Test
	void performForwardToAccessibleField() {
		Action forward = Action.FORWARD;
		Rover rover = new Rover(Direction.SOUTH, new Position(0,0));
		Landscape landscape = new Landscape(2, new ArrayList<>());

		Rover result = forward.perform(rover, landscape);
		Rover expected = new Rover(Direction.SOUTH, new Position(1,0));
		assertEquals(expected, result, "Rover should be equal");
	}

	@Test
	void performTurnLeft() {
		Action left = Action.LEFT;
		Rover rover = new Rover(Direction.SOUTH, new Position(0,0));
		Landscape landscape = new Landscape(2, new ArrayList<>());

		Rover result = left.perform(rover, landscape);
		Rover expected = new Rover(Direction.EAST, new Position(0,0));
		assertEquals(expected, result, "Rover should be equal");
	}

	@Test
	void performTurnRight() {
		Action right = Action.RIGHT;
		Rover rover = new Rover(Direction.SOUTH, new Position(0,0));
		Landscape landscape = new Landscape(2, new ArrayList<>());

		Rover result = right.perform(rover, landscape);
		Rover expected = new Rover(Direction.WEST, new Position(0,0));
		assertEquals(expected, result, "Rover should be equal");
	}


	@Test
	void performForwardToInAccessibleField() {
		Action forward = Action.FORWARD;
		Rover rover = new Rover(Direction.SOUTH, new Position(0,0));
		List<Position> stones = new ArrayList<>();
		stones.add(new Position(1,0));
		Landscape landscape = new Landscape(2, stones);

		Rover result = forward.perform(rover, landscape);
		Rover expected = new Rover(Direction.SOUTH, new Position(1,0));
		assertEquals(expected, result, "Rover should not be equal");
	}

	@Test
	void performBackwardToInAccessibleField() {
		Action backward = Action.BACKWARD;
		Rover rover = new Rover(Direction.NORTH, new Position(0,0));
		List<Position> stones = new ArrayList<>();
		stones.add(new Position(1,0));
		Landscape landscape = new Landscape(2, stones);

		Rover result = backward.perform(rover, landscape);
		Rover expected = new Rover(Direction.NORTH, new Position(1,0));
		assertEquals(expected, result, "Rover should not be equal");
	}

	@Test
	void performBackwardToAccessibleField() {
		Action backward = Action.BACKWARD;
		Rover rover = new Rover(Direction.NORTH, new Position(0,0));
		Landscape landscape = new Landscape(2, new ArrayList<>());

		Rover result = backward.perform(rover, landscape);
		Rover expected = new Rover(Direction.NORTH, new Position(1,0));
		assertEquals(expected, result, "Rover should not be equal");
	}
}