package com.henrj.threads;

public class TestThreadExecution extends Thread {

    private int x = 2;

    public static void main(String[] args) throws Exception {
        new TestThreadExecution().makeItSo();
    }

    private TestThreadExecution() {
        x = 5;
        start();
    }

    private void makeItSo() throws Exception {
        join();
        x = x - 1;
        System.out.println(x);
    }

    @Override
    public void run() {
        x *= 2;
    }
}

class YieldTest extends Thread
{
    public void run()
    {
        System.out.println("In run");
        yield();
        System.out.println("Leaving run");
    }
    public static void main(String []argv)
    {
        (new YieldTest()).start();
    }
}

class Test107 implements Runnable
{
    private int x;
    private int y;

    public static void main(String args[])
    {
        Test107 that = new Test107();
        (new Thread(that)).start();
        (new Thread(that)).start();
    }
    public synchronized void run()
    {
        for(int i = 0; i < 10; i++)
        {
            x++;
            y++;
            System.out.println("x = " + x + ", y = " + y); /* Line 17 */
        }
    }
}

