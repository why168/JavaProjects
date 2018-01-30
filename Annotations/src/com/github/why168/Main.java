package com.github.why168;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Edwin.Wu
 * @version 2018/1/20 下午5:44
 * @since JDK1.8
 */
public class Main {
    private static Main main = new Main();

    public Main() {
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        main.test1();
    }

    public void test1() {
        System.out.println("---------------Class---------------");

        Class<?> aClass = Person.class;
        boolean isExit = aClass.isAnnotationPresent(Description.class);
        if (isExit) {
            Description annotation = aClass.getAnnotation(Description.class);
            System.out.println(annotation.value());
        }

        System.out.println("\n");
        System.out.println("---------------Method---------------");

        Method[] methods = aClass.getMethods();
        for (Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                if (a instanceof Description) {
                    Description description = (Description) a;
                    System.out.println(description.value());
                }
            }
        }
    }
}
