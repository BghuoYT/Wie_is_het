package be.kdg.projectbasis.view.highscore;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HighscoreView extends VBox {
    private Label lblPlaats;
    private Label lblNaaminvoer;
    private Label lblAantalbeurtenInvoer;
    private Label lblSpelernaam;
    private Label lblAantalBeurten;
    private Button btnRead;
    private Button btnWrite;

    private TextField txtSpelernaam;
    private TextField txtAantalBeurten;
    private GridPane mijnGridPane;
    private Button btnBack;
    private HBox buttonbox;
    private VBox inputBox;
    private BorderPane inputpane;


    public HighscoreView(){
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {

        lblPlaats = new Label("Rank");

        lblNaaminvoer = new Label("Naam:");
        lblAantalbeurtenInvoer = new Label("Aantal beurten:");
        lblSpelernaam = new Label("Player name:");
        lblAantalBeurten = new Label("Score");
        btnRead = new Button("Lees");
        btnWrite = new Button("Toevoegen");

        txtSpelernaam = new TextField();
        txtAantalBeurten = new TextField();
        mijnGridPane = new GridPane();
        btnBack = new Button("Terug");
        inputpane = new BorderPane();
        buttonbox = new HBox(20);
        inputBox = new VBox(10);
    }



    private void layoutNodes() {

        buttonbox.getChildren().addAll(btnRead, btnWrite,  btnBack);
        buttonbox.setAlignment(Pos.CENTER);

        inputBox.getChildren().addAll(lblNaaminvoer, txtSpelernaam, lblAantalbeurtenInvoer, txtAantalBeurten);
        inputBox.setAlignment(Pos.CENTER);


        inputpane.setCenter(inputBox);
        inputpane.setBottom(buttonbox);
        inputpane.setMaxWidth(400);
        inputpane.setStyle("-fx-background-color: #f5f5f5; -fx-padding: 20px; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-border-color: red; -fx-border-width: 2px;");

        mijnGridPane.setStyle("-fx-background-color: #f5f5f5; -fx-padding: 20px; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-border-color: blue; -fx-border-width: 2px;");

        VBox.setMargin(inputpane, new Insets(20));
        VBox.setMargin(mijnGridPane, new Insets(20));
        VBox.setMargin(btnBack, new Insets(20));

        mijnGridPane.setHgap(75);
        mijnGridPane.setVgap(10);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(mijnGridPane);
        this.getChildren().add(inputpane);

        this.setPrefSize(800, 800);

    }

    public Label getLblPlaats() {
        return lblPlaats;
    }

    public Label getLblNaaminvoer() {
        return lblNaaminvoer;
    }

    public Label getLblAantalbeurtenInvoer() {
        return lblAantalbeurtenInvoer;
    }

    public Label getLblSpelernaam() {
        return lblSpelernaam;
    }

    public Label getLblAantalBeurten() {
        return lblAantalBeurten;
    }

    public Button getBtnRead() {
        return btnRead;
    }

    public Button getBtnWrite() {
        return btnWrite;
    }

    public TextField getTxtSpelernaam() {
        return txtSpelernaam;
    }

    public TextField getTxtAantalBeurten() {
        return txtAantalBeurten;
    }

    public GridPane getMijnGridPane() {
        return mijnGridPane;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public HBox getButtonbox() {
        return buttonbox;
    }

    public VBox getInputBox() {
        return inputBox;
    }

    public BorderPane getInputpane() {
        return inputpane;
    }
}