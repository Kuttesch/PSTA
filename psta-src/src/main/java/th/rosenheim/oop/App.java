package th.rosenheim.oop;

import java.util.List;

/**
 * The main class of the application.
 *
 */
public class App {
    /**
     * Default constructor.
     */
    public App() {                                          //Why is this needed for Jdoc?
    }

    /**
     * The main method of the application.
     * It creates an instance of the WebGen, creates example instances of SmallCity and BigCity,
     * It adds the example cities to the generator, and generates the example website.
     *
     * @param args Possible command-line arguments.
     */
    public static void main(String[] args) {
        WebGen generator = new WebGen();

        SmallCity rosenheim = new SmallCity("Rosenheim", Weather.WOLKIG);
        BigCity muenchen = new BigCity("München", Weather.REGNERISCH, List.of("Schwabing", "Sendling", "Lehel", "Nymphenburg"));
        BigCity koeln = new BigCity("Köln", Weather.SONNIG, List.of("Raderthal", "Ehrenfeld", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));

        generator.addCity(rosenheim);
        generator.addCity(muenchen);
        generator.addCity(koeln);

        generator.generate();
    }
}