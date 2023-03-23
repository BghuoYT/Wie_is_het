package be.kdg.projectbasis.view.hoofdmenu;

import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.view.gegevens.GegevensPresenter;
import be.kdg.projectbasis.view.gegevens.GegevensView;
import be.kdg.projectbasis.view.highscore.HighscorePresenter;
import be.kdg.projectbasis.view.highscore.HighscoreView;
import be.kdg.projectbasis.view.nieuwCharacter.NieuwCharacterPresenter;
import be.kdg.projectbasis.view.nieuwCharacter.NieuwCharacterView;
import be.kdg.projectbasis.view.spelregels.SpelregelsPresenter;
import be.kdg.projectbasis.view.spelregels.SpelregelsView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

public class HoofdmenuPresenter {

    private final ProgrammaModel model;

    private final HoofdmenuView view;

    public HoofdmenuPresenter(ProgrammaModel model,HoofdmenuView view) {
        this.model = model;
        this.view = view;
        this.addEventHandelers();
        this.updateView();

    }


    private void addEventHandelers() {
        view.getBtnNieuwSpel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                updateView();
            }
        });

        view.getBtnHoogsteScores().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HighscoreView highscoreView = new HighscoreView();
                HighscorePresenter highscorePresenter = new HighscorePresenter(model, highscoreView);
                Scene highscoren = new Scene(highscoreView);
                Main.Window.setScene(highscoren);
                Main.Window.setTitle("Highscoren");
                Main.Window.show();
                Main.Window.setFullScreen(true);
            }
        });

        view.getBtnHandleiding().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SpelregelsView spelregelsView = new SpelregelsView();
                SpelregelsPresenter spelregelsPresenter = new SpelregelsPresenter(model,spelregelsView);
                Stage spelRegelStage = new Stage();
                spelRegelStage.initOwner(view.getScene().getWindow());
                spelRegelStage.initModality(Modality.APPLICATION_MODAL);
                spelRegelStage.setScene(new Scene(spelregelsView));
                spelRegelStage.setX(view.getScene().getWindow().getX() + 100);
                spelRegelStage.setY(view.getScene().getWindow().getY() + 100);
                spelRegelStage.setTitle("Spelregels");
                spelRegelStage.showAndWait();
            }
        });

        view.getBtnNieuwcharacters().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NieuwCharacterView nieuwCharacterView = new NieuwCharacterView();
                NieuwCharacterPresenter nieuwCharacterPresenter = new NieuwCharacterPresenter(model, nieuwCharacterView);
                Scene nieuwcharacter = new Scene(nieuwCharacterView);
                Main.Window.setScene(nieuwcharacter);
                Main.Window.setTitle("Nieuw Characters");
                Main.Window.show();
                Main.Window.setFullScreen(true);
            }
        });

        view.getBtnAfsluiten().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Afsluiten");
                alert.setHeaderText("Wil u de spel afsluiten ?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent()&& result.get() == ButtonType.OK){
                    System.exit(0);
                }

            }
        });

    }

    private void updateView() {
        GegevensView gegevensView = new GegevensView();
        GegevensPresenter gegevensPresenter = new GegevensPresenter(model,gegevensView);
        Scene gegevens = new Scene(gegevensView);
        Main.Window.setScene(gegevens);
        Main.Window.setTitle("speler gegevens");
        Main.Window.show();
        Main.Window.setFullScreen(true);
    }


    public void addWindowEventHandlers() {
    }
}