// Christopher Selter
// CS272
// Homework 4 - Due August 1, 2020

package com.csc272.bouncingball;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;             // JavaFX Scene 
    private final double BALL_SIZE = 20.0;  // size of Ball
    private final int BALL_SPEED = 2;

    @Override
    public void start(Stage stage) {

        // JavaFX Components 
        Group group = new Group();          // Create new container for JavaFX components
        scene = new Scene(group, 600, 400); // Create the size of window scene
        stage.setScene(scene);

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {

                System.out.println("NEW BALL AT " + mouseEvent.getSceneX() + " | " + mouseEvent.getSceneY());
                // When the mouse is clicked, create a ball at those coordinates
                Ball ball = new Ball(scene, BALL_SIZE, BALL_SPEED, mouseEvent.getSceneX(), mouseEvent.getSceneY());
                group.getChildren().add(ball.getBall());

                // Start thread             
                BallThread ballThread = new BallThread(ball);
                ballThread.startMoving();
            }

        });

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
