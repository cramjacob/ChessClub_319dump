package chess;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

public class chessBoardGUI implements MouseListener {
	
	private final JFrame chessFrame;
	private JPanel chessPanel;
	private static Dimension boardDimensions = new Dimension(600,600);
    private final Color lightTileColor = Color.decode("#efd0a7");
    private final Color darkTileColor = Color.decode("#bf7007");
    private Border selectedBorder = BorderFactory.createBevelBorder(0, Color.green, Color.GREEN);
    private Border availableBorder = BorderFactory.createBevelBorder(0, Color.white, Color.white);
    private Board board;
    private Tile selected;
    private Player player;
    private Tile[] available;
    
    
	public chessBoardGUI(Board board) {
		this.board = board;
		this.chessFrame = new JFrame("Chess");
		this.chessFrame.setSize(boardDimensions);
		
		final JMenuBar menuBar = new JMenuBar();
		populateMenuBar(menuBar);
		this.chessFrame.setJMenuBar(menuBar);
		
		setUpPanel();
		
		this.player = Player.White;
		
		this.chessFrame.add(chessPanel);
		this.chessPanel.setVisible(true);
		this.chessFrame.setVisible(true);
		this.chessFrame.repaint();
	}

	private void setUpPanel() {
		this.chessPanel = new JPanel(new GridLayout(8,8));
		Tile[][] board = this.board.board;
		
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Tile currTile = board[row][col];
				currTile.addMouseListener(this);
				
				boolean dark = false;
				dark = col % 2 == 0;
				if (row % 2 == 0) dark = !dark;
				
				currTile.setBackground(dark ? darkTileColor : lightTileColor);
				setImage(currTile);
				currTile.setVisible(true);
				this.chessPanel.add(currTile);
			}
		}
	}
	
	private void tryMove(Tile tile) {
		if (tile.getBorder() == availableBorder) {
			this.selected.moveTo(tile);
			for (int i = 0; i < this.available.length; i++) {
				if (this.available[i] != null) {
					this.available[i].setBorder(null);
				}
			}
			this.available = new Tile[8];
			this.selected = null;
			this.player = this.player == Player.White ? Player.Black : Player.White;
		}
	}
	
	private void showAvailableMoves(Tile tile) {
		this.available = tile.piece.getAvailableMoves(tile.row, tile.col, this.board.board);
		for (int i = 0; i < this.available.length; i++) {
			if (this.available[i] != null) {
				if (this.available[i].getBorder() == null) {
					if (this.available[i].piece != null) {
						System.out.println("x: " + this.available[i].row + ", col: " + this.available[i].col);
					}
					this.available[i].setBorder(this.availableBorder);
				} else {
					this.available[i].setBorder(null);
				}
			}
		}
	}
	
	private void setImage(Tile tile) {
		if (tile.isOccupied) {
			Image dimg = tile.piece.img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(dimg);
			tile.add(new JLabel(imageIcon));
		} else {
			tile.removeAll();
		}
	}

	private void populateMenuBar(JMenuBar menuBar) {
		menuBar.add(new JMenu("File"));
		menuBar.add(new JMenu("Options"));
		menuBar.add(new JMenu("Player Turn"));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Tile tile = (Tile) e.getComponent();
		if (this.selected == null) {
			if (tile.isOccupied && tile.piece.color == this.player) {
				this.selected = tile;
				tile.setBorder(selectedBorder);
				showAvailableMoves(tile);
			}
		} else if (this.selected == tile) {
			this.selected = null;
			tile.setBorder(null);
			showAvailableMoves(tile);
		} else {
			tryMove(tile);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}