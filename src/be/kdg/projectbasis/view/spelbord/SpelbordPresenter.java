package be.kdg.projectbasis.view.spelBord;

import be.kdg.projectbasis.model.ProgrammaModel;
import be.kdg.projectbasis.model.spelbeurten.SpelbeurtSpeler;



public class SpelBordPresenter {
    private ProgrammaModel model;

    private SpelbeurtSpeler spelbeurtSpeler;
    private SpelBordView view;

    public SpelBordPresenter(ProgrammaModel model, SpelBordView view) {
        this.model = model;
        this.view = view;
        this.spelbeurtSpeler = spelbeurtSpeler;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtnVraag().setOnAction(event -> {
            String question = view.getTxtVraag().getText();
            model.startSpelbeurtSpeler(question);
            view.getLblAntwoord().setText(model.getAnswerS());
            view.getLblVorigeVraag().setText(question);
            System.out.println("vraag gesteld");
            model.startSpelbeurtComputer();
            System.out.println("het is terug jou beurt");
            model.refreshCharacters();
            System.out.println("stel een nieuwe vraag");
        });
        view.getBtnGok().setOnAction(event -> {
            String gok = view.getTxtGok().getText();
            model.maakGok(gok);
        });
    }


}
