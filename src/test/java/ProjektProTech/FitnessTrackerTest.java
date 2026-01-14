package ProjektProTech;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FitnessTrackerTest {

    @Test
    void kalorienBerechnenLaufentest() {
        FitnessTracker ft = new FitnessTracker();

        //Eingabefelder setzten
        ft.gewicht_textField1.setText("70");
        ft.dauerMin_textField1.setText("60");
        ft.sportart_comboBox1.setSelectedItem("Laufen");

        //Methode ausführen
        ft.kalorienBerechnen();

        //Ergebnis auslesen
        String ergebnis = ft.ausgabeKalorien_label.getText();
        double kalorien = Double.parseDouble(ergebnis.replace(",", "."));

        //Erwartetes Ergebnis prüfen
        assertEquals(700.0, kalorien);
    }

}

