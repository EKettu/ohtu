package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int arvo;
    private int edellinenArvo;
    private int edellinenTulos;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        arvo = 0;
        edellinenArvo = arvo;
    }

    @Override
    public void suorita() {
        try {
            arvo = Integer.parseInt(syotekentta.getText());
            edellinenArvo = arvo;
        } catch (Exception e) {
        }
        sovellus.plus(arvo);
        arvo = 0;
        int laskunTulos = sovellus.tulos();
        asetaEdellinenTulos(laskunTulos);

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

    }

    @Override
    public void peru() {
        syotekentta.setText("" + edellinenArvo);
        tuloskentta.setText("" + edellinenTulos);
        sovellus.miinus(edellinenArvo);
    }

    private void asetaEdellinenTulos(int tulos) {
        edellinenTulos = tulos - edellinenArvo;
        if (edellinenTulos < 0) {
            edellinenTulos = 0;
        }
    }

}
