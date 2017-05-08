package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Map;

public class KPSPelinValinta {

    private Map<Character, KPSPeliTyyppi> pelityypit;

    public KPSPelinValinta() {
        pelityypit = new HashMap<Character, KPSPeliTyyppi>();
        pelityypit.put('a', KPSPeliTyyppi.luoKPSPelaajaVsPelaaja());
        pelityypit.put('b', KPSPeliTyyppi.luoKPSTekoaly());
        pelityypit.put('c', KPSPeliTyyppi.luoKPSParempiTekoaly());

    }

    public Map<Character, KPSPeliTyyppi> getPelityypit() {
        return pelityypit;
    }

}
