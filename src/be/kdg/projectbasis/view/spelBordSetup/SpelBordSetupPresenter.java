package be.kdg.projectbasis.view.spelBordSetup;

import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.model.character.Character;
import be.kdg.projectbasis.model.character.CharacterlijstComputer;
import be.kdg.projectbasis.model.highscore.HighScoreModel;
import be.kdg.projectbasis.model.spelbeurten.SpelbeurtComputer;
import be.kdg.projectbasis.model.spelbeurten.SpelbeurtSpeler;
import be.kdg.projectbasis.view.spelBord.SpelBordPresenter;
import be.kdg.projectbasis.view.spelBord.SpelBordView;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class SpelBordSetupPresenter {
    private ProgrammaModel model;
    private SpelBordSetupView view;


    public SpelBordSetupPresenter(ProgrammaModel model, SpelBordSetupView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtnSubmit().setOnAction(event -> {
            String gekozenCharacter = view.getTxtKeuze().getText();
            model.setupComputer(gekozenCharacter);
            model.setupSpeler();
            model.refreshCharacters();
            openSpelbord();
        });
        view.getRandomButton().setOnAction(event -> {
            // haal random naam uit view.setCharacters array
            int randomIndex = (int) (Math.random() * SpelBordSetupView.setCharacters.size());
            String gekozenCharacter = SpelBordSetupView.setCharacters.get(randomIndex).getNaam();
            model.setupComputer(gekozenCharacter);
            model.setupSpeler();
            model.refreshCharacters();
            openSpelbord();
        });
    }

    private void openSpelbord() {
        SpelBordView spelBordView = new SpelBordView();
        SpelBordPresenter spelBordPresenter = new SpelBordPresenter(model, spelBordView);
        Scene spelbord = new Scene(spelBordView);
        Main.Window.setScene(spelbord);
        Main.Window.setTitle("Spelbord");
        Main.Window.show();
        Main.Window.setFullScreen(true);
    }


}
