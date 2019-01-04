package dk.cngroup.university;

import java.util.ArrayList;
import java.util.List;


public class InputParser {


    public Position parseFinalPosition(String s){
        String[] split = s.split("\\n");
        String position = split[4];
        String[] coordinates = position.split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        return new Position(x, y);
    }

    public char[] parseActions(String s) {
        String[] split = s.split("\\n");
        String receivedActions = split[5];
        return receivedActions.toCharArray();
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

        return new Rover(direction, position);
    }

    public Landscape parseLandscape(String s){
        String[] split = s.split("\\n");
        String stones = split[3];
        String size = split[2];
        String[] stoneCoordinates = stones.split(";");
        List<Position> inaccessiblePositions = new ArrayList<Position>();
        for(String sl : stoneCoordinates){
            String[] coordinatesXY = sl.split(",");
            int x = Integer.parseInt(coordinatesXY[0]);
            int y = Integer.parseInt(coordinatesXY[1]);
            inaccessiblePositions.add(new Position(x,y));
        }
        return new Landscape(Integer.parseInt(size), inaccessiblePositions);
    }
}
