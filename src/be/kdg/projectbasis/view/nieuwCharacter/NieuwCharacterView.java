package be.kdg.projectbasis.view.nieuwCharacter;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class NieuwCharacterView extends HBox {

    private Button btnConfirm;

    private Button btnBack;

    private Label lblnaam;

    private TextField txtnaam;

    private GridPane gridpanestyle;

    public NieuwCharacterView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.gridpanestyle = new GridPane();
        this.txtnaam = new TextField();
        this.lblnaam = new Label("Nieuw Naam: ");
        this.btnConfirm = new Button("Confirm");
        this.btnBack = new Button("Back");
        this.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), new CornerRadii(20), new Insets(1))));
        btnBack.setFont(new Font("Arial Black", 15));
        btnConfirm.setFont(new Font("Arial Black", 15));


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

    public TextField getTxtnaam() {
        return txtnaam;
    }

    public GridPane getGridpanestyle() {
        return gridpanestyle;
    }

    private void layoutNodes() {
        gridpanestyle.add(btnConfirm, 2,6);
        gridpanestyle.add(lblnaam, 0, 0);
        gridpanestyle.add(txtnaam, 3, 0);
        gridpanestyle.add(btnBack,3,6);
        gridpanestyle.setAlignment(Pos.CENTER);
        //GridPane.setHalignment(lblnaam, HPos.RIGHT);
        // gridpanestyle.setHgap(20);
        this.getChildren().add(gridpanestyle);




        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("/be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        this.setBackground(new Background(achtergrondAfbeelding));
        this.setAlignment(Pos.CENTER);

    }


}