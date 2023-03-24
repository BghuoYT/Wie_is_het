package be.kdg.projectbasis.view.spelBordSetup;

import be.kdg.projectbasis.model.character.Character;
import be.kdg.projectbasis.view.standaardElementen.CharacterButton;
import be.kdg.projectbasis.view.standaardElementen.StyleLabel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Tooltip;
import javafx.stage.Screen;

import java.util.ArrayList;

public class SpelBordSetupView extends VBox {

    private VBox characterBox; // container voor de foto's en labels

    private VBox SpelContainer;
    private ImageView[] characterPic;
    private CharacterButton[] characterName;
    private GridPane GridCharacters;
    private HBox HboxVraag;
    private Label LblKeuze;
    private TextField TxtKeuze;
    private Button BtnSubmit;

    public static ArrayList<Character> setCharacters;
    private VBox[] VboxCharacter;
    private int i = 0;

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

        if (setCharacters != null) {
            characterName = new CharacterButton[setCharacters.size()];
            characterPic = new ImageView[setCharacters.size()];
            VboxCharacter = new VBox[setCharacters.size()];
            for (Character character : setCharacters) {
                characterName[i] = new CharacterButton(character.getNaam());
                characterPic[i] = new ImageView(character.getAfbeelding());
                VboxCharacter[i] = new VBox();

                // Informatie als je over het foto hovert
                Tooltip tooltip = new Tooltip(character.getNaam().toUpperCase() + "\ngeslacht: " + character.getGeslacht() + "\noogkleur: " + character.getOogkleur() + "\nhaarkleur: " + character.getHaarKleur() + "\nhaarlengte: "
                        + character.getHaarlengte() + "\nhaarstijl: " + character.getHaarStijl() + "\ngezichtsbeharing: " + character.getGezichtsbeharing() + "\nhoofddeksel: " + character.getHoofddeksel() + "\naccessoires: " + character.getAccessoires());
                Tooltip.install(characterPic[i], tooltip);
                
                VboxCharacter[i].getChildren().addAll(characterPic[i], characterName[i]);
                GridCharacters.add(VboxCharacter[i], i % 7, i % 3);

                i++;
            }
        }

    }

    private void layoutNodes() {
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = visualBounds.getWidth();
        double screenHeight = visualBounds.getHeight();


        if (setCharacters != null) {
            for (int i = 0; i < VboxCharacter.length; i++) {
                characterPic[i].setFitHeight(0.15 * screenHeight);
                characterPic[i].setFitWidth((0.15 / 4 * 3 ) * screenHeight);
                VboxCharacter[i].setMinHeight((0.10 / 3 * 5) * screenHeight);
                VboxCharacter[i].setMinWidth(0.08 * screenWidth);
                VboxCharacter[i].setMaxWidth(0.15 * screenWidth);
                VboxCharacter[i].setMaxHeight((0.15 / 3 * 5) * screenHeight);
                VboxCharacter[i].setSpacing(10);
            }
        }
        GridCharacters.setVgap(25);
        GridCharacters.setMaxWidth(0.5 * screenWidth);
        GridCharacters.setMaxHeight(0.5 * screenHeight);

        TxtKeuze.setPrefWidth(0.1 * screenWidth);
        HboxVraag.setAlignment(Pos.CENTER);
        HboxVraag.setPadding(new Insets(0.02 * screenHeight));
        HboxVraag.setSpacing(0.01 * screenWidth);
        HboxVraag.getChildren().addAll(LblKeuze, TxtKeuze, BtnSubmit);

        SpelContainer.setAlignment(Pos.CENTER);
        SpelContainer.setPadding(new Insets(0.05 * screenHeight, 0.02 * screenWidth, 0.05 * screenHeight, 0.02 * screenWidth));
        SpelContainer.setSpacing(0.05 * screenHeight);
        SpelContainer.getChildren().addAll(GridCharacters, HboxVraag);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(SpelContainer);

        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(screenWidth, screenHeight, true, true, true, true)); // gebruik de breedte en hoogte van het scherm
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

