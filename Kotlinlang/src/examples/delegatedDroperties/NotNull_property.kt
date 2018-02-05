package examples.delegatedDroperties

import kotlin.properties.Delegates

/**
 * Users frequently ask what to do when you have a non-null var, but you don't have an
 * appropriate value to assign to it in constructor (i.e. it must be assigned later)?
 * You can't have an uninitialized non-abstract property in Kotlin. You could initialize it
 * with null, but then you'd have to check every time you access it. Now you have a delegate
 * to handle this. If you read from this property before writing to it, it throws an exception,
 * after the first assignment it works as expected.
 *
 * @author Edwin.Wu
 * @version 2018/2/2 下午10:19
 * @since JDK1.8
 */
class User1 {
    var name: String by Delegates.notNull()

    fun init(name: String) {
        this.name = name
    }
}

fun main(args: Array<String>) {
    val user = User1()
    // user.name -> IllegalStateException
    user.init("Carl")
    println(user.name)
}

