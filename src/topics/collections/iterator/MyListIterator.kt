package topics.collections.iterator
/*
 * List iterators : It supports iterating lists in both directions: forwards and backwards
 *
 * Backward iteration is implemented by the functions hasPrevious() and previous().
 *
 * ListIterator provides information about the element indices with the functions nextIndex() and previousIndex().
 */
fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val listIterator = numbers.listIterator()
    while (listIterator.hasNext()) listIterator.next()
    println("Iterating backwards:")
    while (listIterator.hasPrevious()) {
        print("Index: ${listIterator.previousIndex()}")
        println(", value: ${listIterator.previous()}")
    }
}