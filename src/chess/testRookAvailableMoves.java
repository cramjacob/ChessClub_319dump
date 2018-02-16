package chess;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class testRookAvailableMoves {


	@Test
	public void testInit() {
		Tile[][] testBoard = new Tile[8][8];
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Tile t = new Tile(j, i, false, null);
				testBoard[i][j] = t;
			}
		}
		
		Rook testRook = new Rook(2, 4, "White", "R"); // second rank, fourth file
		testBoard[testRook.y][testRook.x].isOccupied = true;
		testBoard[testRook.y][testRook.x].piece = testRook;
		int[][] legalMoves = testRook.getAvailableMoves(testRook.x, testRook.y, testBoard);
		int[][] expectedMoves = new int[][]{{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 1, 1, -1, 1, 1, 1, 1, 1},
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 }};
		if (legalMoves.length != expectedMoves.length) {
			fail("legalMoves and expectedMoves arrays are not the same size");
		}
		assertArrayEquals(legalMoves, expectedMoves);
	}
	
	@Test
	public void testPawn() {
		Tile[][] testBoard = new Tile[8][8];
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Tile t = new Tile(j, i, false, null);
				testBoard[i][j] = t;
			}
		}
		
		Rook testRook = new Rook(2, 4, "White", "R"); // second file, fourth rank
		testBoard[testRook.y][testRook.x].isOccupied = true;
		testBoard[testRook.y][testRook.x].piece = testRook;
		
		
		Pawn testPawn = new Pawn(5, 4, "White", "p"); // fifth file, fourth rank
		testBoard[testPawn.y][testPawn.x].isOccupied = true;
		testBoard[testPawn.y][testPawn.x].piece = testPawn;
		
		
		int[][] legalMoves = testRook.getAvailableMoves(testRook.x, testRook.y, testBoard);
		int[][] expectedMoves = new int[][]{{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 1, 1, -1, 1, 1, 1, 0, 0},
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 }};
		if (legalMoves.length != expectedMoves.length) {
			fail("legalMoves and expectedMoves arrays are not the same size");
		}
		assertArrayEquals(legalMoves, expectedMoves);
	}
	
	@Test
	public void testPawnAndBihsop() {
		Tile[][] testBoard = new Tile[8][8];
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Tile t = new Tile(j, i, false, null);
				testBoard[i][j] = t;
			}
		}
		
		// Create test rook
		Rook testRook = new Rook(2, 4, "White", "R"); // second file, fourth rank
		testBoard[testRook.y][testRook.x].isOccupied = true;
		testBoard[testRook.y][testRook.x].piece = testRook;
		
		// Create test pawn
		Pawn testPawn = new Pawn(5, 4, "White", "p"); // fifth file, fourth rank
		testBoard[testPawn.y][testPawn.x].isOccupied = true;
		testBoard[testPawn.y][testPawn.x].piece = testPawn;
		
		// Create test bishop
		Bishop testBishop = new Bishop(2, 2, "White", "B"); // second file, second rank
		testBoard[testBishop.y][testBishop.x].isOccupied = true;
		testBoard[testBishop.y][testBishop.x].piece = testPawn;
		
		// get legalMoves and create expectedMoves
		int[][] legalMoves = testRook.getAvailableMoves(testRook.x, testRook.y, testBoard);
		int[][] expectedMoves = new int[][]{{ 0, 0, 0, 0, 0, 0, 0, 0 },
											{ 0, 0, 0, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 1, 1, -1, 1, 1, 1, 0, 0},
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 },
											{ 0, 0, 1, 0, 0, 0, 0, 0 }};
		if (legalMoves.length != expectedMoves.length) {
			fail("legalMoves and expectedMoves arrays are not the same size");
		}
		assertArrayEquals(legalMoves, expectedMoves);
	}

}
