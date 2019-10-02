package eindopdracht1;

import java.awt.Dimension;
import javax.swing.JFrame;

public class MemoryGame{
	
	public static void main(String[] args) {
		Board game = new Board();
		game.setPreferredSize(new Dimension(500,500));
		game.setLocation(500,250);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.pack();
		game.setVisible(true);
	}
	
}
