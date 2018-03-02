package chess;

public class Player {
	private Tile[] remainingPieces;
	private Tile[] capturedPieces;
	private Color color;
	private short score;
	
	
	public Player (Color color) {
		this.color = color;
	}
	
	
	public Tile[] getRemainingPieces() {
		return this.remainingPieces;
	}
	
	public Tile[] getCapturedPieces() {
		return this.capturedPieces;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public short getScore() {
		return this.score;
	}
}
