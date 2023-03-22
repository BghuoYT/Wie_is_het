package be.kdg.projectbasis.view.hoofdmenu;

import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.view.gegevens.GegevensPresenter;
import be.kdg.projectbasis.view.gegevens.GegevensView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

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