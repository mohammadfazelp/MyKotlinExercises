package topics.function.noinline

/*
 * In Kotlin, if we want only some lambdas passed to an inline function to be inlined,
 * we can mark some function parameters with the noinline modifier.
 */

fun main() {
    println("Main function starts")
    inlinedFunc({
        println("Lambda expression 1")
        return // It does not compiler time error
    }, {
        println("Lambda expression 2")
//            return :  It gives compiler error
    })
    println("Main function ends")
}

inline fun inlinedFunc(lambda1: () -> Unit, noinline lambda2: () -> Unit) {
    lambda1()
    lambda2()
}