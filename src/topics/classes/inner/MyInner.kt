package topics.classes.inner


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

    val b = OuterClass.InnerClass()
    b.test()
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

    fun test(){
        print("Hi from OuterClass!")
    }
    class InnerClass {
        fun test(){
            print("From inner class")
        }
    }
    interface InnerInterface
}
