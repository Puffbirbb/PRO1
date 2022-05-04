package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Conference;
import model.Organisation;
import storage.Storage;

import java.util.ArrayList;


public class ChooseConferenceWindow extends Stage {

    public ChooseConferenceWindow(String title, Stage owner){
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

        registerConferenceWindow = new RegisterConferenceWindow("Register conference", owner);

    }

    private final ListView<Conference> lvwConference = new ListView<>();
    private final RegisterConferenceWindow registerConferenceWindow;
    private final ArrayList<String> conferences = new ArrayList<>();


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(lvwConference, 0,0);

        lvwConference.getItems().setAll(Storage.getConferences());

        lvwConference.setOnMouseClicked(event -> this.mouseClicked());


    }

    private void mouseClicked() {
        if (lvwConference.getSelectionModel().getSelectedItems().size() > 0){
            int indexOfConference = lvwConference.getSelectionModel().getSelectedIndex();
            registerConferenceWindow.selectedConference(indexOfConference);
            registerConferenceWindow.showAndWait();
            lvwConference.getSelectionModel().clearSelection();

        }

    }



}




