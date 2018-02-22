package chess;

abstract public class Board {
	protected Tile[][] board = new Tile[8][8];
	
	public Board() {
		this.initBoard();
	}
	
	abstract public void initBoard();
	
	public void printBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].isOccupied) {
					if (j == 0) {
						System.out.print("|");
					}
					System.out.print(board[i][j].piece.identifier + "|");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}
}
