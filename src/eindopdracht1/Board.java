package eindopdracht1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JFrame{

	private List<Card> cards;
	private Card selectedCard;
	private Card card1;
	private Card card2;
	private Timer t;
	
	public Board() {
		
		int pairs = 8;
		List<Card> cardsList = new ArrayList<Card>();
		List<Integer> cardValues = new ArrayList<Integer>();
		
		for (int i = 0; i < pairs; i++) {
			cardValues.add(i);
			cardValues.add(i);
		}
		Collections.shuffle(cardValues);
		
		for (int val : cardValues) {
			Card c = new Card();
			c.setId(val);
			c.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					selectedCard = c;
					doTurn();
				}
			});
			cardsList.add(c);
		}
		this.cards = cardsList;
		//timer
		t = new Timer(750, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				checkCards();
			}
		});
		
	}
	
}
