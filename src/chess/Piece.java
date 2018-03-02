package chess;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Piece {
	protected int row;
	protected int col;
	protected Player color;
	protected PieceType identifier;
	protected boolean captured;
	public BufferedImage img;

	public Piece(int row, int col, Player color, PieceType identifier) {
		this.row = row;
		this.col = col;
		this.color = color;
		this.identifier = identifier;
		this.setImage(color, identifier);
	}
	
	public boolean canAttack(Piece toAttack) {
		if (toAttack.color == this.color) return false;
		return true;
	}
	
	public void move(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	void setImage(Player color, PieceType identifier) {
		String url = "/Users/leximarie/Desktop/319/B6/assets/";
		url += identifier.name().toLowerCase() + "-" + color.name().toLowerCase() + ".png";
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(url));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		this.img = img;
	}
	
	public boolean isOpponent(Player opp) {
		return this.color != opp && (opp == Player.White || opp == Player.Black);
	}
	
	public boolean isValid(Board board, int fromRow, int fromCol, int toRow, int toCol) {
		if (fromRow == toRow && fromCol == toCol) return false;
		if (toRow > 7 || toRow < 0 || toCol > 7 || toCol < 0) return false;
		return true;
	}

	public abstract Tile[] getAvailableMoves(Tile[][] board);
}
