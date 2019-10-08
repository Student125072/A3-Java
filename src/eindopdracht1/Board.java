package eindopdracht1;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
		
		t.setRepeats(false);
		
		//de board setup
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(4,4));
		for (Card c : cards) {
			pane.add(c);
		}
		setTitle("Memory Game - Eindopdracht 1");
	}
	
	
	//de turn handler van de kaarten
		public void doTurn() {
			if (card1 == null && card2 == null) {
				card1 = selectedCard;
				card1.setText(String.valueOf(card1.getId()));
			}
			
			if (card1 != null && card2 != null) {
				card2 = selectedCard;
				card2.setText(String.valueOf(card2.getId()));
				t.start();
			}
		}
		
		
		public void checkCards() {
			if (card1.getId() == card2.getId()) {
				card1.setEnabled(false);
				card2.setEnabled(false);
				card1.setMatched(true);
				card2.setMatched(true);
				if (this.isGameWon()) {
					JOptionPane.showMessageDialog(this, "You win!");
					System.exit(0);
				}
			}
			
			else {
				//laat de kaarten verdwijnen
				card1.setText("");
				card2.setText("");
			}
			//reset de kaarten
			card1 = null;
			card2 = null;
		}
		
		public boolean isGameWon() {
			for (Card c : this.cards) {
				if (c.getMatched() == false) {
					return false;
				}
			}
			return true;
		}
		
	
	
}
