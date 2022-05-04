package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Companion;
import model.Conference;
import model.Hotel;

import java.util.ArrayList;

public class RegisterHotelWindow extends Stage{

    public RegisterHotelWindow(String title, Stage owner){
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

    private final TextField txfCompanionName = new TextField();
    private final Button btnAddCompanion = new Button("Add hotel");
    private final Button btnAddExcursion = new Button("Add excursion");
    private final Button btnConfirm = new Button("Confirm");
    private final Button btnCancel = new Button("Cancel");
    private final ListView<String> lvwHotel = new ListView<>();
    private final ListView<String> lvwExtra = new ListView<>();
    private Conference conference;
    private int indexOfParticipant;


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblHotels = new Label("Choose hotel");
        pane.add(lblHotels, 0, 0);

    }


}
