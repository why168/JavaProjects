package examples.basicSyntaxWalkThrough

/**
 *
 * 引用必须显式地标记为可空，以使其具有空值。
 * See http://kotlinlang.org/docs/reference/null-safety.html#null-safety
 *
 * @author Edwin.Wu
 * @version 2018/1/30 下午4:06
 * @since JDK1.8
 */

fun parseInt(str: String): Int? {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        println("One of the arguments isn't Int")
    }
    return null
}

fun main(args: Array<String>) {
    if (args.size < 2) {
        println("No number supplied")
    } else {
        val x = parseInt(args[0])
        val y = parseInt(args[1])

        if (x != null && y != null) {
            println(x * y)
        } else {
            println("One of the arguments is null")
        }
    }
}