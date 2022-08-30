package topics.collections.list

/*
 * getOrElse() lets you provide the function for calculating the default value to return if the index isn't
 * present in the collection.
 *
 * getOrNull() returns null as the default value.
 *
 * subList() returns a view of the specified elements range as a list
 *
 * Linear search: In any lists, you can find the position of an element using the functions indexOf() and lastIndexOf().
 * They return the first and the last position of an element equal to the given argument in the list.
 * If there are no such elements, both functions return -1.
 *
 * indexOfFirst() returns the index of the first element matching the predicate or -1 if there are no such elements.
 * indexOfLast() returns the index of the last element matching the predicate or -1 if there are no such elements.
 *
 * binarySearch() works significantly faster than other built-in search functions but requires the list to be
 * sorted in ascending order according to a certain ordering: natural or another one provided in the function parameter.
 * Otherwise, the result is undefined.
 *
 * compareBy() When list elements aren't Comparable, you should provide a Comparator to use in the binary search.
 * The list must be sorted in ascending order according to this Comparator.
 *
 * fill() simply replaces all the collection elements with the specified value.
 *
 * sort* instead of sorted* in the names of all sorting functions: sort(), sortDescending(), sortBy(), and so on.
 * shuffle() instead of shuffled().
 * reverse() instead of reversed().
 * asReversed() called on a mutable list returns another mutable list which is a reversed view of the original list.
 * Changes in that view are reflected in the original list.
 */
fun main() {

    val numbers = listOf(1, 2, 3, 4)
    println(numbers.get(0))
    println(numbers[0])
    //numbers.get(5)                         // exception!
    println(numbers.getOrNull(5))             // null
    println(numbers.getOrElse(5, { it }))        // 5
    print("---------------------------------------------------------")
    val numbers2 = listOf(1, 2, 3, 4, 2, 5)
    println(numbers2.indexOf(2))
    println(numbers2.lastIndexOf(2))
    print("---------------------------------------------------------")
    val numbers3 = mutableListOf("one", "two", "three", "four")
    numbers3.sort()
    println(numbers3)
    println(numbers3.binarySearch("two"))  // 3
    println(numbers3.binarySearch("z")) // -5
    println(numbers3.binarySearch("two", 0, 2))  // -3
    print("---------------------------------------------------------")
    val pList = listOf(
        Product("WebStorm", 49.0),
        Product("AppCode", 99.0),
        Product("DotTrace", 129.0),
        Product("ReSharper", 149.0)
    )
    println(
        pList.binarySearch(Product("AppCode", 99.0), compareBy<Product> { it.price }.thenBy { it.name })
    )
    print("---------------------------------------------------------")
    val numbers4 = mutableListOf(1, 2, 3, 4)
    numbers4.fill(3)
    println(numbers4)
    print("---------------------------------------------------------")
    val _numbers = mutableListOf("one", "two", "three", "four")
    println(_numbers)
    _numbers.sort()
    println("Sort into ascending: $_numbers")
    _numbers.sortDescending()
    println("Sort into descending: $_numbers")

    _numbers.sortBy { it.length }
    println("Sort into ascending by length: $_numbers")
    _numbers.sortByDescending { it.last() }
    println("Sort into descending by the last letter: $_numbers")

    _numbers.sortWith(compareBy<String> { it.length }.thenBy { it })
    println("Sort by Comparator: $_numbers")

    _numbers.shuffle()
    println("Shuffle: $_numbers")
    _numbers.shuffle()
    println("Shuffle: $_numbers")

    _numbers.reverse()
    println("Reverse: $_numbers")
}

data class Product(val name: String, val price: Double)