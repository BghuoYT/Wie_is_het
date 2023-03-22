package be.kdg.projectbasis.view.spelBordSetup;

import be.kdg.projectbasis.view.standaardElementen.StyleButton;
import be.kdg.projectbasis.view.standaardElementen.StyleLabel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class SpelBordSetupView extends VBox {



        private VBox SpelContainer;

        private ImageView[] CharacterPic;
        private Label[] CharacterName;
        private GridPane GridCharacters;
        private HBox HboxVraag;
        private Label LblKeuze;
        private TextField TxtKeuze;
        private Button BtnSubmit;



    public SpelBordSetupView() {
            this.initialiseNodes();
            this.layoutNodes();
        }

        private void initialiseNodes() {
            SpelContainer = new VBox();
            GridCharacters = new GridPane();
            HboxVraag = new HBox();
            LblKeuze = new StyleLabel("kies een character dat de computer moet raden");
            TxtKeuze = new TextField();
            BtnSubmit = new Button("OK");
        }

        private void layoutNodes() {

            HboxVraag.getChildren().addAll(LblKeuze, TxtKeuze, BtnSubmit);

            SpelContainer.getChildren().addAll(GridCharacters, HboxVraag);
            this.getChildren().add(SpelContainer);

            //center everything
            SpelContainer.setAlignment(Pos.CENTER);
            HboxVraag.setAlignment(Pos.CENTER);
            GridCharacters.setAlignment(Pos.CENTER);

            //center label text
            LblKeuze.setAlignment(Pos.CENTER);

            //give evrything padding of 10 on all sides so it looks nice
            SpelContainer.setPadding(new Insets(10, 10, 10, 10));
            HboxVraag.setPadding(new Insets(10, 10, 10, 10));
            GridCharacters.setPadding(new Insets(10, 10, 10, 10));
            LblKeuze.setPadding(new Insets(10, 10, 10, 10));
            TxtKeuze.setPadding(new Insets(10, 10, 10, 10));
            BtnSubmit.setPadding(new Insets(10, 10, 10, 10));

            //set hbox spacing to 10
            HboxVraag.setSpacing(10);

            //make every label the same size
            LblKeuze.setMinWidth(100);

            //make every textfield the same size
            TxtKeuze.setMinWidth(100);

            //make every button the same size
            BtnSubmit.setMinWidth(50);

            BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("/be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true, true));
            this.setBackground(new Background(achtergrondAfbeelding));
            this.setAlignment(Pos.CENTER);
        }

    public TextField getTxtKeuze() {
        return TxtKeuze;
    }

    public Button getBtnSubmit() {
        return BtnSubmit;
    }
}

