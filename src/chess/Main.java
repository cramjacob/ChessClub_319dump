package chess;

public class Main {
	public static void main(String[] args) {
//		classicalChessBoard classicalBoard = new classicalChessBoard();
//		chess960Board chess960Board = new chess960Board();
//		classicalBoard.printBoard();
//		System.out.print("------------------\n");
//		chess960Board.printBoard();
//		
		Tile[][] testBoard = new Tile[8][8];
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Tile t = new Tile(j, i, false, null);
				testBoard[i][j] = t;
			}
		}
		Rook testRook = new Rook(2, 4, "White", "R");
		testBoard[testRook.y][testRook.x].isOccupied = true;
		testBoard[testRook.y][testRook.x].piece = testRook;
		
		testRook.getAvailableMoves(testRook.x, testRook.y, testBoard);
		
		Pawn testPawn = new Pawn(5, 4, "White", "p");
		testBoard[testPawn.y][testPawn.x].isOccupied = true;
		testBoard[testPawn.y][testPawn.x].piece = testPawn;
		
		System.out.println("----------------");
		testRook.getAvailableMoves(testRook.x, testRook.y, testBoard);
		
		
		Bishop testBishop = new Bishop(2, 2, "White", "B");
		testBoard[testBishop.y][testBishop.x].isOccupied = true;
		testBoard[testBishop.y][testBishop.x].piece = testPawn;
		
		System.out.println("----------------");
		testRook.getAvailableMoves(testRook.x, testRook.y, testBoard);
	}
}
