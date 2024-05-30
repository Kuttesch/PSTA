package th.rosenheim.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
/**
 * JUnit test class for the WebsiteGenerator application.
 */
public class AppTest {
    /**
     * Default constructor.
     */
    public AppTest() {
    }


    /**
     * Test the BigCity class.
     * Test the generation of the content and URL for the BigCity class.
     */
    @Test
    public void testBigCity() {
        BigCity muenchen = new BigCity("München", Weather.REGNERISCH, Arrays.asList("Schwabing", "Sendling", "Lehel", "Nymphenburg"));
        assertEquals("<p>In München ist es regnerisch.</p><p> Dies trifft auch für Schwabing, Sendling, Lehel und Nymphenburg zu.</p>", muenchen.getContent());
        assertEquals("weather_bigcity_muenchen.html", muenchen.getURL());

        BigCity koeln = new BigCity("Köln", Weather.SONNIG, Arrays.asList("Ehrenfeld", "Raderthal", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));
        assertEquals("<p>In Köln ist es sonnig.</p><p> Dies trifft auch für Ehrenfeld, Raderthal, Nippes, Poll, Esch, Pesch und Kalk zu.</p>", koeln.getContent());
        assertEquals("weather_bigcity_koeln.html", koeln.getURL());
    }

    /**
     * Test the SmallCity class.
     * Test the generation of the content and URL for the SmallCity class.
     */
    @Test
    public void testSmallCity() {
        SmallCity rosenheim = new SmallCity("Rosenheim", Weather.WOLKIG);
        assertEquals("<p>In Rosenheim ist es wolkig.</p>", rosenheim.getContent());
        assertEquals("weather_smallcity_rosenheim.html", rosenheim.getURL());
    }

    /**
     * Test the WebGen class.
     * Test the generation of the navigation bar in the WebGen class.
     */
    @Test
    public void testNavigation() {
            WebGen generator = new WebGen();

        SmallCity rosenheim = new SmallCity("Rosenheim", Weather.WOLKIG);
        BigCity muenchen = new BigCity("München", Weather.REGNERISCH, Arrays.asList("Schwabing", "Sendling", "Lehel", "Nymphenburg"));
        BigCity koeln = new BigCity("Köln", Weather.SONNIG, Arrays.asList("Raderthal", "Ehrenfeld", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));

        generator.addCity(rosenheim);
        generator.addCity(muenchen);
        generator.addCity(koeln);

        generator.generate();

        assertEquals("<h1>Die Wetter-Website</h1><p><a href=\"weather_smallcity_rosenheim.html\">Rosenheim</a>| <a href=\"weather_bigcity_muenchen.html\">München</a>| <a href=\"weather_bigcity_koeln.html\">Köln</a></p>", generator.getNavigation());
    }

    /**
     * Test the WebGen class.
     * Test the generation of the web pages in the WebGen class.
     */
    @Test
    public void testGeneratePage() {
        WebGen generator = new WebGen();

        SmallCity rosenheim = new SmallCity("Rosenheim", Weather.WOLKIG);
        BigCity muenchen = new BigCity("München", Weather.REGNERISCH, Arrays.asList("Schwabing", "Sendling", "Lehel", "Nymphenburg"));
        BigCity koeln = new BigCity("Köln", Weather.SONNIG, Arrays.asList("Raderthal", "Ehrenfeld", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));

        generator.addCity(rosenheim);
        generator.addCity(muenchen);
        generator.addCity(koeln);

        generator.generate();

        assertTrue(new java.io.File("./output/index.html").exists());
        assertTrue(new java.io.File("./output/weather_smallcity_rosenheim.html").exists());
        assertTrue(new java.io.File("./output/weather_bigcity_muenchen.html").exists());
        assertTrue(new java.io.File("./output/weather_bigcity_koeln.html").exists());
    }
}