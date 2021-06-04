package jmine;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import static java.awt.event.ActionEvent.CTRL_MASK;

public class GUI extends JFrame implements ActionListener {

	private GameField gamefield;
	private CheckClickedButton checkclickedbutton;
	private JMenuBar menubar;
	private JPanel buttonPanel;
	public JTextField statusField;
	public JTextField timeField;
	private Container buttonContainer;
	private MouseListener buttonListener;
	public JButton[] ButtonField;

	public GUI( String s ) {
		super( s );

		// create menu bar
		menubar = new JMenuBar();
		menubar.add( createGameMenu() );
		menubar.add( createHelpMenu() );
		setJMenuBar( menubar );

		// create buttons
		ButtonField = new JButton[100];
		buttonContainer = new Container();
		buttonContainer.setLayout( new GridLayout( 10, 10 ) );
		buttonListener = new MouseListenAdapter( this );

		for( int i = 1; i <= 100; i++ ) {
			ButtonField[i - 1] = new JButton();
			ButtonField[i - 1].setActionCommand( "" + i );
			ButtonField[i - 1].addActionListener( this );
			ButtonField[i - 1].addMouseListener( buttonListener );
			ButtonField[i - 1].setBorder( BorderFactory.createEtchedBorder() );
			ButtonField[i - 1].setBackground( Color.lightGray );
			buttonContainer.add( ButtonField[i - 1] );
		}
		getContentPane().add( "Center", buttonContainer );

		// create status line
		statusField = new JTextField( 20 );
		statusField.setEditable( false );
		getContentPane().add( "South", statusField );

		timeField = new JTextField( 5 );
		timeField.setEditable( false );
		//getContentPane().add("South", timeField);

		// initialize game field
		gamefield = new GameField( this );
		checkclickedbutton = new CheckClickedButton( this );

		// initialize window
		addWindowListener( new WindowClosingAdapter( true ) );
		setLocation( 350, 350 );
		setSize( 250, 300 );
		setResizable( false );
		setVisible( true );
	}

	private JMenu createGameMenu() {
		JMenu gameJMenu = new JMenu( "Game" );
		gameJMenu.setMnemonic( 'G' );

		JMenuItem gameJMenuItem;

		gameJMenuItem = new JMenuItem( "New Game", 'N' );
		setCtrlAccelerator( gameJMenuItem, 'N' );
		gameJMenuItem.addActionListener( this );
		gameJMenu.add( gameJMenuItem );

		gameJMenu.addSeparator();

		gameJMenuItem = new JMenuItem( "Exit", 'x' );
		setCtrlAccelerator( gameJMenuItem, 'Q' );
		gameJMenuItem.addActionListener( this );
		gameJMenu.add( gameJMenuItem );

		return gameJMenu;
	}

	private JMenu createHelpMenu() {
		JMenu helpJMenu = new JMenu( "Help" );
		helpJMenu.setMnemonic( 'H' );

		JMenuItem helpJMenuItem;

		helpJMenuItem = new JMenuItem( "JMine Rules", 'R' );
		setCtrlAccelerator( helpJMenuItem, 'R' );
		helpJMenuItem.addActionListener( this );
		helpJMenu.add( helpJMenuItem );

		helpJMenu.addSeparator();

		helpJMenuItem = new JMenuItem( "About", 'b' );
		setCtrlAccelerator( helpJMenuItem, 'A' );
		helpJMenuItem.addActionListener( this );
		helpJMenu.add( helpJMenuItem );

		return helpJMenu;
	}

	private void setCtrlAccelerator( JMenuItem mi, char acc ) {
		KeyStroke ks = KeyStroke.getKeyStroke( acc, CTRL_MASK );
		mi.setAccelerator( ks );
	}

	public void actionPerformed( ActionEvent event ) {
		String chosen = event.getActionCommand();

		if( chosen.equals( "New Game" ) ) {
			gamefield = new GameField( this );
			checkclickedbutton = new CheckClickedButton( this );
			MouseListenAdapter.gameover = false;

			for( int i = 1; i <= 100; i++ ) {
				ButtonField[i - 1].setText( "" );
				ButtonField[i - 1].setEnabled( true );
				ButtonField[i - 1].setVisible( true );
				ButtonField[i - 1].setBackground( Color.LIGHT_GRAY );
				ButtonField[i - 1].setForeground( Color.BLACK );
			}
		}
		else

		if( chosen.equals( "Exit" ) ) {
			if( JOptionPane.showConfirmDialog( null, "Really Quit JMine?",
											   "Exit",
											   JOptionPane.YES_NO_OPTION ) == 0 ) {
				this.setVisible( false );
				this.dispose();
				System.exit( 0 ); // Im JVideo streichen!
			}
		}
		else

		if( chosen.equals( "JMine Rules" ) ) {
			JOptionPane.showMessageDialog( null, "Find all bombs on the field.",
										   "JMine Rules",
										   JOptionPane.INFORMATION_MESSAGE );
		}
		else

		if( chosen.equals( "About" ) ) {
			JOptionPane.showMessageDialog( null,
					"JMine\n" +
							"by Heiner Engelhardt (heiner.engelhardt@gmail.org)\n" +
							"version 0.1\n" +
							"All Rights Reserved",
					"About",
					JOptionPane.INFORMATION_MESSAGE );
		}

		else {
			int buttonNr;
			int bombCount;
			buttonNr = Integer.parseInt( event.getActionCommand() ); // thanks to Dominik
			bombCount = gamefield.CheckForBombs( buttonNr - 1 );
			checkclickedbutton.check( buttonNr, bombCount );
		}
	}
}