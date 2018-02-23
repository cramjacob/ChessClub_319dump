package chess;

public class King extends Piece {

	public King(int row, int col, String color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	@Override
	public Tile[] getAvailableMoves(int row, int col, Tile[][] board) {
		// TODO Auto-generated method stub
		Tile[] available = new Tile[32];
		int i = 0;
		for (int bRow = 0; bRow < 8; bRow++) {
			for (int bCol = 0; bCol < 8; bCol++) {
				if ((bRow == row - 1 && bCol == col) || (bRow == row + 1 && bCol == col)
						|| (bRow == row && bCol == col - 1) || (bRow == row && bCol == col + 1)
						|| (bRow == row - 1 && bCol == col - 1) || (bRow == row + 1 && bCol == col + 1)
						|| (bRow == row - 1 && bCol == col + 1) || (bRow == row + 1 && bCol == col - 1)) {
							available[i] = board[bRow][bCol];
							i++;
				}
			}
		}

		return available;
	}
}
