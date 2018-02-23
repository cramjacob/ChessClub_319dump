package chess;

public class Rook extends Piece {

	/*
	 * Generic constructor given by super
	 */
	public Rook(int row, int col, Player color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	/*
	 * Returns int array of 8x8 of 0's where there is no legal move and 1's where
	 * there is a legal move Puts a -1 in the spot where the piece is
	 */
	@Override
	public Tile[] getAvailableMoves(int row, int col, Tile[][] board) {
		int[][] legalMoves = new int[8][8];
		boolean flag = false; // this bool represents if we have ran into a piece yet or not

		// Initialize legalMoves to all 0's
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 8; k++) {
				legalMoves[j][k] = 0;
			}
		}

		legalMoves[row][col] = -1;

		// Check upwards on the file
		for (int i = row + 1; i < 8; i++) {
			if (board[i][col].isOccupied == false && !flag) {
				legalMoves[i][col] = 1;
			} else if (board[i][col].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[i][col] = 1;
				flag = true;
			} 
		}
		flag = false;

		// Check downwards on the file
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col].isOccupied == false && !flag) {
				legalMoves[i][col] = 1;
			} else if (board[i][col].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[i][col] = 1;
				flag = true;
			}
		}
		flag = false;

		// Check rightwards on the rank
		for (int i = col + 1; i < 8; i++) {
			if (board[row][i].isOccupied == false && !flag) {
				legalMoves[row][i] = 1;
			} else if (board[row][i].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[row][i] = 1;
				flag = true;
			}
		}
		flag = false;

		// Check leftwards on the rank
		for (int i = col - 1; i >= 0; i--) {
			if (board[row][i].isOccupied == false && !flag) {
				legalMoves[row][i] = 1;
			} else if (board[row][i].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[row][i] = 1;
				flag = true;
			} 
		}
		return board[0];
	}

}
