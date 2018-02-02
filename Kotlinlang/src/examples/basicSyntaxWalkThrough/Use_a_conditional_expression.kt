package examples.basicSyntaxWalkThrough

/**
 * `if` is an expression, i.e. it returns a value.
 * Therefore there is no ternary operator (condition ? then : else),
 * because ordinary `if` works fine in this role.
 * See http://kotlinlang.org/docs/reference/control-flow.html#if-expression
 * @author Edwin.Wu
 * @version 2018/1/30 下午4:00
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    println(max(5, 10))
}

fun max(a: Int, b: Int) = if (a > b) a else b