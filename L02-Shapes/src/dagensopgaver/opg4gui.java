package dagensopgaver;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class opg4gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Huset");
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

        Circle sun = new Circle(300,80,30);
        pane.getChildren().add(sun);
        sun.setFill(Color.YELLOW);
        sun.setStroke(Color.BLACK);

        Line Ground = new Line(10, 300, 380, 300);
        pane.getChildren().add(Ground);

        Rectangle House = new Rectangle(20, 200, 100, 100);
        pane.getChildren().add(House);
        House.setFill(Color.RED);

        Rectangle Window = new Rectangle(35, 220, 30, 30);
        pane.getChildren().add(Window);
        Window.setFill(Color.BLACK);

        Polygon Roof = new Polygon(10, 200, 70, 120, 130, 200);
        pane.getChildren().add(Roof);
        Roof.setFill(Color.GREEN);
    }
}