package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSPeliTyyppi {

    private Scanner scanner;

    public KPSPelaajaVsPelaaja() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String toisenPelaajanSiirto() {
        System.out.println("Toisen pelaajan siirto: ");
        String tokanSiirto = scanner.nextLine();
        return tokanSiirto;
    }

}
