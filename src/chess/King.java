package chess;

public class King extends Piece {

	public King(int row, int col, String color, PieceType identifier) {
		super(row, col, color, identifier);
	}

	@Override
	public Tile[] getAvailableMoves(int row, int col, Tile[][] board) {
		// TODO Auto-generated method stub
		int[][] legalMoves = new int[8][8];
		boolean flag = false;
		
		
		
		
		return null;
	}
}
