package idkprincess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MapFrame extends JFrame
{
    private Map map;

    public MapFrame(final Map map) {
	super("SNEAKY LMAO");
	this.map = map;
	this.setLayout(new BorderLayout());

	final MapComponent mapComponent = new MapComponent(map);

	map.addListener(mapComponent);

	this.add(mapComponent, BorderLayout.PAGE_START);

	this.pack();
	this.setVisible(true);

	class DownAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
			map.moveDown();
		    }
	}
	class UpAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
			map.moveUp();
		    }
	}
	class RightAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
			map.moveRight();
		    }
	}
	class LeftAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
			map.moveLeft();
		    }
	}
	class QuitAction extends AbstractAction {
	    @Override public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		    }
	}
	final InputMap in = mapComponent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("UP"), "moveUp");
	in.put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
	in.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
	in.put(KeyStroke.getKeyStroke("ESCAPE"), "quit");
	final ActionMap act = mapComponent.getActionMap();
	act.put("moveUp", new UpAction());
	act.put("moveDown", new DownAction());
	act.put("moveRight", new RightAction());
	act.put("moveLeft", new LeftAction());
	act.put("quit", new QuitAction());
    }
}
