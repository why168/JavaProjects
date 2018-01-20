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
    1. @Override:重写函数
    2. @Deprecated:不鼓励使用(有更好方式、使用有风险或已不在维护)
    3. @SuppressWarnings:忽略某项Warning
  * 元注解
    * @Retention
      1. SOURCE：Annotation信息仅存在于编译器处理期间，编译器处理完之后就没有该Annotation信息了（源文件保留）
      2. CLASS：编译器将Annotation存储于类对应的.class文件中。默认行为（class保留）
      3. RUNTIME：编译器将Annotation存储于class文件中，并且可由JVM读入（运行时保留）
    * @Target
      1. TYPE：类、接口（包括注释类型）或枚举声明
      2. FIELD：字段声明（包括枚举常量）
      3. METHOD：方法声明
      4. PARAMETER：参数声明
      5. CONSTRUCTOR：构造方法声明
      6. LOCAL_VARIABLE：局部变量声明
      7. ANNOTATION_TYPE：注释类型声明
      8. PACKAGE：包声明
    * @Inherited
    * @Documented
  * 自定义注解
    1. 源码时
    2. 编译时
    3. 运行时
```






# 参考资料
  * http://www.akathink.com/2016/08/11/%E5%BD%BB%E5%BA%95%E6%90%9E%E6%87%82Java%E6%B3%A8%E8%A7%A3Annotation/

  * http://www.cnblogs.com/skywang12345/p/3344137.html
