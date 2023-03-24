package be.kdg.projectbasis.view.highscore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import be.kdg.projectbasis.model.highscore.HighScoreModel;

public class HighscoreView extends VBox {
    private TableView<HighScoreModel> highscoreTable;
    private TableColumn<HighScoreModel, Integer> plaatsNrCol;
    private TableColumn<HighScoreModel, String> usernameCol;
    private TableColumn<HighScoreModel, Integer> aantalWinsCol;
    private ObservableList<HighScoreModel> highscoreList;


    public HighscoreView(){
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        highscoreTable = new TableView<>();
        plaatsNrCol = new TableColumn<>("PlaatsNr");
        usernameCol = new TableColumn<>("Username");
        aantalWinsCol = new TableColumn<>("AantalWins");
        highscoreList = FXCollections.observableArrayList(HighScoreModel.getPlayers());

        plaatsNrCol.setCellValueFactory(new PropertyValueFactory<>("plaatsNr"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        aantalWinsCol.setCellValueFactory(new PropertyValueFactory<>("wins"));

        highscoreTable.setItems(highscoreList);
        highscoreTable.getColumns().addAll(usernameCol, aantalWinsCol);
    }

    private void layoutNodes() {
        this.getChildren().add(highscoreTable);
    }



}