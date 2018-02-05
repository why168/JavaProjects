package examples.problems

import org.junit.Test
import kotlin.test.assertEquals

/**
 * 判断是否是回文数
 * 正读反读都能读通的句子
 *
 * @author Edwin.Wu
 * @version 2018/2/5 下午6:17
 * @since JDK1.8
 */
class PalindromeTest {
    @Test
    fun testEmptyString() {
        test(true, "")
    }

    @Test
    fun testChar() {
        test(true, "a")
    }

    @Test
    fun testPositive1() {
        test(true, "aba")
    }

    @Test
    fun testPositive2() {
        test(true, "abba")
    }

    @Test
    fun testPositive3() {
        test(true, "abbabba")
    }

    @Test
    fun testPositive4() {
        test(true, "abbaabba")
    }

    @Test
    fun testNegative1() {
        test(false, "ab")
    }

    @Test
    fun testNegative2() {
        test(false, "abab")
    }

    @Test
    fun testNegative3() {
        test(false, "abaa")
    }
}

fun test(expected: Boolean, data: String) {
    val actual = isPalindrome(data)
    assertEquals(expected, actual, "\ndata = \"$data\"")
}