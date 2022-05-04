package gui;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Conference;
import storage.Storage;

public class ChooseOverviewWindow extends Stage {

    public ChooseOverviewWindow(String title, Stage owner){
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(200);
        this.setMinWidth(150);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

        showConferenceOverviewWindow = new ShowConferenceOverviewWindow("Conference overview", owner);

        ChangeListener<Conference> listener = (ov, o, n) -> this.updateConferenceOverview();
                //selectedEmployeeChanged();
        lvwConference.getSelectionModel().selectedItemProperty().addListener(listener);
    }


    private final ListView<Conference> lvwConference = new ListView<>();
    private ShowConferenceOverviewWindow showConferenceOverviewWindow;
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(lvwConference, 0, 0);
        updateConferenceOverview();
        //OverviewParticipantsPane
        //updateParticipanList(0)
        lvwConference.setOnMouseClicked(event -> mouseClicked());
    }

    private void showConferenceOverviewWindow() {
        updateConferenceOverview();
        showConferenceOverviewWindow.showAndWait();
    }

    public void updateConferenceOverview(){
        lvwConference.getItems().setAll(Storage.getConferences());
    }

    private void mouseClicked() {
        if (lvwConference.getSelectionModel().getSelectedItems().size() > 0){
            int indexOfConference = lvwConference.getSelectionModel().getSelectedIndex();
            showConferenceOverviewWindow.selectedConference(indexOfConference);
            updateConferenceOverview();
            showConferenceOverviewWindow.showAndWait();
            lvwConference.getSelectionModel().clearSelection();

        }

    }
    
}


//    Employee employee = lvwEmployees.getSelectionModel().getSelectedItem();
//        if (employee == null)
//                return;
//
//                EmployeeWindow dialog = new EmployeeWindow("Update Employee", employee);
//                dialog.showAndWait();
//
//                // Wait for the modal dialog to close
//
//                int selectIndex = lvwEmployees.getSelectionModel().getSelectedIndex();
//                lvwEmployees.getItems().setAll(Controller.getEmployees());
//                lvwEmployees.getSelectionModel().select(selectIndex);