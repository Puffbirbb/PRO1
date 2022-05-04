package gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiHomePage extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Home page");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        participantLogin = new ParticipantLogin("Login", stage);
        chooseOverviewWindow = new ChooseOverviewWindow("Choose Conference Overview", stage);
    }

    private final Button btnParticipant = new Button("Participant");
    private final Button btnAdmin = new Button("Admin");
    private ParticipantLogin participantLogin;
    private ChooseOverviewWindow chooseOverviewWindow;

    private void initContent(GridPane pane) {
        int widthBtn = 100;

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.setGridLinesVisible(false);
        Label lblWelcome = new Label("Welcome");
        pane.add(lblWelcome,1,0, 3, 1);
        GridPane.setHalignment(lblWelcome, HPos.CENTER);

        pane.add(btnParticipant,1,1);
        pane.add(btnAdmin,2,1);
        btnParticipant.setPrefWidth(widthBtn);
        btnAdmin.setPrefWidth(widthBtn);

        btnParticipant.setOnAction(event -> participantEvent());

        btnAdmin.setOnAction(event -> adminEvent());
    }

    private void adminEvent() {
        chooseOverviewWindow.showAndWait();
    }

    private void participantEvent() {
        participantLogin.showAndWait();
    }
}