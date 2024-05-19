package th.rosenheim.oop;

/**
 * Represents a subclass of the Stadt class called Kleinstadt.
 * Represents a small town.
 */
public class Kleinstadt extends Stadt {

    /**
     * Constructs a Kleinstadt object with the specified name and weather.
     *
     * @param name   the name of the town
     * @param wetter the weather in the town
     */
    public Kleinstadt(String name, Wetter wetter) {
        super(name, wetter);
    }

    /**
     * Returns the content of the town's Subsite.
     * The content includes information about the weather.
     *
     * @return the content of the town's Subsite
     */
    @Override
    public String getContent() {
        return "<p>In " + name + " ist es " + wetter.toString().toLowerCase() + ".</p>";
    }

    /**
     * Returns the URL for the town's Subsite.
     * The URL is formatted based on the name of the Kleinstadt.
     *
     * @return the URL of the town's Subsite
     */
    @Override
    public String getURL() {
        return "wetter_kleinstadt_" + formatNameForURL() + ".html";
    }
}
