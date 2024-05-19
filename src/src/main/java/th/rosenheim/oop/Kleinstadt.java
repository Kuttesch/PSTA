package th.rosenheim.oop;

public class Kleinstadt extends Stadt {
    public Kleinstadt(String name, Wetter wetter) {
        super(name, wetter);
    }

    @Override
    public String getContent() {
        return "<p>In " + name + " ist es " + wetter.toString().toLowerCase() + ".</p>";
    }

    @Override
    public String getURL() {
        return "wetter_kleinstadt_" + formatNameForURL() + ".html";
    }
}
