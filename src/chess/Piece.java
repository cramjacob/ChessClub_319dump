package chess;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Piece {
	protected int row;
	protected int col;
	protected String color;
	protected PieceType identifier;
	public BufferedImage img;

	public Piece(int row, int col, String color, PieceType identifier) {
		this.row = row;
		this.col = col;
		this.color = color;
		this.identifier = identifier;
		this.setImage(color, identifier);
	}
	
	void setImage(String color, PieceType identifier) {
		String url = "/Users/jacobcram/Documents/chess_club/assets/";
		url += identifier.name().toLowerCase() + "-" + color.toLowerCase() + ".png";
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(url));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		this.img = img;
	}

	
	public abstract Tile[] getAvailableMoves(int x, int y, Tile[][] board);
}
