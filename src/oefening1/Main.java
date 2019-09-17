package oefening1;

public class Main {

    public static void main(String[] args) {
        Persoon persoon = new Persoon();

        //aanroepen van de setters
        persoon.setVoornaam("Kevin");
        persoon.setAchternaam("Koster");
        persoon.setGeboortedatum("07-10-2001");

        System.out.println(persoon.getVoornaam());
        System.out.println(persoon.getAchternaam());
        System.out.println(persoon.getGeboortedatum());
        System.out.println("Deze persoon is" + aantalDagen() + "dagen oud.");
    }

}
