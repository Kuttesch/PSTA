package th.rosenheim.oop;

/**
 * Represents a subclass of the City class called SmallCity.
 * Represents a small SmallCity.
 */
public class SmallCity extends City {

    /**
     * Constructs a SmallCity object with the specified name and weather.
     *
     * @param name   the name of the SmallCity
     * @param weather the weather in the SmallCity
     */
    public SmallCity(String name, Weather weather) {
        super(name, weather);
    }

    /**
     * Returns the content of the SmallCity's Subsite.
     * The content includes information about the weather.
     *
     * @return the content of the SmallCity's Subsite
     */
    @Override
    public String getContent() {
        return "<p>In " + name + " ist es " + weather.getWeather() + ".</p>";
    }

    /**
     * Returns the URL for the SmallCity's Subsite.
     * The URL is formatted based on the name of the SmallCity.
     *
     * @return the URL of the SmallCity's Subsite
     */
    @Override
    public String getURL() {
        return "weather_smallcity_" + formatNameForURL() + ".html";
    }
}
