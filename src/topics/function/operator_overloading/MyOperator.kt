package topics.function.operator_overloading
/*
Kotlin allows you to provide custom implementations for the predefined set of operators on types.
These operators have predefined symbolic representation (like + or *) and precedence.
To implement an operator, provide a member function or an extension function with a specific name for the corresponding type.
This type becomes the left-hand side type for binary operations and the argument type for the unary ones.
 */
interface IndexedContainer {
    operator fun get(index: Int)
}

class OrdersList : IndexedContainer {
    override fun get(index: Int) { /*...*/
    }
}

data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

val point = Point(10, 20)

fun main() {
    println(point.unaryMinus())
    println(-point)  // prints "Point(x=-10, y=-20)"

}

data class CounterWithOperator(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}

data class Counter(val dayIndex: Int) {
    fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}