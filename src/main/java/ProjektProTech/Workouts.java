package ProjektProTech;

import java.util.ArrayList;

public class Workouts {
    private String datum;
    private String sportart;
    private String dauer;
    private String kalorien;

    public Workouts(String datum, String dauer, String kalorien, String sportart) {
        this.datum = datum;
        this.dauer = dauer;
        this.kalorien = kalorien;
        this.sportart = sportart;
    }

    public String toText(){
        return "Datum: " + datum + "\n" + "Sportart: " + sportart + "\n" + "Dauer: " + dauer + " Minuten\n" + "Kalorien verbraucht: " + kalorien + "\n\n";
    }

    public static ArrayList<Workouts> initMethode(){
        ArrayList<Workouts> liste = new ArrayList<>();

        liste.add (new Workouts("01/05/2024", "45", "520,00", "Laufen"));
        liste.add (new Workouts("10/09/2025", "60", "610,00", "Krafttraining"));
        liste.add (new Workouts("15/10/2025", "90", "780,00", "Radfahren"));

        return liste;
    }
}
