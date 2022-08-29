package topics.function.scope

/*
* Guide for choosing scope functions depending on the intended purpose:
 *
    - Executing a lambda on non-null objects: let
    - Introducing an expression as a variable in local scope: let
    - Object configuration: apply
    - Object configuration and computing the result: run
    - Running statements where an expression is required: non-extension run
    - Additional effects: also
    - Grouping function calls on an object: with
 *
 * "run", "with", and "apply" refer to the context object as a lambda receiver - by keyword this.
 *
 * In turn, "let" and "also" have the context object as a lambda argument
 *
 * "apply" and "also" return the context object.
 *
 * "let", "run", and "with" return the lambda result.
 *
 * "takeIf" and "takeUnless" are especially useful together with scope functions. A good case is chaining
 * them with "let" for running a code block on objects that match the given predicate.
 */
data class Person(val name: String, var age: Int, val city: String) {
    fun moveTo(destination: String) {
        print(destination)
    }
    fun incrementAge() {
        age++
    }
}

fun main() {
    Person("Alice", 20, "Amsterdam").let {
        println(it)
        it.moveTo("London")
        it.incrementAge()
        println(it)
    }
    //-------------------------------------------------//
    val alice = Person("Alice", 20, "Amsterdam")
    println(alice)
    alice.moveTo("London")
    alice.incrementAge()
    println(alice)
    //-------------------------------------------------//
    val numberList = mutableListOf<Double>()
    numberList.also { println("Populating the list") }
        .apply {
            add(2.71)
            add(3.14)
            add(1.0)
        }
        .also { println("Sorting the list") }
        .sort()
    //-------------------------------------------------//
    val numb = mutableListOf("one", "two", "three")
    val countEndsWithE = numb.run {
        add("four")
        add("five")
        count { it.endsWith("e") }
    }
    println("There are $countEndsWithE elements that end with e.")
    //-------------------------------------------------//
    val numbers = mutableListOf("one", "two", "three")
    with(numbers) {
        val firstItem = first()
        val lastItem = last()
        println("First item: $firstItem, last item: $lastItem")
    }
}