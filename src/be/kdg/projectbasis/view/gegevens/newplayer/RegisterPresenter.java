package be.kdg.projectbasis.view.gegevens.newplayer;
import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.model.highscore.HighScoreModel;
import be.kdg.projectbasis.view.spelBord.SpelBordPresenter;
import be.kdg.projectbasis.view.spelBord.SpelBordView;
import be.kdg.projectbasis.view.spelBordSetup.SpelBordSetupPresenter;
import be.kdg.projectbasis.view.spelBordSetup.SpelBordSetupView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;


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
        view.getBtnSubmit().setOnAction(actionEvent -> {
            //maak een nieuwe gebruiker aan in de highscore.xml
            //velden mogen niet leeg zijn en email moet een @ bevatten
            String username = view.getTxtUsername().getText();
            String voornaam = view.getTxtVoorNaam().getText();
            String achternaam = view.getTxtAchterNaam().getText();
            String email = view.getTxtEmail().getText();

            if (username.trim().isEmpty() || voornaam.trim().isEmpty() || achternaam.trim().isEmpty() || email.trim().isEmpty()) {
                System.out.println("Vul alle velden in");
                return;
            }
            if (!email.contains("@") || !email.contains(".")) {
                System.out.println("Voer een geldig e-mailadres in");
                return;
            }
            ProgrammaModel.setUsername(username);
            HighScoreModel newPlayer = new HighScoreModel(username, voornaam, achternaam, email, 0);
            System.out.println(newPlayer);
            HighScoreModel.savePlayerInfo(username, voornaam, achternaam, email, 0);
            // laad de spelerinfo
            System.out.println("gebruiker aangemaakt, doorgaan naar spelbord");
            openSpelbord();
        });

    }
    private void openSpelbord() {
        ProgrammaModel model = new ProgrammaModel();
        SpelBordSetupView spelBordSetupView = new SpelBordSetupView(model);
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
