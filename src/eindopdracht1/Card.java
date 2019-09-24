package eindopdracht1;

import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Card extends JLabel implements MouseListener{
	
	Icon faceIcon;
	Icon backIcon;
	boolean faceUp = false;
	int num;
	int iconWidthHalf, iconHeightHalf;
	
	public Card(Icon face, Icon back, int num) {
		
		//geeft de window een naam
		super(back);
		
		this.faceIcon = face;
		this.backIcon = back;
		this.num = num;
		
		
		//clicks
		this.addMouseListener(this);
		this.iconWidthHalf = back.getIconWidth()/2;
		this.iconHeightHalf = back.getIconHeight()/2;
		
	}
	
}