package ohtu;

public class Viitegeneraattori {

    private int seuraava;

    public Viitegeneraattori() {
        seuraava = 1;
    }

    public int seuraava() {
        return seuraava++;
    }
}
