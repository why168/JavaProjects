package com.github.why168;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 栈侦空间大小设置：‐Xss128K
 * <p>
 * count = 22304
 *
 * @author Edwin.Wu edwin.wu05@gmail.com
 * @version 2020/2/4 10:27 下午
 * @since JDK1.8
 */
public class StackOverflowErrorTest {

    private static int count = 0;

    byte[] a = new byte[1024 * 100];

    public static void redo() {
        count++;
        redo();
    }

    public static void main(String[] args) {

        try {
            redo();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("count = " + count);
        }

//        ArrayList<StackOverflowErrorTest> array = new ArrayList<>();
//        while (true) {
//            // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//            array.add(new StackOverflowErrorTest());
//        }

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
