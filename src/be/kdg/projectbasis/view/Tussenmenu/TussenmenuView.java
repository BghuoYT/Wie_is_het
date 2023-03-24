package be.kdg.projectbasis.view.Tussenmenu;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.view.hoofdmenu.HoofdmenuButton;
import be.kdg.projectbasis.view.standaardElementen.StyleLabel;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class TussenmenuView extends VBox {
    //1. Maak een attribuut per node (zowel controls en panes, behalve de "root pane")
//2. Pas de naam van de constructor aan naar uw klassenaam
//3. Kopieer uw control instantiaties naar "initialiseNodes()"
//4. Laat uw View-klasse overerven van het Pane type waarin alle andere Nodes van uw scherm inzitten
//5. Voeg uw controls toe aan de Nodes om ze een positie op het scherm te geven
//6. Maak public getters aan voor al uw attributen (zijnde controls, panes, ...)


    //Hier uw attributen
//Hier uw getters
    private StyleLabel gameOverLabel;
    private Button btnNieuwSpel;
    private Button btnHoofdMenu;
    private Button btnAfsluiten;
    public static String spelerWin;


    public TussenmenuView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        gameOverLabel = new StyleLabel(spelerWin);
        btnNieuwSpel = new HoofdmenuButton("Nieuw spel");
        btnHoofdMenu = new HoofdmenuButton("Naar Hoofdmenu");
        btnAfsluiten = new HoofdmenuButton("Afsluiten");
    }

    private void layoutNodes() {
        this.getChildren().add(gameOverLabel);
        this.getChildren().add(btnNieuwSpel);
        this.getChildren().add(btnHoofdMenu);
        this.getChildren().add(btnAfsluiten);
        this.setSpacing(50);
        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("/be/kdg/projectbasis/resources/bg-main.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true, true));
        this.setBackground(new Background(achtergrondAfbeelding));
        this.setAlignment(Pos.CENTER);
    }





    public Button getBtnNieuwSpel() {
        return btnNieuwSpel;
    }

    public Button getBtnHoofdMenu() {
        return btnHoofdMenu;
    }

    public Button getBtnAfsluiten(){return btnAfsluiten;}
}