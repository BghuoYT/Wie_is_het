package be.kdg.projectbasis.view.spelregels;

import be.kdg.projectbasis.model.ProgrammaModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SpelregelsPresenter {
    private final ProgrammaModel model;
    private final SpelregelsView view;

    public SpelregelsPresenter( ProgrammaModel model, SpelregelsView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getBtnInvoer().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.getTxtUitvoer().setText("Hallo iedereen!");
            }
        });
    }

    private void updateView() {

    }

    public void addWindowEventHandlers() {

    }

}
