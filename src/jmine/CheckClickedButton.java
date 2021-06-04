package jmine;

import java.awt.Color;

public class CheckClickedButton {

	private GUI gui;
	private int nr;
	private int bombCount;
	private int buttonNr;

	public CheckClickedButton( GUI _gui ) {
		gui = _gui;
	}

	public void checkhim( int _buttonNr, int _bombCount ) {
		bombCount = _bombCount;
		buttonNr = _buttonNr;
		if( bombCount == 88 ) {
			for( int i = 1, nr = 0; i <= 100; i++ ) {
				nr = GameField.CheckForBombs( i - 1 );
				if( nr == 88 ) {
					gui.ButtonField[i - 1].setBackground( Color.red );
					gui.ButtonField[i - 1].setText( "X" );
				}
				else
				if( nr == 0 ) {
					gui.ButtonField[i - 1].setText( "" );
					gui.ButtonField[i - 1].setEnabled( false );
				}
				else {
					gui.ButtonField[i - 1].setText( "" + nr );
					gui.ButtonField[i - 1].setEnabled( false );
				}
			}
			gui.statusField.setText( "Game Over" );
			MouseListenAdapter.gameover = true;
		}
		else

		if( bombCount == 0 ) {
			for( int i = 1, nr = 0; i <= 100; i++ ) {
				nr = GameField.CheckForBombs( i - 1 );
				if( nr == 0 ) {
					gui.ButtonField[i - 1].setBackground( Color.gray );
					gui.ButtonField[i - 1].setEnabled( false );
					gui.ButtonField[i - 1].setText( "" );
				}
			}
		}

		else {
			gui.ButtonField[buttonNr - 1].setText( "" + bombCount );
			gui.ButtonField[buttonNr - 1].setBackground( Color.gray );
		}
	}

	public CheckClickedButton() {
	}
}