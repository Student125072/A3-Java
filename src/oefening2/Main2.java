package oefening2;

public class Main2 {

    public static void main(String[] args) {
        Auto auto = new Auto();

        //setters die overgenomen zijn van de vervoermiddel-class
        auto.setMerk("Mercedes");
        auto.setType("S350d");
        auto.setKleur("selenitgrau metallic");
        auto.setBrandstof("Diesel");

        //setters van de auto-class
        auto.setGewicht(550);
        System.out.println("De wegenbelasting bedraagt: " + auto.getBelasting() + " euro per maand.");
    }

}
