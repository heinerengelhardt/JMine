package jmine;

public class GameField {

	private GUI gui;
	private static int[] BattleField;
	private static final int bomb = 88;
	private static final int safe = 0;
	public static int BoCo;

	public GameField() {}

	public GameField( GUI _gui ) {
		gui = _gui;
		BattleField = new int[100];
		BoCo = 0;

		for( int i = 1; i <= 100; i++ ) {
			BattleField[i - 1] = safe;
		}

		for( int i = 0; i < 20; i++ ) {
			BattleField[ ( int ) ( Math.random() * 100 )] = bomb;
		}

		for( int i = 1; i <= 100; i++ ) {
			if( BattleField[i - 1] == bomb ) {
				BoCo++;
			}
		}

		gui.statusField.setText( "Bombs: " + BoCo );

		initBattleField( 11, 18 );
		initBattleField( 21, 28 );
		initBattleField( 31, 38 );
		initBattleField( 41, 48 );
		initBattleField( 51, 58 );
		initBattleField( 61, 68 );
		initBattleField( 71, 78 );
		initBattleField( 81, 88 );
		initBattleFieldLineLeft();
		initBattleFieldLineRight();
		initBattleFieldLineUp();
		initBattleFieldLineDown();
	}

	public static int CheckForBombs( int i ) {
		if( BattleField[i] == bomb ) {
			return 88;
		}

		return BattleField[i];
	}

	private void initBattleFieldLineDown() {
		int counter = 0;
		for( int i = 91; i <= 98; i++ ) {

			try {
				if( BattleField[i - 1] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 1] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i - 9] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i - 10] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i - 11] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			if( BattleField[i] == safe && counter > 0 ) {
				BattleField[i] = counter;
			}

			counter = 0;
		}
	}

	private void initBattleFieldLineUp() {
		int counter = 0;
		for( int i = 1; i <= 8; i++ ) {

			try {
				if( BattleField[i - 1] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 1] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 9] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 10] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 11] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			if( BattleField[i] == safe && counter > 0 ) {
				BattleField[i] = counter;
			}

			counter = 0;
		}
	}

	private void initBattleFieldLineLeft() {
		int counter = 0;
		for( int i = 0; i <= 90; i += 10 ) {

			try {
				if( BattleField[i - 10] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 10] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 1] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 11] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i - 9] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			if( BattleField[i] == safe && counter > 0 ) {
				BattleField[i] = counter;
			}

			counter = 0;
		}
	}

	private void initBattleFieldLineRight() {
		int counter = 0;
		for( int i = 9; i <= 99; i += 10 ) {

			try {
				if( BattleField[i - 10] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 10] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i - 1] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 9] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i - 11] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			if( BattleField[i] == safe && counter > 0 ) {
				BattleField[i] = counter;
			}

			counter = 0;
		}
	}

	private void initBattleField( int a, int b ) {
		int counter = 0;
		for( int i = a; i <= b; i++ ) {

			try {
				if( BattleField[i - 1] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 1] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i - 10] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 10] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i - 9] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 9] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i - 11] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			try {
				if( BattleField[i + 11] == bomb ) {
					counter++;
				}
			}
			catch( ArrayIndexOutOfBoundsException ae ) {}

			if( BattleField[i] == safe && counter > 0 ) {
				BattleField[i] = counter;
			}

			counter = 0;
		}
	}
}
