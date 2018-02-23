# Kotlin语法学习

## 介绍

1. 2017Google I/O讲到将Kotlin作为Android的第一开发语言，基于Java6
1. 100%兼容Java语言，支持混编
2. 代码的大幅度精简
3. 函数式编程，各种语法糖
4. 避免空指针异常出现
5. 切换到Kotlin无需成本
6. 由知名公司JetBrains为它提供强大的商业支持
7. 编译到APK包里面有大约有6000个方法


#### Scala、Groovy、Clojure 、Kotlin 分别解决了 Java 的什么痛点？

1. Scala：想解决Java表达能力不足的问题
2. Groovy：想解决Java语33法过于冗长的问题
3. Clojure：想解决Java没有函数式编程的问题
4. Kotlin：想解决Java

#### 示例代码
```Kotlin

var age1 = 22 // var是一个可变变量

val age2 = 22 // val是一个只读变量，相当于Java中的final变量

val num1 = number1!!.toInt() // !!表示和正常的Java一样可以为NULL,会报KotlinNullPointerException

fun parseInt(str: String): Int? { // ?:返回值夹问好，表示返回值可以为null
    str.toInt()
    return str.toIntOrNull()
}

var mContext1: Context? = null // 一般
var mContext2: Context by Delegates.notNull() // 委托

```

#### 插件推荐

1. JsonToKotlin：Android Studio插件根据Json自动生成KotlinBean.


# 参考资料
  * https://try.kotlinlang.org/
  * https://android-developers.googleblog.com/2017/05/android-announces-support-for-kotlin.html
  * http://www.demojameson.com/2015/11/08/why-kotlin/
  * http://yun.itheima.com/course/266.html
