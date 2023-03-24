package be.kdg.projectbasis.model.highscore;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HighScoreModel {
    private final String username;
    private final String voornaam;
    private final String achternaam;
    private final String email;
    private int wins;
    public String getUsername() {
        return username;
    }
    public String getVoornaam() {
        return voornaam;
    }
    public String getAchternaam() {
        return achternaam;
    }
    public String getEmail() {
        return email;
    }
    public int getWins() {
        return wins;
    }

    public HighScoreModel(String username, String voornaam, String achternaam,String email, int wins) {
        this.username = username;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.wins = wins;
    }

    public static HighScoreModel readHighScore(String username) {
        try {
            File inputFile = new File("src/be/kdg/projectbasis/resources/spelergegevens/HighScores.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            NodeList playersList = doc.getElementsByTagName("Player");

            for (int i = 0; i < playersList.getLength(); i++) {
                Node player = playersList.item(i);
                if (player.getNodeType() == Node.ELEMENT_NODE) {
                    Element playerElement = (Element) player;
                    String existingUsername = playerElement.getElementsByTagName("Username").item(0).getTextContent();
                    if (existingUsername.equals(username)) {
                        String voornaam = playerElement.getElementsByTagName("Voornaam").item(0).getTextContent();
                        String achternaam = playerElement.getElementsByTagName("Naam").item(0).getTextContent();
                        String email = playerElement.getElementsByTagName("Email").item(0).getTextContent();
                        int wins = Integer.parseInt(playerElement.getElementsByTagName("AantalWins").item(0).getTextContent());
                        return new HighScoreModel(username, voornaam, achternaam, email, wins);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void addWin() {
        wins++;
        savePlayerInfo(username, voornaam, achternaam, email ,wins);
    }
    public static void savePlayerInfo(String username, String voornaam, String naam, String email, int aantalWins) {
        try {
            File inputFile = new File("src/be/kdg/projectbasis/resources/spelergegevens/HighScores.xml");

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);

            Node root = doc.getFirstChild();

            // Check of userame al bestaat
            boolean playerExists = false;
            NodeList playersList = doc.getElementsByTagName("Player");
            for (int i = 0; i < playersList.getLength(); i++) {
                Node player = playersList.item(i);
                if (player.getNodeType() == Node.ELEMENT_NODE) {
                    Element playerElement = (Element) player;
                    String existingUsername = playerElement.getElementsByTagName("Username").item(0).getTextContent();
                    if (existingUsername.equals(username)) {
                        playerExists = true;
                        if (aantalWins > 0) {
                            int currentWins = Integer.parseInt(playerElement.getElementsByTagName("AantalWins").item(0).getTextContent());
                            playerElement.getElementsByTagName("AantalWins").item(0).setTextContent(String.valueOf(currentWins + aantalWins));
                        }
                        break;
                    }
                }
            }

            // Als username nog niet bestaat, maak een nieuwe speler aan
            if (!playerExists) {
                Element newPlayer = doc.createElement("Player");
                root.appendChild(newPlayer);

                Element newUsername = doc.createElement("Username");
                newUsername.setTextContent(username);
                newPlayer.appendChild(newUsername);

                Element newVoornaam = doc.createElement("Voornaam");
                newVoornaam.setTextContent(voornaam);
                newPlayer.appendChild(newVoornaam);

                Element newNaam = doc.createElement("Naam");
                newNaam.setTextContent(naam);
                newPlayer.appendChild(newNaam);

                Element newEmail = doc.createElement("Email");
                newEmail.setTextContent(email);
                newPlayer.appendChild(newEmail);

                Element newAantalWins = doc.createElement("AantalWins");
                newAantalWins.setTextContent(String.valueOf(aantalWins));
                newPlayer.appendChild(newAantalWins);
            }

            // schrijf de nieuwe info naar het bestand
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(inputFile);
            transformer.transform(source, result);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
    public static List<HighScoreModel> getPlayers() {
        List<HighScoreModel> players = new ArrayList<>();

        try {
            File inputFile = new File("src/be/kdg/projectbasis/resources/spelergegevens/HighScores.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            NodeList playersList = doc.getElementsByTagName("Player");

            for (int i = 0; i < playersList.getLength(); i++) {
                Node player = playersList.item(i);
                if (player.getNodeType() == Node.ELEMENT_NODE) {
                    Element playerElement = (Element) player;
                    String username = playerElement.getElementsByTagName("Username").item(0).getTextContent();
                    String voornaam = playerElement.getElementsByTagName("Voornaam").item(0).getTextContent();
                    String achternaam = playerElement.getElementsByTagName("Naam").item(0).getTextContent();
                    String email = playerElement.getElementsByTagName("Email").item(0).getTextContent();
                    int wins = Integer.parseInt(playerElement.getElementsByTagName("AantalWins").item(0).getTextContent());
                    HighScoreModel playerData = new HighScoreModel(username, voornaam, achternaam, email, wins);
                    players.add(playerData);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return players;
    }


}



