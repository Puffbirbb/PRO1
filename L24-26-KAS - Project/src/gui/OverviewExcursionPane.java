package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Companion;
import model.Conference;
import model.Participant;
import storage.Storage;

public class OverviewExcursionPane extends GridPane {
    private final ListView<StringBuilder> lvwExcursions = new ListView<>();

    public OverviewExcursionPane(){
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblExcursions = new Label("Excursions");
        this.add(lblExcursions, 0, 0);

        updateExcursionList(0);
        lvwExcursions.setMinWidth(600);
        add(lvwExcursions, 0, 1);
    }

    public void updateExcursionList(int index){
        Conference conference = Storage.getConferences().get(index);
        lvwExcursions.getItems().setAll(conference.showExcursionOverview());
    }
}
