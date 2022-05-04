//package gui;
//
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.ListView;
//import javafx.scene.control.Tab;
//import javafx.scene.control.TabPane;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//import model.Companion;
//import model.Conference;
//import model.Participant;
//import storage.Storage;
//
//public class ShowConferenceOverviewWindow extends Stage {
//    public ShowConferenceOverviewWindow(String title, Stage owner) {
//        this.initOwner(owner);
//        this.initStyle(StageStyle.UTILITY);
//        this.initModality(Modality.APPLICATION_MODAL);
//        this.setMinHeight(100);
//        this.setMinWidth(200);
//        this.setResizable(false);
//
//        this.setTitle(title);
//        GridPane pane = new GridPane();
//        this.initContent(pane);
//
//        Scene scene = new Scene(pane);
//        this.setScene(scene);
//    }
//    private int indexOfConference;
////    private final ListView<Participant> lvwParticipant = new ListView<>();
////    private final ListView<Conference> lvwHotel = new ListView<>();
////    private final ListView<Companion> lvwExcursion = new ListView<>();
//    private final TabPane tabPane = new TabPane();
//    private void initContent(GridPane pane) {
//        //tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
//        pane.setPadding(new Insets(20));
//        pane.setHgap(10);
//        pane.setVgap(10);
//
//        //Conference chosenConference = listener;
//        pane.add(tabPane, 0, 0);
//
//        Tab tpParticipant = new Tab("Participants");
//        tabPane.getTabs().add(tpParticipant);
//
//        OverviewParticipantsPane overviewParticipantsPane = new OverviewParticipantsPane();
//        tpParticipant.setClosable(false);
//        tpParticipant.setContent(overviewParticipantsPane);
//        //tpHotel.setOnSelectionChanged(event -> OverviewParticipantsPane.updateList);
//
//
//        Tab tpHotel = new Tab("Hotels");
//        tabPane.getTabs().add(tpHotel);
//
//        OverviewHotelsPane overviewHotelsPane = new OverviewHotelsPane();
//        tpHotel.setClosable(false);
//        tpHotel.setContent(overviewHotelsPane);
//        //tpHotel.setOnSelectionChanged(event -> OverviewHotelPane.updateList);
//
//        Tab tpExcursion = new Tab("Excursions");
//        tabPane.getTabs().add(tpExcursion);
//
//        OverviewExcursionPane overviewExcursionPane = new OverviewExcursionPane();
//        tpExcursion.setClosable(false);
//        tpExcursion.setContent(overviewExcursionPane);
//        //tpExcursion.setOnSelectionChanged(event -> OverviewExcursionPane.updateList);
//    }
//
////    public Conference selectedConference(int index){
////        indexOfConference = index;
////        Conference conference = Storage.getConferences().get(indexOfConference);
////        return conference;
////        //setTxfConference(conference.getName());
////    }
//}





package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Companion;
import model.Conference;
import model.Participant;
import storage.Storage;

public class ShowConferenceOverviewWindow extends Stage {
    public ShowConferenceOverviewWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(500);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    //    private final ListView<Participant> lvwParticipant = new ListView<>();
//    private final ListView<Conference> lvwHotel = new ListView<>();
//    private final ListView<Companion> lvwExcursion = new ListView<>();
    private final TabPane tabPane = new TabPane();
    private final Button btnUpdate = new Button("Update");

    private OverviewExcursionPane overviewExcursionPane = new OverviewExcursionPane();
    private OverviewHotelsPane overviewHotelsPane = new OverviewHotelsPane();
    private OverviewParticipantsPane overviewParticipantsPane = new OverviewParticipantsPane();
    private int indexOfConference;

    private void initContent(GridPane pane) {
        //tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        //Conference chosenConference = listener;
        pane.add(tabPane, 0, 0);

        Tab tpParticipant = new Tab("Participants");
        tabPane.getTabs().add(tpParticipant);

        //OverviewParticipantsPane overviewParticipantsPane = new OverviewParticipantsPane();
        tpParticipant.setClosable(false);
        tpParticipant.setContent(overviewParticipantsPane);
        //tpHotel.setOnSelectionChanged(event -> OverviewParticipantsPane.updateList);


        Tab tpHotel = new Tab("Hotels");
        tabPane.getTabs().add(tpHotel);

        //OverviewHotelsPane overviewHotelsPane = new OverviewHotelsPane();
        tpHotel.setClosable(false);
        tpHotel.setContent(overviewHotelsPane);
        //tpHotel.setOnSelectionChanged(event -> OverviewHotelPane.updateList);

        Tab tpExcursion = new Tab("Excursions");
        tabPane.getTabs().add(tpExcursion);

        //OverviewExcursionPane overviewExcursionPane = new OverviewExcursionPane();
        tpExcursion.setClosable(false);
        tpExcursion.setContent(overviewExcursionPane);
        
        pane.add(btnUpdate, 0, 1);
        btnUpdate.setOnAction(event -> updateEvent());
        

    }

    public void selectedConference(int index){
        indexOfConference = index;
        Conference conference = Storage.getConferences().get(indexOfConference);
        //setTxfConference(conference.getName());
    }

    private void updateEvent() {
        overviewParticipantsPane.updateParticipanList(indexOfConference);
        overviewExcursionPane.updateExcursionList(indexOfConference);
        overviewHotelsPane.updateHotelList(indexOfConference);
    }
}