package be.kdg.projectbasis.view.nieuwCharacter;

import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.view.hoofdmenu.HoofdmenuPresenter;
import be.kdg.projectbasis.view.hoofdmenu.HoofdmenuView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import java.io.IOException;

public class NieuwCharacterPresenter {
    private final ProgrammaModel model;
    private final NieuwCharacterView view;

    public NieuwCharacterPresenter(ProgrammaModel model, NieuwCharacterView view) {
        this.model = model;
        this.view = view;

        // Voeg event handlers toe aan de knoppen in de view
        view.getBtnBack().setOnAction(event -> {
            HoofdmenuView hoofdmenuView = new HoofdmenuView();
            HoofdmenuPresenter hoofdmenuPresenter = new HoofdmenuPresenter(model, hoofdmenuView);
            Scene hoofdmenu = new Scene(hoofdmenuView);
            Main.Window.setScene(hoofdmenu);
            Main.Window.setTitle("Hoofdmenu");
            Main.Window.show();
            Main.Window.setFullScreen(true);
        });

        view.getBtnConfirm().setOnAction(event -> {
            try {
                // Create a new character with the data from the view
                XMLWriter xmlWriter = new XMLWriter("src/be/kdg/projectbasis/resources/characters/characters.xml");
                xmlWriter.writeCharacterToXML(
                        view.getTxtnaam().getText(),
                        view.getCbgeslacht().getValue(),
                        view.getCboogkleur().getValue(),
                        view.getCbhaarkleur().getValue(),
                        view.getCbhaarlengte().getValue(),
                        view.getCbhaarstijl().getValue(),
                        view.getCbgezichtsbeharing().getValue(),
                        view.getCbhoofddeksel().getValue(),
                        view.getCbaccessoires().getValue(),
                        view.getImgAfbeelding().getImage().getUrl());

                // Display a popup indicating that the new character has been created and clear all fields
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Nieuw karakter aangemaakt");
                alert.setHeaderText(null);
                alert.setContentText("Het nieuwe karakter is succesvol aangemaakt!");
                alert.showAndWait();
                view.getTxtnaam().clear();
                view.getCbgeslacht().getSelectionModel().clearSelection();
                view.getCboogkleur().getSelectionModel().clearSelection();
                view.getCbhaarkleur().getSelectionModel().clearSelection();
                view.getCbhaarlengte().getSelectionModel().clearSelection();
                view.getCbhaarstijl().getSelectionModel().clearSelection();
                view.getCbgezichtsbeharing().getSelectionModel().clearSelection();
                view.getCbhoofddeksel().getSelectionModel().clearSelection();
                view.getCbaccessoires().getSelectionModel().clearSelection();
                view.getImgAfbeelding().setImage(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
