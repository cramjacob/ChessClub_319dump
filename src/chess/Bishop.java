package chess;

public class Bishop extends Piece {

	public Bishop(int row, int col, Player color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	@Override
	public Tile[] getAvailableMoves(int x, int y, Tile[][] board) {
		int[][] legalMoves = new int[8][8];
		boolean flag = false; // this bool represents if we have ran into a
								// piece yet or not

		// Initialize legalMoves to all 0's
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 8; k++) {
				legalMoves[j][k] = 0;
			}
		}

		legalMoves[y][x] = -1;

		int i = y - 1;
		int j = x - 1;
		// Check up diagonal left on the file
		while (i >= 0 && j >= 0) {
			if (board[i][j].isOccupied == false && !flag) {
				legalMoves[i][j] = 1;
			} else if (board[i][j].isOccupied == true) { // if occupied, it
															// is a legal
															// move
															// (capture)
				legalMoves[i][j] = 1;
				flag = true;
			}
			flag = false;
			i -= 1;
			j -= 1;
		}

		i = y - 1;
		j = x + 1;
		// Check up diagonal right on the file
		while (i >= 0 && j < 8) {
			if (board[i][j].isOccupied == false && !flag) {
				legalMoves[i][j] = 1;
			} else if (board[i][j].isOccupied == true) { // if occupied, it
															// is a legal
															// move
															// (capture)
				legalMoves[i][j] = 1;
				flag = true;
			}
			flag = false;
			i -= 1;
			j += 1;
		}

		i = y + 1;
		j = x - 1;
		// Check down diagonal left on the file
		while (i < 8 && j >= 0) {
			if (board[i][j].isOccupied == false && !flag) {
				legalMoves[i][j] = 1;
			} else if (board[i][j].isOccupied == true) { // if occupied, it
															// is a legal
															// move
															// (capture)
				legalMoves[i][j] = 1;
				flag = true;
			}
			flag = false;
			i += 1;
			j -= 1;
		}

		i = y + 1;
		j = x + 1;
		// Check down diagonal right on the file
		while (i < 8 && j < 8) {
			if (board[i][j].isOccupied == false && !flag) {
				legalMoves[i][j] = 1;
			} else if (board[i][j].isOccupied == true) { // if occupied, it
															// is a legal
															// move
															// (capture)
				legalMoves[i][j] = 1;
				flag = true;
			}
			flag = false;
			i += 1;
			j += 1;
		}
		return board[0];
	}

}
