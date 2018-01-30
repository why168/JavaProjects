package examples.helloWord

/**
 * 演示了字符串模板和数组访问。
 * See this pages for details:
 * http://kotlinlang.org/docs/reference/basic-types.html#strings
 * http://kotlinlang.org/docs/reference/basic-types.html#arrays
 *
 * @author Edwin.Wu
 * @version 2018/1/30 下午3:01
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    if (args.size == 0) {
        println("Please provide a name as a command-line argument")
        return
    }
    println("Hello, ${args[0]}!")
}