package topics.exceptions

data class Person(val name: String?)

fun main() {
    val person = Person(null)
//    val s1 = person.name ?: throw IllegalArgumentException("Name required")

    val s2 = person.name ?: fail("Name required")
    println(s2)     // 's2' is known to be initialized at this point
}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}