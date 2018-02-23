package chess;

public class Knight extends Piece{
	
	public Knight(int row, int col, String color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	public Tile[] getAvailableMoves(int x, int y, Tile[][] board) {
		Tile[][] legalMoves = new Tile[8][8];
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				legalMoves[i][j] = new Tile(j, i, false, null);
				legalMoves[i][j].color = "WHITE";
			}
		}
		
		legalMoves[y][x].color = "RED";
		
		if(((y + 2) <= 7) && ((x + 1) <= 7)){
			legalMoves[y+2][x+1].color = "RED";
		}
		if(((y + 2) <= 7) && ((x - 1) >= 0)){
			legalMoves[y+2][x-1].color = "RED";
		}
		if(((y - 2) >= 0) && ((x + 1) <= 7)){
			legalMoves[y-2][x+1].color = "RED";
		}
		if(((y - 2) >= 0) && ((x - 1) >= 0)){
			legalMoves[y-2][x-1].color = "RED";
		}
		if(((x + 2) <= 7) && ((y + 1) <= 7)){
			legalMoves[y+1][x+2].color = "RED";
		}
		if(((x + 2) <= 7) && ((y - 1) >= 0)){
			legalMoves[y-1][x+2].color = "RED";
		}
		if(((x - 2) >= 0) && ((y + 1) <= 7)){
			legalMoves[y+1][x-2].color = "RED";
		}
		if(((x - 2) >= 0) && ((y - 1) >= 0)){
			legalMoves[y-1][x-2].color = "RED";
		}
		return board[0];
	}
		
}
