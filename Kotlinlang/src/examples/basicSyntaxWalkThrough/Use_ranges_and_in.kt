package examples.basicSyntaxWalkThrough

/**
 * 检查一个数字是否在一个范围内。
 * 检查一个数字是否超出范围。
 * 检查一个集合是否包含一个对象。
 *
 * See http://kotlinlang.org/docs/reference/ranges.html#ranges
 *
 * @author Edwin.Wu
 * @version 2018/1/30 下午4:51
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    val x = 10

    //Check if a number lies within a range:
    val y = 10

    if (x in 1..y - 1)
        println("OK")

    //Iterate over a range:
    for (a in 1..5)
        println("$a")

    //Check if a number is out of range:
    println()
    var array = arrayListOf<String>()
    array.add("aaa")
    array.add("bbb")
    array.add("ccc")

    if (x !in 0..array.size - 1)
        println("Out: array has only ${array.size} elements. x = $x")

    //Check if a collection contains an object:
    if ("aaa" in array) // collection.contains(obj) is called
        println("Yes: array contains aaa")

    if ("ddd" in array) // collection.contains(obj) is called
        println("Yes: array contains ddd")
    else
        println("No: array doesn't contains ddd")


}