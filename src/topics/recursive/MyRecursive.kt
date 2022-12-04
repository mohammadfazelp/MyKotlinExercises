package topics.recursive

import java.lang.IllegalArgumentException

fun sum(list: List<Int>): Int = if (list.isEmpty()) 0 else list[0] + sum(list.drop(1))

fun <T> List<T>.head(): T = if (this.isEmpty()) throw IllegalArgumentException("error") else this[0]

fun <T> List<T>.tail(): List<T> = if (this.isEmpty()) throw IllegalArgumentException("error") else this.drop(1)

fun sum1(list: List<Int>): Int = if (list.isEmpty()) 0 else list.head() + sum1(list.tail())

fun sum2(list: List<Int>): Int {
    tailrec fun sumTail(list: List<Int>, acc: Int): Int =
        if (list.isEmpty()) acc else sumTail(list.tail(), acc + list.head())
    return sumTail(list, 0)
}

fun main() {
//    println(sum(listOf(1, 2, 3)))
    println(sum2(listOf(1, 2, 2)))
}