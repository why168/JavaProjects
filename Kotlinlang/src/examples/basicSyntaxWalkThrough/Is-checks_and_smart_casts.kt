package examples.basicSyntaxWalkThrough

/**
 *
 *
 * @author Edwin.Wu
 * @version 2018/1/30 下午4:14
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    println(getStringLength("aaa"))
    println(getStringLength(1))
}

fun getStringLength(obj: Any): Int? {
    if (obj is String)
        return obj.length
    return null
}