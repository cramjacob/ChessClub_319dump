package chess;

public class Knight extends Piece{
	
	public Knight(int row, int col, Player color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	public Tile[] getAvailableMoves(Tile[][] board) {
		Tile[][] legalMoves = new Tile[8][8];
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				legalMoves[i][j] = new Tile(j, i, false, null);
				legalMoves[i][j].color = "WHITE";
			}
		}
		
		legalMoves[this.row][this.col].color = "RED";
		
		if(((this.row + 2) <= 7) && ((this.col + 1) <= 7)){
			legalMoves[this.row+2][this.col+1].color = "RED";
		}
		if(((this.row + 2) <= 7) && ((this.col - 1) >= 0)){
			legalMoves[this.row+2][this.col-1].color = "RED";
		}
		if(((this.row - 2) >= 0) && ((this.col + 1) <= 7)){
			legalMoves[this.row-2][this.col+1].color = "RED";
		}
		if(((this.row - 2) >= 0) && ((this.col - 1) >= 0)){
			legalMoves[this.row-2][this.col-1].color = "RED";
		}
		if(((this.col + 2) <= 7) && ((this.row + 1) <= 7)){
			legalMoves[this.row+1][this.col+2].color = "RED";
		}
		if(((this.col + 2) <= 7) && ((this.row - 1) >= 0)){
			legalMoves[this.row-1][this.col+2].color = "RED";
		}
		if(((this.col - 2) >= 0) && ((this.row + 1) <= 7)){
			legalMoves[this.row+1][this.col-2].color = "RED";
		}
		if(((this.col - 2) >= 0) && ((this.row - 1) >= 0)){
			legalMoves[this.row-1][this.col-2].color = "RED";
		}
		return board[0];
	}	
}
