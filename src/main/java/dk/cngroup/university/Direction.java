package dk.cngroup.university;

public enum Direction {
	NORTH {
		@Override
		Direction getDirectionOnRight() {
			return EAST;
		}
		@Override
		Direction getDirectionOnLeft() {
			return WEST;
		}
	},
	SOUTH {
		@Override
		Direction getDirectionOnRight() {
			return WEST;
		}
		@Override
		Direction getDirectionOnLeft() {
			return EAST;
		}
	},
	WEST {
		@Override
		Direction getDirectionOnRight() {
			return NORTH;
		}
		@Override
		Direction getDirectionOnLeft() {
			return SOUTH;
		}
	},
	EAST {
		@Override
		Direction getDirectionOnRight() {
			return SOUTH;
		}
		@Override
		Direction getDirectionOnLeft() {
			return NORTH;
		}
	};

	abstract Direction getDirectionOnRight();
	abstract Direction getDirectionOnLeft();

}
