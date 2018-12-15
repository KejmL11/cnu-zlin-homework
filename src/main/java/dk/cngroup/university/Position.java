package dk.cngroup.university;

import java.util.Objects;

public class Position {
	public final int x;
	public final int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Position getNeighbour(Direction direction) {
		switch (direction) {
			case SOUTH:
				return new Position(x + 1, y);
			case WEST:
				return new Position(x, y - 1);
			case NORTH:
				return new Position(x - 1, y);
			case EAST:
				return new Position(x, y + 1);
			default:
				return this;
		}
	}

	@Override
	public String toString() {
		return "Position{" +
				"x=" + x +
				", y=" + y +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return x == position.x &&
				y == position.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
