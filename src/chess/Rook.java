package chess;

public class Rook extends Piece {

	/*
	 * Generic constructor given by super
	 */
	public Rook(int x, int y, String color, String identifier) {
		super(x, y, color, identifier);
	}

	/*
	 * Returns int array of 8x8 of 0's where there is no legal move and 1's where
	 * there is a legal move Puts a -1 in the spot where the piece is
	 */
	@Override
	public int[][] getAvailableMoves(int x, int y, Tile[][] board) {
		int[][] legalMoves = new int[8][8];
		boolean flag = false; // this bool represents if we have ran into a piece yet or not

		// Initialize legalMoves to all 0's
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 8; k++) {
				legalMoves[j][k] = 0;
			}
		}

		legalMoves[y][x] = -1;

		// Check upwards on the file
		for (int i = y + 1; i < 8; i++) {
			if (board[i][x].isOccupied == false && !flag) {
				legalMoves[i][x] = 1;
			} else if (board[i][x].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[i][x] = 1;
				flag = true;
			} 
		}
		flag = false;

		// Check downwards on the file
		for (int i = y - 1; i >= 0; i--) {
			if (board[i][x].isOccupied == false && !flag) {
				legalMoves[i][x] = 1;
			} else if (board[i][x].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[i][x] = 1;
				flag = true;
			}
		}
		flag = false;

		// Check rightwards on the rank
		for (int i = x + 1; i < 8; i++) {
			if (board[y][i].isOccupied == false && !flag) {
				legalMoves[y][i] = 1;
			} else if (board[y][i].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[y][i] = 1;
				flag = true;
			}
		}
		flag = false;

		// Check leftwards on the rank
		for (int i = x - 1; i >= 0; i--) {
			if (board[y][i].isOccupied == false && !flag) {
				legalMoves[y][i] = 1;
			} else if (board[y][i].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[y][i] = 1;
				flag = true;
			} 
		}

		return legalMoves;
	}

}
