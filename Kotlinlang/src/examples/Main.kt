package examples.basicSyntaxWalkThrough

import org.junit.Test
import java.math.BigInteger
import java.util.*

/**
 *
 *
 * @author Edwin.Wu
 * @version 2018/1/30 下午6:35
 * @since JDK1.8
 */


class Main {

    /**
     * 从1加到100，Kotlin写法
     */
    @Test
    fun addSizeDemo() {
        val size = 1..100
        var count = 0
        for (s in size) {
            count += s
        }
        println(count)

        // 等价于

        count = size.sum()
        println(count)
    }

    /**
     * List使用
     */
    @Test
    fun listDemo() {
        val lists = listOf<String>("买鸡蛋", "买大米", "买杜蕾斯")
        for ((i, e) in lists.withIndex()) {
            println("$i $e")
        }
    }

    /**
     * Map使用
     */
    @Test
    fun mapDemo() {
        val map = TreeMap<String, String>()
        map["好"] = "good"
        map["学习"] = "study"
        map["天"] = "day"
        map["向上"] = "dup"
        println(map["学习"])
    }

    /**
     * 函数表达式
     */
    @Test
    fun addDemo() {
        val i = { x: Int, y: Int -> x + y }
        println(i(10, 10))

        val j: (Int, Int) -> Int = { x, y -> x + y }
        println(j(3, 5))
    }

    /**
     * 具名参数和默认参数
     */
    @Test
    fun parameterDemo() {
        println(getRectArea(2.5, 3.3))
        println(getCirclePerimeter(r = 12F))

    }

    private fun getRectArea(l: Double, w: Double): Double {
        return l * w
    }

    private val Pi = 3.1415926f
    private fun getCirclePerimeter(pi: Float = Pi, r: Float): Float {
        return 2 * pi * r
    }

    /**
     * 字符串和数字
     */
    @Test
    fun strNumDemo() {
        var a = "18"
        var b = 18

        a = b.toString()
        b = a.toInt()

        var c = "a5"
        b = c.toInt() // java.lang.NumberFormatException: For input string: "a5"
    }

    /**
     * 人机交互
     * 意念交互
     */
    @Test
    fun calcDemo() {
        println("请输入第一个数字:")
        val number1 = readLine()
        println("请输入第二个数字:")
        val number2 = readLine()

        val num1 = number1!!.toInt()
        val num2 = number2!!.toInt()

        println("$num1 + $num2 =${num1 + num2} ")
    }

    /**
     * 异常问题
     */
    @Test
    fun errorDemo() {
        try {
            var b = 18

            var c = "a5"
            b = c.toInt() // java.lang.NumberFormatException: For input string: "a5"
        } catch (e: Exception) {
            throw NumberFormatException("字母不能转换成数字")
//            e.printStackTrace()
        }
    }

    /**
     * 递归
     */
    @Test
    fun recursionDemo() {
//        val num = BigInteger.valueOf(100)
//        println(fact(num))

//        try {
//            println(ollAdd(10000))
//        } catch (e: Exception) {
//
//        }

        println(ollAdd(1000, 0))
    }

    private fun fact(num: BigInteger): BigInteger {
        return if (num == BigInteger.ONE) {
            BigInteger.ONE
        } else {
            num * fact(num - BigInteger.ONE)
        }
    }

    private fun ollAdd(num: Int): Int {
        println("计算机第${num}次运算")
        return if (num == 1) {
            1
        } else {
            num + ollAdd(num - 1)
        }
    }

    tailrec fun ollAdd(num: Int, result: Int): Int {
        println("计算机第${num}次运算,result = $result")
        return if (num == 1) {
            1
        } else {
            num + ollAdd(num - 1, result + num)
        }
    }

    @Test
    fun objectDemo() {
        val girl = Girl("彪悍", "甜美音")

        println(girl.chactor + "   " + girl.voice)
        girl.smile()
        girl.cry()

    }

    class Girl(var chactor: String, var voice: String) {
        fun smile() {
            println("妹子么么哒,啪啪拍")
        }

        fun cry() {
            println("555,人家伤心么")
        }
    }


}