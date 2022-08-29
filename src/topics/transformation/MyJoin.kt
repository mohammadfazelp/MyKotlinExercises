/*
 * If you need to retrieve the collection content in a readable format, use functions that transform the collections
 * to strings: joinToString() and joinTo().
 *
 * joinToString() builds a single String from the collection elements based on the provided arguments.
 *
 * joinTo() does the same but appends the result to the given Appendable object.
 *
 * When called with the default arguments, the functions return the result similar to calling toString() on
 * the collection: a String of elements' string representations separated by commas with spaces.
 */
fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val numbs= (1..100).toList()

    println(numbers)
    println(numbers.joinToString())

    val listString = StringBuffer("The list of numbers: ")
    numbers.joinTo(listString)
    println(listString)

    // The resulting string will start with the prefix and end with the postfix.
    // The separator will come after each element except the last
    println(numbers.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))

    // For bigger collections
    println(numbs.joinToString(limit = 10, truncated = "<...>"))

    // customize the representation of elements themselves
    println(numbers.joinToString { "Element: ${it.toUpperCase()}"})
}