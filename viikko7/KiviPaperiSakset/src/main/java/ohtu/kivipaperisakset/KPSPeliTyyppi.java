package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPSPeliTyyppi {

    private Scanner scanner;
    private Tuomari tuomari;

    protected KPSPeliTyyppi() {
        this.scanner = new Scanner(System.in);
        this.tuomari = new Tuomari();
    }

    public static KPSPeliTyyppi luoKPSParempiTekoaly() {
        return new KPSParempiTekoaly();
    }

    public static KPSPeliTyyppi luoKPSPelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }

    public static KPSPeliTyyppi luoKPSTekoaly() {
        return new KPSTekoaly();
    }

    public void pelaa() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto = toisenPelaajanSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            toisenPelaajanSiirto();
            opiSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);

    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    public abstract String toisenPelaajanSiirto();

    public void opiSiirto(String ekanSiirto) {

    }
}
