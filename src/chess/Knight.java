package chess;

public class Knight extends Piece{
	
	public Knight(int x, int y, String color, String identifier) {
		super(x, y, color, identifier);
	}

	@Override
	public int[][] getAvailableMoves(int x, int y, Tile[][] board) {
		int[][] legalMoves = new int[8][8];
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				legalMoves[i][j] = 0;
			}
		}
		
		legalMoves[y][x] = -1;
		
		if(((y + 2) <= 7) && ((x + 1) <= 7)){
			legalMoves[y+2][x+1] = 1;
		}
		if(((y + 2) <= 7) && ((x - 1) >= 0)){
			legalMoves[y+2][x-1] = 1;
		}
		if(((y - 2) >= 0) && ((x + 1) <= 7)){
			legalMoves[y-2][x+1] = 1;
		}
		if(((y - 2) >= 0) && ((x - 1) >= 0)){
			legalMoves[y-2][x-1] = 1;
		}
		if(((x + 2) <= 7) && ((y + 1) <= 7)){
			legalMoves[y+1][x+2] = 1;
		}
		if(((x + 2) <= 7) && ((y - 1) >= 0)){
			legalMoves[y-1][x+2] = 1;
		}
		if(((x - 2) >= 0) && ((y + 1) <= 7)){
			legalMoves[y+1][x-2] = 1;
		}
		if(((x - 2) >= 0) && ((y - 1) >= 0)){
			legalMoves[y-1][x-2] = 1;
		}
		return legalMoves;
	}
		
}
