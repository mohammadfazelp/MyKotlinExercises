package topics.collections.transformation
/*
 * The mapping transformation creates a collection from the results of a function on the elements of another collection.
 * The basic mapping function is map().
 * It applies the given lambda function to each subsequent element and returns the list of the lambda results.
 * The order of results is the same as the original order of elements.
 * To apply a transformation that additionally uses the element index as an argument, use mapIndexed().
 */
fun main() {
    val numbers = setOf(1, 2, 3)
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)

    println(numbers.map { it * 3 })
    println(numbers.mapIndexed { idx, value -> value * idx })

    println(numbers.mapNotNull { if ( it == 2) null else it * 3 })
    println(numbers.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })

    println(numbersMap.mapKeys { it.key.toUpperCase() })
    println(numbersMap.mapValues { it.value + it.key.length })
}