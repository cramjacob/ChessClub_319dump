package chess;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class chessBoardGUI {
	
	private final JFrame chessFrame;
	private JPanel chessPanel;
	private ArrayList <Tile> boardTiles;
	private static Dimension boardDimensions = new Dimension(600,600); 
	private static Dimension panelDimensions = new Dimension(600,600); 
    //private final Color lightTileColor = Color.decode("#FFFACD");
    //private final Color darkTileColor = Color.decode("#593E1A");
    private final Color lightTileColor = Color.decode("#efd0a7");
    private final Color darkTileColor = Color.decode("#bf7007");
    

    
	public chessBoardGUI() {
		
		this.chessFrame = new JFrame("Chess");
		this.chessFrame.setSize(boardDimensions);
		
		final JMenuBar menuBar = new JMenuBar();
		populateMenuBar(menuBar);
		this.chessFrame.setJMenuBar(menuBar);
		
		setUpPanel();
		
		//this.chessPanel.setBackground(Color.BLACK);
		this.chessFrame.add(chessPanel);
		this.chessPanel.setVisible(true);
		this.chessFrame.setVisible(true);
		this.chessFrame.repaint();
		
		
	}

	private void setUpPanel() {

		chessPanel = new JPanel(new GridLayout(8,8));
		this.boardTiles =  new ArrayList<>();
		
		for(int i = 0; i < 64; i++) {
			Tile currTile = new Tile(10,10,false, null);
			this.boardTiles.add(currTile);

			if(i < 8 || (i <24 && i >= 16) ||(i < 40 && i >= 32) || (i < 56 && i >= 48)) {
				if(i%2 == 0) {
				
				 currTile.setBackground(lightTileColor);
				}
				else {
				 currTile.setBackground(darkTileColor);

				}
			}
			
			else{
				if(i%2 == 0) {
				
				 currTile.setBackground(darkTileColor);
				}
				else {
				 currTile.setBackground(lightTileColor);

				}
			}
			
			//currTile.setBackground(Color.BLACK);
			currTile.setVisible(true);
			this.chessPanel.add(currTile);
			
			
		}
		
	}

	private void populateMenuBar(JMenuBar menuBar) {
		menuBar.add(createFileMenu());
		menuBar.add(createOptionsMenu());
		menuBar.add(createPlayerTurnMenu());


	}

	private JMenu createFileMenu() {
		JMenu fileMenu = new JMenu("File");
		
		return fileMenu;
	}
	
	private JMenu createOptionsMenu() {
		JMenu fileMenu = new JMenu("Options");
		
		return fileMenu;
	}
	
	private JMenu createPlayerTurnMenu() {
		JMenu fileMenu = new JMenu("Player Turn");
		
		return fileMenu;
	}
	
	
	

}