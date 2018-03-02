package chess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawCircle extends ImageIcon {
	
	public DrawCircle() {
		this.setImage(setImage());
	}

	// paint is called automatically when program begins, when window is
	// refreshed and when repaint() is invoked
	public Image setImage() {
		String url =  "/Users/jacobcram/Documents/chess_club/assets/";
		url += "grey-circle.png";
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(url));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		return dimg;
	}
}