package dk.cngroup.university;

import java.util.ArrayList;
import java.util.List;


public class InputParser {


    public char[] parseActions(String s) {
        String[] split = s.split("\\n");
        String receivedActions = split[5];
        char[] actions = receivedActions.toCharArray();
        return actions;
    }

    public Rover parseRover(String s) {
        String[] split = s.split("\\n");
        Direction direction;
        switch (split[1]){
            case "N":
                direction = Direction.NORTH;
                break;
            case "E":
                direction = Direction.EAST;
                break;
            case "W":
                direction = Direction.WEST;
                break;
            default :
                direction = Direction.SOUTH;
                break;
        }
        String positionString = split[0];
        String[] coordinates = positionString.split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        Position position = new Position(x, y);

        Rover rover = new Rover(direction, position);
        return rover;
    }

    public Landscape parseLandscape(String s){
        String[] split = s.split("\\n");
        String stones = split[3];
        String size = split[2];
        String[] stoneCoordinates = stones.split(";");
        List<Position> inaccessiblePositions = new ArrayList<Position>();
        for(String sl : stoneCoordinates){
            String coordinatesXY[] = sl.split(",");
            int x = Integer.parseInt(coordinatesXY[0]);
            int y = Integer.parseInt(coordinatesXY[1]);
            inaccessiblePositions.add(new Position(x,y));
        }

        Landscape landscape = new Landscape(Integer.parseInt(size), inaccessiblePositions);
        return landscape;
    }


}
