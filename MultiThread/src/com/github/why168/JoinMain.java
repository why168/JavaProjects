package com.github.why168;

import java.util.concurrent.TimeUnit;

/**
 * Join
 *
 * @author Edwin.Wu edwin.wu05@gmail.com
 * @version 2020/1/12 6:41 下午
 * @since JDK1.8
 */
public class JoinMain {

    public static void main(String[] args) {
        Thread threadA = new Thread(new RunJoin("A"));
        Thread threadB = new Thread(new RunJoin("B"));

        threadA.start();
        threadB.start();
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("JoinMain .......");
    }

    static class RunJoin implements Runnable {

        private final String tag;

        public RunJoin(String tag) {
            this.tag = tag;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " * " + tag + " -- start");

            try {
                TimeUnit.SECONDS.sleep(40000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " * " + tag + " -- stop");
        }
    }
}
