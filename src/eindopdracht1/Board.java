package eindopdracht1;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@SuppressWarnings("serial")
class Board extends JFrame {


    private List<Card> cards;
    private Card selectedCard;
    private Card card1;
    private Card card2;
    private Timer tim;

    private void revealCard1() {
        try {
            Image revealCard1 = ImageIO.read(getClass().getResource("resources/card" + card1.getId() + ".jpg"));
            ImageIcon icon1 = new ImageIcon(revealCard1);
            card1.setIcon(icon1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void revealCard2() {
        try {
            Image revealCard2 = ImageIO.read(getClass().getResource("resources/card" + card2.getId() + ".jpg"));
            ImageIcon icon2 = new ImageIcon(revealCard2);
            card2.setIcon(icon2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Board() {

        int pairs = 9;
        List<Card> cardsList = new ArrayList<Card>();
        List<Integer> cardWaardes = new ArrayList<Integer>();

        for (int i = 1; i < pairs; i++) {
            cardWaardes.add(i);
            cardWaardes.add(i);
        }
        Collections.shuffle(cardWaardes);

        for (int waarde : cardWaardes){
            Card c = new Card();
            c.setId(waarde);

            c.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    selectedCard = c;
                    doTurn();
                }
            });
            cardsList.add(c);
        }
        this.cards = cardsList;
        //set up the timer
        tim = new Timer(750, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                checkCards();
            }
        });

        tim.setRepeats(false);

        //set up the board itself
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 4));
        for (Card c : cards) {
            pane.add(c);
        }
        setTitle("Memory Match");
    }

    private void doTurn() {
        if (card1 == null && card2 == null) {
            card1 = selectedCard;
            card1.setText(String.valueOf(card1.getId()));
            revealCard1();
        }

        if (card1 != null && card1 != selectedCard && card2 == null) {
            card2 = selectedCard;
            card2.setText(String.valueOf(card2.getId()));
            revealCard2();
            tim.start();
        }
    }

    private void checkCards() {
        if (card1.getId() == card2.getId()){//match condition
            card1.setEnabled(false); //disables the button
            card2.setEnabled(false);
            card1.setMatched(); //flags the button as having been matched
            card2.setMatched();
            if (this.isGameWon()) {
                JOptionPane.showMessageDialog(this, "U heeft gewonnen!");
                System.exit(0);
            }
        }

        else{
            card1.setText(""); //'hides' text
            card2.setText("");
            card1.setIcon(null);
            card2.setIcon(null);
        }
        card1 = null; //reset c1 and c2
        card2 = null;
    }

    private boolean isGameWon() {
        for(Card c: this.cards) {
            if (!c.getMatched()) {
                return false;
            }
        }
        return true;
    }

}