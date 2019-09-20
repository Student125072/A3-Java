package oefening2;

public class Auto extends Vervoermiddel {

    private double belasting;
    private String brandstof;

    public void setBrandstof(String brandstof) { this.brandstof = brandstof; }

    public void bepaalBelasting(int gewicht) {


        if (gewicht <= 550) {
            this.belasting = 28;
        }
        if (gewicht > 550 && gewicht <= 650) {
            this.belasting = 37;
        }
        if (gewicht > 650 && gewicht <= 750) {
            this.belasting = 45;
        }

    }

    public double getBelasting() { return belasting; }
    public String getBrandstof() { return brandstof; }


}
