package topics.transformation
/*
 * Zipping transformation is building pairs from elements with the same positions in both collections.
 * In the Kotlin standard library, this is done by the zip() extension function.
 * When called on a collection or an array with another collection (or array) as an argument, zip() returns the List
 * of Pair objects.
 * The elements of the receiver collection are the first elements in these pairs.
 * If the collections have different sizes, the result of the zip() is the smaller size; the last elements of the
 * larger collection are not included in the result.
 * zip() can also be called in the infix form a zip b.
 */
fun main() {

    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)

    val twoAnimals = listOf("fox", "bear")
    println(colors zip twoAnimals)
}