package dk.cngroup.university;

import java.util.Arrays;
import java.util.List;

public class Landscape {
	private Field[][] fields;

	public Landscape(int size, List<Position> inaccessiblePositions) {
		initAccessibleLandscape(size);
		insertInaccessibleFields(inaccessiblePositions);
	}

	public boolean isAccessible(Position position){//TODO check if not outside landscape
		int x = position.x;
		int y = position.y;

		if(x > fields.length - 1 || x < 0){
			System.out.println("X coordinate is out of bounds " + position);
			return false;
		}

		if(y> fields.length - 1 || x < 0){
			System.out.println("Y one coordinate is out of bounds " + position);
			return false;
		}

		if(fields[x][y].equals(Field.INACCESSIBLE)) {
            return false;
        }
		return true;
	}

	@Override
	public String toString() {
		String output = "";
		for (Field[] row : fields) {
			for (Field field : row) {
				output += field.toString();
			}
			output += "\n";
		}
		return output;
	}

	private void insertInaccessibleFields(List<Position> inaccessiblePositions) {
		for (Position p : inaccessiblePositions) {
			fields[p.x][p.y] = Field.INACCESSIBLE;
		}
	}

	private void initAccessibleLandscape(int size) {
		this.fields = new Field[size][size];
		for (int i = 0; i < fields.length; i++){
			for (int j = 0; j < fields[i].length; j++){
				fields[i][j] = Field.ACCESSIBLE;
			}
		}
	}

}
