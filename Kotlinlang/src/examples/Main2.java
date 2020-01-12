package examples;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Edwin.Wu
 * @version 2018-12-26 20:36
 * @since JDK1.8
 */
class Main2 {

    public static void main(String[] args) {
        Student.main();
    }

    static class Person<T> {

    }

    static class Student extends Person<Student> {

        static void main() {
            Student st = new Student();
            Class clazz = st.getClass();

            // getSuperclass()获得该类的父类
            System.out.println(clazz.getSuperclass());

            // getGenericSuperclass()获得带有泛型的父类
            // Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
            Type type = clazz.getGenericSuperclass();
            System.out.println(type);

            // ParameterizedType参数化类型，即泛型
            ParameterizedType p = (ParameterizedType) type;
            // getActualTypeArguments获取参数化类型的数组，泛型可能有多个
            Class c = (Class) p.getActualTypeArguments()[0];
            System.out.println(c);

            // 输出内容
            // class com.Main$Person
            // com.Main.com.Main$Person<com.Main$Student>
            // class com.Main$Student
        }
    }
}


/*
 * class com.test.Person
 * com.test.Person<com.test.Student>
 * class com.test.Student
 */

/*
 * 输出内容
 *
 * class com.Main$Person
 * com.Main.com.Main$Person<com.Main$Student>
 * class com.Main$Student
 *
 */

