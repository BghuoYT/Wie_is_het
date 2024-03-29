package be.kdg.projectbasis.view.gegevens;

import be.kdg.projectbasis.view.standaardElementen.StyleLabel;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GegevensView extends VBox {

    private Button btnValidate;

    private Label lblUsername;

    private TextField txtUsername;

    private GridPane gridpanestyle;

    private Button btnBack;



    public GegevensView() {
        this.initialiseNodes();
        this.layoutNodes();
    }



    private void initialiseNodes() {
        this.btnValidate = new Button("Validate Info");
        this.lblUsername = new StyleLabel("Username: ");
        this.txtUsername = new TextField();
        this.gridpanestyle= new GridPane();
        this.btnBack = new Button("Back");


    }

    public Button getBtnValidate() {
        return btnValidate;
    }

    public Label getLblUsername() {
        return lblUsername;
    }

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public GridPane getGridpanestyle() {
        return gridpanestyle;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    private void layoutNodes() {

        gridpanestyle.add(btnValidate, 2,6);
        gridpanestyle.add(lblUsername, 0, 0);
        gridpanestyle.add(txtUsername, 3, 0);
        gridpanestyle.add(btnBack,3,6);
        gridpanestyle.setAlignment(Pos.CENTER);
        GridPane.setHalignment(lblUsername, HPos.RIGHT);
        gridpanestyle.setHgap(20);
        this.getChildren().add(gridpanestyle);
        this.btnValidate.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), new CornerRadii(20), new Insets(1))));
        this.btnBack.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), new CornerRadii(20), new Insets(1))));




        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true, true));
        this.setBackground(new Background(achtergrondAfbeelding));
        this.setAlignment(Pos.CENTER);
    }




}