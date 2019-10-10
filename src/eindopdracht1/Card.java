 package eindopdracht1;

 import javax.swing.*;

 @SuppressWarnings("serial")
 class Card extends JButton {

     private int id;
     private boolean matched = false;

     void setId(int id) {
         this.id = id;
     }

     int getId() {
         return this.id;
     }

     void setMatched() {
         this.matched = true;
     }

     boolean getMatched() {
         return this.matched;
     }

 }