package chess;

import java.util.ArrayList;

public class Knight extends Piece{
	
	public Knight(int row, int col, Player color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	@Override
	public Tile[] getAvailableMoves(Tile[][] board) {
		ArrayList<Tile> legalMoves = new ArrayList<Tile>();
		
		
		
		if(((this.row + 2) <= 7) && ((this.col + 1) <= 7) && ((board[this.col+1][this.row+2].isOccupied == false) || (board[this.col+1][this.row+2].piece.color != this.color))){
			legalMoves.add(board[this.col+1][this.row+2]);
		}
		if(((this.row + 2) <= 7) && ((this.col - 1) >= 0) && ((board[this.col-1][this.row+2].isOccupied == false) || (board[this.col-1][this.row+2].piece.color != this.color))){
			legalMoves.add(board[this.col-1][this.row+2]);
		}
		if(((this.row - 2) >= 0) && ((this.col + 1) <= 7) && ((board[this.col+1][this.row-2].isOccupied == false) || (board[this.col+1][this.row-2].piece.color != this.color))){
			legalMoves.add(board[this.col+1][this.row-2]);
		}
		if(((this.row - 2) >= 0) && ((this.col - 1) >= 0) && ((board[this.col-1][this.row-2].isOccupied == false) || (board[this.col-1][this.row-2].piece.color != this.color))){
			legalMoves.add(board[this.col-1][this.row-2]);
		}
		if(((this.col + 2) <= 7) && ((this.row + 1) <= 7) && ((board[this.col+2][this.row+1].isOccupied == false) || (board[this.col+2][this.row+1].piece.color != this.color))){
			legalMoves.add(board[this.col+2][this.row+1]);
		}
		if(((this.col + 2) <= 7) && ((this.row - 1) >= 0) && ((board[this.col+2][this.row-1].isOccupied == false) || (board[this.col+2][this.row-1].piece.color != this.color))){
			legalMoves.add(board[this.col+2][this.row-1]);
		}
		if(((this.col - 2) >= 0) && ((this.row + 1) <= 7) && ((board[this.col-2][this.row+1].isOccupied == false) || (board[this.col-2][this.row+1].piece.color != this.color))){
			legalMoves.add(board[this.col-2][this.row+1]);
		}
		if(((this.col - 2) >= 0) && ((this.row - 1) >= 0) && ((board[this.col-2][this.row-1].isOccupied == false) || (board[this.col-2][this.row-1].piece.color != this.color))){
			legalMoves.add(board[this.col-2][this.row-1]);
		}
		
		Tile[] temp = new Tile[legalMoves.size()];
		return legalMoves.toArray(temp);
	}
}
