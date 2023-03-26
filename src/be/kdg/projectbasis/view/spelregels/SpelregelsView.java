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
        lblRegels = new Label("Spelregels WIE IS HET\n\n" +
                "Het spel wordt meestal met twee spelers gespeeld, maar kan ook met meerdere spelers worden gespeeld.\n\n" +
                "Elk van de twee spelers heeft een spelbord met 20 gezichten en namen.\n\n" +
                "Beide spelers moeten hun spelbord opvullen met 20 gezichten.\n\n" +
                "De eerste speler stelt een vraag over een kaartje op het spelbord van de tegenstander.\n\n" +
                "De vraag moet beantwoord worden met ja of nee.\n\n" +
                "Op basis van het antwoord kan de eerste speler sommige gezichten afsluiten.\n\n" +
                "Dit doet hij door op de naam van de speler te drukken.\n\n" +
                "Dan mag de tweede speler een vraag stellen.\n\n" +
                "Het spel gaat door totdat één van de spelers kan raden wie het gezicht van de tegenstander is.\n\n" +
                "Bij een foute gok verlies je automatisch het spel.\n\n"
                );
        lblRegels.setWrapText(true);
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