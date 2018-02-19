package chess;

import java.util.Arrays;

public class KnightTest {

	public static void main(String[] args) {
		Tile[][] testBoard = new Tile[8][8];
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Tile t = new Tile(j, i, false, null);
				testBoard[i][j] = t;
			}
		}
		
		Knight testKnight = new Knight(3, 3, "White", "K");
		int[][] legalMoves = testKnight.getAvailableMoves(3, 3, testBoard);
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				System.out.print(legalMoves[i][j] + " ");
			}
			System.out.println("");
		}

	}

}
