package be.kdg.projectbasis.view.spelBord;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.view.standaardElementen.StyleLabel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class SpelBordView extends VBox {


    private VBox SpelContainer;
    private ImageView[] CharacterPic;
    private StyleLabel[] CharacterName;
    private GridPane GridCharacters;
    private HBox HBoxPrev;
    private StyleLabel LblPrev;
    private StyleLabel LblVorigeVraag;
    private StyleLabel LblPrevA;
    private StyleLabel LblAntwoord;
    private HBox HboxVraag;
    private StyleLabel LblVraag;
    private TextField TxtVraag;
    private Button BtnVraag;
    private HBox HboxGok;
    private StyleLabel LblGok;
    private TextField TxtGok;
    private Button BtnGok;
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
    }

    private void layoutNodes() {
        HBoxPrev.getChildren().addAll(LblPrev, LblVorigeVraag, LblPrevA, LblAntwoord);
        HboxVraag.getChildren().addAll(LblVraag, TxtVraag, BtnVraag);
        HboxGok.getChildren().addAll(LblGok, TxtGok, BtnGok);
        SpelContainer.getChildren().addAll(GridCharacters, HboxVraag, HboxGok);
        this.getChildren().add(SpelContainer);

            //give evrything padding of 10 on all sides so it looks nice
            SpelContainer.setPadding(new Insets(10, 10, 10, 10));
            HBoxPrev.setPadding(new Insets(10, 10, 10, 10));
            HboxVraag.setPadding(new Insets(10, 10, 10, 10));
            HboxGok.setPadding(new Insets(10, 10, 10, 10));
            GridCharacters.setPadding(new Insets(10, 10, 10, 10));
            TxtVraag.setPadding(new Insets(10, 10, 10, 10));
            TxtGok.setPadding(new Insets(10, 10, 10, 10));
            BtnVraag.setPadding(new Insets(10, 10, 10, 10));
            BtnGok.setPadding(new Insets(10));

            //set hbox spacing to 10
            HboxVraag.setSpacing(10);
            HboxGok.setSpacing(10);
            HBoxPrev.setSpacing(10);

            //make every SceneLabel the same size

            //make every textfield the same size
            TxtVraag.setMinWidth(100);
            TxtGok.setMinWidth(100);

            //make every button the same size
            BtnVraag.setMinWidth(50);
            BtnGok.setMinWidth(50);

            GridCharacters.setMinWidth(250);
            GridCharacters.setMinHeight(250);

            //align everything to middle of the screen
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

        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("/be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true, true));
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

    public StyleLabel getLblVorigeVraag() {
        return LblVorigeVraag;
    }

    public StyleLabel getLblAntwoord() {
        return LblAntwoord;
    }
}

