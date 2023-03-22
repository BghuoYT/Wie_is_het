package be.kdg.projectbasis;

import be.kdg.projectbasis.model.highscore.HighScoreModel;
import be.kdg.projectbasis.model.spelbeurten.SpelbeurtComputer;
import be.kdg.projectbasis.model.spelbeurten.SpelbeurtSpeler;

import java.util.Scanner;

public class ConsoleTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welkom bij het spel 'Wie is het?'");

        // laad de spelerinfo
        System.out.println("vul je username in: ");
        String username = scanner.nextLine();
        //check of username al bestaat
        HighScoreModel player = HighScoreModel.readHighScore(username); // haal gegevens op van player1
        if (player != null) {
            System.out.println("Gebruikersnaam: " + player.getUsername());
            System.out.println("Voornaam: " + player.getVoornaam());
            System.out.println("Achternaam: " + player.getAchternaam());
            System.out.println("Aantal overwinningen: " + player.getWins());
        }else {
            System.out.println("Gebruikersnaam niet gevonden, vul je gegevens in om nieuwe gebruiker aan te maken: ");
            System.out.println("Voornaam: ");
            String voornaam = scanner.nextLine();
            System.out.println("Achternaam: ");
            String achternaam = scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.nextLine();
            HighScoreModel newPlayer = new HighScoreModel(username, voornaam, achternaam, email, 0);
            HighScoreModel.savePlayerInfo(username, voornaam, achternaam, email,0);
        }
        System.out.println("welcome " + username + "!");

        // maak instanties van alle nodige klasses
        SpelbeurtSpeler spelbeurtSpeler = new SpelbeurtSpeler();
        SpelbeurtComputer spelbeurtComputer = new SpelbeurtComputer();

        // begin met de setup en laat elke speler een character kiezen
        String chosenCharacter = scanner.nextLine();
        spelbeurtComputer.setupComputer(chosenCharacter);
        spelbeurtSpeler.setupSpeler();

        // start spelbeurt speler en wissel om de beurt af met computer totdat iemand wint
        boolean gameOver = false; // nieuwe variabele
        while (!gameOver) { // verander de voorwaarde in een boolean expressie
            String vraag = scanner.nextLine();
            spelbeurtSpeler.startSpelbeurt(vraag);
            //wil je een gok wagen ja/nee
            System.out.println("wil je een gok wagen ja/nee");
            String gokWagen = scanner.nextLine();
            if (gokWagen == "ja") {
                String gok = scanner.nextLine();
              spelbeurtSpeler.makeGuess(gok);
            } else if (gokWagen == "nee") {
                break;
            }
            if (spelbeurtSpeler.getSpelerWin()) {
                System.out.println("Gefeliciteerd, je hebt gewonnen!");
                player.addWin();
                gameOver = true; // verander de gameOver-status
            } else {
                spelbeurtComputer.startSpelbeurt();
                if (spelbeurtComputer.getComputerWin()) {
                    System.out.println("Helaas, de computer heeft gewonnen.");
                    gameOver = true; // verander de gameOver-status
                }
            }
        }

        // print de highscores

        //mogelijkheid om opnieuw te spelen met nieuwe characters
        System.out.println("Wil je opnieuw spelen? (ja/nee)");
        String newGame = scanner.nextLine();
        //reset de gekozen characters en start nieuw spel
        if (newGame.equals("ja")) {
            spelbeurtSpeler.reset();
            spelbeurtComputer.reset();
            main(args);
        } else {
            System.out.println("Bedankt voor het spelen!");
        }
    }

}
