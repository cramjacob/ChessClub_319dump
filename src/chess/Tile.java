package chess;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile extends JPanel {
	public int row;
	public int col;
	public boolean isOccupied;
	public Piece piece;
	
	public Tile(int row, int col, boolean isOccupied, Piece piece) {
		this.row = row;
		this.col = col;
		this.isOccupied = isOccupied;
		this.piece = piece;
	}
	
	public void moveTo(Tile moveTo) {
		if (moveTo.isOccupied) {
			if (!this.piece.canAttack(moveTo.piece)) return;
		}
		// this is tile you are moving, tile is
		this.piece.move(moveTo.row, moveTo.col);
		moveTo.removeAll();
		moveTo.isOccupied = true;
		moveTo.piece = this.piece;
		this.removePiece();
		Image dimg = moveTo.piece.img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		moveTo.add(new JLabel(imageIcon));
	}

	public void removePiece() {
		this.piece = null;
		this.isOccupied = false;
		this.removeAll();
		this.setBorder(null);
	}
}
