package examples

/**
 * 枚举
 *
 * @author Edwin.Wu
 * @version 2018/2/8 下午7:16
 * @since JDK1.8
 */

enum class Week {
    星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日
}

fun main(args: Array<String>) {
    println(Week.星期一.ordinal)
    println(Week.星期日.ordinal)
}