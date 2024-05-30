package th.rosenheim.oop;

/**
 * The Weather enum represents the different weather conditions used in the WebGen.
 * It has three values: SUNNY, CLOUDY and RAINY.
 * It is used throughout the project to represent the weather in a City.
 *
 * Each enum value is associated with a string that describes the weather condition in German.
 */
public enum Weather {
    /**
     * The SUNNY value represents a sunny weather condition.
     * The associated string is "sonnig".
     */
    SUNNY("sonnig"),

    /**
     * The CLOUDY value represents a cloudy weather condition.
     * The associated string is "wolkig".
     */
    CLOUDY("wolkig"),

    /**
     * The RAINY value represents a rainy weather condition.
     * The associated string is "regnerisch".
     */
    RAINY("regnerisch");

    // The string that describes the weather condition in German.
    private final String weather;

    /**
     * Constructs a new Weather enum value with the specified description.
     *
     * @param weather the description of the weather condition in German
     */
    Weather(String weather) {
        this.weather = weather;
    }

    /**
     * Returns the description of the weather condition in German.
     *
     * @return the description of the weather condition in German
     */
    public String getWeather() {
        return weather;
    }
}