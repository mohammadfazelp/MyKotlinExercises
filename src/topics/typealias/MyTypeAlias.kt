package topics.`typealias`
/*
 * Type aliases provide alternative names for existing types.
 * If the type name is too long you can introduce a different shorter name and use the new one instead.
 *
 * It's useful to shorten long generic types.
 */

typealias MyHandler = (Int, String, Any) -> Unit

typealias Predicate<T> = (T) -> Boolean

fun foo(p: Predicate<Int>) = p(42)

fun main() {
    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f)) // prints "true"

    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p)) // prints "[1]"

    val a : AInner
}

class A {
    inner class Inner
}
class B {
    inner class Inner
}

typealias AInner = A.Inner
typealias BInner = B.Inner