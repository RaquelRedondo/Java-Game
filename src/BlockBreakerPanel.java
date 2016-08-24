import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

import javafx.scene.input.KeyCode;

public class BlockBreakerPanel extends JPanel implements KeyListener {
	
	ArrayList<Block> blocks = new ArrayList<Block>();
	Block base;
	
	Animation animation;
	Thread thread;
	
	BlockBreakerPanel(){
		
		base = new Block(170, 500, 70, 20, "rectangle.png");
		
		for (int i=0; i<8; i++){
			blocks.add(new Block((i*72+2), 0, 70, 20, "rectangle.png"));
			
			blocks.add(new Block((i*72+2), 20, 70, 20, "rectangle.png"));
			
			blocks.add(new Block((i*72+2), 40, 70, 20, "rectangle.png"));
			
			blocks.add(new Block((i*72+2), 60, 70, 20, "rectangle.png"));
		}
		
		//Need these two lines to listen to keys
		addKeyListener(this);
		setFocusable(true);
		
	}

	@Override
	public void paintComponent(Graphics g){
		//Erase screen and reprint
		super.paintComponent(g);
		for (Block b : blocks){
			b.draw(g, this);
		}
		
		base.draw(g,this);
	}
	
	public void update(){
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			animation = new Animation(this);
			
			//Start the animation Runnable
			thread = new Thread(animation);
			thread.start();
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			base.x -= 15;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			base.x += 15;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
