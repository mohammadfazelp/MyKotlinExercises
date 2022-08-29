package topics.collections.iterator
/*
 * iterator : For traversing collection elements.
 *
 * Iterators are useful when you need to process all the elements of a collection one-by-one,
 * for example, print values or make similar updates to them.
 *
 * Iterators can be obtained for inheritors of the Iterable<T> interface, including Set and List,
 * by calling the iterator() function.
 *
 * Once you obtain an iterator, it points to the first element of a collection; calling the next() function
 * returns this element and moves the iterator position to the following element if it exists.
 */
fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val numbersIterator = numbers.iterator()
    // Another way to go through an Iterable collection is the well-known for loop
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }
}