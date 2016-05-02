package idkprincess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapComponent extends JComponent implements GameListener
{
    private Map map;

    private final static int SQUARE_SIZE = 100;

    private BufferedImage princessFront = null;
    private BufferedImage princessLeft = null;
    private BufferedImage princessRight = null;
    private BufferedImage princessBack = null;

    public MapComponent(final Map map) {
	this.map = map;

	try {
	    princessFront = ImageIO.read(new File(getClass().getResource("resources/princess_front.png").getPath()));
	    princessLeft = ImageIO.read(new File(getClass().getResource("resources/princess_left.png").getPath()));
	    princessRight = ImageIO.read(new File(getClass().getResource("resources/princess_right.png").getPath()));
	    princessBack = ImageIO.read(new File(getClass().getResource("resources/princess_back.png").getPath()));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	for (int r = 0; r < map.getHeight(); r++) {
	    for (int c = 0; c < map.getWidth(); c++) {
		if (map.getCoordinates(r, c) == SquareType.FLOOR) {
		    Shape rect = new Rectangle(c * SQUARE_SIZE, r * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);

		    g2d.setPaint(Color.WHITE);
		    g2d.fill(rect);
		}
	    }
	}
	Direction princessDirection = map.getPlayerDirection();
	if (princessDirection == Direction.FRONT) {
	    g2d.drawImage(princessFront, map.getPlayerX() * SQUARE_SIZE, map.getPlayerY() * SQUARE_SIZE, null);
	}
	else if (princessDirection == Direction.BACK) {
	    g2d.drawImage(princessBack, map.getPlayerX() * SQUARE_SIZE, map.getPlayerY() * SQUARE_SIZE, null);
	}
	else if (princessDirection == Direction.LEFT) {
	    g2d.drawImage(princessLeft, map.getPlayerX() * SQUARE_SIZE, map.getPlayerY() * SQUARE_SIZE, null);
	}
	else if (princessDirection == Direction.RIGHT) {
	    g2d.drawImage(princessRight, map.getPlayerX() * SQUARE_SIZE, map.getPlayerY() * SQUARE_SIZE, null);
	}
    }

    public Dimension getPreferredSize() {
   	Dimension size = new Dimension(SQUARE_SIZE * map.getWidth(), SQUARE_SIZE * map.getHeight());
   	return size;
    }

    public void changed() {
	repaint();
    }
}
