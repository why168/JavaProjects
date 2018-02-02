package examples.basicSyntaxWalkThrough

/**
 *
 *
 * @author Edwin.Wu
 * @version 2018/1/30 下午4:47
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    var i = 0
    while (i < args.size) {
        println(args[i++])
    }
}