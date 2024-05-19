package th.rosenheim.oop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebsitenGenerator {
    private List<Stadt> staedte = new ArrayList<>();

    public void addStadt(Stadt stadt) {
        staedte.add(stadt);
    }

    public String getNavigation() {
        String staedteString = String.join("| ", staedte.stream()
                .map(stadt -> "<a href=\"" + stadt.getURL() + "\">" + stadt.name + "</a>")
                .toArray(String[]::new));
     return "<h1>Die Wetter-Website</h1><p>" + staedteString + "</p>";

    }

    public String generatePage(String navigation, String content) {
        return "<html><body>" + navigation + content + "</body></html>";
    }

    public void generate() {
        String navigation = getNavigation();
        try {
            FileWriter indexWriter = new FileWriter("index.html");
            indexWriter.write(generatePage(navigation, ""));
            indexWriter.close();

            for (Stadt stadt : staedte) {
                FileWriter writer = new FileWriter(stadt.getURL());
                writer.write(generatePage(navigation, stadt.getContent()));
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
