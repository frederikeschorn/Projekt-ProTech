package ProjektProTech;

import java.util.ArrayList;

public class Workouts {

    private String datum;
    private String sportart;
    private int dauer;
    private double kalorien;

    public Workouts(String datum, int dauer, double kalorien, String sportart) {

        this.datum = datum;
        this.dauer = dauer;
        this.kalorien = kalorien;
        this.sportart = sportart;
    }

    public String toText(){
        return "Datum: " + datum + "\n" + "Sportart: " + sportart + "\n" + "Dauer: " + dauer + " Minuten\n" + "Kalorien verbraucht: " + kalorien + "\n\n";
    }


}
