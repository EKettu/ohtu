package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int tulos;
    private int syote;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;

    }

    @Override
    public void suorita() {
        try {
        tulos = Integer.parseInt(tuloskentta.getText());
        syote = Integer.parseInt(syotekentta.getText());
        }
        catch (Exception e) {
            
        }

        sovellus.nollaa();
        tuloskentta.setText(Integer.toString(sovellus.tulos()));
        syotekentta.setText("");
    }

    @Override
    public void peru() {
        tuloskentta.setText("" + tulos);
        syotekentta.setText("" + syote);
        sovellus.plus(tulos);
    }

}
