package be.kdg.projectbasis.model.spelbeurten;
import be.kdg.projectbasis.model.character.Character;
import be.kdg.projectbasis.model.character.CharacterlijstSpeler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class SpelbeurtSpeler {
    // Declare variables
    private ArrayList<Character> remainingCharacters;
    private Random random;
    private Character characterToGuess;
    private String guess;
    // Declare a variable to track whether the player has won or not
    private boolean spelerWin;

    // Constructor to set up the game

    public void setupSpeler() {
        CharacterlijstSpeler characterlijstSpeler = new CharacterlijstSpeler();
        remainingCharacters = new ArrayList<>();

        System.out.println(" ");
        // Add all characters to the remaining characters list and display them
        for (Character character : characterlijstSpeler.getCharactersSpeler()) {
            System.out.println("- " + character.getNaam());
            remainingCharacters.add(character);
        }

        // Choose a random character for the player to guess and inform them
        random = new Random();
        characterToGuess = remainingCharacters.get(random.nextInt(remainingCharacters.size()));
        System.out.println("Het te raden karakter is gekozen.");
        System.out.println(" ");
    }

    public void startSpelbeurt(String question) {
        // Prompt the player to ask a question about the character they are trying to guess
        System.out.println("Stel een vraag over het karakter om te raden (bijv. 'Is het karakter een man?')");

        // Use the question to determine whether the character matches the attribute and respond accordingly
        String answer;
        if (characterToGuess.matches(question)) {
            answer = "ja";
            System.out.println(answer);
        } else {
            answer = "nee";
            System.out.println(answer);
        }

        // Remove characters that do not match the attribute from the remaining characters list
        Iterator<Character> iterator = remainingCharacters.iterator();
        while (iterator.hasNext()) {
            Character character = iterator.next();
            if ((answer.equals("ja") && !character.matches(question)) || (answer.equals("nee") && character.matches(question))) {
                iterator.remove();
            }
        }
    }

    public void makeGuess(String guess) {
        // Check if the player's guess is correct, update the spelerWin variable and inform the player
        if (guess.equalsIgnoreCase(characterToGuess.getNaam())) {
            System.out.println("Je hebt het juiste karakter geraden, gefeliciteerd!");
            spelerWin = true;
        } else {
            System.out.println("Dat is helaas niet het juiste karakter. Probeer het nog eens.");
        }
    }

    // Reset the game by choosing a new character and resetting the remaining characters list and spelerWin flag
    public void reset() {
        CharacterlijstSpeler characterlijstSpeler = new CharacterlijstSpeler();
        remainingCharacters = new ArrayList<>();
        for (Character character : characterlijstSpeler.getCharactersSpeler()) {
            remainingCharacters.add(character);
        }
        random = new Random();
        characterToGuess = remainingCharacters.get(random.nextInt(remainingCharacters.size()));
        spelerWin = false;
    }

    // Display the remaining characters and their attributes
    public void refreshCharacters() {
        System.out.println(" ");
        System.out.println("Resterende karakters:");
        for (Character character : remainingCharacters) {
            System.out.println("- " + character.getNaam() + ", geslacht: " + character.getGeslacht() + ", oogkleur: " + character.getOogkleur() +", haarkleur: " + character.getHaarKleur() + ", haarlengte: "
                    + character.getHaarlengte() + ", haarstijl: " + character.getHaarStijl() + ", gezichtsbeharing: " + character.getGezichtsbeharing() + ", hoofddeksel: " + character.getHoofddeksel() + ", accessoires: " + character.getAccessoires() + ")");
        }
    }

    public boolean getSpelerWin() {
        return spelerWin;
    }
}