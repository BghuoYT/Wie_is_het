package be.kdg.projectbasis.view.spelBord;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.model.character.Character;
import be.kdg.projectbasis.view.standaardElementen.CharacterButton;
import be.kdg.projectbasis.view.standaardElementen.StyleLabel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

import java.util.ArrayList;


public class SpelBordView extends VBox {


    public static int setAantalCharacters;
    public static ArrayList<Character> setCharacters;
    public static ArrayList<Character> setRemainingCharactersC;
    private static String ComputerVraag;

    private static String ComputerAntwoord;
    private VBox SpelContainer;
    private ImageView[] characterPic;
    private CharacterButton[] characterName;
    private GridPane GridCharacters;
    private VBox VBoxPrev;
    private StyleLabel LblPrev;
    private Label LblVorigeVraag;
    private StyleLabel LblPrevA;
    private Label LblAntwoord;
    private HBox HboxVraag;
    private StyleLabel LblVraag;
    private TextField TxtVraag;
    private Button BtnVraag;
    private HBox HboxGok;
    private StyleLabel LblGok;
    private TextField TxtGok;
    private Button BtnGok;
    private StyleLabel LblComputerAntwoordIn;
    private StyleLabel LblComputerVraagIn;
    private Label LblComputerAntwoord;
    private Label LblComputerVraag;
    private VBox[] VboxCharacter;
    private int i;
    private VBox Computerview;
    private ProgrammaModel programmaModel = new ProgrammaModel();
    private VBox inputs;
    private HBox logics;

    public SpelBordView() {
        this.programmaModel = programmaModel;
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        SpelContainer = new VBox();
        GridCharacters = new GridPane();
        VBoxPrev = new VBox();
        LblPrev = new StyleLabel("Vorige vraag: ");
        LblVorigeVraag = new Label("nog geen vraag gesteld");
        LblPrevA = new StyleLabel("     Antwoord: ");
        LblAntwoord = new Label("nog geen antwoord");
        HboxVraag = new HBox();
        LblVraag = new StyleLabel("Vraag");
        TxtVraag = new TextField();
        BtnVraag = new Button("Vraag");
        HboxGok = new HBox();
        LblGok = new StyleLabel("Gok");
        TxtGok = new TextField();
        BtnGok = new Button("Gok");
        LblComputerAntwoordIn = new StyleLabel("Computer antwoord:");
        LblComputerVraagIn = new StyleLabel("Computer vraag:");
        LblComputerAntwoord = new Label("Computer antwoord");
        LblComputerVraag = new Label("Computer vraag");
        Computerview = new VBox();
        inputs = new VBox();
        logics = new HBox();
        System.out.println("aantal characters: " + setAantalCharacters);
        System.out.println("deze characters doen mee " + setCharacters);

        //maak voor elk character in de setCharacters array een label aan met de naam
        characterName = new CharacterButton[setCharacters.size()];
        characterPic = new ImageView[setCharacters.size()];
        VboxCharacter = new VBox[setCharacters.size()];
        for (Character character : setCharacters) {
            characterName[i] = new CharacterButton(character.getNaam());
            characterPic[i] = new ImageView(character.getAfbeelding());
            VboxCharacter[i] = new VBox();

            // Informatie als je over het foto hovert
            Tooltip tooltip = new Tooltip(character.getNaam().toUpperCase() + "\ngeslacht: " + character.getGeslacht() + "\noogkleur: " + character.getOogkleur() +"\nhaarkleur: " + character.getHaarKleur() + "\nhaarlengte: "
                    + character.getHaarlengte() + "\nhaarstijl: " + character.getHaarStijl() + "\ngezichtsbeharing: " + character.getGezichtsbeharing() + "\nhoofddeksel: " + character.getHoofddeksel() + "\naccessoires: " + character.getAccessoires() + "\nKlik op de naam om te verwijderen");
            Tooltip.install(characterPic[i], tooltip);

            //info als je over naam hovert
            Tooltip tooltip2 = new Tooltip("klik hier om "+ character.getNaam().toUpperCase() + " uit het spelbord te verwijderen \nHover over de afbeelding voor info over het personage");
            Tooltip.install(characterName[i], tooltip2);
            VboxCharacter[i].getChildren().addAll(characterPic[i], characterName[i]);
            GridCharacters.add(VboxCharacter[i],i % 7, i % 3);

            i++;
        }

    }

