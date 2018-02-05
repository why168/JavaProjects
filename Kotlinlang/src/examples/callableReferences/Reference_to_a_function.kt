package examples.callableReferences

/**
 * "Callable References" or "Feature Literals", i.e. an ability to pass
 * named functions or properties as values. Users often ask
 * "I have a foo() function, how do I pass it as an argument?".
 * The answer is: "you prefix it with a `::`".
 * @author Edwin.Wu
 * @version 2018/2/2 下午10:31
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    val numbers = listOf(1, 2, 3)
    val result = numbers.filter(::isOdd)
    println(result)
}

fun isOdd(x: Int) = x % 2 != 0
