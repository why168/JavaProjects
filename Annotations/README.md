# Annotations-Java注解项目

## 介绍

* Java Annotation是JDK5.0引入的一种注释机制，提供一种为程序元素设置元数据的方法。
* 注解（也被成为元数据）为我们在代码中添加信息提供了一种形式化的方法，使我们可以在稍后某个时刻非常方便地使用这些数据。 ———摘自《Thinking in Java》
* 元数据的作用
  1. 编写文档：通过代码里标识的元数据生成文档；
  2. 代码分析：通过代码里标识的元数据对代码进行分析；
  3. 编译检查：通过代码里标识的元数据让编译器能实现基本的编译检查。
* 学习注解目的？
  1. 能够读懂别人使用注解实现的开源库
  2. 让编程变得更加简洁


``` Java
* 注解的分类
  * 标准注解:
    1. @Override: 重写函数
    2. @Deprecated: 标记过时方法。如果使用该方法，会报编译警告
    3. @SuppressWarnings: 指示编译器去忽略注解中声明的警告
  * 元注解:
    1. @Inherited：标记这个注解是继承于哪个注解类(默认 注解并没有继承于任何子类)
    2. @Documented：标记这些注解是否包含在用户文档中
    3. @Retention：标识这个注解怎么保存
      1. SOURCE：Annotation信息仅存在于编译器处理期间，编译器处理完之后就没有该Annotation信息了（源文件保留）
      2. CLASS：编译器将Annotation存储于类对应的.class文件中。默认行为（class保留）
      3. RUNTIME：编译器将Annotation存储于class文件中，并且可由JVM读入（运行时保留）
    4. @Target：标记这个注解应该是哪种Java成员
      1. TYPE：类、接口（包括注释类型）或枚举声明
      2. FIELD：字段声明（包括枚举常量）
      3. METHOD：方法声明
      4. PARAMETER：参数声明
      5. CONSTRUCTOR：构造方法声明
      6. LOCAL_VARIABLE：局部变量声明
      7. ANNOTATION_TYPE：注释类型声明
      8. PACKAGE：包声明
    5. @SafeVarargs：Java7 开始支持，忽略任何使用参数为泛型变量的方法或构造函数调用产生的警告。
    6. @FunctionalInterface：Java8 开始支持，标识一个匿名函数或函数式接口。
    7. @Repeatable：Java8 开始支持，标识某注解可以在同一个声明上使用多次。
  * 自定义注解:
    1. 源码时
    2. 编译时
    3. 运行时
```






# 参考资料
  * http://www.akathink.com/2016/08/11/%E5%BD%BB%E5%BA%95%E6%90%9E%E6%87%82Java%E6%B3%A8%E8%A7%A3Annotation/

  * http://www.cnblogs.com/skywang12345/p/3344137.html

  * https://www.jianshu.com/p/d115baa823a7

  * https://docs.oracle.com/javase/1.5.0/docs/guide/language/annotations.html