    private void layoutNodes() {
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = visualBounds.getWidth();
        double screenHeight = visualBounds.getHeight();

        VBoxPrev.getChildren().addAll(LblPrev, LblVorigeVraag, LblPrevA, LblAntwoord);
        HboxVraag.getChildren().addAll(LblVraag, TxtVraag, BtnVraag);
        HboxGok.getChildren().addAll(LblGok, TxtGok, BtnGok);
        inputs.getChildren().addAll(HboxVraag, HboxGok);
        Computerview.getChildren().addAll(LblComputerVraagIn,LblComputerVraag,LblComputerAntwoordIn,LblComputerAntwoord);
        logics.getChildren().addAll(VBoxPrev, Computerview);
        SpelContainer.getChildren().addAll(GridCharacters, logics, inputs);
        this.getChildren().add(SpelContainer);

        this.BtnVraag.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), new CornerRadii(20), new Insets(1))));
        this.BtnGok.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.5), new CornerRadii(20), new Insets(1))));

        SpelContainer.setPadding(new Insets(10, 10, 10, 10));
        VBoxPrev.setPadding(new Insets(10, 10, 10, 10));
        Computerview.setPadding(new Insets(10, 10, 10, 10));
        HboxVraag.setPadding(new Insets(10, 10, 10, 10));
        HboxGok.setPadding(new Insets(10, 10, 10, 10));
        GridCharacters.setPadding(new Insets(10, 10, 10, 10));
        TxtVraag.setPadding(new Insets(10, 10, 10, 10));
        TxtGok.setPadding(new Insets(10, 10, 10, 10));
        BtnVraag.setPadding(new Insets(10, 10, 10, 10));
        BtnGok.setPadding(new Insets(10));

        HboxVraag.setSpacing(10);
        Computerview.setSpacing(10);
        HboxGok.setSpacing(10);
        VBoxPrev.setSpacing(10);
        TxtVraag.setMinWidth(100);
        TxtGok.setMinWidth(100);
        BtnVraag.setMinWidth(50);
        BtnGok.setMinWidth(50);

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
        logics.setSpacing(20);
        GridCharacters.setMaxWidth(0.5 * screenWidth);
        GridCharacters.setMaxHeight(0.5 * screenHeight);

        VBoxPrev.setAlignment(Pos.CENTER);
        logics.setAlignment(Pos.CENTER);
        HboxVraag.setAlignment(Pos.CENTER);
        HboxGok.setAlignment(Pos.CENTER);
        GridCharacters.setAlignment(Pos.CENTER);
        TxtVraag.setAlignment(Pos.CENTER);
        TxtGok.setAlignment(Pos.CENTER);
        BtnVraag.setAlignment(Pos.CENTER);
        BtnGok.setAlignment(Pos.CENTER);
        LblVraag.setAlignment(Pos.CENTER);
        LblGok.setAlignment(Pos.CENTER);
        SpelContainer.setAlignment(Pos.CENTER);
        LblPrev.setAlignment(Pos.CENTER);
        LblVorigeVraag.setAlignment(Pos.CENTER);
        LblPrevA.setAlignment(Pos.CENTER);
        LblAntwoord.setAlignment(Pos.CENTER);
        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true, true));
        this.setBackground(new Background(achtergrondAfbeelding));
        this.setAlignment(Pos.CENTER);
        }

    public Button getBtnVraag() {
        return BtnVraag;
    }

    public Button getBtnGok() {
        return BtnGok;
    }

    public TextField getTxtVraag() {
        return TxtVraag;
    }

    public TextField getTxtGok() {
        return TxtGok;
    }

    public Label getLblVorigeVraag() {
        return LblVorigeVraag;
    }

    public Label getLblAntwoord() {
        return LblAntwoord;
    }

    public ImageView[] getCharacterPic() {
        return characterPic;
    }

    public CharacterButton[] getCharacterName() {
        return characterName;
    }
    public VBox[] getVboxCharacter() {
        return VboxCharacter;
    }

    @FunctionalInterface
    public interface ButtonActionHandler {
        void handleAction(int index);
    }

    ButtonActionHandler handler = new ButtonActionHandler() {
        @Override
        public void handleAction(int index) {
            characterPic[index].setVisible(false);
            characterName[index].setVisible(false);
        }
    };

    public Label getLblComputerAntwoord() {
        return LblComputerAntwoord;
    }

    public Label getLblComputerVraag() {
        return LblComputerVraag;
    }
    public String getComputerVraag() {
        return ComputerVraag;
    }

    public String getComputerAntwoord() {
        return ComputerAntwoord;
    }

    public static void setComputerVraag(String computerVraag) {
        ComputerVraag = computerVraag;
    }

    public static void setComputerAntwoord(String computerAntwoord) {
        ComputerAntwoord = computerAntwoord;
    }

    }

