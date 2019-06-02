import java.awt.Color;

public class PlayerHuman extends Player {

	public PlayerHuman(int randX, int randY, int velx, int vely, Color color) {
		super(randX, randY, velx, vely, color);
	}

	// does nothing because human players can see screen
	// only needed for AI, but required for abstract class
	public void addPlayers(Player[] players) {
	}

	// moves the Player based on its conditions
	public void move() {
		int a = xCoordinate;
		int b = yCoordinate;
		boost();

		if (!jump) {
			xCoordinate += velocityX;
			yCoordinate += velocityY;
			if (lines.size() > 1) {
				Shape l1 = lines.get(lines.size() - 2);
				Shape l2 = lines.get(lines.size() - 1);
				if (a == l1.getStartX() &&
						l1.getEndY() == l2.getStartY()) {
					lines.add(new Line(l1.getStartX(), l1.getStartY(),
							l2.getEndX(), l2.getEndY()));
					lines.remove(lines.size() - 2);
					lines.remove(lines.size() - 2);
				} else if (b == l1.getStartY() &&
						l1.getEndX() == l2.getStartX()) {
					lines.add(new Line(l1.getStartX(), l1.getStartY(),
							l2.getEndX(), l2.getEndY()));
					lines.remove(lines.size() - 2);
					lines.remove(lines.size() - 2);
				}
			}
			lines.add(new Line(a, b, xCoordinate, yCoordinate));
		} else {
			if (velocityX > 0) {
				xCoordinate += JUMPHEIGHT;
			} else if (velocityX < 0) {
				xCoordinate -= JUMPHEIGHT;
			} else if (velocityY > 0) {
				yCoordinate += JUMPHEIGHT;
			} else if (velocityY < 0) {
				yCoordinate -= JUMPHEIGHT;
			}
			jump = false;
		}
		accelerate();
		clip();
	}

}