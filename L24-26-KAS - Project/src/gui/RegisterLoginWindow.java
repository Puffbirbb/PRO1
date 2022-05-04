package gui;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Participant;

public class RegisterLoginWindow extends Stage {

    public RegisterLoginWindow(String title, Stage owner){
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

    private final TextField[] txfInput = new TextField[6];
    private final Button btnRegister = new Button("Register");
    private final Button btnCancel = new Button("Cancel");
    private void initContent(GridPane pane) {
        int widthBtn = 100;
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        for (int i = 0; i < 6; i++){
            txfInput[i] = new TextField();
            pane.add(txfInput[i], 1, i);
        }

        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 0);
        Label lblCity = new Label("City: ");
        pane.add(lblCity, 0, 1);
        Label lblCountry = new Label("Country: ");
        pane.add(lblCountry, 0, 2);
        Label lblPhoneNumber = new Label("Phone Number: ");
        pane.add(lblPhoneNumber, 0, 3);
        Label lblBusinessName = new Label("Business Name: ");
        pane.add(lblBusinessName, 0, 4);
        Label lblBusinessPhone = new Label("Business Phone: ");
        pane.add(lblBusinessPhone, 0, 5);

        pane.add(btnRegister, 0, 6);
        btnRegister.setPrefWidth(widthBtn);
        GridPane.setHalignment(btnRegister, HPos.CENTER);
        btnRegister.setOnAction(event -> registerEvent());

        pane.add(btnCancel, 1, 6);
        btnCancel.setPrefWidth(widthBtn);
        GridPane.setHalignment(btnCancel, HPos.CENTER);
        btnCancel.setOnAction(event -> cancelEvent());
    }

    private void cancelEvent() {
        for (int i = 0; i < 5; i++){
            txfInput[i].clear();
        }
        RegisterLoginWindow.this.hide();
    }

    private void registerEvent() {
        RegisterLoginWindow.this.hide();
        Participant participant = Controller.createParticipant(txfInput[0].getText(), txfInput[1].getText(), txfInput[2].getText(), Integer.parseInt(txfInput[3].getText()), txfInput[4].getText(), Integer.parseInt(txfInput[5].getText()));
        for (int i = 0; i < 6; i++){
            txfInput[i].clear();
        }
    }
}
