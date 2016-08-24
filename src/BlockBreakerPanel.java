import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class BlockBreakerPanel extends JPanel {
	
	ArrayList<Block> blocks = new ArrayList<Block>();
	
	BlockBreakerPanel(){
		
		for (int i=0; i<8; i++){
			blocks.add(new Block((i*72+2), 0, 70, 20, "rectangle.png"));
			
			blocks.add(new Block((i*72+2), 20, 70, 20, "rectangle.png"));
			
			blocks.add(new Block((i*72+2), 40, 70, 20, "rectangle.png"));
			
			blocks.add(new Block((i*72+2), 60, 70, 20, "rectangle.png"));
		}
		
	}

	@Override
	public void paintComponent(Graphics g){
		for (Block b : blocks){
			b.draw(g, this);
		}
	}

}
