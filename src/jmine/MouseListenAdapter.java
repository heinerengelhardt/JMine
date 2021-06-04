package jmine;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

class MouseListenAdapter extends MouseAdapter {
	private GUI gui;
	private boolean[] metaField;
	public static boolean gameover = false;

	public MouseListenAdapter( GUI _gui ) {
		gui = _gui;
		metaField = new boolean[100];
		gameover = false;
		for( int i = 1; i <= 100; i++ ) {
			metaField[i - 1] = false;
		}
	}

	public void mousePressed( MouseEvent me ) {
		if(me.getButton() == 3 && !gameover && (((JButton) me.getSource()).getText().isBlank()) || ((JButton) me.getSource()).getText() == "O") {
			int nr = Integer.parseInt( ((JButton) me.getSource()).getActionCommand() );

			if(gui.ButtonField[nr - 1].getBackground() != Color.GRAY) {
				if (metaField[nr - 1] == false) {
					gui.ButtonField[nr - 1].setBackground(Color.CYAN);
					gui.ButtonField[nr - 1].setText("O");
					gui.statusField.setText("Bombs: " + (--GameField.BoCo));
					metaField[nr - 1] = true;

				} else {
					gui.ButtonField[nr - 1].setBackground(Color.LIGHT_GRAY);
					gui.ButtonField[nr - 1].setText("");
					gui.statusField.setText("Bombs: " + (++GameField.BoCo));
					metaField[nr - 1] = false;
				}
			}
		}
	}
}
