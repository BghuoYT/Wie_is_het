package be.kdg.projectbasis.view.gegevens.newplayer;

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

public class RegisterView extends VBox {

    private Button btnSubmit;

    private Label lblUsername;

    private TextField txtUsername;

    private Label lblVoorNaam;
    private TextField txtVoorNaam;
    private Label lblAchterNaam;
    private TextField txtAchterNaam;
    private Label lblEmail;
    private TextField txtEmail;


    private GridPane gridpanestyle;



    public RegisterView() {
        this.initialiseNodes();
        this.layoutNodes();
    }



    private void initialiseNodes() {
      this.btnSubmit = new Button("registreer");
      this.lblUsername = new StyleLabel("Username: ");
      this.txtUsername = new TextField();
        this.lblVoorNaam = new StyleLabel("Voornaam: ");
        this.txtVoorNaam = new TextField();
        this.lblAchterNaam = new StyleLabel("Achternaam: ");
        this.txtAchterNaam = new TextField();
        this.lblEmail = new StyleLabel("Email: ");
        this.txtEmail = new TextField();
      this.gridpanestyle= new GridPane();


    }

    public Button getBtnSubmit() {
        return btnSubmit;
    }

    public Label getLblUsername() {
        return lblUsername;
    }

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public Label getLblVoorNaam() {
        return lblVoorNaam;
    }

    public TextField getTxtVoorNaam() {
        return txtVoorNaam;
    }

    public Label getLblAchterNaam() {
        return lblAchterNaam;
    }

    public TextField getTxtAchterNaam() {
        return txtAchterNaam;
    }

    public Label getLblEmail() {
        return lblEmail;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public GridPane getGridpanestyle() {
        return gridpanestyle;
    }

    private void layoutNodes() {

        gridpanestyle.add(btnSubmit, 2,6);
        gridpanestyle.add(lblUsername, 0, 0);
        gridpanestyle.add(txtUsername, 3, 0);
        gridpanestyle.add(lblVoorNaam, 0, 1);
        gridpanestyle.add(txtVoorNaam, 3, 1);
        gridpanestyle.add(lblAchterNaam, 0, 2);
        gridpanestyle.add(txtAchterNaam, 3, 2);
        gridpanestyle.add(lblEmail, 0, 3);
        gridpanestyle.add(txtEmail, 3, 3);
        gridpanestyle.setAlignment(Pos.CENTER);
        GridPane.setHalignment(lblUsername, HPos.RIGHT);
        gridpanestyle.setHgap(20);
        this.getChildren().add(gridpanestyle);
        this.btnSubmit.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), new CornerRadii(20), new Insets(1))));



        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true, true));
        this.setBackground(new Background(achtergrondAfbeelding));
        this.setAlignment(Pos.CENTER);
    }



}
