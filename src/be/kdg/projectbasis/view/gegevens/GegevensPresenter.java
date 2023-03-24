package be.kdg.projectbasis.view.gegevens;
import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.model.highscore.HighScoreModel;
import be.kdg.projectbasis.view.hoofdmenu.HoofdmenuPresenter;
import be.kdg.projectbasis.view.hoofdmenu.HoofdmenuView;
import be.kdg.projectbasis.view.spelBordSetup.SpelBordSetupPresenter;
import be.kdg.projectbasis.view.spelBordSetup.SpelBordSetupView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import be.kdg.projectbasis.view.gegevens.newplayer.RegisterPresenter;
import be.kdg.projectbasis.view.gegevens.newplayer.RegisterView;

public class GegevensPresenter {

    private final ProgrammaModel model;
    private final GegevensView view;

    public GegevensPresenter(ProgrammaModel model, GegevensView view) {
        this.model= model;
        this.view = view;
        this.addEventHandlers();
        this.openSpelbord();
        this.createNewUser();
    }
    private void addEventHandlers() {
        view.getBtnValidate().setOnAction(actionEvent -> {
            // laad de spelerinfo
            String username = view.getTxtUsername().getText(); // haal de username op uit de view
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
            } else {
                // als de speler niet bestaat, open de GegevensViewNewPlayer
                createNewUser();
                System.out.println("Gebruikersnaam niet gevonden, vul je gegevens in om nieuwe gebruiker aan te maken: ");
            }
        });



        view.getBtnBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HoofdmenuView hoofdmenuView = new HoofdmenuView();
                HoofdmenuPresenter hoofdmenuPresenter = new HoofdmenuPresenter(model, hoofdmenuView);
                Scene hoofdmenu = new Scene(hoofdmenuView);
                Main.Window.setScene(hoofdmenu);
                Main.Window.setTitle("Hoofdmenu");
                Main.Window.show();
                Main.Window.setFullScreen(true);
            }
        });
    }

    private void createNewUser() {
        RegisterView registerView = new RegisterView();
        RegisterPresenter registerPresenter = new RegisterPresenter(model, registerView);
        Scene register = new Scene(registerView);
        Main.Window.setScene(register);
        Main.Window.setTitle("Nieuwe gebruiker");
        Main.Window.show();
        Main.Window.setFullScreen(true);
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