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
     * Test the Grossstadt class.
     * Test the generation of the content and URL for the Grossstadt class.
     */
    @Test
    public void testGrossstadt() {
        Grossstadt muenchen = new Grossstadt("München", Wetter.REGNERISCH, Arrays.asList("Schwabing", "Sendling", "Lehel", "Nymphenburg"));
        assertEquals("<p>In München ist es regnerisch.</p><p> Dies trifft auch für Schwabing, Sendling, Lehel und Nymphenburg zu.</p>", muenchen.getContent());
        assertEquals("wetter_grossstadt_muenchen.html", muenchen.getURL());

        Grossstadt koeln = new Grossstadt("Köln", Wetter.SONNIG, Arrays.asList("Ehrenfeld", "Raderthal", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));
        assertEquals("<p>In Köln ist es sonnig.</p><p> Dies trifft auch für Ehrenfeld, Raderthal, Nippes, Poll, Esch, Pesch und Kalk zu.</p>", koeln.getContent());
        assertEquals("wetter_grossstadt_koeln.html", koeln.getURL());
    }

    /**
     * Test the Kleinstadt class.
     * Test the generation of the content and URL for the Kleinstadt class.
     */
    @Test
    public void testKleinstadt() {
        Kleinstadt rosenheim = new Kleinstadt("Rosenheim", Wetter.WOLKIG);
        assertEquals("<p>In Rosenheim ist es wolkig.</p>", rosenheim.getContent());
        assertEquals("wetter_kleinstadt_rosenheim.html", rosenheim.getURL());
    }

    /**
     * Test the WebsitenGenerator class.
     * Test the generation of the navigation bar in the WebsitenGenerator class.
     */
    @Test
    public void testNavigation() {
            WebsitenGenerator generator = new WebsitenGenerator();

        Kleinstadt rosenheim = new Kleinstadt("Rosenheim", Wetter.WOLKIG);
        Grossstadt muenchen = new Grossstadt("München", Wetter.REGNERISCH, Arrays.asList("Schwabing", "Sendling", "Lehel", "Nymphenburg"));
        Grossstadt koeln = new Grossstadt("Köln", Wetter.SONNIG, Arrays.asList("Raderthal", "Ehrenfeld", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));

        generator.addStadt(rosenheim);
        generator.addStadt(muenchen);
        generator.addStadt(koeln);

        generator.generate();

        assertEquals("<h1>Die Wetter-Website</h1><p><a href=\"wetter_kleinstadt_rosenheim.html\">Rosenheim</a>| <a href=\"wetter_grossstadt_muenchen.html\">München</a>| <a href=\"wetter_grossstadt_koeln.html\">Köln</a></p>", generator.getNavigation());
    }

    /**
     * Test the WebsitenGenerator class.
     * Test the generation of the web pages in the WebsitenGenerator class.
     */
    @Test
    public void testGeneratePage() {
        WebsitenGenerator generator = new WebsitenGenerator();

        Kleinstadt rosenheim = new Kleinstadt("Rosenheim", Wetter.WOLKIG);
        Grossstadt muenchen = new Grossstadt("München", Wetter.REGNERISCH, Arrays.asList("Schwabing", "Sendling", "Lehel", "Nymphenburg"));
        Grossstadt koeln = new Grossstadt("Köln", Wetter.SONNIG, Arrays.asList("Raderthal", "Ehrenfeld", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));

        generator.addStadt(rosenheim);
        generator.addStadt(muenchen);
        generator.addStadt(koeln);

        generator.generate();

        assertTrue(new java.io.File("./output/index.html").exists());
        assertTrue(new java.io.File("./output/wetter_kleinstadt_rosenheim.html").exists());
        assertTrue(new java.io.File("./output/wetter_grossstadt_muenchen.html").exists());
        assertTrue(new java.io.File("./output/wetter_grossstadt_koeln.html").exists());
    }
}