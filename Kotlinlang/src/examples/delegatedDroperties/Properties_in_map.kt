package examples.delegatedDroperties

/**
 * Properties stored in a map. This comes up a lot in applications like parsing JSON
 * or doing other "dynamic" stuff. Delegates take values from this map (by the string keys -
 * names of properties). Of course, you can have var's as well,
 * that will modify the map upon assignment (note that you'd need MutableMap instead of read-only Map).
 *
 * @author Edwin.Wu
 * @version 2018/2/2 下午10:22
 * @since JDK1.8
 */
class User2(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main(args: Array<String>) {
    val user = User2(mapOf(
            "name" to "John Doe",
            "age" to 25
    ))

    println("name =${user.name}, age =${user.age}")
}