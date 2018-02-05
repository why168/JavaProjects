package examples.problems

/**
 * Your task is to implement the indexOfMax() function so that it returns
 * the index of the largest element in the array, or null if the array is empty.
 * @author Edwin.Wu
 * @version 2018/2/5 下午4:39
 * @since JDK1.8
 */
fun indexOfMax(a: IntArray): Int? {


    val max = a.max() ?: null

    println(max)


    if (max != null) {
        return a.indexOf(max)
    } else {
        return null
    }


}

fun indexOfMax(vararg data: Int) {
    indexOfMax(data)
}

fun main(args: Array<String>) {
//    println(indexOfMax(-1, 0))

    val intArray = IntArray(3, { 1; 2; 3;  })

    println(intArray.max())

}