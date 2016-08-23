import java.awt.Panel;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args){
		JFrame frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BlockBreakerPanel panel = new BlockBreakerPanel();
		
		frame.add(panel);
		frame.setVisible(true);
		
		//Set frame size and not resizable
		frame.setSize(680, 520);
		frame.setResizable(false);
	}
	
}
