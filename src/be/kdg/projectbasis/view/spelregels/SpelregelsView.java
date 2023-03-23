package be.kdg.projectbasis.view.spelregels;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SpelregelsView extends HBox {
    private Label lblRegels;

    public SpelregelsView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        lblRegels = new Label("Spelregels WIE IS HET" + "\n" +
                "Het spel ‘Wie is het?’ zal in de meeste gevallen met twee spelers worden gespeeld," + "\n" +
                "maar het is ook ontzettend gezellig om met meerdere spelers te spelen. De twee spelers krijgen beide een spelbord met daarop 24 gezichten." + "\n" +
                "Natuurlijk heeft elk gezicht ook een naam. Beide spelers moeten hun spelbord opvullen met 24 gezichten.\n" +
                "\n" + "Daarna is het de beurt aan de eerste speler om een vraag te stellen over het desbetreffende kaartje. Iedere vraag moet beantwoord worden met ja of nee, dus er kunnen geen open vragen worden gesteld." + "\n" +
                "Een vraag die bijvoorbeeld kan is: is het een vrouw? Stel dat klopt, dan kan jij alle gezichten van de mannen dichtklappen en dan ben je weer een stap dichterbij de winst. Daarna mag de andere speler een vraag stellen.");

    }

    private void layoutNodes() {
        lblRegels.setAlignment(Pos.CENTER);
        this.getChildren().add(lblRegels);


        /*
        this.layoutHbox.getChildren().add(btnAfsluiten);
        txtVbox.setAlignment(Pos.CENTER);
        layoutHbox.setAlignment(Pos.CENTER);

         */
    }


    public Label getLblRegels() {
        return lblRegels;
    }

/*
    public HBox getLayoutHbox() {
        return layoutHbox;
    }

    public VBox getTxtVbox() {
        return txtVbox;
    }

    public Button getBtnAfsluiten() {
        return btnAfsluiten;
    }
}

 */
}