package eindopdracht1;

import java.awt.*;
import javax.swing.*;

public class Game{

    public static void main(String[] args) {
        Board game = new Board();
        game.setPreferredSize(new Dimension(500,500));
        game.setLocation(500,250);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.pack();
        game.setVisible(true);
    }

}
