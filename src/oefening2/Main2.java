package oefening2;

public class Main2 {

    public static void main(String[] args) {
        Auto auto = new Auto();

        //setters die overgenomen zijn van de vervoermiddel-class
        auto.setMerk("Mercedes");
        auto.setType("S350d");
        auto.setKleur("selenitgrau metallic");
        auto.setBrandstof("Diesel");
        auto.setGewicht(550);

        //setters van de auto-class
        System.out.println("Merk: " + auto.getMerk());
        System.out.println("Type: " + auto.getType());
        System.out.println("Kleur: " + auto.getKleur());
        System.out.println("Brandstoftype: " + auto.getBrandstof());
        System.out.println("De wegenbelasting bedraagt " + auto.getBelasting() + " euro per kwartaal.");
        System.out.println("Wegenbelasting per jaar: " + auto.getBelasting()*4);
    }

}
