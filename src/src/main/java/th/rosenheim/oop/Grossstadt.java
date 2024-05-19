package th.rosenheim.oop;
import java.util.List;

/**
 * Represents a subclass of the Stadt class called Grossstadt.
 * A Grossstadt is a big city with multiple stadtteile (districts).
 */
public class Grossstadt extends Stadt {
    private List<String> stadtteile;

    /**
     * Constructs a Grossstadt object with the specified name, weather, and districts.
     *
     * @param name       the name of the big city
     * @param wetter     the weather of the big city
     * @param stadtteile the list of districts in the big city
     */
    public Grossstadt(String name, Wetter wetter, List<String> stadtteile) {
        super(name, wetter);
        this.stadtteile = stadtteile;
    }

    /**
     * Returns the content of the big city's Subsite.
     * The content includes information about the weather and districts.
     *
     * @return the content of the big city's Subsite
     */
    @Override
    public String getContent() {
        String stadtteileString = String.join(", ", stadtteile.subList(0, stadtteile.size() - 1))
                + " und " + stadtteile.get(stadtteile.size() - 1);
        return "<p>In " + name + " ist es " + wetter.toString().toLowerCase() + ".</p>"
                + "<p> Dies trifft auch für " + stadtteileString + " zu.</p>";
    }

    /**
     * Returns the URL of the big city.
     * The URL is formatted based on the name of the big city.
     *
     * @return the URL of the big city's Subsite
     */
    @Override
    public String getURL() {
        return "wetter_grossstadt_" + formatNameForURL() + ".html";
    }
}