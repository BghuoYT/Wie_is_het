package be.kdg.projectbasis.view.highscore;
import be.kdg.projectbasis.view.standaardElementen.StyleLabel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import be.kdg.projectbasis.model.highscore.HighScoreModel;
import javafx.stage.Screen;

import java.util.Comparator;
import java.util.stream.IntStream;

import static javafx.geometry.Pos.CENTER;

public class HighscoreView extends VBox {
    private VBox pageContainer;
    private StyleLabel pageLabel;
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
        pageContainer = new VBox();
        pageLabel = new StyleLabel("Highscores");
        highscoreTable = new TableView<>();
        plaatsNrCol = new TableColumn<>("PlaatsNr");
        usernameCol = new TableColumn<>("Username");
        aantalWinsCol = new TableColumn<>("AantalWins");
        highscoreList = FXCollections.observableArrayList(HighScoreModel.getPlayers());

        plaatsNrCol.setCellValueFactory(features -> {
            int index = features.getTableView().getItems().indexOf(features.getValue());
            return new SimpleObjectProperty<>(index + 1);
        });

        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        aantalWinsCol.setCellValueFactory(new PropertyValueFactory<>("wins"));

        aantalWinsCol.setComparator(Comparator.reverseOrder());

        highscoreTable.setItems(highscoreList);
        highscoreTable.getColumns().addAll(plaatsNrCol, usernameCol, aantalWinsCol);
        pageContainer.getChildren().addAll(pageLabel, highscoreTable);
        this.getChildren().addAll(pageLabel, highscoreTable);
    }

    private void layoutNodes() {
        this.setAlignment(CENTER);
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = visualBounds.getWidth();
        double screenHeight = visualBounds.getHeight();

        pageLabel.setAlignment(CENTER);
        pageLabel.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(highscoreTable, Priority.ALWAYS);
        highscoreTable.setMaxWidth(0.5*screenWidth);
        highscoreTable.setMaxHeight(0.5*screenHeight);
        VBox.setVgrow(pageContainer, Priority.ALWAYS);
        pageContainer.setFillWidth(true);
        pageContainer.setAlignment(CENTER);



        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("/be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true, true));
        this.setBackground(new Background(achtergrondAfbeelding));
        this.setAlignment(Pos.CENTER);
    }




}