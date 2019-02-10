package com.henrj.threads;

public class HardThreadQuestion {

    public static void main (String [] args) {
        final Foo f = new Foo();

        Thread t = new Thread(new Runnable() {
            public void run() {
                f.doStuff();
            }
        });

        Thread g = new Thread() {
            @Override
            public void run() {
                f.doStuff();
            }
        };

        t.start();
        g.start();
    }
}

class Foo {
    private int x = 5;

    void doStuff() {
        if (x < 10) {
            // nothing to do
            try {
                wait();
            } catch (InterruptedException ignored) { }
        }
        else {
            System.out.println("x is " + x++);
            if (x >= 10) {
                notify();
            }
        }
    }
}
