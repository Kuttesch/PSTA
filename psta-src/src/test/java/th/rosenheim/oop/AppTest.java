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
     * Test the Weather enum.
     * Test the weather conditions.
     */
    @Test
    public void testWeather() {
        assertEquals("sonnig", Weather.SUNNY.getWeather());
        assertEquals("regnerisch", Weather.RAINY.getWeather());
        assertEquals("wolkig", Weather.CLOUDY.getWeather());

        System.out.println("TEST: testWeather passed.");
    }


    /**
     * Test the City class.
     * Test the formatting of the name of the City for use in a URL.
     */
    @Test
    public void testCity() {
        City city = new City("München", Weather.RAINY) {
            @Override
            public String getContent() {
                return "<p>In München ist es regnerisch.</p>";
            }

            @Override
            public String getURL() {
                return "weather_city_muenchen.html";
            }
        };
        assertEquals("muenchen", city.formatNameForURL());

        System.out.println("TEST: testCity passed.");
    }


    /**
     * Test the BigCity class.
     * Test the generation of the content and URL for the BigCity class.
     */
    @Test
    public void testBigCity() {
        BigCity muenchen = new BigCity("München", Weather.RAINY, Arrays.asList("Schwabing", "Sendling", "Lehel", "Nymphenburg"));
        assertEquals("<p>In München ist es regnerisch.</p><p> Dies trifft auch für Schwabing, Sendling, Lehel und Nymphenburg zu.</p>", muenchen.getContent());
        assertEquals("weather_bigcity_muenchen.html", muenchen.getURL());

        BigCity koeln = new BigCity("Köln", Weather.SUNNY, Arrays.asList("Ehrenfeld", "Raderthal", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));
        assertEquals("<p>In Köln ist es sonnig.</p><p> Dies trifft auch für Ehrenfeld, Raderthal, Nippes, Poll, Esch, Pesch und Kalk zu.</p>", koeln.getContent());
        assertEquals("weather_bigcity_koeln.html", koeln.getURL());

        System.out.println("TEST: testBigCity passed.");
    }

    /**
     * Test the SmallCity class.
     * Test the generation of the content and URL for the SmallCity class.
     */
    @Test
    public void testSmallCity() {
        SmallCity rosenheim = new SmallCity("Rosenheim", Weather.CLOUDY);
        assertEquals("<p>In Rosenheim ist es wolkig.</p>", rosenheim.getContent());
        assertEquals("weather_smallcity_rosenheim.html", rosenheim.getURL());

        System.out.println("TEST: testSmallCity passed.");
    }

    /**
     * Test the WebGen class.
     * Test the generation of the navigation bar in the WebGen class.
     */
    @Test
    public void testNavigation() {
            WebGen generator = new WebGen();

        SmallCity rosenheim = new SmallCity("Rosenheim", Weather.CLOUDY);
        BigCity muenchen = new BigCity("München", Weather.RAINY, Arrays.asList("Schwabing", "Sendling", "Lehel", "Nymphenburg"));
        BigCity koeln = new BigCity("Köln", Weather.SUNNY, Arrays.asList("Raderthal", "Ehrenfeld", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));

        generator.addCity(rosenheim);
        generator.addCity(muenchen);
        generator.addCity(koeln);

        generator.generate();

        assertEquals("<h1>Die Wetter-Website</h1><p><a href=\"weather_smallcity_rosenheim.html\">Rosenheim</a>| <a href=\"weather_bigcity_muenchen.html\">München</a>| <a href=\"weather_bigcity_koeln.html\">Köln</a></p>", generator.getNavigation());

        System.out.println("TEST: testNavigation passed.");
    }

    /**
     * Test the WebGen class.
     * Test the generation of the web pages in the WebGen class.
     */
    @Test
    public void testGeneratePage() {
        WebGen generator = new WebGen();

        SmallCity rosenheim = new SmallCity("Rosenheim", Weather.CLOUDY);
        BigCity muenchen = new BigCity("München", Weather.RAINY, Arrays.asList("Schwabing", "Sendling", "Lehel", "Nymphenburg"));
        BigCity koeln = new BigCity("Köln", Weather.SUNNY, Arrays.asList("Raderthal", "Ehrenfeld", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));

        generator.addCity(rosenheim);
        generator.addCity(muenchen);
        generator.addCity(koeln);

        generator.generate();

        assertTrue(new java.io.File("./output/index.html").exists());
        assertTrue(new java.io.File("./output/weather_smallcity_rosenheim.html").exists());
        assertTrue(new java.io.File("./output/weather_bigcity_muenchen.html").exists());
        assertTrue(new java.io.File("./output/weather_bigcity_koeln.html").exists());

        System.out.println("TEST: testGeneratePage passed.");
    }
}