package topics.function.higherorder
/*
 * A higher-order function is a function that takes functions as parameters, or returns a function.
 */
fun main() {
    val items = listOf(1, 2, 3, 4, 5)

    // Lambdas are code blocks enclosed in curly braces.
    items.fold(0) {
        // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    }

    // Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("Elements:") { acc, i -> "$acc $i" }

    // Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times)
}

// A good example of a higher-order function is the functional programming idiom fold for collections.
// It takes an initial accumulator value and a combining function and builds its return value by consecutively
// combining the current accumulator value with each collection element, replacing the accumulator value each time
fun <T, R> Collection<T>.fold(
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}