package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class testPawnAvailableMoves {

	/*
	 * Tests if black and white pawn in starting positions without any other pieces are returning the correct moves.
	 */
	@Test
	public void testPawnMoves() {
		//new empty board
		Tile[][] testBoard = new Tile[8][8];
		for (int col = 0; col < 8; col++) {
			for (int row = 0; row < 8; row++) {
				Tile t = new Tile(row, col, false, null);
				testBoard[col][row] = t;
			}
		}
		Pawn testerw = new Pawn(6, 4, Color.White, PieceType.Pawn);
		testBoard[6][4] = new Tile(6, 4, true, testerw);
		Pawn testerb = new Pawn(1, 4, Color.Black, PieceType.Pawn);
		testBoard[1][4] = new Tile(1, 4, true, testerb);
		
		
		Tile[] pawnMovesW = testerw.getAvailableMoves(testBoard);
		Tile[] pawnMovesB = testerb.getAvailableMoves(testBoard);
		assertEquals(2,pawnMovesB.length);
		assertEquals(2,pawnMovesW.length);
	}
	/*
	 * Tests if a piece in the middle of an empty board is getting the correct number of allowed moves
	 */
	@Test
	public void testAllowedMoves() {
		//new empty board
		Tile[][] testBoard = new Tile[8][8];
		for (int col = 0; col < 8; col++) {
			for (int row = 0; row < 8; row++) {
				Tile t = new Tile(row, col, false, null);
				testBoard[col][row] = t;
			}
		}
		Pawn testerw = new Pawn(3, 3, Color.White, PieceType.Pawn);
		testBoard[3][3] = new Tile(3, 3, true, testerw);
		
		Tile[] pawnMoves = testerw.getAvailableMoves(testBoard);
		assertEquals(2,pawnMoves.length);
	}

	/*
	 * Tests if a piece in the middle of an empty board is getting the correct number of allowed moves
	 */
	@Test
	public void testIfhasMoved() {
		//new empty board
		Tile[][] testBoard = new Tile[8][8];
		for (int col = 0; col < 8; col++) {
			for (int row = 0; row < 8; row++) {
				Tile t = new Tile(row, col, false, null);
				testBoard[col][row] = t;
			}
		}
		Pawn testerw = new Pawn(6, 4, Color.White, PieceType.Pawn);
		testBoard[6][4] = new Tile(6, 4, true, testerw);
		Pawn testerb = new Pawn(1, 4, Color.Black, PieceType.Pawn);
		testBoard[1][4] = new Tile(1, 4, true, testerb);
		
		testerw.move(5, 4);
		testerb.move(2, 4);
		assertTrue(testerw.hasMoved);
		assertTrue(testerb.hasMoved);
	}


	
}
