@file:Suppress("UNUSED_CHANGED_VALUE")

package examples.problems

/**
 * Any array may be viewed as a number of "runs" of equal numbers.
 * For example, the following array has two runs:
 *   1, 1, 1, 2, 2
 * Three 1's in a row form the first run, and two 2's form the second.
 * This array has two runs of length one:
 *   3, 4
 * And this one has five runs:
 *   1, 0, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0
 * Your task is to implement the runs() function so that it returns the number
 * of runs in the given array.
 *
 * @author Edwin.Wu
 * @version 2018/2/5 下午5:45
 * @since JDK1.8
 */
fun runs(a: IntArray): Int {
    // Write your solution here
    var count: Int = 0

    for (index: Int in 0 until a.size) {
        println("index = $index , a[index] = ${a[index]} , a.size = ${a.size}")

        if (a.size - 1 == 0) {
            ++count
            break
        }

        if (index == a.size - 1) {
            ++count
            break
        }

        if (a[index] != a[index + 1]) {
            ++count
        }
    }

    return count
}