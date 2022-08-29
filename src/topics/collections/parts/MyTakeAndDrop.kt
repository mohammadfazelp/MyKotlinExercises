package topics.collections.parts
/*
 * To get the specified number of elements starting from the first, use the take() function.
 * For getting the last elements, use takeLast().
 * When called with a number larger than the collection size, both functions return the whole collection.
 * To take all the elements except a given number of first or last elements,
 * call the drop() and dropLast() functions respectively.
 */
fun main() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.take(3))
    println(numbers.takeLast(3))
    println(numbers.drop(1))
    println(numbers.dropLast(5))
}