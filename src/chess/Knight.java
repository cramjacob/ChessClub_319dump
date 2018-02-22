package chess;

public class Knight extends Piece{
	
	public Knight(int row, int col, String color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	@Override
	public Tile[] getAvailableMoves(int row, int col, Tile[][] board) {
		int[][] legalMoves = new int[8][8];
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				legalMoves[i][j] = 0;
			}
		}
		
		legalMoves[row][col] = -1;
		
		if(((row + 2) <= 7) && ((col + 1) <= 7)){
			legalMoves[row+2][col+1] = 1;
		}
		if(((row + 2) <= 7) && ((col - 1) >= 0)){
			legalMoves[row+2][col-1] = 1;
		}
		if(((row - 2) >= 0) && ((col + 1) <= 7)){
			legalMoves[row-2][col+1] = 1;
		}
		if(((row - 2) >= 0) && ((col - 1) >= 0)){
			legalMoves[row-2][col-1] = 1;
		}
		if(((col + 2) <= 7) && ((row + 1) <= 7)){
			legalMoves[row+1][col+2] = 1;
		}
		if(((col + 2) <= 7) && ((row - 1) >= 0)){
			legalMoves[row-1][col+2] = 1;
		}
		if(((col - 2) >= 0) && ((row + 1) <= 7)){
			legalMoves[row+1][col-2] = 1;
		}
		if(((col - 2) >= 0) && ((row - 1) >= 0)){
			legalMoves[row-1][col-2] = 1;
		}
		return board[0];
	}
		
}
