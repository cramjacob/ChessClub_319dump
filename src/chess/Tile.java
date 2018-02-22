package chess;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Tile extends JPanel {
	public int row;
	public int col;
	public boolean isOccupied;
	public Piece piece;
	public String color;
	
	public Tile(int row, int col, boolean isOccupied, Piece piece) {
		this.row = row;
		this.col = col;
		this.isOccupied = isOccupied;
		this.piece = piece;
	}
}
