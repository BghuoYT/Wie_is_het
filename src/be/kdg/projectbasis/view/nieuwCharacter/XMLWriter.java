package be.kdg.projectbasis.view.nieuwCharacter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class XMLWriter {
    private final File file;

    public XMLWriter(String filename) {
        file = new File(filename);
    }

    public void writeCharacterToXML(String name, String geslacht, String oogkleur, String haarkleur, String haarlengte,
                                    String haarstijl, String gezichtsbeharing, String hoofddeksel, String accessoires,
                                    String afbeelding) throws IOException {

        // read existing file contents
        List<String> lines = Files.readAllLines(file.toPath());

        // remove last line
        if (!lines.isEmpty()) {
            lines.remove(lines.size() - 1);
        }

        // append new content and closing tag
        String xmlContent = String.format("<character name=\"%s\" geslacht=\"%s\" oogkleur=\"%s\" haarkleur=\"%s\" haarlengte=\"%s\"" +
                        " haarstijl=\"%s\" gezichtsbeharing=\"%s\" hoofddeksel=\"%s\" accessoires=\"%s\" afbeelding=\"%s\"/>",
                name, geslacht, oogkleur, haarkleur, haarlengte, haarstijl, gezichtsbeharing, hoofddeksel, accessoires, afbeelding);

        lines.add(xmlContent);
        lines.add("</xml>");

        // write modified content back to file
        Files.write(file.toPath(), lines);
    }

}
