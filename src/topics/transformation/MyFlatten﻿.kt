package topics.transformation

/*
 * flatten() : If you operate nested collections, you may find the standard library functions that provide flat access
 * to nested collection elements useful.
 * You can call it on a collection of collections, for example, a List of Sets.
 * The function returns a single List of all the elements of the nested collections.
 *
 * flatMap() : provides a flexible way to process nested collections.
 * It takes a function that maps a collection element to another collection.
 * As a result, flatMap() returns a single list of its return values on all the elements.
 * So, flatMap() behaves as a subsequent call of map() (with a collection as a mapping result) and flatten().
 *
 * flatMap vs. map : https://stackoverflow.com/questions/52078207/what-is-the-use-case-for-flatmap-vs-map-in-kotlin
 */
class Data(val items: List<String>)

val dataObjects = listOf(
    Data(listOf("a", "b", "c")),
    Data(listOf("1", "2", "3"))
)

fun main() {
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())

    val items: List<String> = dataObjects.flatMap { it.items } //[a, b, c, 1, 2, 3]
    items.forEach {
        println(it)
    }

}