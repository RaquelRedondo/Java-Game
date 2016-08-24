import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class BlockBreakerPanel extends JPanel implements KeyListener {
	
	ArrayList<Block> balls = new ArrayList<Block>();
	ArrayList<Block> blocks = new ArrayList<Block>();
	Block base;
	final int ballSize = 30;
	
	Animation animation;
	Thread thread;
	
	BlockBreakerPanel(){
		
		balls.add(new Block(250, 400, ballSize, ballSize, "ball.png"));
		base = new Block(240, 500, 70, 20, "rectangle.png");
		
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
		
		for (Block ball : balls){
			ball.draw(g, this);
		}
		
		base.draw(g,this);
	}
	
	public void update(){
		
		for (Block ball : balls){
			ball.x += ball.nX;
			ball.y += ball.nY;
			if (ball.x > getWidth() - ballSize || ball.x < 0){
				ball.nX *= -1;
			}
			if ( ball.intersects(base) || ball.y < 80) {
				ball.nY *= -1;
			}
		}
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
		
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT && base.x > 0){
			base.x -= 15;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && base.x < (getWidth()-base.getWidth())){
			base.x += 15;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
