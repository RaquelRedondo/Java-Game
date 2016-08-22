import java.awt.Panel;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args){
		JFrame frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BlockBreakerPanel panel = new BlockBreakerPanel();
		
		
		panel.setAlignmentX(Panel.CENTER_ALIGNMENT);
		frame.add(panel);
		frame.setVisible(true);
		
		frame.setSize(600, 520);
	}
	
}
