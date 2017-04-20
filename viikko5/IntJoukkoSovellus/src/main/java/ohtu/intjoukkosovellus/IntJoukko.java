package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        alustus(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        alustus(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Ei saa antaa negatiivisia lukuja!");
        }
        alustus(kapasiteetti, kasvatuskoko);
    }

    private void alustus(int kapasiteetti, int kasvatuskoko) {
        lukujono = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        } else {
            lisaaTaulukkoon(luku);
            return true;
        }
    }

    private void lisaaTaulukkoon(int luku) {
        lukujono[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm % lukujono.length == 0) {
            kasvataTaulukkoa();
        }
    }

    private void kasvataTaulukkoa() {
        int[] taulukkoOld = new int[lukujono.length];
        kopioiTaulukko(lukujono, taulukkoOld);
        lukujono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, lukujono);
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = etsiPoistettava(luku);
        if (kohta != -1) {
            vaihdaAlkiot(kohta);
            return true;
        }
        return false;
    }

    private int etsiPoistettava(int luku) {
        int kohta = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            kohta = onkoLukuJonossa(i, luku, kohta);
            if(kohta!=-1) {
                break;
            }
        }
        return kohta;
    }

    private int onkoLukuJonossa(int indeksi, int luku, int kohta) {
        if (luku == lukujono[indeksi]) {
            kohta = indeksi; //siis luku löytyy tuosta kohdasta :D
            lukujono[kohta] = 0;
            return kohta;
        }
        return -1;
    }

    private void vaihdaAlkiot(int kohta) {
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            int apu = lukujono[j];
            lukujono[j] = lukujono[j + 1];
            lukujono[j + 1] = apu;
        }
        alkioidenLkm--;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukujono[0] + "}";
        } else {
            return tulostaAlkiot();
        }
    }

    private String tulostaAlkiot() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += lukujono[i];
            tuotos += ", ";
        }
        tuotos += lukujono[alkioidenLkm - 1];
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko joukkoA, IntJoukko joukkoB) {
        int[] aTaulu = joukkoA.toIntArray();
        int[] bTaulu = joukkoB.toIntArray();
        return yhdistaJoukot(aTaulu, bTaulu);
    }

    private static IntJoukko yhdistaJoukot(int[] aTaulu, int[] bTaulu) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdisteJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdisteJoukko.lisaa(bTaulu[i]);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko joukkoA, IntJoukko joukkoB) {
        int[] aTaulu = joukkoA.toIntArray();
        int[] bTaulu = joukkoB.toIntArray();
        return leikkaa(aTaulu, bTaulu);
    }

    private static IntJoukko leikkaa(int[] aTaulu, int[] bTaulu) {
        IntJoukko leikkausJoukko = new IntJoukko();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkausJoukko.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkausJoukko;
    }

    public static IntJoukko erotus(IntJoukko joukkoA, IntJoukko joukkoB) {
        int[] aTaulu = joukkoA.toIntArray();
        int[] bTaulu = joukkoB.toIntArray();
        return erotaJoukot(aTaulu, bTaulu);
    }

    private static IntJoukko erotaJoukot(int[] aTaulu, int[] bTaulu) {
        IntJoukko erotusJoukko = new IntJoukko();
        for (int i = 0; i < aTaulu.length; i++) {
            erotusJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotusJoukko.poista(bTaulu[i]);
        }
        return erotusJoukko;
    }

}
