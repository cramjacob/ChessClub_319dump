package chess;

import java.util.ArrayList;

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
	public Tile[] getAvailableMoves(Tile[][] board) {
		ArrayList<Tile> legalMoves = new ArrayList<Tile>();
		boolean flag = false;
		
		// Check to the right on rank
		for (int col = this.col; col < 8; col++) {
			if (!board[this.row][col].isOccupied && !flag) {
				legalMoves.add(board[this.row][col]);
			} else if (board[this.row][col].isOccupied && board[this.row][col].piece.color != this.color) {
				legalMoves.add(board[this.row][col]);
				flag = true;
			} else if (board[this.row][col].isOccupied && board[this.row][col].piece.color == this.color && col != this.col) {
				col = 8;
			}
		} flag = false;
		
		// Check to left on rank
		for (int col = this.col; col >= 0; col--) {
			if (!board[this.row][col].isOccupied && !flag) {
				legalMoves.add(board[this.row][col]);
			} else if (board[this.row][col].isOccupied && board[this.row][col].piece.color != this.color) {
				legalMoves.add(board[this.row][col]);
				flag = true;
			} else if (board[this.row][col].isOccupied && board[this.row][col].piece.color == this.color && col != this.col) {
				col = -1;
			}
		} flag = false;
		
		// Check above on file
		for (int row = this.row ; row >= 0; row--) {
			if (!board[row][this.col].isOccupied && !flag) {
				legalMoves.add(board[row][this.col]);
			} else if (board[row][this.col].isOccupied && board[row][this.col].piece.color != this.color) {
				legalMoves.add(board[row][this.col]);
				flag = true;
			} else if (board[row][this.col].isOccupied && board[row][this.col].piece.color == this.color && row != this.row) {
				row = -1;
			}
		} flag = false;
		
		// Check below on file
		for (int row = this.row; row < 8; row++) {
			if (!board[row][this.col].isOccupied && !flag) {
				legalMoves.add(board[row][this.col]);
			} else if (board[row][this.col].isOccupied && board[row][this.col].piece.color != this.color) {
				legalMoves.add(board[row][this.col]);
				flag = true;
			} else if (board[row][this.col].isOccupied && board[row][this.col].piece.color == this.color && row != this.row) {
				row = 8;
			}
		} flag = false;
		
		Tile[] ret = new Tile[legalMoves.size()];
		System.out.print("arraylist: " + legalMoves.size() + " ");
		System.out.print("array: " + ret.length + "\n");
		return legalMoves.toArray(ret);
	}

}
