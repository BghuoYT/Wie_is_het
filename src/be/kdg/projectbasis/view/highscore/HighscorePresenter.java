package be.kdg.projectbasis.view.highscore;

import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.model.highscore.HighScoreModel;
import be.kdg.projectbasis.view.hoofdmenu.HoofdmenuPresenter;
import be.kdg.projectbasis.view.hoofdmenu.HoofdmenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.util.List;
import java.util.TreeSet;

public class HighscorePresenter {

    private ProgrammaModel model;
    private HighscoreView view; //Pas het type van de view aan naar de view die samenhangt met deze presenter

    public HighscorePresenter(ProgrammaModel model, HighscoreView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();

    }


    private void addEventHandlers() {
        view.getBtnBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HoofdmenuView hoofdmenuView = new HoofdmenuView();
                HoofdmenuPresenter hoofdmenuPresenter = new HoofdmenuPresenter(model, hoofdmenuView);
                Scene Hoofdmenu = new Scene(hoofdmenuView);
                Main.Window.setScene(Hoofdmenu);
                Main.Window.setTitle("Hoofdmenu");
                Main.Window.show();
                Main.Window.setFullScreen(true);
            }
        });
    }


    private void updateView() {

    }

    private void addWindowEventHandlers(){

    }

}