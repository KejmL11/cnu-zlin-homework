package dk.cngroup.university;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

	@Test
	void testTrueSolve() {
		String input = "6,5" +
				"\n" +
				"W" +
				"\n" +
				"7" +
				"\n" +
				"1,2;1,4;1,5;3,3;4,1;4,5;5,2;5,4;6,1" +
				"\n" +
				"0,0" +
				"\n" +
				"FFRFFLFRFFLFRFFLF";
		Solver solver = new Solver();
		assertTrue(solver.Solve(input), "Should be true");
	}
	@Test
	void testFalseSolve() {
		String input = "6,5" +
				"\n" +
				"W" +
				"\n" +
				"7" +
				"\n" +
				"1,2;1,4;1,5;3,3;4,1;4,5;5,2;5,4;6,1" +
				"\n" +
				"0,0" +
				"\n" +
				"FFRFFFFRFFLFRFFLF";
		Solver solver = new Solver();
		assertFalse(solver.Solve(input), "Should be false");
	}
}