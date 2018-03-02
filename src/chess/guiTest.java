package chess;

public class guiTest {
	public static void main(String [] args) {
		classicalChessBoard board = new classicalChessBoard();
		chessBoardGUI gui = new chessBoardGUI(board);
	}
}