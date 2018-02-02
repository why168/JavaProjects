package examples.destructuringDeclarations

/**
 * Kotlin Standard Library provide component functions for Map.Entry
 *
 * @author Edwin.Wu
 * @version 2018/2/1 下午5:35
 * @since JDK1.8
 */
fun main(args: Array<String>) {
    val map = hashMapOf<String, Int>()
    map.put("one", 1)
    map.put("two", 2)

    for ((key, value) in map) {
        println("key = $key, value = $value")
    }

}