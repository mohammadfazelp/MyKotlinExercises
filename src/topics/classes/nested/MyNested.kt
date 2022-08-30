package topics.classes.nested
// You can use interfaces with nesting. All combinations of classes and interfaces are possible:
// You can nest interfaces in classes, classes in interfaces, and interfaces in interfaces.
fun main() {
    val demo = Outer.Nested().foo() // == 2
    println(demo)

}

class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

