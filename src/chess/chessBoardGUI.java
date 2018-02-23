package chess;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class chessBoardGUI implements MouseListener {
	
	private final JFrame chessFrame;
	private JPanel chessPanel;
	private static Dimension boardDimensions = new Dimension(600,600);
    private final Color lightTileColor = Color.decode("#efd0a7");
    private final Color darkTileColor = Color.decode("#bf7007");
    private final Color testColor = Color.CYAN;
    private DrawCircle circle = new DrawCircle();
    private Board board;
    private String player;
    private Tile selected;
    
	public chessBoardGUI(Board board) {
		this.board = board;
		this.chessFrame = new JFrame("Chess");
		this.chessFrame.setSize(boardDimensions);
		
		final JMenuBar menuBar = new JMenuBar();
		populateMenuBar(menuBar);
		this.chessFrame.setJMenuBar(menuBar);
		
		setUpPanel();
		this.player = "White";
		
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
		Tile[] moves = this.selected.piece.getAvailableMoves(this.board.board);
	}
	
	private void showAvailableMoves(Tile tile) {
		Tile[] moves = tile.piece.getAvailableMoves(this.board.board);
		for (int i = 0; i < moves.length; i++) {
			if (moves[i] != null) {
				if (moves[i].getComponentCount() == 0) {
					moves[i].add(new JLabel(this.circle));
				} else {
					moves[i].remove(0);
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
		menuBar.add(createFileMenu());
		menuBar.add(createOptionsMenu());
		menuBar.add(createPlayerTurnMenu());
	}

	private JMenu createFileMenu() {
		return new JMenu("File");
	}
	
	private JMenu createOptionsMenu() {
		return new JMenu("Options");
	}
	
	private JMenu createPlayerTurnMenu() {
		return new JMenu("Player Turn");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Tile tile = (Tile) e.getComponent();
		if (this.selected == null) {
			if (tile.isOccupied && tile.piece.color == this.player) {
				this.selected = tile;
				tile.setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.GREEN));
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