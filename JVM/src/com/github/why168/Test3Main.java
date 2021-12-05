package com.github.why168;

/**
 * @author Edwin.Wu edwin.wu05@gmail.com
 * @version 2020/2/29 5:35 下午
 * @since JDK1.8
 */
public class Test3Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        System.out.println("---");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName());
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + " hello");
                }
            }
        });

        thread.start();
        thread.wait(1 * 1000);
        thread.interrupt();
//        thread.join();
        System.out.println("main is over");

    }
}
