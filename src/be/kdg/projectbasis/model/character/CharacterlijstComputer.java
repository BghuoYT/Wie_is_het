package be.kdg.projectbasis.model.character;

import be.kdg.projectbasis.model.character.Enums.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;


public class CharacterlijstComputer {
    private final ArrayList<Character> charactersComputer;

    public CharacterlijstComputer() {
        charactersComputer = new ArrayList<>();
        try {
            File file = new File("src/be/kdg/projectbasis/resources/characters/characters.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("character");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getAttribute("name");
                    String geslacht = element.getAttribute("geslacht").toLowerCase();
                    String oogKleur = element.getAttribute("oogkleur").toLowerCase();
                    String haarKleur = element.getAttribute("haarkleur").toLowerCase();
                    String haarLengte = element.getAttribute("haarlengte").toLowerCase();
                    String haarStijl = element.getAttribute("haarstijl").toLowerCase();
                    String gezichtsbeharing = element.getAttribute("gezichtsbeharing").toLowerCase();
                    String hoofddeksel = element.getAttribute("hoofddeksel").toLowerCase();
                    String accessoires = element.getAttribute("accessoires").toLowerCase();
                    String afbeelding = element.getAttribute("afbeelding");
                    charactersComputer.add(new Character(name, Geslacht.valueOf(geslacht), Oogkleur.valueOf(oogKleur), HaarKleur.valueOf(haarKleur), Haarlengte.valueOf(haarLengte), HaarStijl.valueOf(haarStijl), Gezichtsbeharing.valueOf(gezichtsbeharing), Hoofddeksel.valueOf(hoofddeksel), Accessoires.valueOf(accessoires), afbeelding));
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<Character> getCharactersComputer() {
        return charactersComputer;
    }
}

