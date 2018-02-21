package chess;

public class Queen extends Piece {

	public Queen(int x, int y, String color, String identifier) {
		super(x, y, color, identifier);
	}

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
		
		// Check left up on the rank
		for (int i = x - 1, j = y + 1; i >= 0 || j < 8; i--, j++) {
			if (board[j][i].isOccupied == false && !flag) {
				legalMoves[j][i] = 1;
			} else if (board[j][i].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[j][i] = 1;
				flag = true;
			} 
		}
		
		// Check left down on the rank
		for (int i = x - 1, j = y - 1; i >= 0 || j >= 0; i--, j--) {
			if (board[j][i].isOccupied == false && !flag) {
				legalMoves[j][i] = 1;
			} else if (board[j][i].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[j][i] = 1;
				flag = true;
			} 
		}
		
		// Check right up on the rank
		for (int i = x + 1, j = y + 1; i < 8 || j < 8; i++, j++) {
			if (board[j][i].isOccupied == false && !flag) {
				legalMoves[j][i] = 1;
			} else if (board[j][i].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[j][i] = 1;
				flag = true;
			} 
		}
		
		// Check right down on the rank
		for (int i = x + 1, j = y - 1; i < 8 || j >= 0; i++, j--) {
			if (board[j][i].isOccupied == false && !flag) {
				legalMoves[j][i] = 1;
			} else if (board[j][i].isOccupied == true) { // if occupied, it is a legal move (capture) 
				legalMoves[j][i] = 1;
				flag = true;
			} 
		}
		
		return legalMoves;
	}
}
