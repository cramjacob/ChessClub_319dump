package chess;

import java.util.ArrayList;

public class Pawn extends Piece {
	
	protected boolean hasMoved = false;

	public Pawn(int row, int col, String color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	@Override
	public Tile[] getAvailableMoves(int row, int col, Tile[][] board) {
		ArrayList<Tile> available = new ArrayList<Tile>();
		for (int bRow = 0; bRow < 8; bRow++) {
			for (int bCol = 0; bCol < 8; bCol++) {
				if (bCol == col) {
					// first move
					if (!hasMoved && (bRow == row - 2 || bRow == row + 2)) {
						available.add(board[bRow][bCol]);
					} else if (bRow == row - 1 || bRow == row + 1) {
						if (!board[bRow][bCol].isOccupied) {
							available.add(board[bRow][bCol]);
						}
					}
				} else if (bCol == col + 1 || bCol == col - 1) {
					if (bRow == row - 1 || bRow == row + 1) {
						if (board[bRow][bCol].isOccupied && this.isOpponent(board[bRow][bCol].piece.color)) {
							available.add(board[bRow][bCol]);
						}
					}
				}
			}
		}
		return available.toArray(new Tile[available.size()]);
	}

	@Override
	public void move(int row, int col) {
		this.row = row;
		this.col = col;
		this.hasMoved = true;
	}
}
