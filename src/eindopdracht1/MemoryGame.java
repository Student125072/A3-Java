package eindopdracht1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MemoryGame extends JFrame{
	
	public MemoryGame() {
		
		//window-naam
		super("Memory Game");
		
		//properties
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new MemoryGame();
				}
			
		});
	}
	
}
