package idkprincess;

public class Map extends ListenedTo
{
    private SquareType[][] coordinates;

    private int height;
    private int width;
    private final static int BORDER = 2;

    private int playerX;
    private int playerY;
    private Direction playerDirection;

    public Map(final int height, final int width) {
	this.height = height;
	this.width = width;

	coordinates = new SquareType[height+BORDER*2][width+BORDER*2];

	playerDirection = Direction.FRONT;

	playerX = width/2;
	playerY = height/2;

	for (int r = 0; r < height + BORDER*2; r++) {
	    for (int c = 0; c < width + BORDER*2; c++) {
		if (r < BORDER || c < BORDER || r >= height+BORDER || c>= width+BORDER) {
		    coordinates[r][c] = SquareType.BLOCKED;
		}
		else {
		    coordinates[r][c] = SquareType.FLOOR;
		}
	    }
	}
    }

    public void moveDown() {
    	if (playerDirection == Direction.FRONT) {
    	    playerY++;
    	}
	else {
	    playerDirection = Direction.FRONT;
	}
    	notifyListeners();
    }

    public void moveUp() {
	if (playerDirection == Direction.BACK) {
    	    playerY--;
    	}
	else {
	    playerDirection = Direction.BACK;
	}
    	notifyListeners();
    }

    public void moveRight() {
    	if (playerDirection == Direction.RIGHT) {
    	    playerX++;
    	}
	else {
	    playerDirection = Direction.RIGHT;
	}
    	notifyListeners();
    }

    public void moveLeft() {
    	if (playerDirection == Direction.LEFT) {
    	    playerX--;
    	}
	else {
	    playerDirection = Direction.LEFT;
	}
    	notifyListeners();
    }

    public SquareType getCoordinates(int y, int x) {
	return coordinates[y+BORDER][x+BORDER];
    }

    public int getHeight() {
	return height;
    }

    public int getWidth() {
	return width;
    }

    public static int getBORDER() {
	return BORDER;
    }

    public int getPlayerX() {
	return playerX;
    }

    public int getPlayerY() {
	return playerY;
    }

    public Direction getPlayerDirection() {
	return playerDirection;
    }

    public void setCoordinates(final SquareType[][] coordinates) {
	this.coordinates = coordinates;
    }

    public void setHeight(final int height) {
	this.height = height;
    }

    public void setWidth(final int width) {
	this.width = width;
    }

    public void setPlayerX(final int playerX) {
	this.playerX = playerX;
    }

    public void setPlayerY(final int playerY) {
	this.playerY = playerY;
    }
}
