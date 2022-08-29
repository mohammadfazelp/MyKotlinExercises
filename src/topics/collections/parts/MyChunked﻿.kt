package topics.collections.parts
/*
 * To break a collection into parts of a given size, use the chunked() function.
 * chunked() takes a single argument – the size of the chunk – and returns a List of Lists of the given size.
 * The first chunk starts from the first element and contains the size elements,
 * the second chunk holds the next size elements, and so on.
 * The last chunk may have a smaller size.
 */
fun main() {
    val numbers = (0..13).toList()
    println(numbers.chunked(3))
    println(numbers.chunked(3) { it.sum() })  // `it` is a chunk of the original collection
}