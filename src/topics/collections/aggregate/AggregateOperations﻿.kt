package topics.collections.aggregate
/*
 * minOrNull() and maxOrNull() return the smallest and the largest element respectively. On empty collections, they return null
 * average() returns the average value of elements in the collection of numbers.
 * sum() returns the sum of elements in the collection of numbers.
 * count() returns the number of elements in a collection.
 *
 * reduce(),fold() apply the provided operation to the collection elements sequentially and return the accumulated result.
 * The operation takes two arguments: the previously accumulated value and the collection element.
 *
 * reduce() vs fold() takes an initial value and uses it as the accumulated value on the first step,
 * whereas the first step of reduce() uses the first and the second elements as operation arguments on the first step.
 *
 * To apply a function to elements in the reverse order, use functions reduceRight() and foldRight().
 * They work in a way similar to fold() and reduce() but start from the last element and then continue to previous.
 * Note that when folding or reducing right, the operation arguments change their order:
 *  - first goes the element,
 *  - and then the accumulated value.
 */
fun main() {
    val numbers = listOf(6, 42, 10, 4)

    println("Count: ${numbers.count()}")
//    println("Max: ${numbers.maxOrNull()}")
//    println("Min: ${numbers.minOrNull()}")
    println("Average: ${numbers.average()}")
    println("Sum: ${numbers.sum()}")

    val list = listOf("3","hi","four")
    val it: Iterator<String> = list.asIterable().iterator()
    while (it.hasNext()) {
        print("${it.next()} ")
    }

    val numbers2 = listOf(5, 42, 10, 4)
    val min3Remainder = numbers2.minBy { it % 3 }
    println(min3Remainder)

    val strings = listOf("one", "two", "three", "four")
    val longestString = strings.maxWith(compareBy { it.length })
    println(longestString)

    val numbers4 = listOf(5, 42, 10, 4)
    println(numbers4.sumBy { it * 2 })
    println(numbers4.sumByDouble { it.toDouble() / 2 })

    val numbers5 = listOf(5, 2, 10, 4)
    // fold() is used for calculating the sum of doubled elements
    val sumDoubled = numbers5.fold(0) { sum, element -> sum + element * 2 }
    println(sumDoubled) // prints 42
    //it will return another result because it uses the list's first and second elements as arguments on the first step,
    // so the first element won't be doubled.
    val simpleSum = numbers5.reduce { sum, element -> sum + element }
    println(simpleSum)  // prints 21

    //incorrect: the first element isn't doubled in the result
    //val sumDoubledReduce = numbers.reduce { sum, element -> sum + element * 2 }
    //println(sumDoubledReduce)

    val numbs = listOf(5, 2, 10, 4)
    val sumDoubledRight = numbs.foldRight(0) { element, sum -> sum + element * 2 }
    println(sumDoubledRight)

    val numbers6 = listOf(5, 2, 10, 4)
    val sumEven = numbers6.foldIndexed(0) { idx, sum, element -> if (idx % 2 == 0) sum + element else sum }
    println(sumEven)

    val sumEvenRight = numbers.foldRightIndexed(0) { idx, element, sum -> if (idx % 2 == 0) sum + element else sum }
    println(sumEvenRight)

}