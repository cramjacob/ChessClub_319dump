package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class testKnightAvailableMoves {

	@Test
	public void testKnightMoves() {
		Tile[][] testBoard = new Tile[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Tile t = new Tile(j, i, false, null);
				testBoard[i][j] = t;
			}
		}
		// Checking corner
		Tile[][] test1;
		Knight k1 = new Knight(7, 7, "WHITE", "N");
		test1 = k1.getAvailableMoves(7, 7, testBoard);
		assertEquals(test1[5][6].color, "RED");
		assertEquals(test1[6][5].color, "RED");
		if (test1[0][0].color == "RED") {
			fail("Too many red squares");
		}
		// Checking half corner
		Tile[][] test2;
		Knight k2 = new Knight(1, 1, "WHITE", "N");
		test2 = k2.getAvailableMoves(1, 1, testBoard);
		assertEquals(test2[0][3].color, "RED");
		assertEquals(test2[2][3].color, "RED");
		assertEquals(test2[3][2].color, "RED");
		assertEquals(test2[3][0].color, "RED");
		if (test2[0][0].color == "RED") {
			fail("Too many red squares");
		}
		//Checking 1/4 corner
		Tile[][] test3;
		Knight k3 = new Knight(1, 4, "WHITE", "N");
		test3 = k3.getAvailableMoves(1, 4, testBoard);
		assertEquals(test3[2][0].color, "RED");
		assertEquals(test3[2][2].color, "RED");
		assertEquals(test3[3][3].color, "RED");
		assertEquals(test3[5][3].color, "RED");
		assertEquals(test3[6][2].color, "RED");
		assertEquals(test3[6][0].color, "RED");
		if (test3[0][0].color == "RED") {
			fail("Too many red squares");
		}
		//Checking open area
		Tile[][] test4;
		Knight k4 = new Knight(4, 4, "WHITE", "N");
		test4 = k4.getAvailableMoves(4, 4, testBoard);
		assertEquals(test4[3][2].color, "RED");
		assertEquals(test4[2][3].color, "RED");
		assertEquals(test4[2][5].color, "RED");
		assertEquals(test4[3][6].color, "RED");
		assertEquals(test4[5][6].color, "RED");
		assertEquals(test4[6][5].color, "RED");
		assertEquals(test4[6][3].color, "RED");
		assertEquals(test4[5][2].color, "RED");
		if (test4[0][0].color == "RED") {
			fail("Too many red squares");
		}
	}

}
