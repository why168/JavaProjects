package examples.basicSyntaxWalkThrough

/**
 * For loop iterates through anything that provides an iterator.
 * See http://kotlinlang.org/docs/reference/control-flow.html#for-loops
 * @author Edwin.Wu
 * @version 2018/1/30 下午4:49
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    for (arg in args)
        println(arg)

    // or
    println()
    for (i in args.indices) {
        println(args[i])
    }
}