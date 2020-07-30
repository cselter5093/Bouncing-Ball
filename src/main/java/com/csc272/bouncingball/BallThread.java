// Christopher Selter
// CS272
// Homework 4 - Due August 1, 2020

package com.csc272.bouncingball;

import static java.lang.Thread.sleep;
import javafx.application.Platform;

class BallThread extends Thread {

    private Ball myBall;
    private final int MAXTIME = 1000;  // how long the ball will bounce

    public BallThread(Ball inBall) {
        myBall = inBall;
    }

    public void startMoving() {

        Runnable moveTheBall = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAXTIME; i++) {
                    try {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                myBall.moveMyBall();
                            }
                        });

                        System.out.println("iteration: " + i);
                        sleep(10);

                    } catch (InterruptedException e) {
                        System.out.println("Thread Exception: " + e);
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thisBallThread = new Thread(moveTheBall);
        thisBallThread.setDaemon(true);
        thisBallThread.start();
    }

}
