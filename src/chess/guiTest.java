package chess;

public class guiTest {
	public static void main(String [] args) {
		classicalChessBoard board = new classicalChessBoard();
		//board.emptyBoard();
		//board.placeTile(new Tile(2, 1, true, new Rook(2, 1, "White", PieceType.Rook)));
		chessBoardGUI gui = new chessBoardGUI(board);
	}
}