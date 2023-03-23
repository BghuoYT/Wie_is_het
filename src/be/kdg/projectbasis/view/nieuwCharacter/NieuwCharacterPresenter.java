package be.kdg.projectbasis.view.nieuwCharacter;

import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.view.gegevens.GegevensPresenter;
import be.kdg.projectbasis.view.gegevens.GegevensView;
import be.kdg.projectbasis.view.hoofdmenu.HoofdmenuPresenter;
import be.kdg.projectbasis.view.hoofdmenu.HoofdmenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class NieuwCharacterPresenter {
    private final ProgrammaModel model;

    private final NieuwCharacterView view;


    public NieuwCharacterPresenter(ProgrammaModel model, NieuwCharacterView view) {
        this.model = model;
        this.view = view;
        this.addEventHandelers();
        this.updateView();
    }
    private void addEventHandelers() {
        view.getBtnBack().setOnAction(event -> {
            HoofdmenuView hoofdmenuView = new HoofdmenuView();
            HoofdmenuPresenter hoofdmenuPresenter = new HoofdmenuPresenter(model,hoofdmenuView);
            Scene hoofdmenu = new Scene(hoofdmenuView);
            Main.Window.setScene(hoofdmenu);
            Main.Window.setTitle("Hoofdmenu");
            Main.Window.show();
            Main.Window.setFullScreen(true);
        });


    }



    private void updateView() {

    }

}