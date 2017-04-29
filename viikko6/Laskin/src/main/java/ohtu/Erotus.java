package ohtu;

import javax.swing.JTextField;

public class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int arvo;
    private int edellinenArvo;
    private int edellinenTulos;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
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
        sovellus.miinus(arvo);
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
        sovellus.plus(edellinenArvo);
    }

    private void asetaEdellinenTulos(int tulos) {
        edellinenTulos = tulos + edellinenArvo;
    }

}
