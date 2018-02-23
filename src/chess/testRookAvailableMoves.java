package chess;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class testRookAvailableMoves {
	/*
	 * This test will place a rook on an empty board at 
	 * position col:2 row:3 and get available moves then test them
	 */
	@Test
	public void testOpenRook() {
		
		/*
		 * This initializes an 8x8 board to empty tiles
		 */
		Tile[][] testBoard = new Tile[8][8];
		for (int col = 0; col < 8; col++) {
			for (int row = 0; row < 8; row++) {
				Tile t = new Tile(row, col, false, null);
				testBoard[col][row] = t;
			}
		}
		Rook testRook = new Rook(2, 1, "White", PieceType.Rook);
		testBoard[2][1] = new Tile(2, 1, true, testRook);
		
		Tile[] rookMoves = testRook.getAvailableMoves(testBoard);
		Tile[] rookMovesExpected = getExpectedMoves(testRook);
		System.out.println("rme " + rookMovesExpected.length);
		System.out.println("rm " + rookMoves.length);
		assertArrayEquals(rookMovesExpected, rookMoves);
	}
	
	private Tile[] getExpectedMoves(Rook testRook) {
		ArrayList<Tile> list = new ArrayList<Tile>();
		
		for (int col = 0; col < 8; col++) {
			for (int row = 0; row < 8; row++) {
				if (col == testRook.col) {
					if (row == testRook.row) {
						// do nothing
					} else {
						list.add(new Tile(row, col, false, null));
					}
				}
				if (row == testRook.row) {
					if (col == testRook.col) {
						// do nothing
					} else {
						list.add(new Tile(row, col, false, null));
					}
				}
			}
		}
		Tile[] ret = new Tile[list.size()];
		ret = list.toArray(ret);
		return ret;
	}

	/*
	 * This test will create a new classical board, initialize it to 
	 * it's standard position, and then assign a Tile[][] array to the classical board
	 * 
	 * For the Rooks in a starting classical game, we would expect them to
	 * have no legal moves to make, since they are trapped in by their own pieces. 
	 * This test checks to ensure that they all return the correct getAvailableMoves()
	 * when there are no available moves to make.
	 */
	@Test
	public void testInit() {
		
		classicalChessBoard board = new classicalChessBoard();
		board.initBoard();
		Tile[][] testBoard = board.getBoard();
		/*
		 * Get each rook (2 for white side, 2 for black side)
		 */
		Piece whiteRook1 = testBoard[7][0].piece;
		Piece whiteRook2 = testBoard[7][7].piece;
		Piece blackRook1 = testBoard[0][0].piece;
		Piece blackRook2 = testBoard[0][7].piece;
		
		/*
		 * Get the available moves from each rook
		 */
		Tile[] whiteRook1Moves = whiteRook1.getAvailableMoves(testBoard);
		Tile[] whiteRook2Moves = whiteRook2.getAvailableMoves(testBoard);
		Tile[] blackRook1Moves = blackRook1.getAvailableMoves(testBoard);
		Tile[] blackRook2Moves = blackRook2.getAvailableMoves(testBoard);
		
		/*
		 * These are all empty, as if there are no available moves, getLegalMoves() 
		 * has no objects to return, thus returns empty Tile array.
		 */
		Tile[] whiteRook1ExpectedMoves = new Tile[0];
		Tile[] whiteRook2ExpectedMoves = new Tile[0];
		Tile[] blackRook1ExpectedMoves = new Tile[0];
		Tile[] blackRook2ExpectedMoves = new Tile[0];
		
		/*
		 * Test equality
		 */
		assertArrayEquals(whiteRook1ExpectedMoves, whiteRook1Moves);
		assertArrayEquals(whiteRook2ExpectedMoves, whiteRook2Moves);
		assertArrayEquals(blackRook1ExpectedMoves, blackRook1Moves);
		assertArrayEquals(blackRook2ExpectedMoves, blackRook2Moves);
	}
}
