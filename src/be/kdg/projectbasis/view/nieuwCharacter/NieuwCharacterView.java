package be.kdg.projectbasis.view.nieuwCharacter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class NieuwCharacterView extends HBox {

    private Button btnConfirm;

    private Button btnBack;


    public NieuwCharacterView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.btnConfirm = new Button("Confirm");
        this.btnBack = new Button("Back");
        this.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), new CornerRadii(20), new Insets(1))));
        btnBack.setFont(new Font("Arial Black", 24));
        btnConfirm.setFont(new Font("Arial Black", 24));


    }

    public Button getBtnConfirm() {
        return btnConfirm;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    private void layoutNodes() {
        this.getChildren().add(btnConfirm);
        this.getChildren().add(btnBack);
        this.setAlignment(Pos.BOTTOM_CENTER);
        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("/be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true, true));
        this.setBackground(new Background(achtergrondAfbeelding));
    }


}