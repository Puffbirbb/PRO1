package gui;

import controller.Controller;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
import storage.Storage;

import java.util.ArrayList;



public class RegisterCompanionWindow extends Stage{

    public RegisterCompanionWindow(String title, Stage owner){
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


    }

    private final ComboBox<Companion> cbPreviousCompanions = new ComboBox<>();
    private final TextField txfCompanionName = new TextField();
    private final Button btnAddCompanion = new Button("Add new companion");
    private final Button btnAddExcursion = new Button("Add excursion");
    private final Button btnConfirm = new Button("Confirm");
    private final Button btnCancel = new Button("Cancel");
    private final ListView<String> lvwExcursions = new ListView<>();
    private final ArrayList<String> excursions = new ArrayList<>();
    private final ArrayList<String> chosenExcursions = new ArrayList<>();
    private Conference conference;
    private int indexOfConference;
    private static ReadOnlyIntegerProperty indexOfParticipant;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Labels
        Label lblCompanion = new Label("Previous companions");
        Label lblExcursion = new Label("Excursions");

        pane.add(lblCompanion, 0, 0);
        pane.add(lblExcursion, 0, 2);

        // Combo boxes
        cbPreviousCompanions.setPrefWidth(130);
        pane.add(cbPreviousCompanions, 1, 0);

        cbPreviousCompanions.getItems().addAll();

        // Text fields
        pane.add(txfCompanionName, 0, 1);
        txfCompanionName.setPromptText("Add new companion");

        // Buttons
        pane.add(btnAddCompanion,  1, 1);
        btnAddExcursion.setPrefWidth(130);
        pane.add(btnAddExcursion, 1, 3);
        HBox hbox = new HBox();
        int prefWidth = 100;
        btnCancel.setPrefWidth(prefWidth);
        btnConfirm.setPrefWidth(prefWidth);
        hbox.getChildren().addAll(btnConfirm, btnCancel);
        pane.add(hbox, 0, 4);
        hbox.setSpacing(40);

        // List viewers
        lvwExcursions.setPrefHeight(200);
        pane.add(lvwExcursions, 0, 3);
        
        // Actions
        btnAddCompanion.setOnAction(event -> addCompanionAction());
        btnAddExcursion.setOnAction(event -> addExcursionAction());
        btnCancel.setOnAction(event -> cancelAction());


    }

    private void addCompanionAction() {
        Participant participant = Storage.getParticipants().get(indexOfParticipant.getValue());
        Companion companion = Controller.createCompanion(txfCompanionName.getText(), participant);
    }

    private void addExcursionAction() {
        String selectedExcursion = lvwExcursions.getSelectionModel().getSelectedItems().get(0);
        chosenExcursions.add(selectedExcursion);
        System.out.println(selectedExcursion);
    }

    private void cancelAction() {
        txfCompanionName.clear();
        cbPreviousCompanions.getSelectionModel().clearSelection();
        RegisterCompanionWindow.this.hide();
    }



    public void selectedConference(int index){
        indexOfConference = index;
    }

    public static void selectedParticipant(ReadOnlyIntegerProperty index){
        indexOfParticipant = index;
        Participant participant = Storage.getParticipants().get(indexOfParticipant.getValue());
    }



}
