package be.kdg.projectbasis.view.hoofdmenu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HoofdmenuView extends VBox {
    //1. Maak een attribuut per node (zowel controls en panes, behalve de "root pane")
//2. Pas de naam van de constructor aan naar uw klassenaam
//3. Kopieer uw control instantiaties naar "initialiseNodes()"
//4. Laat uw View-klasse overerven van het Pane type waarin alle andere Nodes van uw scherm inzitten
//5. Voeg uw controls toe aan de Nodes om ze een positie op het scherm te geven
//6. Maak public getters aan voor al uw attributen (zijnde controls, panes, ...)


    //Hier uw attributen
//Hier uw getters

    private Button btnNieuwSpel;
    private Button btnTopscoren;
    private Button btnSpelregels;

    private Button btnAfsluiten;




    public HoofdmenuView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        btnNieuwSpel = new HoofdmenuButton("Nieuwe spel");
        btnTopscoren = new HoofdmenuButton("Topscoren");
        btnSpelregels = new HoofdmenuButton("Spelregels");
        btnAfsluiten = new HoofdmenuButton("Afsluiten");

    }

    private void layoutNodes() {
        this.getChildren().add(btnNieuwSpel);
        this.getChildren().add(btnTopscoren);
        this.getChildren().add(btnSpelregels);
        this.getChildren().add(btnAfsluiten);
        this.setSpacing(50);
        BackgroundImage achtergrondAfbeelding = new BackgroundImage(new Image("/istockphoto-1126081792-612x612.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true, true));
        this.setBackground(new Background(achtergrondAfbeelding));
        this.setAlignment(Pos.CENTER);
    }

    public Button getBtnNieuwSpel() {
        return btnNieuwSpel;
    }

    public Button getBtnHoogsteScores() {
        return btnTopscoren;
    }

    public Button getBtnHandleiding() {
        return btnSpelregels;
    }

    public Button getBtnAfsluiten(){return btnAfsluiten;}
}