package be.kdg.projectbasis.model;

import be.kdg.projectbasis.model.character.Character;
import be.kdg.projectbasis.model.character.CharacterlijstComputer;
import be.kdg.projectbasis.model.character.CharacterlijstSpeler;
import be.kdg.projectbasis.model.spelbeurten.ComputerQuestions;
import be.kdg.projectbasis.view.spelBord.SpelBordView;

import java.util.*;

public class ProgrammaModel{
    private static String username;
    private String gekozenCharacterNaam;
    private String question;
    private ArrayList<Character> remainingCharactersC;
    private ArrayList<Character> remainingCharactersP;
    private Random random;
    private String answerS;
    private String answerC;
    private Character gekozenCharacter;
    private Character teRadenCharacter;
    public boolean spelerWin = false;
    public boolean computerWin = false;

    public static void setUsername(String username) {
        ProgrammaModel.username = username;
        System.out.println("username set to: " + username);
    }
    public void characterListComputer() {
        CharacterlijstComputer characterlijstComputer = new CharacterlijstComputer();

        remainingCharactersC = new ArrayList<>();


        System.out.println(" ");
        // Add all characters to the remaining characters list and display them
        for (Character character : characterlijstComputer.getCharactersComputer()) {
            System.out.println("- " + character.getNaam());
            remainingCharactersC.add(character);
        }

        SpelBordView.setAantalCharacters = remainingCharactersC.size();
        //zet namen van alle characters in setCharacters string[]
        ArrayList<Character> Characters = new ArrayList<>();
        for (Character character : characterlijstComputer.getCharactersComputer()) {
            System.out.println("- " + character.getNaam());
            Characters.add(character);
        }
        SpelBordView.setCharacters = Characters;


    }
    public void setupComputer(String gekozenCharacterNaam) {
        //haal gekozen character uit lijst van characters
        for (Character character : remainingCharactersC) {
            if (character.getNaam().equalsIgnoreCase(gekozenCharacterNaam)) {
                gekozenCharacter = character;
                break;
            }
        }

        System.out.println("Het te raden karakter is gekozen.");
        System.out.println("je hebt gekozen voor: " + gekozenCharacter);
    }
    public void setupSpeler() {
        CharacterlijstSpeler characterlijstSpeler = new CharacterlijstSpeler();
        remainingCharactersP = new ArrayList<>();

        System.out.println(" ");
        // Add all characters to the remaining characters list and display them
        for (Character character : characterlijstSpeler.getCharactersSpeler()) {
            System.out.println("- " + character.getNaam());
            remainingCharactersP.add(character);
        }

        // Choose a random character for the player to guess and inform them
        random = new Random();
        teRadenCharacter = remainingCharactersP.get(random.nextInt(remainingCharactersP.size()));
        System.out.println("Het te raden karakter is gekozen.");
        System.out.println(" ");


    }
    public void refreshCharacters() {
        System.out.println(" ");
        System.out.println("Resterende karakters:");
        for (Character character : remainingCharactersP) {
            System.out.println("- " + character.getNaam() + ", geslacht: " + character.getGeslacht() + ", oogkleur: " + character.getOogkleur() +", haarkleur: " + character.getHaarKleur() + ", haarlengte: "
                    + character.getHaarlengte() + ", haarstijl: " + character.getHaarStijl() + ", gezichtsbeharing: " + character.getGezichtsbeharing() + ", hoofddeksel: " + character.getHoofddeksel() + ", accessoires: " + character.getAccessoires() + ")");
        }

    }
    public void startSpelbeurtSpeler(String question) {
        if (teRadenCharacter.matches(question)) {
            answerS = "ja";
            System.out.println(answerS);
        } else {
            answerS = "nee";
            System.out.println(answerS);
        }
        //verwijder characters die niet aan de vraag voldoen
        Iterator<Character> iterator = remainingCharactersP.iterator();
        while (iterator.hasNext()) {
            Character character = iterator.next();
            if ((answerS.equals("ja") && !character.matches(question)) || (answerS.equals("nee") && character.matches(question))) {
                iterator.remove();
            }
        }

    }
    public void maakGok(String gok) {
        // Check if the player's guess is correct, update the spelerWin variable and inform the player
        if (gok.equalsIgnoreCase(teRadenCharacter.getNaam())) {
            System.out.println("Je hebt het juiste karakter geraden, gefeliciteerd!");
            spelerWin = true;
        } else {
            System.out.println("Dat is helaas niet het juiste karakter. je verliest het spel.");
            computerWin = true;
        }
    }
    public void startSpelbeurtComputer() {
        // Een Random object om vragen te stellen aan de speler uit de lijst met vragen
        Random random = new Random();
        ComputerQuestions computerQuestions = new ComputerQuestions();

        // Geef de lijst met resterende karakters weer, samen met hun eigenschappen
        for (Character character : remainingCharactersC) {
            System.out.print(" - " + character.getNaam());
        }

        String question = computerQuestions.getRandomQuestion();
        System.out.println(question);

        // Gebruik de vraag van de computer om te bepalen of het karakter aan de eigenschap voldoet
        if (gekozenCharacter.matches(question)) {
            answerC = "ja";
            System.out.println(answerC);
        } else {
            answerC = "nee";
            System.out.println(answerC);
        }

        // Een lijst met resterende karakters

        // Als antwoord nee is
        if (answerC.equals("nee")) {
            Iterator<Character> iterator = remainingCharactersC.iterator();
            while (iterator.hasNext()) {
                Character character = iterator.next();
                if (character.matches(question)) {
                    iterator.remove();
                }
            }
        }
        // Als antwoord ja is
        if (answerC.equals("ja")) {
            Iterator<Character> iterator = remainingCharactersC.iterator();
            while (iterator.hasNext()) {
                Character character = iterator.next();
                if (!character.matches(question)) {
                    iterator.remove();
                }
            }
        }
        // Geef de lijst met resterende karakters weer, samen met hun eigenschappen

        //als remainingCharactersC.size() kleiner is dan 3, waag een gok
        if (remainingCharactersC.size() < 3) {
            String guess = remainingCharactersC.get(random.nextInt(remainingCharactersC.size())).getNaam();
            System.out.println(guess);

            // Als de computer het juiste karakter heeft geraden, geef het resultaat weer en stop het spel
            if (guess.equalsIgnoreCase(gekozenCharacter.getNaam())) {
                System.out.println("Je hebt het juiste karakter geraden! Het was " + gekozenCharacter.getNaam());
                computerWin = true;
            } else {
                System.out.println("Dat is helaas niet het juiste karakter. De speler wint");
                spelerWin = true;
            }
        }
    }

    public String getAnswerS() {
        return answerS;
    }

}
