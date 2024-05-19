package th.rosenheim.oop;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        WebsitenGenerator generator = new WebsitenGenerator();

        Kleinstadt rosenheim = new Kleinstadt("Rosenheim", Wetter.WOLKIG);
        Grossstadt muenchen = new Grossstadt("München", Wetter.REGNERISCH, List.of("Schwabing", "Sendling", "Lehel", "Nymphenburg"));
        Grossstadt koeln = new Grossstadt("Köln", Wetter.SONNIG, List.of("Raderthal", "Ehrenfeld", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));

        generator.addStadt(rosenheim);
        generator.addStadt(muenchen);
        generator.addStadt(koeln);

        generator.generate();
    }
}