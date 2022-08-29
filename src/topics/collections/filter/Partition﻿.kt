package topics.collections.filter
/*
 * partition() – filters a collection by a predicate and keeps the elements that don't match it in a separate list.
 * So, you have a Pair of Lists as a return value:
 *  1- the first list containing elements that match the predicate and
 *  2- the second one containing everything else from the original collection.
 */
fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val (match, rest) = numbers.partition { it.length > 3 }

    println(match)
    println(rest)
}