package be.kdg.projectbasis.view.spelBord;

import be.kdg.projectbasis.Main;
import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.model.spelbeurten.SpelbeurtSpeler;
import be.kdg.projectbasis.view.Tussenmenu.TussenmenuPresenter;
import be.kdg.projectbasis.view.Tussenmenu.TussenmenuView;
import be.kdg.projectbasis.view.standaardElementen.CharacterButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.awt.event.ActionListener;


public class SpelBordPresenter {
    private ProgrammaModel model;

    private SpelbeurtSpeler spelbeurtSpeler;
    private SpelBordView view;
    private int x = 0;

    private String computerVraag;

    public SpelBordPresenter(ProgrammaModel model, SpelBordView view) {
        this.model = model;
        this.view = view;
        this.spelbeurtSpeler = spelbeurtSpeler;
        addEventHandlers();
        initializeCharacterHandlers();
    }

    private void addEventHandlers() {

        view.getBtnVraag().setOnAction(event -> {
            if (!model.getSpelerWin() && !model.getComputerWin()){
            String question = view.getTxtVraag().getText();
            model.startSpelbeurtSpeler(question);
            view.getLblAntwoord().setText(model.getAnswerS());
            view.getLblVorigeVraag().setText(question);
            System.out.println("vraag gesteld");
            model.startSpelbeurtComputer();
            System.out.println("het is terug jou beurt");
            model.refreshCharacters();
            System.out.println("stel een nieuwe vraag");
            view.getLblComputerAntwoord().setText(model.getAnswerC());
            view.getLblComputerVraag().setText(model.getComputerVraag());
            }   else {
                TussenmenuView TussenmenuView = new TussenmenuView();
                TussenmenuPresenter TussenmenuPresenter = new TussenmenuPresenter(model,TussenmenuView);
                Scene Tussenmenu = new Scene(TussenmenuView);
                Main.Window.setScene(Tussenmenu);
                Main.Window.setTitle("Tussenmenu");
                Main.Window.show();
                Main.Window.setFullScreen(true);
            }
        });


        view.getBtnGok().setOnAction(event -> {
            String gok = view.getTxtGok().getText();
            model.maakGok(gok);
            if (model.getSpelerWin() || model.getComputerWin()) {
                TussenmenuView TussenmenuView = new TussenmenuView();
                TussenmenuPresenter TussenmenuPresenter = new TussenmenuPresenter(model,TussenmenuView);
                Scene Tussenmenu = new Scene(TussenmenuView);
                Main.Window.setScene(Tussenmenu);
                Main.Window.setTitle("Tussenmenu");
                Main.Window.show();
                Main.Window.setFullScreen(true);
            }
        });
    }
    private void initializeCharacterHandlers() {
        CharacterButton[] characterButtons = view.getCharacterName();
        ImageView[] characterPics = view.getCharacterPic(); // toegevoegd
        for (int j = 0; j < characterButtons.length; j++) {
            final int index = j; // toegevoegd
            characterButtons[j].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    CharacterButton button = (CharacterButton) event.getSource();
                    button.setVisible(false); // Het karakter verdwijnt uit de view
                    characterPics[index].setVisible(false); // toegevoegd
                }
            });
        }
    }

}
