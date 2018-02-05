package examples.callableReferences

/**
 * The composition function return a composition of two functions passed to it:
 * compose(f, g) = f(g(*)).
 * Now, you can apply it to callable references.
 *
 * @author Edwin.Wu
 * @version 2018/2/3 上午11:26
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    val oddLength = compose(::isOdd2, ::length)
    val strings = listOf("a", "ab", "abc")

    println(strings.filter(oddLength))
}

fun isOdd2(x: Int) = x % 2 != 0
fun length(s: String) = s.length

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}