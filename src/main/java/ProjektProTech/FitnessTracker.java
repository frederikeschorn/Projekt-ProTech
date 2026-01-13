package ProjektProTech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Klassenkopf - Klasse erbt alle Funktionen von JFrame
public class FitnessTracker extends JFrame {

    //Attribute (GUI-Komponenten)
    private JPanel mainPanel;
    private JLabel datum_label;
    private JLabel gewicht_label;
    private JTextField gewicht_textField1;
    private JLabel sportart_label;
    private JComboBox sportart_comboBox1;
    private JLabel dauerMin_label;
    private JTextField dauerMin_textField1;
    private JLabel kalorien_label;
    private JLabel ausgabeKalorien_label;
    private JButton berechnen_button1;
    private JButton speichern_button1;
    private JTextArea workoutListe_textArea1;
    private JLabel workoutListe_label;
    private JTextField name_textField1;
    private JComboBox monat_comboBox2;
    private JComboBox jahr_comboBox3;
    private JComboBox tage_comboBox1;
    private JButton kalorienSumme_button1;
    private JLabel kalorienSumme_label;

    //Klassenvariable
    private double kalorienSumme = 520 + 610 + 780;
    static ArrayList<Workouts> liste = new ArrayList<>();//außerhalb einer Methode, da es so für die ganze Klasse gilt

