package topics.collections.filter

/*
 * When called with a predicate, filter() returns the collection elements that match it.
 * For both List and Set, the resulting collection is a List, for Map it's a Map as well.
 *
 * filterNot() : It returns a list of elements for which the predicate yields false.
 *
 * filterIndexed() : It takes a predicate with two arguments: the index and the value of an element.
 *
 * filterIsInstance() returns collection elements of a given type.
 * Being called on a List<Any>, filterIsInstance<T>() returns a List<T>, thus allowing you to call functions
 * of the T type on its items.
 *
 * filterNotNull() returns all non-null elements.
 * Being called on a List<T?>, filterNotNull() returns a List<T: Any>, thus allowing you to treat the elements as
 * non-null objects.
 */

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10}
    println(filteredMap)

    val filteredIdx = numbers.filterIndexed { index, s -> (index != 0) && (s.length < 5)  }
    val filteredNot = numbers.filterNot { it.length <= 3 }

    println(filteredIdx)
    println(filteredNot)

    val numbers2 = listOf(null, 1, "two", 3.0, "four")
    println("All String elements in upper case:")
    numbers2.filterIsInstance<String>().forEach {
        println(it.toUpperCase())
    }

    val numbers3 = listOf(null, "one", "two", null)
    numbers3.filterNotNull().forEach {
        println(it.length)   // length is unavailable for nullable Strings
    }
}