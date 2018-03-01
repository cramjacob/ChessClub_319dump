package chess;

public class King extends Piece {

	public King(int row, int col, Player color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	@Override
	public Tile[] getAvailableMoves(Tile[][] board) {
		// TODO Auto-generated method stub
		Tile[] available = new Tile[32];
		int i = 0;
		for (int bRow = 0; bRow < 8; bRow++) {
			for (int bCol = 0; bCol < 8; bCol++) {
				if ((bRow == row - 1 && bCol == col) || (bRow == row + 1 && bCol == col)
						|| (bRow == row && bCol == col - 1) || (bRow == row && bCol == col + 1)
						|| (bRow == row - 1 && bCol == col - 1) || (bRow == row + 1 && bCol == col + 1)) {
					available[i] = board[bRow][bCol];
					i++;
				}
			}
		}
		// Castle Check (east)
		boolean valid = true;
		int side = 0;
		if(this.color == Player.White) {
			side = 7;
		}
		for(int j = 1; j < 3; j++) {
			if(board[side][j + 4].isOccupied || !this.hasMoved) {
				valid = false;
			}
		}
		if(board[side][7].isOccupied && board[side][7].piece.identifier == PieceType.Rook
				&& this.color == board[side][7].piece.color
				&& !board[side][7].piece.hasMoved && valid) {
			i++;
			available[i] = board[side][6];
		}
		// Castle Check (west)
		valid = true;
		side = 0;
		if(this.color == Player.White) {
			side = 7;
		}
		for(int j = 1; j < 4; j++) {
			if(board[side][4 - j].isOccupied || !this.hasMoved) {
				valid = false;
			}
		}
		if(board[side][0].isOccupied && board[side][0].piece.identifier == PieceType.Rook
				&& this.color == board[side][0].piece.color
				&& !board[side][0].piece.hasMoved && valid) {
			i++;
			available[i] = board[side][2];
		}
		
		return available;
	}
}
