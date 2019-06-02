import java.awt.Graphics;
import java.util.ArrayList;

public abstract class GameObject {
	// x and yCoordinate coordinates
	int xCoordinate;
	int yCoordinate;

	// width and height of the court
	int width;
	int height;

	// Pixels to move each time move() method is called.
	int velocityX;
	int velocityY;

	// Maximum x, yCoordinate values that the player can reach
	int rightBound;
	int bottomBound;

	/*initialise the game object that has the x and y coordinates, the movement of the pixel
	and the maximum values of the x and y coordinates*/
	public GameObject(int x, int yCoordinate, int velocityX, int velocityY, int width,
					  int height) {
		this.xCoordinate = x;
		this.yCoordinate = yCoordinate;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.width = width;
		this.height = height;
	}
	
	// adjusts the bounds of the court
	public void setBounds(int width, int height) {
		rightBound = width - this.width;
		bottomBound = height - this.height;
	}
	
	// sets the player's x velocity as long as it doesn't oppose current motion
	public void setXVelocity(int velocityX) {
		if (!(velocityX > 0 && this.velocityX < 0)
				&& !(velocityX < 0 && this.velocityX > 0))
		{
			this.velocityX = velocityX;
		}
	}
	
	// sets the player's yCoordinate velocity as long as it doesn't oppose current motion
	public void setYVelocity(int velocityY) {
		if (!(velocityY > 0 && this.velocityY < 0)
				&& !(velocityY < 0 && this.velocityY > 0)) {
			this.velocityY = velocityY;
		}
	}

	// Move the object at the given velocity.
	public void move()
	{
		//move to every xCoordinate
		xCoordinate += velocityX;
		//move to every yCoordinate
		yCoordinate += velocityY;

		accelerate();
		clip();
	}

	// Keep the object in the bounds of the court
	public void clip() {
		if (xCoordinate < 0)
			xCoordinate = 0;
		else if (xCoordinate > rightBound)
			xCoordinate = rightBound;

		if (yCoordinate < 0)
			yCoordinate = 0;
		else if (yCoordinate > bottomBound)
			yCoordinate = bottomBound;
	}

	/*Compute whether an object crashes*/

	public Intersection intersects(GameObject other)
	{
		if (other != this) {
			if (other.yCoordinate - other.height/2 <= yCoordinate + height/2 &&
				other.yCoordinate + other.height/2 >= yCoordinate - height/2 &&
				other.xCoordinate - other.width/2 <= xCoordinate + width/2 &&
				other.xCoordinate + other.width/2 >= xCoordinate - width/2) {
				return Intersection.UP;
			}
		}
		ArrayList<Shape> pa = other.getPath();
		for (int i = 0; i < pa.size() - 1; i++) {
			Shape k = pa.get(i);
			int x1 = k.getStartX();
			int y1 = k.getStartY();
			int x2 = k.getEndX();
			int y2 = k.getEndY();

			if (y1 == y2) {
				if (Math.abs(y1 - yCoordinate) <= height/2 &&
					(xCoordinate >= Math.min(x1, x2) && xCoordinate <= Math.max(x1, x2))) {
					return Intersection.UP;
				}
			} else if (x1 == x2) {
				if (Math.abs(x1 - xCoordinate) <= width/2 &&
					(yCoordinate >= Math.min(y1, y2) && yCoordinate <= Math.max(y1, y2))) {
					return Intersection.UP;
				}
			}
		}
		return Intersection.NONE;
	}
	
	// checks if an object has crossed the bounds of the screen
	public abstract void accelerate();

	// draws the object
	public abstract void draw(Graphics g);
	
	// returns true if the player is alive
	public abstract boolean getAlive();
	
	// returns the player's path as a list of shapes
	public abstract ArrayList<Shape> getPath();
}
