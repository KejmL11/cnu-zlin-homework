package dk.cngroup.university;

public enum Action {
	RIGHT {
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
			Direction direction = rover.getDirection().getDirectionOnRight();
			Position position = rover.getPosition();
			return new Rover(direction, position);
		}
	},
	LEFT {
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
				Direction direction = rover.getDirection().getDirectionOnLeft();
				Position position = rover.getPosition();
				return new Rover(direction, position);
		}
	},
	FORWARD {
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
			Direction direction = rover.getDirection();
			Position position =
					rover.getPosition().getNeighbour(direction);
			if (landscape.isAccessible(position)) {
				return new Rover(direction, position);
			}
			return rover;
		}
	},
	BACKWARD {
		@Override
		public Rover perform(Rover rover, Landscape landscape) {
			Direction turnBack = rover.getDirection().getDirectionOnLeft();
			Direction direction = turnBack.getDirectionOnLeft();
			Position position =
					rover.getPosition().getNeighbour(direction);
			if (landscape.isAccessible(position)) {
				return new Rover(rover.getDirection(), position);
			}
			return rover;
		}
	};

	public abstract Rover perform(Rover rover, Landscape landscape);
}