    //Konstruktor und Fenster konfigurieren
    public FitnessTracker() {
        setTitle("FitnessTracker");
        setSize(1000, 500);
        mainPanel.setBackground(Color.lightGray);
        setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);

// Workouts werden beim Start angezeigt
        for (Workouts w : initMethode()) {
            workoutListe_textArea1.append(w.toText());
        }


// Button erstellen
        berechnen_button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kalorienBerechnen();
            }
        });
        speichern_button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inListeSpeichern();
                clearTextfeld();
            }
        });
        kalorienSumme_button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kalorienSumme();
            }
        });
    }

    //Eingabe lesen und prüfen - leere Eingabe abfangen, dann Fehlermeldung
    public void kalorienBerechnen() {
        String gewichtText = gewicht_textField1.getText().trim(); //Trim= Leerzeichen werden am Anfang und Ende entfernt
        String dauerText = dauerMin_textField1.getText().trim();

        if (gewichtText.isEmpty()) {
            gewicht_textField1.setText("");
            JOptionPane.showMessageDialog(null, "Bitte Gewicht eingeben.", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (dauerText.isEmpty()) {
            dauerMin_textField1.setText("");
            JOptionPane.showMessageDialog(null, "Bitte Dauer in Minuten eingeben.", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
            return;
        }


        //Komma statt Punkt erlauben
        try {
            gewichtText = gewichtText.replace(",", ".");

            //Kalorien berechnen

            double gewicht = Double.parseDouble(gewichtText);//double, weil nicht nur ganze Zahlen
            int dauerMin = Integer.parseInt(dauerText); //int, weil nur ganze Zahlen

            sportart_comboBox1.getSelectedItem();
            String sportart = sportart_comboBox1.getSelectedItem().toString(); //DropDown wird jedes Mal neu gelesen

            double kalorien;

            if ("Fußball".equals(sportart)) {
                kalorien = 7.0 * gewicht * (dauerMin / 60.0); //kalorien = MET * Körpergewicht * Dauer in Stunden

            } else if ("Gehen".equals(sportart)) {
                kalorien = 3.5 * gewicht * (dauerMin / 60.0);

            } else if ("Krafttraining".equals(sportart)) {
                kalorien = 8.0 * gewicht * (dauerMin / 60.0);

            } else if ("Laufen".equals(sportart)) {
                kalorien = 10.0 * gewicht * (dauerMin / 60.0);

            } else if ("Radfahren".equals(sportart)) {
                kalorien = 8.0 * gewicht * (dauerMin / 60.0);

            } else if ("Schwimmen".equals(sportart)) {
                kalorien = 5.8 * gewicht * (dauerMin / 60.0);

            } else if ("Skifahren".equals(sportart)) {
                kalorien = 5.0 * gewicht * (dauerMin / 60.0);

            } else if ("Tennis".equals(sportart)) {
                kalorien = 7.0 * gewicht * (dauerMin / 60.0);

            } else if ("Wandern".equals(sportart)) {
                kalorien = 6.0 * gewicht * (dauerMin / 60.0);

            } else if ("Yoga".equals(sportart)) {
                kalorien = 2.5 * gewicht * (dauerMin / 60.0);

            } else {
                JOptionPane.showMessageDialog(null, "Bitte Sportart auswählen.", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
                return;

            }
            ausgabeKalorien_label.setText(String.format("%.2f", kalorien)); //Ausgabe und runden auf zwei Nachkommastellen


        } catch (NumberFormatException e) {
            ausgabeKalorien_label.setText("");
            JOptionPane.showMessageDialog(null, "Bitte Gewicht (z.B. 71,5) und Dauer (z.B. 120) als Zahl eingeben.");
        }
    }


    //Workouts in TextArea speichern
    public void inListeSpeichern() {

        String gewicht = gewicht_textField1.getText().trim();
        String dauer = dauerMin_textField1.getText().trim();
        String name = name_textField1.getText().trim();

        //Prüfen ob bei Name, Gewicht, Dauer und Sportart etwas eingegeben wurde -> wenn nicht, dann Fehlerfenster
        if (name.isEmpty() || gewicht.isEmpty() || dauer.isEmpty() || sportart_comboBox1.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Bitte Gewicht, Dauer, Name und Sportart eingeben. \nSind diese ausgefüllt, bitte betätige den 'Berechnen-Button'.");
            return;
        }

        //Name wird angezeigt ohne alles zulöschen
        workoutListe_textArea1.append("Workout von: " + name + "\n");


        //Name prüfen
        if (name.isEmpty()) {
            name_textField1.setText("");
            JOptionPane.showMessageDialog(null, "Bitte Name eingeben.", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
            return;
        }


        //Datum auslesen
        String tag = tage_comboBox1.getSelectedItem().toString();
        String monat = monat_comboBox2.getSelectedItem().toString();
        String jahr = jahr_comboBox3.getSelectedItem().toString();
        String sportart = sportart_comboBox1.getSelectedItem().toString();
        String kalorien = ausgabeKalorien_label.getText();

        liste.add(new Workouts("01/05/2024", 45, 520.00, "Laufen"));
        workoutListe_textArea1.setText(workoutListe_textArea1.getText() + "Datum: " + tag + "/" + monat + "/" + jahr + "\n" + "Sportart: " + sportart + "\n" + "Dauer: " + dauer + " Minuten\n" + "Kalorien verbraucht: " + kalorien + "\n" + "\n");

        double kcal = Double.parseDouble(kalorien.replace(",", ".")); //Java erwartet Punkt bei Kalorien und nicht Komma - deshalb ändern
        kalorienSumme = kalorienSumme + kcal;
    }


    //Eingabefelder Dauer und Gewicht löschen nach betätigen des Speichern Button
    public void clearTextfeld() {
        dauerMin_textField1.setText("");
        gewicht_textField1.setText("");
    }

    //Alle Kalorien werden addiert und ausgegeben
    public double kalorienSumme() {
        kalorienSumme_label.setText(
                String.format("Gesamtkalorien: %.2f", kalorienSumme)); //auf zwei Nachkommastellen runden
        return kalorienSumme;
    }

    //main-Methode - Startpunkt des Programms
    public static void main(String[] args) {
        FitnessTracker ft = new FitnessTracker();
    }

    public static ArrayList<Workouts> initMethode() {


        liste.add(new Workouts("01/05/2024", 45, 520.00, "Laufen"));
        liste.add(new Workouts("10/09/2025", 60, 610.00, "Krafttraining"));
        liste.add(new Workouts("15/10/2025", 90, 780.00, "Radfahren"));

        return liste;
    }
}
