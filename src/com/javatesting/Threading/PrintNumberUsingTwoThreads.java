package com.javatesting.Threading;

public class PrintNumberUsingTwoThreads {

    int counter = 1;
    int target = 10;

    public static void main(String[] args) {

        PrintNumberUsingTwoThreads printNumberUsingTwoThreads = new PrintNumberUsingTwoThreads();
        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumberUsingTwoThreads.printEven();
            }
        });

        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumberUsingTwoThreads.printOdd();
            }
        });

        evenThread.start();
        oddThread.start();

    }

    void printEven(){
        synchronized (this) {
            if (counter<target) {
                if (counter % 2 == 1) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println(counter);
                    counter++;
                    notify();
                }
            }
        }
    }

    void printOdd(){
        synchronized (this) {
            if (counter < target) {
                if (counter % 2 == 0) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(counter);
                counter++;
                notify();
            }
        }
    }

}
