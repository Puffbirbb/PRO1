package DagensOpgaver;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;

public class opg1gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Min Circle, Firkant, Streg");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    private void drawShapes(Pane pane) {
        Circle circle = new Circle(70,70,30);
        pane.getChildren().add(circle);
        circle.setFill(Color.DARKRED);
        circle.setStroke(Color.BLACK);

        Rectangle rectangle = new Rectangle(220, 220, 140, 140);
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.CRIMSON);
        rectangle.setStroke(Color.BLACK);

        Line line = new Line(0, 0, 400, 400);
        pane.getChildren().add(line);
        line.setFill(Color.BLACK);

    }



}
