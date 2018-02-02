package examples.basicSyntaxWalkThrough

/**
 * See http://kotlinlang.org/docs/reference/control-flow.html#when-expression
 * @author Edwin.Wu
 * @version 2018/1/30 下午5:50
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
}

fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

class MyClass() {

}