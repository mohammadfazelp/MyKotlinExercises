package topics.sequence

import java.time.Instant

/*
 * A sequence is a container Sequence<T> with type T.
 * It’s also an interface, including intermediate operations like map() and filter(), as well as terminal operations
 * like count() and find().
 * Like Streams in Java, Sequences in Kotlin execute lazily.
 * It has tremendous potential to boost application performance while working with large collections.
 * On the other hand, there is an overhead to sequences when processing small collections
 */

fun main() {

    // From Elements
    val seq = sequenceOf(1, 3, 4)
    val a = seq.filter { it > 2 }
    val b = seq.map { it+2 }
    a.forEach { println(it) }
    b.forEach { println(it) }

    // From a Function
    val seqFromFunction = generateSequence(Instant.now()) {it.plusSeconds(1)}

    // From Chunks
    val seqFromChunks = sequence {
        yield(1)
        yieldAll((2..5).toList())
    }

    // From a Collection
    val seqFromIterable = (1..10).asSequence()

    // Lazy and Eager Processing
    val withoutSequence = (1..10).filter{it % 2 == 1}.map { it * 2 }.toList()
    val withSequence = (1..10).asSequence().filter{it % 2 == 1}.map { it * 2 }.toList()
    // In the first example, each operator introduces an intermediate collection. So, all ten elements pass to a map()
    // function.
    // In the second example, there are no intermediate collections introduced, thus map() function has only
    // five elements as input.
}