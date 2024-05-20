package th.rosenheim.oop;

/**
 * The abstract class representing a city.
 * It has two abstract methods: getContent and getURL.
 * It also has a method to format the name of the city for use in a URL.
 */
public abstract class Stadt {
    /**
     * The name of the city.
     */
    protected String name;
    /**
     * The weather of the city.
     */
    protected Wetter wetter;

    /**
     * Constructs a Stadt object with the specified name and weather.
     *
     * @param name   the name of the city
     * @param wetter the weather of the city
     */
    public Stadt(String name, Wetter wetter) {
        this.name = name;
        this.wetter = wetter;
    }

    /**
     * Formats the name of the city for use in a URL.
     *
     * @return the formatted name of the city
     */
    protected String formatNameForURL() {
        return name.toLowerCase()
                    .replace("ä", "ae")
                    .replace("ö", "oe")
                    .replace("ü", "ue")
                    .replace("ß", "ss")
                    .replace(" ", "_");
    }

    /**
     * Gets the content of the city.
     *
     * @return the content of the city's Subsite
     */
    public abstract String getContent();

    /**
     * Gets the URL of the city.
     *
     * @return the URL of the city's Subsite
     */
    public abstract String getURL();
}