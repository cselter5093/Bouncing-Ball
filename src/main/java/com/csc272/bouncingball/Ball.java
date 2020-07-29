// Christopher Selter
// CS272
// Homework 4 - Due August 1, 2020
package com.csc272.bouncingball;

import java.util.Random;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {

    private double size;   // radius size of ball
    private double xCoord; // x coordinate of ball
    private double yCoord; // y coordinate of ball
    private Circle myBall; // circle object
    private double sceneWidth;
    private double sceneHeight;
    private int ballDirectionX;
    private int ballDirectionY;

    // Constructor 
    Ball(Scene scene, double size, int speed, double xC, double yC) {
        // set object variables 
        this.size = size;
        
        
       
                
        this.xCoord = xC;
        
       
        
        this.yCoord = yC;
        this.sceneHeight = scene.getHeight();
        this.sceneWidth = scene.getWidth();
        this.ballDirectionX = speed;
        this.ballDirectionY = speed;

        this.myBall = new Circle(xCoord, yCoord, size);
        myBall.setFill(Color.BLUE);

        // Use Random Boolean to determine initial direction
        Random randDir = new Random();

        if (randDir.nextBoolean()) {
            this.ballDirectionX *= -1;
        }

        if (randDir.nextBoolean()) {
            this.ballDirectionY *= -1;
        }
    }

    public void moveMyBall() {

        if (xCoord - size < 0 || xCoord + size >= sceneWidth)
            ballDirectionX = -ballDirectionX;
        
        if (yCoord - size < 0 || yCoord + size >= sceneHeight)
            ballDirectionY = -ballDirectionY;
        
        xCoord += ballDirectionX;
        yCoord += ballDirectionY;
       
        myBall.setCenterX(xCoord);
        myBall.setCenterY(yCoord);

        System.out.println("xCoord: " + xCoord + " yCoord: " + yCoord);

    }

    public Circle getBall() {
        return this.myBall;
    }

}