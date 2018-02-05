package examples.delegatedDroperties

import kotlin.properties.Delegates

/**
 * The observable() function takes two arguments: initial value and a handler for modifications.
 * The handler gets called every time we assign to `name`, it has three parameters:
 * a property being assigned to, the old value and the new one. If you want to be able to veto
 * the assignment, use vetoable() instead of observable().
 * @author Edwin.Wu
 * @version 2018/2/2 下午10:14
 * @since JDK1.8
 */
class User {
    var name: String by Delegates.observable("no name") { _, old, new ->
        println("$old - $new")
    }
}

fun main(args: Array<String>) {
    val user = User()
    user.name = "Carl"

}