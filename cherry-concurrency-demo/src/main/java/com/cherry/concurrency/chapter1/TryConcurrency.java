package com.cherry.concurrency.chapter1;

public class TryConcurrency {

    public static void main(String[] args) {
        Thread t = new Thread("READ-Thread") {
            @Override
            public void run() {
                println(Thread.currentThread().getName());//main
                readFromDataBase();
            }
        };

        t.start();

/*        new Thread("WRITE-Thread"){
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();*/
    }

    private static void readFromDataBase() {
        //read data from database and handle it.
        try {
            println("Begin read data from db.");
            Thread.sleep(1000 * 30L);
            println("Read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("The data handle finish and successfully.");
    }

    @SuppressWarnings("unused")
    private static void writeDataToFile() {
        try {
            println("Begin write data to file.");
            Thread.sleep(2000 * 20L);
            println("Write data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("The data handle finish and successfully.");
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
