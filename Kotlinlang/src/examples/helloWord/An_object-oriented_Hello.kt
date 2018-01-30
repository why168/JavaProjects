package examples.helloWord

/**
 * 这里我们有一个具有主构造函数和成员函数的类。
 * 注意，没有用于创建对象的“新”关键字。
 * See http://kotlinlang.org/docs/reference/classes.html#classes
 *
 * @author Edwin.Wu
 * @version 2018/1/30 下午3:18
 * @since JDK1.8
 */
class Greeter(val name: String) {
    fun greet() {
        println("Hello,${name}")
    }
}

fun main(args: Array<String>) {
    Greeter("args").greet()
}

