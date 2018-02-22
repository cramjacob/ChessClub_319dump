package chess;

public class Pawn extends Piece{
	
	protected boolean hasMoved = false;

	public Pawn(int x, int y, String color, String identifier) {
		super(x, y, color, identifier);
	}

	@Override
	public int[][] getAvailableMoves(int x, int y, Tile[][] board) {
		int[][] legalMoves = new int[8][8];
		
		if(!hasMoved){
			legalMoves[y + 2][x] = 1;
			hasMoved = true;
		}
		else if(y < 8){
			legalMoves[y + 1][x] = 1;
		}
		
		return legalMoves;
	}
}
