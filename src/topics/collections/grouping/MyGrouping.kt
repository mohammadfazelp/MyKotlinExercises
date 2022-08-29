package topics.collections
/*
 * groupBy() takes a lambda function and returns a Map.
 * In this map, each key is the lambda result and the corresponding value is the List of elements on which this
 * result is returned.
 * This function can be used, for example, to group a list of Strings by their first letter.
 * You can also call groupBy() with a second lambda argument – a value transformation function. In the result map
 * of groupBy() with two lambdas, the keys produced by keySelector function are mapped to the results of the value
 * transformation function instead of the original elements.
 *
 * If you want to group elements and then apply an operation to all groups at one time, use the function groupingBy().
 * It returns an instance of the Grouping type. The Grouping instance lets you apply operations to all groups in a
 * lazy manner: the groups are actually built right before the operation execution.
 *
 * Namely, Grouping supports the following operations:
 *  1- eachCount() counts the elements in each group.
 *  2- fold() and reduce() perform fold and reduce operations on each group as a separate collection and return the results.
 *  3- aggregate() applies a given operation subsequently to all the elements in each group and returns the result.
 * This is the generic way to perform any operations on a Grouping.
 * Use it to implement custom operations when fold or reduce are not enough.
 *
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/reduce.html
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/aggregate.html
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/each-count.html
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/fold.html
 */
fun main() {
    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.groupBy { it.first().toUpperCase() })
    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))
    println(numbers.groupingBy { it.first() }.eachCount())

    val aggregated = numbers.groupingBy { it.toUpperCase() }.aggregate { key, accumulator: StringBuilder?, element, first ->
        if (first) StringBuilder().append(key).append(":").append(element)
        else accumulator!!.append("-").append(element)
    }
    println(aggregated.values)
//    println(numbers.groupingBy { it.first() }.fold())


    val fruits = listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")
    val evenFruits = fruits.groupingBy { it.first() }
        .fold({ key, _ -> key to mutableListOf<String>() },
            { _, accumulator, element ->
                accumulator.also { (_, list) -> if (element.length % 2 == 0) list.add(element) }
            })

    val sorted = evenFruits.values.sortedBy { it.first }
    println(sorted) // [(a, []), (b, [banana]), (c, [cherry, citrus])]

    val strings = listOf("a", "b", "c", "d")
    println(strings.reduce { acc, string -> acc + string }) // abcd
    println(strings.reduceIndexed { index, acc, string -> acc + string + index }) // ab1c2d3


    val animals = listOf("raccoon", "reindeer", "cow", "camel", "giraffe", "goat")

// grouping by first char and collect only max of contains vowels
    val compareByVowelCount = compareBy { s: String -> s.count { it in "aeiou" } }
    val maxVowels = animals.groupingBy { it.first() }.reduce { _, a, b -> maxOf(a, b, compareByVowelCount) }
    println(maxVowels) // {r=reindeer, c=camel, g=giraffe}
}