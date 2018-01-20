package com.edwin;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Edwin.Wu
 * @version 2018/1/20 下午5:44
 * @since JDK1.8
 */
public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.edwin.Person");
            boolean isExit = aClass.isAnnotationPresent(Description.class);
            if (isExit) {
                Description annotation = aClass.getAnnotation(Description.class);
                System.out.println(annotation.value());
            }

            Method[] methods = aClass.getMethods();
            for (Method m : methods) {
                boolean annotationPresent = m.isAnnotationPresent(Description.class);
                if (annotationPresent) {
                    Description annotation = m.getAnnotation(Description.class);
                    System.out.println(annotation.value());
                }
            }

            for (Method m : methods) {
                Annotation[] annotations = m.getAnnotations();
                for (Annotation a : annotations) {
                    if (a instanceof Description) {
                        Description description = (Description) a;
                        System.out.println(description.value());
                    }


                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
