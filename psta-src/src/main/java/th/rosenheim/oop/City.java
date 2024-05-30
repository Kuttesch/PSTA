package th.rosenheim.oop;

/**
 * The abstract class representing a City.
 * It has two abstract methods: getContent and getURL.
 * It also has a method to format the name of the City for use in a URL.
 */
public abstract class City {
    /**
     * The name of the City.
     */
    protected String name;
    /**
     * The weather of the City.
     */
    protected Weather weather;

    /**
     * Constructs a City object with the specified name and weather.
     *
     * @param name   the name of the City
     * @param weather the weather of the City
     */
    public City(String name, Weather weather) {
        this.name = name;
        this.weather = weather;
    }

    /**
     * Formats the name of the City for use in a URL.
     *
     * @return the formatted name of the City
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
     * Gets the content of the City.
     *
     * @return the content of the City's Subsite
     */
    public abstract String getContent();

    /**
     * Gets the URL of the City.
     *
     * @return the URL of the City's Subsite
     */
    public abstract String getURL();
}