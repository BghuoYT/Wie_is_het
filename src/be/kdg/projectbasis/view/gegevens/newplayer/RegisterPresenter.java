package be.kdg.projectbasis.view.gegevens.newplayer;
import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.model.highscore.HighScoreModel;
import be.kdg.projectbasis.view.spelBord.SpelBordPresenter;
import be.kdg.projectbasis.view.spelBord.SpelBordView;
import be.kdg.projectbasis.view.spelBordSetup.SpelBordSetupPresenter;
import be.kdg.projectbasis.view.spelBordSetup.SpelBordSetupView;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


public class RegisterPresenter {

    private final ProgrammaModel model;
    private final RegisterView view;

    public RegisterPresenter(ProgrammaModel model, RegisterView view) {
        this.model= model;
        this.view = view;
        this.addEventHandlers();
        this.openSpelbord();
    }
    private void addEventHandlers() {
        view.getTxtUsername().setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                if (view.getTxtUsername().getText().matches("[a-z,A-Z]+")) {
                    view.getTxtUsername().setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    view.getTxtUsername().setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                    System.out.println("Voer een geldig Username in");

                }
            }
        });

        view.getTxtVoorNaam().setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                if (view.getTxtVoorNaam().getText().matches("[a-z,A-Z]+")) {
                    view.getTxtVoorNaam().setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    view.getTxtVoorNaam().setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                    System.out.println("Voer een geldig Voornaam in");

                }
            }
        });

        view.getTxtAchterNaam().setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                if (view.getTxtAchterNaam().getText().matches("[a-z,A-Z]+")) {
                    view.getTxtAchterNaam().setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    view.getTxtAchterNaam().setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                    System.out.println("Voer een geldig Achternaam in");

                }
            }
        });

        view.getTxtEmail().setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                if (view.getTxtEmail().getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                    view.getTxtEmail().setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    view.getTxtEmail().setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                    System.out.println("Voer een geldig e-mailadres in");
                }
            }
        });

        view.getBtnSubmit().setOnAction(actionEvent -> {

            String username = view.getTxtUsername().getText();
            String voornaam = view.getTxtVoorNaam().getText();
            String achternaam = view.getTxtAchterNaam().getText();
            String email = view.getTxtEmail().getText();

            if (username.trim().isEmpty() || voornaam.trim().isEmpty() || achternaam.trim().isEmpty() || email.trim().isEmpty()) {
                System.out.println("Vul alle velden in");
                return;
            }

            ProgrammaModel.setUsername(username);
            HighScoreModel newPlayer = new HighScoreModel(username, voornaam, achternaam, email, 0);
            System.out.println(newPlayer);
            HighScoreModel.savePlayerInfo(username, voornaam, achternaam, email, 0);

            // laad de spelerinfo
            HighScoreModel player = HighScoreModel.readHighScore(username); // haal gegevens op van de speler
            if (player != null) {
                // als de speler al bestaat, laad de gegevens uit Highscores.xml en ga door naar SpelbordView
                String firstName = player.getVoornaam();
                String lastName = player.getAchternaam();
                int wins = player.getWins();
                model.setUsername(username);
                System.out.println("Gebruikersnaam gevonden, doorgaan naar spelbord");
                model.characterListComputer();
                openSpelbord();
            }
        });

    }
    private void openSpelbord() {
        SpelBordSetupView spelBordSetupView = new SpelBordSetupView();
        SpelBordSetupPresenter spelBordSetupPresenter = new SpelBordSetupPresenter(model, spelBordSetupView);
        Scene spelBord = new Scene(spelBordSetupView);
        Main.Window.setScene(spelBord);
        Main.Window.setTitle("Spelbord");
        Main.Window.show();
        Main.Window.setFullScreen(true);
    }


    public void addWindowEventHandlers() {

    }
}
