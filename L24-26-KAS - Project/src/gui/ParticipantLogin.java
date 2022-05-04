package gui;

import controller.Controller;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Participant;

public class ParticipantLogin extends Stage {

    public ParticipantLogin(String title, Stage owner){
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

        chooseConferenceWindow = new ChooseConferenceWindow("Choose conference", owner);
        registerLoginWindow = new RegisterLoginWindow("Register Info", owner);
    }

    private final Button btnLogin = new Button("Login");
    private final Button btnRegister = new Button("Register");
    private final ComboBox<Participant> chbParticipants = new ComboBox<>();
    private final ChooseConferenceWindow chooseConferenceWindow;
    private final RegisterLoginWindow registerLoginWindow;
    private void initContent(GridPane pane) {
        int widthBtn = 100;
        int widthChb = 200;
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(chbParticipants, 0, 0, 2, 1);
        chbParticipants.setPrefWidth(widthChb);
        GridPane.setHalignment(chbParticipants, HPos.CENTER);
        chbParticipants.setPromptText(" Select User ");
        chbParticipants.getItems().addAll(Controller.getParticipants());
        chbParticipants.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
            }
        });

        pane.add(btnRegister, 1, 1);
        btnRegister.setPrefWidth(widthBtn);
        GridPane.setHalignment(btnRegister, HPos.RIGHT);
        btnRegister.setOnAction(event -> registerEvent());

        pane.add(btnLogin, 0, 1);
        btnLogin.setPrefWidth(widthBtn);
        btnLogin.setOnAction(event -> loginEvent());
    }

    private void loginEvent() {
        if (chbParticipants.getSelectionModel().selectedIndexProperty() == null){
            chbParticipants.setPromptText(" SELECT USER! ");
        }
        else {
            ReadOnlyIntegerProperty indexOfParticipant = chbParticipants.getSelectionModel().selectedIndexProperty();
            RegisterConferenceWindow.selectedParticipant(indexOfParticipant);
            chooseConferenceWindow.showAndWait();
        }
    }

    private void registerEvent() {
        registerLoginWindow.showAndWait();
        chbParticipants.getItems().clear();
        chbParticipants.getItems().addAll(Controller.getParticipants());
    }
}