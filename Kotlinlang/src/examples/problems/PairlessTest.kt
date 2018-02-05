package examples.problems

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 *
 *
 * @author Edwin.Wu
 * @version 2018/2/5 下午7:15
 * @since JDK1.8
 */
class Tests {
    @Test fun testPairless1() {
        PairlessTest(0, 0)
    }

    @Test fun testPairless2() {
        PairlessTest(1, 0, 1, 0)
    }

    @Test fun testPairless3() {
        PairlessTest(5, 5, -1, -1, 0, 0)
    }

    @Test fun testPairless4() {
        PairlessTest(3, 1, 3, 1, 1, 1)
    }

    @Test fun testPairless5() {
        PairlessTest(1, 2, 3, 1, 2, 3)
    }

}

fun PairlessTest(expected: Int?, vararg data: Int) {
    val actual = findPairless(data)
    assertEquals(expected, actual, "\ndata = ${Arrays.toString(data)}")
}