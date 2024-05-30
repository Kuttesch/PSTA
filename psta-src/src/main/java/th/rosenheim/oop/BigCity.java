package th.rosenheim.oop;
import java.util.List;

/**
 * Represents a subclass of the City class called BigCity.
 * A BigCity is a big City with multiple districts (districts).
 */
public class BigCity extends City {
    private List<String> districts;

    /**
     * Constructs a BigCity object with the specified name, weather, and districts.
     *
     * @param name       the name of the big City
     * @param weather     the weather of the big City
     * @param districts the list of districts in the big City
     */
    public BigCity(String name, Weather weather, List<String> districts) {
        super(name, weather);
        this.districts = districts;
    }

    /**
     * Returns the content of the big City's Subsite.
     * The content includes information about the weather and districts.
     *
     * @return the content of the big City's Subsite
     */
    @Override
    public String getContent() {
        String districtsString= String.join(", ", districts.subList(0, districts.size() - 1))
                + " und " + districts.get(districts.size() - 1);
        return "<p>In " + name + " ist es " + weather.getWeather() + ".</p>"
                + "<p> Dies trifft auch für " + districtsString + " zu.</p>";
    }

    /**
     * Returns the URL of the big City.
     * The URL is formatted based on the name of the big City.
     *
     * @return the URL of the big City's Subsite
     */
    @Override
    public String getURL() {
        return "weather_bigcity_" + formatNameForURL() + ".html";
    }
}