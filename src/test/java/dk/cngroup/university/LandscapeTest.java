package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LandscapeTest {

	@Test
	void testCreateSmallAccessibleLandscape() {
		Landscape landscape = new Landscape(2, new ArrayList<>());
		String expected = "..\n..\n";
		assertEquals(expected, landscape.toString(),
				"Small accessible landscape should be like this.");
	}

	@Test
	void testCreateSmallLandscapeWithOneStone() {
		List<Position> stones = new ArrayList<>();
		stones.add(new Position(0, 0));
		Landscape landscape = new Landscape(2, stones);
		String expected = "0.\n..\n";
		assertEquals(expected, landscape.toString(),
				"Small landscape with one stone on position 0,0 should be like this.");
	}

	@Test
	void isAccessible() {
		List<Position> stones = new ArrayList<>();
		stones.add(new Position(0, 0));
		Landscape landscape = new Landscape(2, stones);
		boolean result = landscape.isAccessible(new Position(1,0));
		assertTrue(result, "Position 1,0 should be accessible");
	}
	@Test
	void isInaccessible() {
		List<Position> stones = new ArrayList<>();
		stones.add(new Position(0, 0));
		Landscape landscape = new Landscape(2, stones);
		boolean result = landscape.isAccessible(new Position(0,0));
		assertFalse(result, "Position 0,0 should be inaccessible");
	}
	@Test
	void outOfBounds() {
		Landscape landscape = new Landscape(2, new ArrayList<>());
		boolean result = landscape.isAccessible(new Position(2,0));
		assertTrue(result, "Position -1,0 should be inaccessible");
	}
}