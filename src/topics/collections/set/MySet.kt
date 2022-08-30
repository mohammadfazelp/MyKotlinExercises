package topics.collections.set
/*
 * finding intersections, merging, or subtracting collections from each other.
 *
 * To merge two collections into one, use the union() function.
 *
 * To find an intersection between two collections (elements present in both of them), use intersect().
 *
 * To find collection elements not present in another collection, use subtract().
 */
fun main() {
    val numbers = setOf("one", "two", "three")

    println(numbers union setOf("four", "five"))
    println(setOf("four", "five") union numbers)

    println(numbers intersect setOf("two", "one"))
    println(numbers subtract setOf("three", "four"))
    println(numbers subtract setOf("four", "three")) // same output


    val list1 = listOf(1, 1, 2 ,3, 5, 8, -1)
    val list2 = listOf(1, 1, 2, 2 ,3, 5)
    println(list1 intersect list2) // result on two lists is a Set
    println(list1 union list2)     // equal elements are merged into one
}