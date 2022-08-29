package topics.collections.parts
/*
 * Retrieve all possible ranges of the collection elements of a given size.
 * It returns a list of element ranges that you would see if you were looking at the collection through a sliding
 * window of the given size.
 * Unlike chunked(), windowed() returns element ranges (windows) starting from each collection element.
 * All the windows are returned as elements of a single List.
 */
fun main() {
    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.windowed(3))

    val numbs = (1..10).toList()
    println(numbers.windowed(3, step = 2, partialWindows = true))
//    println(numbers.windowed(3) { it.sum() })

    val n = listOf("one", "two", "three", "four", "five")
    println(numbers.zipWithNext())
    println(numbers.zipWithNext() { s1, s2 -> s1.length > s2.length})
}