package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Companion;
import model.Conference;
import model.Participant;
import storage.Storage;

public class OverviewHotelsPane extends GridPane {
    private final ListView<StringBuilder> lvwHotel = new ListView<>();

    public OverviewHotelsPane(){
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblHotels = new Label("Hotels");
        this.add(lblHotels, 0, 0);
        updateHotelList(0);
        lvwHotel.setMinWidth(600);
        add(lvwHotel, 0, 1);
    }

    public void updateHotelList(int index){
        Conference conference = Storage.getConferences().get(index);
        lvwHotel.getItems().setAll(conference.showHotelOverview());
    }
}
