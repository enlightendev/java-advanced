package com.enlightendev.concurrency.reentrantlocks.ex2;

/**
 * Driver app to execute multiple threads against s shared resource (Runner).
 * We start both threads and examine the state of the shared resource when done executing
 * to understand the impact of using re entrant locks
 */
public class App {

    public static void main(String[] args) throws Exception{

        final Runner runner = new Runner();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    runner.threadOneIncrement();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    runner.threadTwoIncrement();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner.finished();

    }
}
