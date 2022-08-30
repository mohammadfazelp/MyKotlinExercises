package topics.classes.nested

import java.awt.Window

fun main() {
    val demo = Outer2().Inner().foo() // == 1
    println(demo)

//    Anonymous inner class instances are created using an object expression:

//    window.addMouseListener(object : MouseAdapter() {
//
//        override fun mouseClicked(e: MouseEvent) { ... }
//
//        override fun mouseEntered(e: MouseEvent) { ... }
//    })
}

class Outer2 {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }

    inner class Inner {
        fun foo() = bar
    }
}

interface OuterInterface {
    class InnerClass
    interface InnerInterface
}

class OuterClass {
    class InnerClass
    interface InnerInterface
}
