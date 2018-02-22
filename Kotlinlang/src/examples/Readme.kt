package examples

/**
 *
 *
 * @author Edwin.Wu
 * @version 2018/2/22 上午10:55
 * @since JDK1.8
 */
fun main(args: Array<String>) {

    var age1 = 22
    val age2 = 22

    println("请输入第一个数字:")
    val number1 = null
    val num1 = number1!!.toInt()
}

fun parseInt(str: String): Int? {
    str.toInt()
    return str.toIntOrNull()
}


