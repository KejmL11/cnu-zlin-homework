package dk.cngroup.university;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Solver {

	boolean Solve(String input) {
		InputParser parser = new InputParser();
		Landscape landscape = parser.parseLandscape(input);
		Rover rover = parser.parseRover(input);
		char[] actions = parser.parseActions(input);
		Position finalPosition = parser.parseFinalPosition(input);

		Action performedAction;
		for (char action : actions) {
			switch (action){
				case 'L':
					performedAction = Action.LEFT;
					break;
				case 'R':
					performedAction = Action.RIGHT;
					break;
				case 'F':
					performedAction = Action.FORWARD;
					break;
				default:
					performedAction = Action.BACKWARD;
					break;
			}
		rover = performedAction.perform(rover, landscape);
		}

		Position currentPosition = rover.getPosition();
		if(currentPosition.equals(finalPosition)){
			return TRUE;
		}else{
			return FALSE;
		}
	}

}
