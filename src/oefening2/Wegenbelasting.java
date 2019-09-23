package oefening2;

public class Wegenbelasting extends Auto {

    private int gewicht;

    private final int[][] tarieven = {
            {0,550,28},
            {550,650,37},
            {650,750,42}
    };

    public double getBelasting() {

        for(int t = 0 ; t < tarieven.length; t++){
            if(tarieven[t][0] < gewicht && tarieven[t][1] >= gewicht){
                return (double)tarieven[t][2];
            }
        }
        return 0;
    }

    public void setGewicht(int gewicht){
        this.gewicht = gewicht;
    }

}
