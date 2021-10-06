package com.javatesting.Threading;

public class PrintNumberUsingTwoThreads {

    int counter = 1;
    static int target;

    public static void main(String[] args) {

        target = 10;

        PrintNumberUsingTwoThreads printNumberUsingTwoThreads = new PrintNumberUsingTwoThreads();
        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumberUsingTwoThreads.printEven();
            }
        }, "evenThread");

        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumberUsingTwoThreads.printOdd();
            }
        }, "oddThread");

        evenThread.start();
        oddThread.start();

    }

    public void printEven(){
        synchronized (this) {
            while (counter<target) {
                if (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" -- "+ counter);
                counter++;
                notify();

            }
        }
    }

    public void printOdd(){
        synchronized (this) {
            while (counter < target) {
                if (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" -- "+ counter);
                counter++;
                notify();
            }
        }
    }

}
