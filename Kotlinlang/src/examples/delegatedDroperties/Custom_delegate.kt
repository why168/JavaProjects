package examples.delegatedDroperties

import kotlin.reflect.KProperty

/**
 * There's some new syntax: you can say `val 'property name': 'Type' by 'expression'`.
 * The expression after by is the delegate, because get() and set() methods
 * corresponding to the property will be delegated to it.
 * Property delegates don't have to implement any interface, but they have
 * to provide methods named getValue() and setValue() to be called.</p>
 *
 * @author Edwin.Wu
 * @version 2018/2/2 上午11:24
 * @since JDK1.8
 */
class Example {
    var p: String by Delegate()

    override fun toString() = "Example"
}

class Delegate {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef,thank you for delegating '${prop.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

fun main(args: Array<String>){
    val e = Example()
    println(e)
    e.p = "NEW"

    println(e.p)
}