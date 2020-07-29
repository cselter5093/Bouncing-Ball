// Christopher Selter
// CS272
// Homework 4 - Due August 1, 2020
package com.csc272.bouncingball;

class BallThread extends Thread {

    private Ball myBall;
    private final int MAXTIME = 1000;  // how long the ball will bounce

    public BallThread(Ball inBall) {
        myBall = inBall;
    }

    @Override
    public void run() {
        try {
            
            for (int i = 0; i < MAXTIME; i++) {
                myBall.moveMyBall();
                System.out.println("iteration: " + i);
                sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Exception: " + e);
            e.printStackTrace();
        }
    }

}