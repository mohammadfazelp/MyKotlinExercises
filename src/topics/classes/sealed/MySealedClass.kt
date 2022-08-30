package topics.classes.sealed

/*
 * Sealed classes and interfaces represent restricted class hierarchies that provide more control over inheritance.
 * All direct subclasses of a sealed class are known at compile time.
 * No other subclasses may appear outside a module within which the sealed class is defined.
 * For example, third-party clients can't extend your sealed class in their code.
 * Thus, each instance of a sealed class has a type from a limited set that is known when this class is compiled.
 *
 * The same works for sealed interfaces and their implementations:
 * once a module with a sealed interface is compiled, no new implementations can appear.
 *
 * In some sense, sealed classes are similar to enum classes: the set of values for an enum type is also restricted,
 * but each enum constant exists only as a single instance, whereas a subclass of a sealed class can have multiple
 * instances, each with its own state.
 */

// A sealed class with a string property
sealed class Fruit(val x: String) {
    // Two subclasses of sealed class defined within
    class Apple : Fruit("Apple")
    class Mango : Fruit("Mango")
}

// A subclass defined outside the sealed class
class Pomegranate : Fruit("Pomegranate")

// A function to take in an object of type Fruit
// And to display an appropriate message depending on the type of Fruit
fun display(fruit: Fruit) {
    when (fruit) {
        is Fruit.Apple -> println("${fruit.x} is good for iron")
        is Fruit.Mango -> println("${fruit.x} is delicious")
        is Pomegranate -> println("${fruit.x} is good for vitamin d")
    }
}

fun main() {
    // Objects of different subclasses created
    val obj = Fruit.Apple()
    val obj1 = Fruit.Mango()
    val obj2 = Pomegranate()

    // Function called with different objects
    display(obj)
    display(obj1)
    display(obj2)
}
