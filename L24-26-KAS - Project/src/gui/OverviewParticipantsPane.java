package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Companion;
import model.Conference;
import model.Participant;
import storage.Storage;

public class OverviewParticipantsPane extends GridPane {

    private final ListView<StringBuilder> lvwParticipant = new ListView<>();

    public OverviewParticipantsPane(){

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblParticipants = new Label("Participants");
        this.add(lblParticipants, 0, 0);
        //lvwParticipant.getItems().setAll();
        updateParticipanList(0);
        lvwParticipant.setMinWidth(600);
        add(lvwParticipant, 0, 1);

    }
    public void updateParticipanList(int index){
       // Participant participant = lvwParticipant.getSelectionModel().getSelectedItem();
        Conference conference = Storage.getConferences().get(index);

        lvwParticipant.getItems().setAll(conference.showParticipantOverview());
    }

}
