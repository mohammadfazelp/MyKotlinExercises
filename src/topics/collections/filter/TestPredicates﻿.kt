package topics.collections.filter
/*
 * Finally, there are functions that simply test a predicate against collection elements:
 * 1- any() returns true if at least one element matches the given predicate.
 * 2- none() returns true if none of the elements match the given predicate.
 * 3- all() returns true if all elements match the given predicate.
 * Note that all() returns true when called with any valid predicate on an empty collection.
 * Such behavior is known in logic as vacuous truth.
 */
fun main() {
    val numbers = listOf("one", "two", "three", "four")

    println(numbers.any { it.endsWith("e") })
    println(numbers.none { it.endsWith("a") })
    println(numbers.all { it.endsWith("e") })

    println(emptyList<Int>().all { it > 5 })   // vacuous truth

    val empty = emptyList<String>()

    println(numbers.any())
    println(empty.any())

    println(numbers.none())
    println(empty.none())
}