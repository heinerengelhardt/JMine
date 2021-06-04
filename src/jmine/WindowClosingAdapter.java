package jmine;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowClosingAdapter extends WindowAdapter {
	private boolean exitSystem;

	public WindowClosingAdapter( boolean _exitSystem ) {
		exitSystem = _exitSystem;
	}

	public WindowClosingAdapter() {
		exitSystem = true;
	}

	public void windowClosing( WindowEvent we ) {
		we.getWindow().setVisible( false );
		we.getWindow().dispose();

		if( exitSystem == true ) {
			System.exit( 0 );
		}
	}
}