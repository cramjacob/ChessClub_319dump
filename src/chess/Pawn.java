package chess;

public class Pawn extends Piece{
	
	protected boolean hasMoved = false;

	public Pawn(int row, int col, String color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	@Override
	public Tile[] getAvailableMoves(int row, int col, Tile[][] board) {
		// TODO Auto-generated method stub
		Tile[] available = new Tile[32];
		int i = 0;
		for (int bRow = 0; bRow < 8; bRow++) {
			for (int bCol = 0; bCol < 8; bCol++) {
				if ((bRow == row - 2 || bRow == row - 1) && bCol == col) {
					available[i] = board[bRow][bCol];
					i++;
				}
			}
		}
		return available;
	}
}
