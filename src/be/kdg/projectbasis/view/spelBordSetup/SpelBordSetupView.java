package be.kdg.projectbasis.view.spelBordSetup;

import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.model.character.Character;
import be.kdg.projectbasis.model.character.Enums.*;
import be.kdg.projectbasis.view.standaardElementen.StyleLabel;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.events.Characters;
import java.io.File;
import java.util.ArrayList;

public class SpelBordSetupView extends VBox {

    private VBox characterBox; // container voor de foto's en labels

    private VBox SpelContainer;
    private ToggleButton[] characterPic;
    private Label[] characterName;
    private GridPane GridCharacters;
    private HBox HboxVraag;
    private Label LblKeuze;
    private TextField TxtKeuze;
    private Button BtnSubmit;




    // constructor
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
        characterPic = new ToggleButton[24];



    }

    private void layoutNodes() {
        // Set background image

        // Create grid for characters
        GridCharacters.setAlignment(Pos.CENTER);
        GridCharacters.setHgap(20);
        GridCharacters.setVgap(20);

        // Add character images and names to grid

        // Create box for question and text field
        TxtKeuze.setPrefWidth(100);
        LblKeuze.setPrefWidth(300);
        HboxVraag.setAlignment(Pos.CENTER);
        HboxVraag.setPadding(new Insets(10));
        HboxVraag.setSpacing(10);
        HboxVraag.getChildren().addAll(LblKeuze, TxtKeuze, BtnSubmit);

        // Add grid and box to container
        SpelContainer.setAlignment(Pos.CENTER);
        SpelContainer.setPadding(new Insets(50, 20, 50, 20));
        SpelContainer.setSpacing(50);
        SpelContainer.getChildren().addAll(GridCharacters, HboxVraag);

        // Add container to view
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(SpelContainer);

        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true, true));
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

