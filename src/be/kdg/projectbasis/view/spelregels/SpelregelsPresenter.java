package be.kdg.projectbasis.view.spelregels;

import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.view.gegevens.GegevensPresenter;
import be.kdg.projectbasis.view.gegevens.GegevensView;
import be.kdg.projectbasis.view.spelBord.SpelBordView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class SpelregelsPresenter {
    private final ProgrammaModel model;
    private final SpelregelsView view;

    public SpelregelsPresenter( ProgrammaModel model, SpelregelsView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {





    }

    private void updateView() {

    }

    public void addWindowEventHandlers() {

    }

}