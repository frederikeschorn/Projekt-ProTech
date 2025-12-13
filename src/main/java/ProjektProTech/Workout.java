package ProjektProTech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Workout extends JFrame{
    private JPanel mainPanel;
    private JLabel name_label;
    private JTextField name_textField1;
    private JLabel datum_label;
    private JTextField datum_textField1;
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


    public Workout(){
        setTitle("Workout");
        setSize(300, 200);
        setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);


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
        double gewicht = Double.parseDouble(String.valueOf(gewicht_textField1.getText()));

        int dauerMin = Integer.parseInt(String.valueOf(dauerMin_textField1.getText()));

       sportart_comboBox1.getSelectedItem();
       String sportart = sportart_comboBox1.getSelectedItem().toString(); //DropDown wird jedes Mal neu gelesen

       double kalorien;

        if ("Fußball".equals(sportart)){
            kalorien = 7.0 * gewicht * (dauerMin/60.0); //kalorien = MET * Körpergewicht * Dauer in Stunden

        }else if ("Gehen".equals(sportart)){
            kalorien = 3.5 * gewicht * (dauerMin/60.0);

        }else if ("Krafttraining".equals(sportart)){
            kalorien = 8.0 * gewicht * (dauerMin/60.0);

        }else if ("Laufen".equals(sportart)){
            kalorien = 10.0 * gewicht * (dauerMin/60.0);

        }else if ("Radfahren".equals(sportart)){
            kalorien = 8.0 * gewicht * (dauerMin/60.0);

        }else if ("Schwimmen".equals(sportart)){
            kalorien = 5.8 * gewicht * (dauerMin/60.0);

        }else if ("Skifahren".equals(sportart)){
            kalorien = 5.0 * gewicht * (dauerMin/60.0);

        }else if ("Tennis".equals(sportart)){
            kalorien = 7.0 * gewicht * (dauerMin/60.0);

        }else if ("Wandern".equals(sportart)){
            kalorien = 6.0 * gewicht * (dauerMin/60.0);

        }else{
            kalorien = 2.5 * gewicht * (dauerMin/60.0);

        }
        ausgabeKalorien_label.setText(String.format("%.2f",kalorien)); //Ausgabe und runden auf zwei Nachkommastellen
    }

    public void inListeSpeichern(){
        String datum = datum_textField1.getText();
        String sportart = sportart_comboBox1.getSelectedItem().toString();
        String dauer = dauerMin_textField1.getText();
        String kalorien = ausgabeKalorien_label.getText();

        workoutListe_textArea1.setText(workoutListe_textArea1.getText() + "Datum: " + datum + "\n" + "Sportart: " + sportart + "\n" + "Dauer: " + dauer + "\n" + "Kalorien verbraucht: " + kalorien + "\n" + "\n");

    }

    public void clearTextfeld(){
        datum_textField1.setText("");
        dauerMin_textField1.setText("");


    }


    public static void main(String[] args) {
        Workout w = new Workout();

    }


}
