package jmine;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class SplashScreen extends JWindow {

	public SplashScreen( String text ) {
		JPanel jminePanel = new JPanel();
		jminePanel.setLayout( new BorderLayout() );
		Border bd1 = BorderFactory.createBevelBorder( BevelBorder.RAISED );
		Border bd2 = BorderFactory.createEtchedBorder();
		Border bd3 = BorderFactory.createCompoundBorder( bd1, bd2 );
		( ( JPanel ) jminePanel ).setBorder( bd3 );
		jminePanel.add( "Center", new JLabel( text, JLabel.CENTER ) );
		setContentPane( jminePanel );

		showFor( 3000 );
	}

	public void showFor( int millis ) {
		setLocation( 225, 260 );
		setSize( 50, 50 );
		setVisible( true );
		try {
			Thread.sleep( millis );
		}
		catch( InterruptedException e ) {}
		setVisible( false );
	}
}