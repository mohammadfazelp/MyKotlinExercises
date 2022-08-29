package topics.collections.plusminus
/*
 * They take a collection as the first operand; the second operand can be either an element or another collection
 * The return value is a new read-only collection
 */
fun main() {
    val numbers = listOf("one", "two", "three", "four")

    val plusList = numbers + "five"
    val minusList = numbers - listOf("three", "four")
    println(plusList)
    println(minusList)
}