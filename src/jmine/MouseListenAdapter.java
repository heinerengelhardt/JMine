package jmine;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

class MouseListenAdapter extends MouseAdapter {
	private GUI gui;
	private boolean[] metaField;
	public static boolean gameover;

	public MouseListenAdapter( GUI _gui ) {
		gui = _gui;
		metaField = new boolean[100];
		gameover = false;
		for( int i = 1; i <= 100; i++ ) {
			metaField[i - 1] = false;
		}
	}

	public void mousePressed( MouseEvent me ) {
		String choosed = new String();

		if( me.isMetaDown() && gameover == false ) {
			int nr;
			choosed = ( ( JButton ) me.getSource() ).getActionCommand();
			nr = Integer.parseInt( choosed );
			if( metaField[nr - 1] == false ) {
				gui.ButtonField[nr - 1].setBackground( Color.blue );
				gui.ButtonField[nr - 1].setText( "X" );
				gui.statusField.setText( "Bombs: " + ( --GameField.BoCo ) );
				metaField[nr - 1] = true;
			}
			else {
				gui.ButtonField[nr - 1].setBackground( Color.lightGray );
				gui.ButtonField[nr - 1].setText( "" );
				gui.statusField.setText( "Bombs: " + ( ++GameField.BoCo ) );
				metaField[nr - 1] = false;
			}
		}

		switch( me.getClickCount() ) {
			case 1:

				//System.out.println("EINZELKLICK");
				break;

			case 2:

				//System.out.println("DOPPELKLICK");
				break;

			default:
				break;
		}
	}
}
