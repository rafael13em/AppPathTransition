/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppathtransition;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author rafae
 */
public class AppPathTransition extends Application{

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(125, 100, 50);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        Rectangle rec = new Rectangle(20, 30);
        rec.setFill(Color.ORANGE);
        // Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circle);
        pt.setNode(rec);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
        pt.play(); // Start animation
        circle.setOnMousePressed(e -> pt.pause());
        circle.setOnMouseReleased(e -> pt.play());
        
        Pane root = new Pane();
        root.getChildren().add(rec);
        root.getChildren().add(circle);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
