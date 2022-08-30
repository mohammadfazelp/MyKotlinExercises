package topics.function.operator_overloading

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