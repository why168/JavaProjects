package examples.helloWord

/**
 *
 *
 * @author Edwin.Wu
 * @version 2018/1/30 下午3:07
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    for (name in args)
        println("Hello,$name")

    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
}