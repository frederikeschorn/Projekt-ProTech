package ProjektProTech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FitnessTracker extends JFrame{
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


    public FitnessTracker(){
        setTitle("FitnessTracker");
        setSize(500, 500);
        setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);

        workoutListe_textArea1.setText(Workouts.iniitMethode());


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
    }

    public void kalorienBerechnen(){
        String gewichtText = gewicht_textField1.getText().trim(); //Trim= Leerzeichen werden am Anfang und Ende entfernt
        String dauerText   = dauerMin_textField1.getText().trim();

        if (gewichtText.isEmpty() ){
            gewicht_textField1.setText("");
            JOptionPane.showMessageDialog(null, "Bitte gebe dein Gewicht ein.", "Eingabefehler",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (dauerText.isEmpty() ){
            dauerMin_textField1.setText("");
            JOptionPane.showMessageDialog(null, "Bitte gebe die Dauer in Minuten ein.", "Eingabefehler",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (dauerText.contains(",")) {
            ausgabeKalorien_label.setText("");//alter Wert wird gelöscht und es steht nichts mehr in dem Feld
            JOptionPane.showMessageDialog(null, "Bitte bei Dauer in Minuten nur ganze Zahlen (ohne Komma) eingeben.", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
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

            } else {
                kalorien = 2.5 * gewicht * (dauerMin / 60.0);

            }
            ausgabeKalorien_label.setText(String.format("%.2f", kalorien)); //Ausgabe und runden auf zwei Nachkommastellen

        }catch(NumberFormatException g){
            ausgabeKalorien_label.setText("");
            JOptionPane.showMessageDialog(null, "Bitte beim Gewicht nur Zahlen eingeben.", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
            return; //wiso brauche ich hier kein return??
        }

    }

    public void inListeSpeichern(){
        String name = name_textField1.getText().trim();

        if (name.isEmpty()){
            name_textField1.setText("");
            JOptionPane.showMessageDialog(null, "Bitte gebe dein Name ein.", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String tag = tage_comboBox1.getSelectedItem().toString();
        String monat = monat_comboBox2.getSelectedItem().toString();
        String jahr = jahr_comboBox3.getSelectedItem().toString();
        String sportart = sportart_comboBox1.getSelectedItem().toString();
        String dauer = dauerMin_textField1.getText();
        String kalorien = ausgabeKalorien_label.getText();

        workoutListe_textArea1.setText(workoutListe_textArea1.getText() + "Datum: " + tag + "/" + monat + "/" + jahr + "\n" + "Sportart: " + sportart + "\n" + "Dauer: " + dauer + " Minuten\n" + "Kalorien verbraucht: " + kalorien + "\n" + "\n");

    }

    public void clearTextfeld(){
        dauerMin_textField1.setText("");
    }




    public static void main(String[] args) {
        FitnessTracker w = new FitnessTracker();

    }


}
