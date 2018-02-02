package examples.destructuringDeclarations

/**
 * Data class gets next functions, generated automatically:
 * component functions, toString(), equals(), hashCode() and copy().
 * See http://kotlinlang.org/docs/reference/data-classes.html#data-classes
 * @author Edwin.Wu
 * @version 2018/2/1 下午5:40
 * @since JDK1.8
 */
data class User1(val name: String, val id: Int)

fun main(args: Array<String>) {
    val user = User1("Alex", 1)
    println(user)

    val secondUser = User1("Alex", 1)
    val thirdUser = User1("Max", 1)

    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")

    // copy() function
    println(user.copy())
    println(user.copy(name = "Max"))
    println(user.copy(id = 2))
    println(user.copy(name = "Max", id = 2))

    println("user.toString() = " + user.toString())
    println("user.equals(secondUser) = " + user.equals(secondUser))
    println("user.hashCode() = " + user.hashCode())
    println("secondUser.hashCode() = " + secondUser.hashCode())
    println("thirdUser.hashCode() = " + thirdUser.hashCode())


}

