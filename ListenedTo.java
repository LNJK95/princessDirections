package idkprincess;

import java.util.ArrayList;
import java.util.Collection;

public class ListenedTo
{
    protected Collection<GameListener> gameListeners = new ArrayList<GameListener>();

        protected void notifyListeners() {
        	for (GameListener gl : gameListeners) {
        	    gl.changed();
        	}
        }

        public void addListener(GameListener gl) {
        	gameListeners.add(gl);
        }
}
