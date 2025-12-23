package ProjektProTech;

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

    public static String iniitMethode(){
        Workouts w1 = new Workouts("01/05/2024", "45", "520", "Laufen");
        Workouts w2 = new Workouts("10/09/2025", "60", "610", "Krafttraining");
        Workouts w3 = new Workouts("15/10/2025", "90", "780", "Radfahren");

        return w1.toText() + w2.toText() + w3.toText();
    }
}
