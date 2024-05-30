package th.rosenheim.oop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The WebGen class is responsible for generating the weather website including the navigation and Subsites.
 * It allows adding cities and generating Subsites for each City.
 */
public class WebGen {
    private List<City> cities = new ArrayList<>();

    /**
     * Default constructor for the WebGen class.
     * This constructor initializes the list of cities.
     */
    public WebGen() {
        this.cities = new ArrayList<>();
    }

    /**
     * Adds a City to the list of cities.
     *
     * @param city The City to add.
     */
    public void addCity(City city) {
        cities.add(city);
    }

    /**
     * Generates a navigation string that contains links to the Subsite of all the cities added.
     * The links are separated by a pipe character (|).
     *
     * @return The generated navigation string.
     */
    public String getNavigation() {
        String cityString = String.join("| ", cities.stream()
                .map(City -> "<a href=\"" + City.getURL() + "\">" + City.name + "</a>")
                .toArray(String[]::new));
     return "<h1>Die Wetter-Website</h1><p>" + cityString + "</p>";

    }

    /**
     * Generates the HTML code for a web page. The page contains the provided navigation and content.
     *
     * @param navigation    The navigation to include in the page.
     * @param content       The content to include in the page.
     * @return              The generated HTML code.
     */
    public String generatePage(String navigation, String content) {
        return "<html><body>" + navigation + content + "</body></html>";
    }

    /**
     * Generates the web pages for all the cities added. It first generates an index page that contains links to all the City pages.
     * Then, it generates a web page for each City. The City page contains the same navigation as the index page and the content of the City.
     *
     */
    public void generate() {
        String navigation = getNavigation();
        try {
            // Ensure the output directory exists
            File outputDir = new File("./output");
            if (!outputDir.exists()) {
                outputDir.mkdir();
            }

            FileWriter indexWriter = new FileWriter("./output/index.html");
            indexWriter.write(generatePage(navigation, ""));
            indexWriter.close();

            for (City stadt : cities) {
                FileWriter writer = new FileWriter("./output/" + stadt.getURL());
                writer.write(generatePage(navigation, stadt.getContent()));
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}