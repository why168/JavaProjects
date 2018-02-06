package kotlins.koans.introduction

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 *
 *
 * @author Edwin.Wu
 * @version 2018/2/6 下午2:42
 * @since JDK1.8
 */
fun main(args: Array<String>) {

    println(start())
}

class Simple {

    @Test
    fun testOk() {
        Assert.assertEquals("OK", start())
    }

    @Test
    fun collection() {
        Assert.assertEquals("toJSON", "[1, 2, 3, 42, 555]", toJSON(listOf(1, 2, 3, 42, 555)))
    }

    @Test
    fun testJoinToString() {
        Assert.assertEquals("joinOptions", "[yes, no, may be]", joinOptions(listOf("yes", "no", "may be")))
    }

    @Test
    fun testDefaultAndNamedParams() {
        Assert.assertEquals(listOf("a42", "b1", "C42", "D2"), useFoo())
    }

    @Test
    fun contains() {
        println(containsEven(listOf(1, 2, 3, 126, 555)))
        Assert.assertTrue("The result should be true if the collection contains an even number", containsEven(listOf(1, 2, 3, 126, 555)))
    }

    @Test
    fun notContains() {
        println(containsEven(listOf(43, 33)))
        Assert.assertFalse("The result should be false if the collection doesn't contain an even number", containsEven(listOf(43, 33)))
    }

    private fun testMatch(date: String) = Assert.assertTrue("The pattern should match $date", date.matches(getPattern().toRegex()))
    private fun testMismatch(date: String) = Assert.assertFalse("The pattern shouldn't match $date", date.matches(getPattern().toRegex()))

    @Test
    fun match() {
        testMatch("11 MAR 1952")
    }

    @Test
    fun match1() {
        testMatch("24 AUG 1957")
    }

    @Test
    fun doNotMatch() {
        testMismatch("24 RRR 1957")
    }

    @Test
    fun testListOfPeople() {
        Assert.assertEquals("[Person(name=Alice, age=29), Person(name=Bob, age=31)]", getPeople().toString())
    }

    fun testSendMessageToClient(client: Client?,
                                message: String?,
                                expectedEmail: String? = null,
                                shouldBeInvoked: Boolean = false) {
        var invoked = false
        val expectedMessage = message
        sendMessageToClient(client, message, object : Mailer {
            override fun sendMessage(email: String, message: String) {
                invoked = true
                Assert.assertEquals("The message is not as expected:", expectedMessage, message)
                Assert.assertEquals("The email is not as expected:", expectedEmail, email)
            }
        })
        Assert.assertEquals("The function 'sendMessage' should${if (shouldBeInvoked) "" else "n't"} be invoked", shouldBeInvoked, invoked)
    }

    @Test
    fun everythingIsOk() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")),
                "Hi Bob! We have an awesome proposition for you...",
                "bob@gmail.com",
                true)
    }

    @Test
    fun noMessage() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")), null)
    }

    @Test
    fun testNum() {
        Assert.assertEquals("'eval' on Num should work:", 2, eval(Num(2)))
    }

    @Test
    fun testSum() {
        Assert.assertEquals("'eval' on Sum should work:", 3, eval(Sum(Num(2), Num(1))))
    }

    @Test
    fun testRecursion() {
        Assert.assertEquals("'eval' should work:", 6, eval(Sum(Sum(Num(1), Num(2)), Num(3))))
    }

    @Test
    fun testIntExtension() {
        Assert.assertEquals("Rational number creation error: ", RationalNumber(4, 1), 4.r())
    }

    @Test
    fun testPairExtension() {
        Assert.assertEquals("Rational number creation error: ", RationalNumber(2, 3), Pair(2, 3).r())
    }

    @Test
    fun testSort() {
        Assert.assertEquals("getList", listOf(5, 2, 1), getList())
        Assert.assertEquals("getList", listOf(5, 2, 1), getList2())
        Assert.assertEquals("getList", listOf(5, 2, 1), getList3())

        println( arrayListOf(5, 1, 2).sortedDescending())
        println( arrayListOf(5, 1, 2).sorted())
    }
}

/**
 * Hello, world!
 */
fun start(): String = "OK"

/**
 * Java to Kotlin conversion
 */
fun toJSON(collection: Collection<Int>): String {
    val sb = StringBuilder()
    sb.append("[")
    val iterator = collection.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        sb.append(element)
        if (iterator.hasNext()) {
            sb.append(", ")
        }
    }
    sb.append("]")
    return sb.toString()
}

/**
 * Named arguments
 */
fun joinOptions(options: Collection<String>) = options.joinToString(", ", "[", "]")

/**
 * Default arguments
 */

fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) = (if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo() = listOf(
        foo("a"),
        foo("b", number = 1),
        foo("c", toUpperCase = true),
        foo(name = "d", number = 2, toUpperCase = true)
)


/**
 * Lambdas
 */
fun containsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }


val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
/**
 * Strings
 */
fun getPattern(): String = """\d{2} ${month} \d{4}"""

/**
 * Data classes
 */
class Person(val name: String, var age: Int) {

    override fun toString(): String {
        return "Person(name=$name, age=$age)"
    }
}

fun getPeople(): List<Person> {
    return listOf(
            Person("Alice", 29),
            Person("Bob", 31)
    )
}

/**
 * Nullable types
 */
fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    if (client == null || message == null)
        return

    val personalInfo: PersonalInfo? = client.personalInfo ?: return
    val email: String = personalInfo?.email ?: return

    mailer.sendMessage(email, message)
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

/**
 * Smart casts
 */
fun eval(expr: Expr): Int =
        when (expr) {
            is Num -> expr.value
            is Sum -> eval(expr.left) + eval(expr.right)
            else -> throw IllegalArgumentException("Unknown expression")
        }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

/**
 * Extension functions
 */
fun Int.r(): RationalNumber = RationalNumber(this, 1)

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)

data class RationalNumber(val numerator: Int, val denominator: Int)

/**
 * Object expressions
 */
fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)

    Collections.sort(arrayList, object : Comparator<Int> {
        override fun compare(x: Int, y: Int) = y - x
    })

    return arrayList
}

/**
 * SAM conversions
 */
fun getList2(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, { x, y -> -x + y })
    return arrayList
}

/**
 * Extension functions on collections
 */
fun getList3(): List<Int> {
    return arrayListOf(1, 5, 2).sortedDescending()
}
