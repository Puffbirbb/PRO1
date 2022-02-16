package dagensopgaver;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class opg3gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Opgaver");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    private void drawShapes(Pane pane){

        //Navn Firkant

        Rectangle Background = new Rectangle(180, 170, 80, 35);
        pane.getChildren().add(Background);
        Background.setFill(Color.BLACK);
        Text Gwion = new Text(185, 200, "Gwion");
        Gwion.setFont(Font.font(25));
        Gwion.setFill(Color.GOLD);
        pane.getChildren().add(Gwion);

        //Ansigt

        Circle face = new Circle(50,50,20);
        pane.getChildren().add(face);
        face.setFill(Color.WHITE);
        face.setStroke(Color.BLACK);
        Circle eye1 = new Circle(42,44,2);
        pane.getChildren().add(eye1);
        eye1.setFill(Color.WHITE);
        eye1.setStroke(Color.BLACK);
        Circle eye2 = new Circle(58,44,2);
        pane.getChildren().add(eye2);
        eye2.setFill(Color.WHITE);
        eye2.setStroke(Color.BLACK);
        Line mouth = new Line(42, 60, 58, 60);
        pane.getChildren().add(mouth);

        //Målskive

        Circle OuterTarget = new Circle(50,300,20);
        pane.getChildren().add(OuterTarget);
        OuterTarget.setFill(Color.BLACK);
        OuterTarget.setStroke(Color.BLACK);
        Circle SecondTarget = new Circle(50,300,16);
        pane.getChildren().add(SecondTarget);
        SecondTarget.setFill(Color.WHITE);
        SecondTarget.setStroke(Color.WHITE);
        Circle ThirdTarget = new Circle(50,300,12);
        pane.getChildren().add(ThirdTarget);
        ThirdTarget.setFill(Color.BLACK);
        ThirdTarget.setStroke(Color.BLACK);
        Circle FourthTarget = new Circle(50,300,8);
        pane.getChildren().add(FourthTarget);
        FourthTarget.setFill(Color.WHITE);
        FourthTarget.setStroke(Color.WHITE);
        Circle FifthTarget = new Circle(50,300,4);
        pane.getChildren().add(FifthTarget);
        FifthTarget.setFill(Color.BLACK);
        FifthTarget.setStroke(Color.BLACK);

        //OL Logo

        Circle BlueCircle = new Circle(240,300,20);
        pane.getChildren().add(BlueCircle);
        BlueCircle.setFill(Color.TRANSPARENT);
        BlueCircle.setStroke(Color.BLUE);
        BlueCircle.setStrokeWidth(2);
        Circle BlackCircle = new Circle(280,300,20);
        pane.getChildren().add(BlackCircle);
        BlackCircle.setFill(Color.TRANSPARENT);
        BlackCircle.setStroke(Color.BLACK);
        BlackCircle.setStrokeWidth(2);
        Circle RedCircle = new Circle(320,300,20);
        pane.getChildren().add(RedCircle);
        RedCircle.setFill(Color.TRANSPARENT);
        RedCircle.setStroke(Color.RED);
        RedCircle.setStrokeWidth(2);
        Circle YellowCircle = new Circle(260,320,20);
        pane.getChildren().add(YellowCircle);
        YellowCircle.setFill(Color.TRANSPARENT);
        YellowCircle.setStroke(Color.YELLOW);
        YellowCircle.setStrokeWidth(2);
        Circle GreenCircle = new Circle(300,320,20);
        pane.getChildren().add(GreenCircle);
        GreenCircle.setFill(Color.TRANSPARENT);
        GreenCircle.setStroke(Color.GREEN);
        GreenCircle.setStrokeWidth(2);



    }
}
