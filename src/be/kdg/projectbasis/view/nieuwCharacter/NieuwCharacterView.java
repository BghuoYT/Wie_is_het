package be.kdg.projectbasis.view.nieuwCharacter;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.File;

public class NieuwCharacterView extends HBox {

    private Button btnConfirm;
    private Button btnBack;
    private Label lblnaam;
    private Label lblgeslacht;
    private Label lbloogkleur;
    private Label lblhaarkleur;
    private Label lblhaarlengte;
    private Label lblhaarstijl;
    private Label lblgezichtsbeharing;
    private Label lblhoofddeksel;
    private Label lblaccessoires;
    private Label lblAfbeelding;
    private TextField txtnaam;
    private ComboBox<String> cbgeslacht;
    private ComboBox<String> cboogkleur;
    private ComboBox<String> cbhaarkleur;
    private ComboBox<String> cbhaarlengte;
    private ComboBox<String> cbhaarstijl;
    private ComboBox<String> cbgezichtsbeharing;
    private ComboBox<String> cbhoofddeksel;
    private ComboBox<String> cbaccessoires;
    private GridPane gridpanestyle;
    private ImageView imgAfbeelding;
    private Button btnKiesAfbeelding;

    public NieuwCharacterView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        gridpanestyle = new GridPane();
        lblnaam = new Label("Naam:");
        lblgeslacht = new Label("Geslacht:");
        lbloogkleur = new Label("Oogkleur:");
        lblhaarkleur = new Label("Haarkleur:");
        lblhaarlengte = new Label("Haarlengte:");
        lblhaarstijl = new Label("Haarstijl:");
        lblgezichtsbeharing = new Label("Gezichtsbeharing:");
        lblhoofddeksel = new Label("Hoofddeksel:");
        lblaccessoires = new Label("Accessoires:");
        lblAfbeelding = new Label("Afbeelding:");
        txtnaam = new TextField();
        cbgeslacht = new ComboBox<>();
        cbgeslacht.getItems().addAll("vrouw", "man");
        cboogkleur = new ComboBox<>();
        cboogkleur.getItems().addAll("bruin", "blauw", "groen", "grijs");
        cbhaarkleur = new ComboBox<>();
        cbhaarkleur.getItems().addAll("blond", "bruin", "zwart", "rood", "kaal");
        cbhaarlengte = new ComboBox<>();
        cbhaarlengte.getItems().addAll("kaal", "kort", "schouderlengte", "lang");
        cbhaarstijl = new ComboBox<>();
        cbhaarstijl.getItems().addAll("krullen", "golvend", "stijl", "kaal");
        cbgezichtsbeharing = new ComboBox<>();
        cbgezichtsbeharing.getItems().addAll("baard", "snor", "geen");
        cbhoofddeksel = new ComboBox<>();
        cbhoofddeksel.getItems().addAll("hoed", "pet", "muts", "geen");
        cbaccessoires = new ComboBox<>();
        cbaccessoires.getItems().addAll("bril", "halsketting", "oorbellen", "geen");

        // Voeg een ImageView en een knop toe voor het kiezen van een afbeelding
        imgAfbeelding = new ImageView();
        btnKiesAfbeelding = new Button("Kies afbeelding");
        btnKiesAfbeelding.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                imgAfbeelding.setImage(image);
            }
        });

       btnConfirm = new Button("Bevestigen");
       btnBack = new Button("Terug");
        this.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), new CornerRadii(20), new Insets(1))));
        btnBack.setFont(new Font("Arial Black", 15));
        btnConfirm.setFont(new Font("Arial Black", 15));

    }
    private void layoutNodes() {
        // Maak rijen en kolommen even breed
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(25);
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(40);

        // Voeg rijen en kolommen toe aan de GridPane
        GridPane gridPane = new GridPane();
        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints, columnConstraints, columnConstraints);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints, rowConstraints, rowConstraints, rowConstraints, rowConstraints, rowConstraints);

