package com.henrj.threads;

public class BasicThreadExecution implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new BasicThreadExecution());

        t.start();
        System.out.print("started");

        t.join();

        System.out.print("Complete");

    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.print(i);
        }
    }
}
