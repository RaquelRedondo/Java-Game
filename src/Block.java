import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Block extends Rectangle{

	Image image;
	
	int nX = 2;
	int nY = 2;
	boolean destroyed = false;
	
	Block (int coordX, int coordY, int w, int h, String s){
		
		x = coordX;
		y = coordY;
		width = w;
		height = h;
		
		image = Toolkit.getDefaultToolkit().getImage(s);
			
	}
	
	public void draw(Graphics g, Component c){
		if(!destroyed)
			g.drawImage(image, x, y, width, height, c);
	}
	
	
}
