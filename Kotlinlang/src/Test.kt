import org.junit.Test
import java.util.*

/**
 *
 *
 * @author Edwin.Wu
 * @version 2018-12-16 16:11
 * @since JDK1.8
 */
class Test {

    /**
     * repeat 操作符
     *
     * results:
     * Hello kotlin
     * Hello kotlin
     * Hello kotlin
     */
    @Test
    fun repeatTest() {
        repeat(3) {
            println("Hello kotlin")
        }
    }

    /**
     * repeat 操作符
     *
     * results:
     * language = [Java, Kotlin, Flutter]
     */
    @Test
    fun withTest() {
        with(ArrayList<String>()) {
            add("Java")
            add("Kotlin")
            add("Flutter")
            println("language = $this")
        }
    }

    @Test
    fun letTest(): Int {

        "testLet".let {
            println(it)
            println(it)
            println(it)
            return 1
        }
    }

    @Test
    fun alsoTest() {
        val also = Date().also {
            println("in also time = " + it.time)
        }

        println("also = $also")
    }

    @Test
    fun applyTest() {
        ArrayList<String>().apply {
            add("testApply")
            add("testApply")
            add("testApply")
            println("this = $this")
        }.let {
            println(it)
        }
    }

    @Test
    fun runTest() {
        "testRun".run {
            println("this = $this")
        }.let {
            println(it)
        }
    }

    @Test
    fun run2Test() {
        val date = run {
            Date()
        }
        println("date = $date")
    }

    @Test
    fun takeIfTest() {
        val date = Date().takeIf {
            // 是否在2018年元旦后
            it.after(Date(2018 - 1900, 0, 1))
        }

        println("date = $date")
    }
}
