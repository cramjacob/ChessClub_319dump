package chess;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class testBishopAvailableMoves {

	@Test
	public void testInit() {
		Tile[][] testBoard = new Tile[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Tile t = new Tile(j, i, false, null);
				testBoard[i][j] = t;
			}
		}

		Bishop testBishop = new Bishop(2, 4, "White", "B"); // second rank,
															// fourth file
		testBoard[testBishop.y][testBishop.x].isOccupied = true;
		testBoard[testBishop.y][testBishop.x].piece = testBishop;
		int[][] legalMoves = testBishop.getAvailableMoves(testBishop.x, testBishop.y, testBoard);
		int[][] expectedMoves = new int[][] { { 0, 0, 0, 0, 0, 0, 1, 0 }, 
											  { 0, 0, 0, 0, 0, 1, 0, 0 },
											  { 1, 0, 0, 0, 1, 0, 0, 0 }, 
											  { 0, 1, 0, 1, 0, 0, 0, 0 }, 
											  { 0, 0, -1, 0, 0, 0, 0, 0 },
											  { 0, 1, 0, 1, 0, 0, 0, 0 }, 
											  { 1, 0, 0, 0, 1, 0, 0, 0 }, 
											  { 0, 0, 0, 0, 0, 1, 0, 0 } };
		if (legalMoves.length != expectedMoves.length) {
			fail("legalMoves and expectedMoves arrays are not the same size");
		}
		/*for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				System.out.print(legalMoves[i][j] + " ");
			}
			System.out.println();
		}*/
		assertArrayEquals(legalMoves, expectedMoves);
	}

	@Test
	public void testPawn() {
		Tile[][] testBoard = new Tile[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Tile t = new Tile(j, i, false, null);
				testBoard[i][j] = t;
			}
		}

		Bishop testBishop = new Bishop(2, 4, "White", "B"); // second file,
															// fourth rank
		testBoard[testBishop.y][testBishop.x].isOccupied = true;
		testBoard[testBishop.y][testBishop.x].piece = testBishop;

		Pawn testPawn = new Pawn(5, 4, "White", "p"); // fifth file, fourth rank
		testBoard[testPawn.y][testPawn.x].isOccupied = true;
		testBoard[testPawn.y][testPawn.x].piece = testPawn;

		int[][] legalMoves = testBishop.getAvailableMoves(testBishop.x, testBishop.y, testBoard);
		int[][] expectedMoves = new int[][] { { 0, 0, 0, 0, 0, 0, 1, 0 }, 
											  { 0, 0, 0, 0, 0, 1, 0, 0 },
											  { 1, 0, 0, 0, 1, 0, 0, 0 }, 
											  { 0, 1, 0, 1, 0, 0, 0, 0 }, 
											  { 0, 0, -1, 0, 0, 0, 0, 0 },
											  { 0, 1, 0, 1, 0, 0, 0, 0 }, 
											  { 1, 0, 0, 0, 1, 0, 0, 0 }, 
											  { 0, 0, 0, 0, 0, 1, 0, 0 } };
		if (legalMoves.length != expectedMoves.length) {
			fail("legalMoves and expectedMoves arrays are not the same size");
		}
		assertArrayEquals(legalMoves, expectedMoves);
	}

	@Test
	public void testPawnAndPawn() {
		Tile[][] testBoard = new Tile[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Tile t = new Tile(j, i, false, null);
				testBoard[i][j] = t;
			}
		}

		// Create test Bishop
		Bishop testBishop = new Bishop(4, 2, "White", "B"); // second file, fourth
														// rank
		testBoard[testBishop.y][testBishop.x].isOccupied = true;
		testBoard[testBishop.y][testBishop.x].piece = testBishop;

		// Create test pawn
		Pawn testPawn = new Pawn(5, 4, "White", "p"); // fifth file, fourth rank
		testBoard[testPawn.y][testPawn.x].isOccupied = true;
		testBoard[testPawn.y][testPawn.x].piece = testPawn;

		// Create test pawn
		Pawn testPawn2 = new Pawn(2, 4, "White", "p"); // second file,
															// second rank
		testBoard[testPawn2.y][testPawn2.x].isOccupied = true;
		testBoard[testPawn2.y][testPawn2.x].piece = testPawn2;

		// get legalMoves and create expectedMoves
		int[][] legalMoves = testBishop.getAvailableMoves(testBishop.x, testBishop.y, testBoard);
		int[][] expectedMoves = new int[][] { { 0, 0, 1, 0, 0, 0, 1, 0 }, 
											  { 0, 0, 0, 1, 0, 1, 0, 0 },
											  { 0, 0, 0, 0, -1, 0, 0, 0 }, 
											  { 0, 0, 0, 1, 0, 1, 0, 0 }, 
											  { 0, 0, 1, 0, 0, 0, 1, 0 },
											  { 0, 1, 0, 0, 0, 0, 0, 1 }, 
											  { 1, 0, 0, 0, 0, 0, 0, 0 }, 
											  { 0, 0, 0, 0, 0, 0, 0, 0 } };
		if (legalMoves.length != expectedMoves.length) {
			fail("legalMoves and expectedMoves arrays are not the same size");
		}
		/*for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				System.out.print(legalMoves[i][j] + " ");
			}
			System.out.println();
		}*/
		assertArrayEquals(legalMoves, expectedMoves);
	}

	/*
	 * This test is going to place a rook at every possible spot on an empty
	 * board and then generate a legalMoves array, and will verify that with
	 * what we would expect from that rook position on an empty board
	 */
	@Test
	public void testLiterallyAllPossibleCombinationsOfBishopOnEmptyBoard() {
		Tile[][] testBoard = new Tile[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Tile t = new Tile(j, i, false, null);
				testBoard[i][j] = t;
			}
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Bishop testBishop = new Bishop(j, i, "White", "B");
				Tile t = new Tile(j, i, true, testBishop);
				testBoard[i][j] = t;
				System.out.println("y: " + testBishop.y + ", x: " + testBishop.x);
				int[][] legalMoves = testBishop.getAvailableMoves(testBishop.x, testBishop.y, testBoard);
				int[][] expectedMoves = getExpectedMoves(testBishop);

				if (legalMoves.length != expectedMoves.length) {
					fail("legalMoves and expectedMoves arrays are not the same size");
				}
				
				/*for(int i1 = 0; i1 < 8; i1++){
					for(int j1 = 0; j1 < 8; j1++){
						System.out.print(legalMoves[i1][j1] + " ");
					}
					System.out.println();
				}*/
				
				assertArrayEquals(legalMoves, expectedMoves);

				Tile empty = new Tile(j, i, false, null);
				testBoard[i][j] = empty;
			}
		}

	}

	private int[][] getExpectedMoves(Bishop testBishop) {
		int[][] ret = new int[8][8];
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 8; k++) {
				ret[j][k] = 0;
			}
		}
		int i = testBishop.y - 1;
		int j = testBishop.x - 1;
		while(i >= 0 && j >= 0){
			ret[i][j] = 1;
			i -= 1;
			j-= 1;
		}
		
		i = testBishop.y - 1;
		j = testBishop.x + 1;
		while(i >= 0 && j < 8){
			ret[i][j] = 1;
			i -= 1;
			j += 1;
		}
		
		i = testBishop.y + 1;
		j = testBishop.x - 1;
		while(i < 8 && j >= 0){
			ret[i][j] = 1;
			i += 1;
			j -= 1;
		}
		
		i = testBishop.y + 1;
		j = testBishop.x + 1;
		while(i < 8 && j < 8){
			ret[i][j] = 1;
			i += 1;
			j += 1;
		}
		
		ret[testBishop.y][testBishop.x] = -1;
		return ret;
	}
}
