package examples

/**
 * 小母驴，小公驴，小公马生下来的儿子
 *
 * @author Edwin.Wu
 * @version 2018/2/8 下午7:40
 * @since JDK1.8
 */
sealed class Son {
    fun sayHello() {
        println("大家好！")
    }

    class 小小驴 : Son()
    class 小骡子 : Son()
}

fun main(args: Array<String>) {
    var s1: Son = Son.小小驴()
    var s2: Son = Son.小骡子()
    var s3: Son = Son.小小驴()

    var list = listOf(s1, s2, s3)
    for (v in list) {
        if (v is Son.小骡子)
            v.sayHello()
    }

}