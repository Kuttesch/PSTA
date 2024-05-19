package th.rosenheim.oop;

public abstract class Stadt {
    protected String name;
    protected Wetter wetter;

    public Stadt(String name, Wetter wetter) {
        this.name = name;
        this.wetter = wetter;
    }

    protected String formatNameForURL() {
        return name.toLowerCase()
                    .replace("ä", "ae")
                    .replace("ö", "oe")
                    .replace("ü", "ue")
                    .replace("ß", "ss")
                    .replace(" ", "_");
    }
    public abstract String getContent();
    public abstract String getURL();
}