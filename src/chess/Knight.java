package chess;

import java.util.ArrayList;

public class Knight extends Piece{
	
	public Knight(int row, int col, Player color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	@Override
	public Tile[] getAvailableMoves(int x, int y, Tile[][] board) {
		ArrayList<Tile> legalMoves = new ArrayList<Tile>;
		
		
		
		if(((y + 2) <= 7) && ((x + 1) <= 7) && ((board[x+1][y+2].isOccupied == false) || (board[x+1][y+2].piece.color != this.color))){
			legalMoves.add(board[x+1][y+2]);
		}
		if(((y + 2) <= 7) && ((x - 1) >= 0) && ((board[x-1][y+2].isOccupied == false) || (board[x-1][y+2].piece.color != this.color))){
			legalMoves.add(board[x-1][y+2]);
		}
		if(((y - 2) >= 0) && ((x + 1) <= 7) && ((board[x+1][y-2].isOccupied == false) || (board[x+1][y-2].piece.color != this.color))){
			legalMoves.add(board[x+1][y-2]);
		}
		if(((y - 2) >= 0) && ((x - 1) >= 0) && ((board[x-1][y-2].isOccupied == false) || (board[x-1][y-2].piece.color != this.color))){
			legalMoves.add(board[x-1][y-2]);
		}
		if(((x + 2) <= 7) && ((y + 1) <= 7) && ((board[x+2][y+1].isOccupied == false) || (board[x+2][y+1].piece.color != this.color))){
			legalMoves.add(board[x+2][y+1]);
		}
		if(((x + 2) <= 7) && ((y - 1) >= 0) && ((board[x+2][y-1].isOccupied == false) || (board[x+2][y-1].piece.color != this.color))){
			legalMoves.add(board[x+2][y-1]);
		}
		if(((x - 2) >= 0) && ((y + 1) <= 7) && ((board[x-2][y+1].isOccupied == false) || (board[x-2][y+1].piece.color != this.color))){
			legalMoves.add(board[x-2][y+1]);
		}
		if(((x - 2) >= 0) && ((y - 1) >= 0) && ((board[x-2][y-1].isOccupied == false) || (board[x-2][y-1].piece.color != this.color))){
			legalMoves.add(board[x-2][y-1]);
		}
		
		Tile[] temp = new Tile[legalMoves.size()];
		return legalMoves.toArray(temp);
	}
}
