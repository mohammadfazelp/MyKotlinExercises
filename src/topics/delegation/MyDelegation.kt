package topics.delegation

import kotlin.properties.Delegates
import kotlin.random.Random

// https://blog.frankel.ch/kotlin-delegation/
/*
 * Delegation is critical when one chooses composition over inheritance.
 *
 * The by-clause in the supertype list for Delegate indicates that b will be stored internally in objects of Delegate,
 * and the compiler will generate all the methods of B that forward to b.
 *
 * Delegated properties : a property that delegates its getter (and its setter if a var) to "something else".
 * A delegated property also uses the by keyword.
 */
interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        println(x)
    }
}

// A class Derived can implement an interface Base by delegating all of its public members to a specified object.
// The by-clause in the supertype list for Derived indicates that b will be stored internally in objects of Derived
// and the compiler will generate all the methods of Base that forward to b.
class Derived(b: Base) : Base by b
fun main() {
    val b = BaseImpl(10)
    Derived(b).print() // prints 10

    val b2 = Base2Impl(10)
    Derived2(b2).printMessage()
    Derived2(b2).printMessageLine()

    val b3 = BaseImpl3(10)
    val derived = Derived3(b3)
    derived.print()
    println(derived.message)

    /*
    * Non-null delegate
    * A non-null delegate behaves the same way as the lateinit keyword: if one uses the variable before one
    * has initialized it to a non-null value, it will throw an IllegalStateException.
    */
    var notNull: String by Delegates.notNull()

    /*
     * A lazy delegate computes the value on the first access, stores it, and then returns the stored value.
     * As its name implies, you use lazy when the value is expensive to compute and doesn't change after computation
     */
    val lazy: String by lazy {
        println("lazy started!")
        "an expensive computation"
    }

    /*
     * An observable delegate offers a hook when the value is accessed,so you can execute code afterward.
     */
    val observed = "Observed"
    var observable: String by Delegates.observable(observed) {
            _, old, new -> println("old: $old, new: $new")
    }

    /*
     * A vetoable delegate is the opposite of the observable. It offers a hook that executes before.
     * If this hook returns true, the set of the value executes as expected;
     * if it returns false, the set doesn’t happen.
     */
    val vetoable: String by Delegates.vetoable(observed) {
            _, _, _ -> Random.nextBoolean()
    }

    println("lazy for $lazy")
}

interface Base2 {
    fun printMessage()
    fun printMessageLine()
}

class Base2Impl(val x: Int) : Base2 {
    override fun printMessage() {
        println(x)
    }

    override fun printMessageLine() {
        println(x)
    }
}

class Derived2(b: Base2) : Base2 by b {
    override fun printMessage() {
        println("abc")
    }
}

interface Base3 {
    val message: String
    fun print()
}

class BaseImpl3(val x: Int) : Base3 {
    override val message = "BaseImpl: x = $x"
    override fun print() {
        println(message)
    }
}

class Derived3(b: Base3) : Base3 by b {
    override val message: String = "Message of Derived"
}