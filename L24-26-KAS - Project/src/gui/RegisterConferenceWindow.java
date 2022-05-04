package gui;

import controller.Controller;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Conference;
import model.Participant;
import model.Register;
import storage.Storage;

import java.time.LocalDate;


public class RegisterConferenceWindow extends Stage {

    private final Label lblErrorMSG = new Label();
    private final TextField txfConference = new TextField();
    private final Button btnCompanion = new Button("Companion");
    private final Button btnHotel = new Button("Hotel");
    private final Button btnConfirm = new Button("Confirm");
    private final Button btnCancel = new Button("Cancel");
    private final TextField txfArrivalDate = new TextField();
    private final TextField txfDepartureDate = new TextField();
    private final CheckBox cbxLecturer = new CheckBox();
    private final RegisterHotelWindow registerHotelWindow;
    private final RegisterCompanionWindow registerCompanionWindow;
    private Register actualRegister = null;
    private int indexOfConference;
    private static ReadOnlyIntegerProperty indexOfParticipant;

    public RegisterConferenceWindow(String title, Stage owner) {
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

        registerHotelWindow = new RegisterHotelWindow("Register hotel", owner);
        registerCompanionWindow = new RegisterCompanionWindow("Register companion", owner);
    }


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        txfConference.setEditable(false);
        pane.add(txfConference, 0, 0, 2, 1);
        txfConference.setFocusTraversable(false);

        Label lblArrivalDate = new Label("Arrival date: ");
        Label lblDepartureDate = new Label("Departure date: ");
        Label lblLecturer = new Label("Lecturer: ");

        lblErrorMSG.setTextFill(Color.RED);

        pane.add(lblArrivalDate, 0, 2);
        pane.add(lblDepartureDate, 0, 3);
        pane.add(lblErrorMSG, 0, 6, 2, 1);

        txfArrivalDate.setPromptText("YYYY/MM/DD");
        txfDepartureDate.setPromptText("YYYY/MM/DD");
        pane.add(txfArrivalDate, 1, 2);
        pane.add(txfDepartureDate, 1, 3);
        pane.add(lblLecturer, 0, 4);

        pane.add(btnCompanion, 0, 1);
        pane.add(btnHotel, 1, 1);
        pane.add(btnConfirm, 0, 5);
        pane.add(btnCancel, 1, 5);

        int prefWidth = 100;
        btnHotel.setPrefWidth(prefWidth);
        btnCompanion.setPrefWidth(prefWidth);
        btnConfirm.setPrefWidth(prefWidth);
        btnCancel.setPrefWidth(prefWidth);

        pane.add(cbxLecturer, 1, 4);

        btnCompanion.setOnAction(event -> registerCompanionAction());
        btnHotel.setOnAction(event -> registerHotelAction());
        btnCancel.setOnAction(event -> cancelAction());
        btnConfirm.setOnAction(event -> confirmAction());


    }

    private void registerCompanionAction() {
        registerCompanionWindow.selectedConference(indexOfConference);
        registerCompanionWindow.showAndWait();
    }

    private void cancelAction() {
        clear();
        actualRegister = null;
        RegisterConferenceWindow.this.hide();
    }

    private void confirmAction() {

        try {
            int arrivalDateYear = Integer.parseInt(txfArrivalDate.getText().substring(0, 4));
            int arrivalDateMonth = Integer.parseInt(txfArrivalDate.getText().substring(5, 7));
            int arrivalDateDay = Integer.parseInt(txfArrivalDate.getText().substring(8));

            int departureDateYear = Integer.parseInt(txfDepartureDate.getText().substring(0, 4));
            int departureDateMonth = Integer.parseInt(txfDepartureDate.getText().substring(5, 7));
            int departureDateDay = Integer.parseInt(txfDepartureDate.getText().substring(8));

            LocalDate arrivalDate = LocalDate.of(arrivalDateYear, arrivalDateMonth, arrivalDateDay);
            LocalDate departureDate = LocalDate.of(departureDateYear, departureDateMonth, departureDateDay);

            boolean isLecturer = cbxLecturer.isSelected();

            Conference conference = Storage.getConferences().get(indexOfConference);
            Participant participant = Storage.getParticipants().get(indexOfParticipant.getValue());

            System.out.println(Controller.createRegister(arrivalDate, departureDate, isLecturer, participant, conference));
            System.out.println(Storage.getConferences().get(0).getRegisters());
            RegisterConferenceWindow.this.hide();

        } catch (Exception e) {
            lblErrorMSG.setText("Wrong insert of dates");
        }

        clear();
    }

    public void setTxfConference(String strConference) {
        txfConference.setText(strConference);
    }

    private void registerHotelAction() {
        registerHotelWindow.showAndWait();
    }

    public void selectedConference(int index) {
        indexOfConference = index;
        Conference conference = Storage.getConferences().get(indexOfConference);
        setTxfConference(conference.getName());
    }

    public static void selectedParticipant(ReadOnlyIntegerProperty index) {
        indexOfParticipant = index;
        Storage.getParticipants().get(indexOfParticipant.getValue());
    }

    private void clear() {
        txfArrivalDate.clear();
        txfDepartureDate.clear();
        cbxLecturer.setSelected(false);
    }
}