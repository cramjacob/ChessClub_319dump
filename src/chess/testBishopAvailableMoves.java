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

		Bishop testBishop = new Bishop(2, 4, Player.White, PieceType.Bishop); // second rank,
															// fourth file
		testBoard[testBishop.row][testBishop.col].isOccupied = true;
		testBoard[testBishop.row][testBishop.col].piece = testBishop;
		Tile[] legalMoves = testBishop.getAvailableMoves(testBoard);
		int[][] expectedMoves = new int[][] { { 0, 0, 0, 0, 0, 0, 1, 0 }, 
											  { 0, 0, 0, 0, 0, 1, 0, 0 },
											  { 1, 0, 0, 0, 1, 0, 0, 0 }, 
											  { 0, 1, 0, 1, 0, 0, 0, 0 }, 
											  { 0, 0, -1, 0, 0, 0, 0, 0},
											  { 0, 1, 0, 1, 0, 0, 0, 0 }, 
											  { 1, 0, 0, 0, 1, 0, 0, 0 }, 
											  { 0, 0, 0, 0, 0, 1, 0, 0 } };
		if (legalMoves.length != expectedMoves.length) {
			fail("legalMoves and expectedMoves arrays are not the same size");
		}
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

		Bishop testBishop = new Bishop(2, 4, Player.White, PieceType.Bishop); // second file,
															// fourth rank
		testBoard[testBishop.row][testBishop.col].isOccupied = true;
		testBoard[testBishop.row][testBishop.col].piece = testBishop;

		Pawn testPawn = new Pawn(5, 4, Player.White, PieceType.Pawn); // fifth file, fourth rank
		testBoard[testPawn.row][testPawn.col].isOccupied = true;
		testBoard[testPawn.row][testPawn.col].piece = testPawn;

		Tile[] legalMoves = testBishop.getAvailableMoves(testBoard);
		int[][] expectedMoves = new int[][] { { 0, 0, 0, 0, 0, 0, 1, 0 }, 
											  { 0, 0, 0, 0, 0, 1, 0, 0 },
											  { 1, 0, 0, 0, 1, 0, 0, 0 }, 
											  { 0, 1, 0, 1, 0, 0, 0, 0 }, 
											  { 0, 0, -1, 0, 0, 0, 0, 0},
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
		Bishop testBishop = new Bishop(4, 2, Player.White, PieceType.Bishop); // second file, fourth
														// rank
		testBoard[testBishop.row][testBishop.col].isOccupied = true;
		testBoard[testBishop.row][testBishop.col].piece = testBishop;

		// Create test pawn
		Pawn testPawn = new Pawn(5, 4, Player.White, PieceType.Pawn); // fifth file, fourth rank
		testBoard[testPawn.row][testPawn.col].isOccupied = true;
		testBoard[testPawn.row][testPawn.col].piece = testPawn;

		// Create test pawn
		Pawn testPawn2 = new Pawn(2, 4, Player.White, PieceType.Pawn); // second file,
															// second rank
		testBoard[testPawn2.row][testPawn2.col].isOccupied = true;
		testBoard[testPawn2.row][testPawn2.col].piece = testPawn2;

		// get legalMoves and create expectedMoves
		Tile[] legalMoves = testBishop.getAvailableMoves(testBoard);
		int[][] expectedMoves = new int[][] { { 0, 0, 1, 0, 0, 0, 1, 0 }, 
											  { 0, 0, 0, 1, 0, 1, 0, 0 },
											  { 0, 0, 0, 0, -1, 0, 0, 0}, 
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
				Bishop testBishop = new Bishop(j, i, Player.White, PieceType.Bishop);
				Tile t = new Tile(j, i, true, testBishop);
				testBoard[i][j] = t;
				System.out.println("y: " + testBishop.row + ", x: " + testBishop.col);
				Tile[] legalMoves = testBishop.getAvailableMoves(testBoard);
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
		int i = testBishop.row - 1;
		int j = testBishop.col - 1;
		while(i >= 0 && j >= 0){
			ret[i][j] = 1;
			i -= 1;
			j-= 1;
		}
		
		i = testBishop.row - 1;
		j = testBishop.col + 1;
		while(i >= 0 && j < 8){
			ret[i][j] = 1;
			i -= 1;
			j += 1;
		}
		
		i = testBishop.row + 1;
		j = testBishop.col - 1;
		while(i < 8 && j >= 0){
			ret[i][j] = 1;
			i += 1;
			j -= 1;
		}
		
		i = testBishop.row + 1;
		j = testBishop.col + 1;
		while(i < 8 && j < 8){
			ret[i][j] = 1;
			i += 1;
			j += 1;
		}
		
		ret[testBishop.row][testBishop.col] = -1;
		return ret;
	}
}
