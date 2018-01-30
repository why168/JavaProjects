package examples.helloWord

/**
 * 在本例中，“val”表示一个只读局部变量的声明，该声明分配了一个模式匹配表达式。
 * See http://kotlinlang.org/docs/reference/control-flow.html#when-expression
 *
 * @author Edwin.Wu
 * @version 2018/1/30 下午3:11
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    val language = if (args.size == 0) "EN" else args[0]
    println(when (language) {
        "EN" -> "Hello!"
        "FR" -> "Salut!"
        "IT" -> "Ciao!"
        else -> "Sorry,I can't greet you in $language yet"
    })
}