// Voeg alle labels en inputvelden toe aan de GridPane
        gridPane.add(lblnaam, 0, 0);
        gridPane.add(txtnaam, 1, 0, 3, 1);
        gridPane.add(lblgeslacht, 0, 1);
        gridPane.add(cbgeslacht, 1, 1);
        gridPane.add(lbloogkleur, 0, 2);
        gridPane.add(cboogkleur, 1, 2);
        gridPane.add(lblhaarkleur, 0, 3);
        gridPane.add(cbhaarkleur, 1, 3);
        gridPane.add(lblhaarlengte, 0, 4);
        gridPane.add(cbhaarlengte, 1, 4);
        gridPane.add(lblhaarstijl, 0, 5);
        gridPane.add(cbhaarstijl, 1, 5);
        gridPane.add(lblgezichtsbeharing, 0, 6);
        gridPane.add(cbgezichtsbeharing, 1, 6);
        gridPane.add(lblhoofddeksel, 2, 1);
        gridPane.add(cbhoofddeksel, 3, 1);
        gridPane.add(lblaccessoires, 2, 2);
        gridPane.add(cbaccessoires, 3, 2);
        gridPane.add(lblAfbeelding, 2, 3);
        gridPane.add(imgAfbeelding, 3, 3, 1, 3);
        gridPane.add(btnKiesAfbeelding, 3, 6);
        gridPane.add(btnConfirm, 2, 7);
        gridPane.add(btnBack, 3, 7);

        imgAfbeelding.setFitWidth(50);
        imgAfbeelding.setFitHeight(50/3*4);


// Voeg stijlen toe aan de GridPane
        gridPane.setPadding(new Insets(20));
        gridPane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), new Insets(-10))));
        gridPane.setAlignment(Pos.CENTER);

// Voeg de GridPane toe aan de HBox
        this.getChildren().addAll(gridPane);
        this.setAlignment(Pos.CENTER);

// Pas de styling van de HBox aan
        this.setSpacing(20);

        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("/be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        this.setBackground(new Background(achtergrondAfbeelding));
        this.setAlignment(Pos.CENTER);

    }
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public Label getLblnaam() {
        return lblnaam;
    }

    public Label getLblgeslacht() {
        return lblgeslacht;
    }

    public Label getLbloogkleur() {
        return lbloogkleur;
    }

    public Label getLblhaarkleur() {
        return lblhaarkleur;
    }

    public Label getLblhaarlengte() {
        return lblhaarlengte;
    }

    public Label getLblhaarstijl() {
        return lblhaarstijl;
    }

    public Label getLblgezichtsbeharing() {
        return lblgezichtsbeharing;
    }

    public Label getLblhoofddeksel() {
        return lblhoofddeksel;
    }

    public Label getLblaccessoires() {
        return lblaccessoires;
    }

    public Label getLblAfbeelding() {
        return lblAfbeelding;
    }

    public TextField getTxtnaam() {
        return txtnaam;
    }

    public ComboBox<String> getCbgeslacht() {
        return cbgeslacht;
    }

    public ComboBox<String> getCboogkleur() {
        return cboogkleur;
    }

    public ComboBox<String> getCbhaarkleur() {
        return cbhaarkleur;
    }

    public ComboBox<String> getCbhaarlengte() {
        return cbhaarlengte;
    }

    public ComboBox<String> getCbhaarstijl() {
        return cbhaarstijl;
    }

    public ComboBox<String> getCbgezichtsbeharing() {
        return cbgezichtsbeharing;
    }

    public ComboBox<String> getCbhoofddeksel() {
        return cbhoofddeksel;
    }

    public ComboBox<String> getCbaccessoires() {
        return cbaccessoires;
    }

    public GridPane getGridpanestyle() {
        return gridpanestyle;
    }

    public ImageView getImgAfbeelding() {
        return imgAfbeelding;
    }

    public Button getBtnKiesAfbeelding() {
        return btnKiesAfbeelding;
    }



}