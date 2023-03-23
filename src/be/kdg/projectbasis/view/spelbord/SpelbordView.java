package be.kdg.projectbasis.view.spelBord;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.model.character.Character;
import be.kdg.projectbasis.view.standaardElementen.CharacterButton;
import be.kdg.projectbasis.view.standaardElementen.StyleLabel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.util.ArrayList;


public class SpelBordView extends VBox {


    public static int setAantalCharacters;
    public static ArrayList<Character> setCharacters;
    private VBox SpelContainer;
    private ImageView[] characterPic;
    private CharacterButton[] characterName;
    private GridPane GridCharacters;
    private HBox HBoxPrev;
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

    private VBox[] VboxCharacter;
    private int i;

    private ProgrammaModel programmaModel = new ProgrammaModel();

    public SpelBordView() {
        this.programmaModel = programmaModel;
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        SpelContainer = new VBox();
        GridCharacters = new GridPane();
        HBoxPrev = new HBox();
        LblPrev = new StyleLabel("Vorige vraag: ");
        LblVorigeVraag = new StyleLabel("nog geen vraag gesteld");
        LblPrevA = new StyleLabel("     Antwoord: ");
        LblAntwoord = new StyleLabel("nog geen antwoord");
        HboxVraag = new HBox();
        LblVraag = new StyleLabel("Vraag");
        TxtVraag = new TextField();
        BtnVraag = new Button("Vraag");
        HboxGok = new HBox();
        LblGok = new StyleLabel("Gok");
        TxtGok = new TextField();
        BtnGok = new Button("Gok");
        System.out.println("aantal characters: " + setAantalCharacters);
        System.out.println("deze characters doen mee " + setCharacters);

        //maak voor elk character in de setCharacters array een label aan met de naam
        characterName = new CharacterButton[setCharacters.size()];
        characterPic = new ImageView[setCharacters.size()];
        VboxCharacter = new VBox[setCharacters.size()];
        for (Character character : setCharacters) {
            characterName[i] = new CharacterButton(character.getNaam());
            characterPic[i] = new ImageView("be/kdg/projectbasis/resources/characters/afbeeldingen/"+ character.getNaam() +".png");
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



        HBoxPrev.setAlignment(Pos.CENTER);
        HboxVraag.setAlignment(Pos.CENTER);
        HboxGok.setAlignment(Pos.CENTER);
        GridCharacters.setAlignment(Pos.CENTER);
        TxtVraag.setAlignment(Pos.CENTER);
        TxtGok.setAlignment(Pos.CENTER);
        BtnVraag.setAlignment(Pos.CENTER);
        BtnGok.setAlignment(Pos.CENTER);
    }

    private void layoutNodes() {
        HBoxPrev.getChildren().addAll(LblPrev, LblVorigeVraag, LblPrevA, LblAntwoord);
        HboxVraag.getChildren().addAll(LblVraag, TxtVraag, BtnVraag);
        HboxGok.getChildren().addAll(LblGok, TxtGok, BtnGok);
        SpelContainer.getChildren().addAll(GridCharacters, HBoxPrev,HboxVraag, HboxGok);
        this.getChildren().add(SpelContainer);

            SpelContainer.setPadding(new Insets(10, 10, 10, 10));
            HBoxPrev.setPadding(new Insets(10, 10, 10, 10));
            HboxVraag.setPadding(new Insets(10, 10, 10, 10));
            HboxGok.setPadding(new Insets(10, 10, 10, 10));
            GridCharacters.setPadding(new Insets(10, 10, 10, 10));
            TxtVraag.setPadding(new Insets(10, 10, 10, 10));
            TxtGok.setPadding(new Insets(10, 10, 10, 10));
            BtnVraag.setPadding(new Insets(10, 10, 10, 10));
            BtnGok.setPadding(new Insets(10));

            HboxVraag.setSpacing(10);
            HboxGok.setSpacing(10);
            HBoxPrev.setSpacing(10);
        GridCharacters.setHgap(20);
        GridCharacters.setVgap(10);

        for (int i = 0; i < VboxCharacter.length; i++) {
            characterPic[i].setFitWidth(150);
            characterPic[i].setFitHeight(200);
            VboxCharacter[i].setMinWidth(120);
            VboxCharacter[i].setMinHeight(120);
            VboxCharacter[i].setSpacing(10);
        }


        HboxVraag.setSpacing(10);
        HboxGok.setSpacing(10);
        HBoxPrev.setSpacing(10);

        TxtVraag.setMinWidth(100);
        TxtGok.setMinWidth(100);

        BtnVraag.setMinWidth(50);
        BtnGok.setMinWidth(50);

        GridCharacters.setMinWidth(250);
        GridCharacters.setMinHeight(250);


        HboxVraag.setSpacing(10);
        HboxGok.setSpacing(10);
        HBoxPrev.setSpacing(10);


            TxtVraag.setMinWidth(100);
            TxtGok.setMinWidth(100);


            BtnVraag.setMinWidth(50);
            BtnGok.setMinWidth(50);

            GridCharacters.setMinWidth(250);
            GridCharacters.setMinHeight(250);

            GridCharacters.setAlignment(Pos.CENTER);
            HboxVraag.setAlignment(Pos.CENTER);
            HboxGok.setAlignment(Pos.CENTER);
            LblVraag.setAlignment(Pos.CENTER);
            LblGok.setAlignment(Pos.CENTER);
            TxtVraag.setAlignment(Pos.CENTER);
            TxtGok.setAlignment(Pos.CENTER);
            BtnVraag.setAlignment(Pos.CENTER);
            BtnGok.setAlignment(Pos.CENTER);
            SpelContainer.setAlignment(Pos.CENTER);
            GridCharacters.setAlignment(Pos.CENTER);
            HBoxPrev.setAlignment(Pos.CENTER);
            LblPrev.setAlignment(Pos.CENTER);
            LblVorigeVraag.setAlignment(Pos.CENTER);
            LblPrevA.setAlignment(Pos.CENTER);
            LblAntwoord.setAlignment(Pos.CENTER);
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


}

