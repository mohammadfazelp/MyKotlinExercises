package topics.collections.transformation
/*
 * Association transformations allow building maps from the collection elements and certain values associated with them.
 * In different association types, the elements can be either keys or values in the association map.
 *
 * associateWith() creates a Map in which the elements of the original collection are keys, and values are produced
 * from them by the given transformation function.
 * If two elements are equal, only the last one remains in the map.
 *
 * associateBy() : For building maps with collection elements as values.
 * It takes a function that returns a key based on an element's value.
 * If two elements' keys are equal, only the last one remains in the map.
 * It can also be called with a value transformation function.
 *
 * associate() : Another way to build maps in which both keys and values are somehow produced from collection elements.
 */

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")

    println(numbers.associateWith { it.length })
    println(numbers.associateBy { it.first().toUpperCase() })
    println(numbers.associateBy(keySelector = { it.first().toUpperCase() }, valueTransform = { it.length }))
//    println(names.associate { name -> parseFullName(name).let { it.lastName to it.firstName } })
//    returns : {Adams=Alice, Brown=Brian, Campbell=Clara}
}