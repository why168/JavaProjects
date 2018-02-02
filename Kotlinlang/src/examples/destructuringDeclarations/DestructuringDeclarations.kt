package examples.destructuringDeclarations

/**
 * This example introduces a concept that we call destructuring declarations.
 * It creates multiple variable at once. Anything can be on the right-hand
 * side of a destructuring declaration, as long as the required number of component
 * functions can be called on it.
 * See http://kotlinlang.org/docs/reference/multi-declarations.html#multi-declarations
 *
 * @author Edwin.Wu
 * @version 2018/1/30 下午6:37
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    val pair = Pair(1, "one")

    val (num, name666) = pair

    // 等价于
//    println(pair.component1())
//    println(pair.component2())

    println("num = $num,name = $name666")
}

class Pair<out K, out V>(private val first: K, private val second: V) {
    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }
}