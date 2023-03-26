package be.kdg.projectbasis.view.Tussenmenu;

import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.view.gegevens.GegevensPresenter;
import be.kdg.projectbasis.view.gegevens.GegevensView;
import be.kdg.projectbasis.view.hoofdmenu.HoofdmenuPresenter;
import be.kdg.projectbasis.view.hoofdmenu.HoofdmenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class TussenmenuPresenter {

    private final ProgrammaModel model;

    private final TussenmenuView view;

    public TussenmenuPresenter(ProgrammaModel model, TussenmenuView view) {
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

        view.getBtnHoofdMenu().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HoofdmenuView hoofdmenuView = new HoofdmenuView();
                HoofdmenuPresenter hoofdmenuPresenter = new HoofdmenuPresenter(model, hoofdmenuView);
                Scene hoofdmenu = new Scene(hoofdmenuView);
                Main.Window.setScene(hoofdmenu);
                Main.Window.setTitle("Hoofdmenu");
                Main.Window.show();
                Main.Window.setFullScreen(true);
            }
        });

        view.getBtnAfsluiten().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Afsluiten");
                alert.setHeaderText("Wil u het spel afsluiten ?");
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