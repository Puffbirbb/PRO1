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

public class opg2gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Solnedgang På Stranden");
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

        Rectangle sky = new Rectangle(0, 0, 400, 400);
        pane.getChildren().add(sky);
        sky.setFill(Color.LIGHTBLUE);

        Circle sun = new Circle(200,300,30);
        pane.getChildren().add(sun);
        sun.setFill(Color.YELLOW);
        sun.setStroke(Color.BLACK);

        Rectangle sand = new Rectangle(0, 350, 400, 400);
        pane.getChildren().add(sand);
        sand.setFill(Color.BEIGE);

        Rectangle sea = new Rectangle(0, 300, 400, 60);
        pane.getChildren().add(sea);
        sea.setFill(Color.BLUE);

        //Sky 1

        Circle c11 = new Circle(80,200,20);
        pane.getChildren().add(c11);
        c11.setFill(Color.WHITE);
        c11.setStroke(Color.WHITE);

        Circle c12 = new Circle(100,200,20);
        pane.getChildren().add(c12);
        c12.setFill(Color.WHITE);
        c12.setStroke(Color.WHITE);

        Circle c13 = new Circle(90,190,20);
        pane.getChildren().add(c13);
        c13.setFill(Color.WHITE);
        c13.setStroke(Color.WHITE);

        //Sky 2

        Circle c21 = new Circle(190,100,20);
        pane.getChildren().add(c21);
        c21.setFill(Color.WHITE);
        c21.setStroke(Color.WHITE);

        Circle c22 = new Circle(210,100,20);
        pane.getChildren().add(c22);
        c22.setFill(Color.WHITE);
        c22.setStroke(Color.WHITE);

        Circle c23 = new Circle(200,110,20);
        pane.getChildren().add(c23);
        c23.setFill(Color.WHITE);
        c23.setStroke(Color.WHITE);

        //Sky 3

        Circle c31 = new Circle(320,200,20);
        pane.getChildren().add(c31);
        c31.setFill(Color.WHITE);
        c31.setStroke(Color.WHITE);

        Circle c32 = new Circle(300,200,20);
        pane.getChildren().add(c32);
        c32.setFill(Color.WHITE);
        c32.setStroke(Color.WHITE);

        Circle c33 = new Circle(310,190,20);
        pane.getChildren().add(c33);
        c33.setFill(Color.WHITE);
        c33.setStroke(Color.WHITE);

    }



}
