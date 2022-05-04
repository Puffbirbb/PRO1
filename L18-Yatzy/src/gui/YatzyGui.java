package gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.YatzyDice;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // Shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // Shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // Shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final TextField[] txfResults = new TextField[15];
    // Shows points in sums, bonus and total.
    private final TextField txfBonus = new TextField(), txfSumOfNumber = new TextField(),
            txfSumOther = new TextField(), txfTotal = new TextField();

    //    private final Label lblRolled = new Label();
    //    private final Button btnRoll = new Button(" Roll ");

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(10));
        pane.setHgap(20);
        pane.setVgap(20);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        // dicePane.setGridLinesVisible(true);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(33);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i] = new TextField();
            dicePane.add(txfValues[i], i, 0);
            txfValues[i].setMinSize(100, 100);
            txfValues[i].setMaxSize(100, 100);
            txfValues[i].setFont(Font.font(55));
            txfValues[i].setDisable(true);
            cbxHolds[i] = new CheckBox();
            dicePane.add(cbxHolds[i], i, 1);
            cbxHolds[i].setText("Holds");
        }
        Button btnRoll = new Button(" Roll ");
        dicePane.add(btnRoll, 2, 2);
        GridPane.setHalignment(btnRoll, HPos.CENTER);
        btnRoll.setOnAction(event -> this.rollAction());

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        // scorePane.setGridLinesVisible(true);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int w = 55; // width of the text fields

        Label lbl1 = new Label("1's");
        scorePane.add(lbl1, 2, 0);
        Label lbl2 = new Label("2's");
        scorePane.add(lbl2, 2, 1);
        Label lbl3 = new Label("3's");
        scorePane.add(lbl3, 2, 2);
        Label lbl4 = new Label("4's");
        scorePane.add(lbl4, 2, 3);
        Label lbl5 = new Label("5's");
        scorePane.add(lbl5, 2, 4);
        Label lbl6 = new Label("6's");
        scorePane.add(lbl6, 2, 5);
        Label lblOnePair = new Label("One Pair");
        scorePane.add(lblOnePair, 27, 0);
        Label lblTwoPair = new Label("Two Pair");
        scorePane.add(lblTwoPair, 27, 1);
        Label lblThreeSame = new Label("Three-Same");
        scorePane.add(lblThreeSame, 27, 2);
        Label lblFourSame = new Label("Four-Same");
        scorePane.add(lblFourSame, 27, 3);
        Label lblFullHouse = new Label("Full House");
        scorePane.add(lblFullHouse, 27, 4);
        Label lblSmallStraight = new Label("Small Straight");
        scorePane.add(lblSmallStraight, 27, 5);
        Label lblLargeStraight = new Label("Large Straight");
        scorePane.add(lblLargeStraight, 27, 6);
        Label lblChance = new Label("Chance");
        scorePane.add(lblChance, 27, 7);
        Label lblYatzy = new Label("Yatzy");
        scorePane.add(lblYatzy, 27, 8);
        Label lblSumOfNumber = new Label("Sum");
        scorePane.add(lblSumOfNumber, 2, 6);
        scorePane.add(txfSumOfNumber, 0, 6);
        txfSumOfNumber.setMinSize(w,30);
        txfSumOfNumber.setMaxSize(w,30);
        Label lblSumOfOther = new Label("Sum");
        scorePane.add(lblSumOfOther, 15, 10);
        scorePane.add(txfSumOther, 15, 9);
        txfSumOther.setMinSize(w,30);
        txfSumOther.setMaxSize(w,30);
        Label lblBonus = new Label("Bonus");
        scorePane.add(lblBonus, 2, 7);
        scorePane.add(txfBonus, 0, 7);
        txfBonus.setMinSize(w,30);
        txfBonus.setMaxSize(w,30);
        Label lblTotal = new Label("TOTAL");
        scorePane.add(lblTotal, 18, 10);
        scorePane.add(txfTotal, 18, 9);
        txfTotal.setMinSize(w,30);
        txfTotal.setMaxSize(w,30);
        for (int i = 0; i < txfResults.length - 9; i++){
            int l = 0;
            txfResults[i] = new TextField();
            scorePane.add(txfResults[i], l, i);
            txfResults[i].setMinSize(w, 30);
            txfResults[i].setMaxSize(w, 30);
            GridPane.setHalignment(txfResults[i], HPos.LEFT);
            txfResults[i].setOnMouseClicked(event -> this.mouseClicked(event));
                if (i == 5) {
                    l = 29;
                    for (int j = 6; j < txfResults.length; j++) {
                        txfResults[j] = new TextField();
                        scorePane.add(txfResults[j], l, j - 6);
                        txfResults[j].setMinSize(w, 30);
                        txfResults[j].setMaxSize(w, 30);
                        GridPane.setHalignment(txfResults[j], HPos.RIGHT);
                        txfResults[j].setOnMouseClicked(event -> this.mouseClicked(event));
                    }
                }
        }
    }



    // -------------------------------------------------------------------------

    // Create an action method for btnRoll's action.
    // Hint: Create small helper methods to be used in the action method.
    // TODO
    private void rollAction() {
        if (dice.getThrowCount() < 3) {
            boolean[] hold = new boolean[5];
            for (int i = 0; i < cbxHolds.length; i++){
                hold[i] = cbxHolds[i].isSelected();
            }
            dice.throwDice(hold);

            for (int i = 0; i < dice.getValues().length; i++){
                txfValues[i].setText("" + dice.getValues()[i]);
                if(hold[i]) {
                    txfValues[i].setDisable(true);
                    cbxHolds[i].setDisable(true);
                }
                else {
                    txfValues[i].setDisable(false);
                    cbxHolds[i].setSelected(false);
                    cbxHolds[i].setDisable(false);
                }
            }

            for (int i = 0; i < txfResults.length; i++){
                if (txfResults[i].isDisable() == false) {
                    txfResults[i].setText("" + dice.getResults()[i]);
                }
            }
            if (dice.getThrowCount() == 0) {
                for (int i = 0; i < cbxHolds.length; i++) {
                    cbxHolds[i].setDisable(false);
                }
            }
        }
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    // TODO
    private void mouseClicked(MouseEvent event) {
        if (dice.getThrowCount() != 0) {
            TextField txf = (TextField) event.getSource();
            txf.setDisable(true);

            int sum = 0;
            for (int i = 0; i < 6; i++) {
                if (txfResults[i].isDisable() == true){
                    sum = sum + Integer.parseInt(txfResults[i].getText());
                }
            }
            int sum2 = 0;
            for (int i = 6; i < 15; i++) {
                if (txfResults[i].isDisable() == true) {
                    sum2 = sum2 + Integer.parseInt(txfResults[i].getText());
                }
            }
            txfSumOfNumber.setText("" + sum);
            txfSumOther.setText("" + sum2);
            int temp = 0;
            dice.resetThrowCount();
            if (sum >= 63) {
                txfBonus.setText("" + 50);
                temp = 50;
            }

            txfTotal.setText("" + (sum + sum2 + temp));
        }
        if (dice.getThrowCount() == 0) {
            for (int i = 0; i < cbxHolds.length; i++) {
                txfValues[i].setDisable(false);
                cbxHolds[i].setSelected(false);
            }
        }
        if (dice.getThrowCount() == 0) {
            for (CheckBox cbxHold : cbxHolds) {
                cbxHold.setDisable(true);
            }
        }
    }
}