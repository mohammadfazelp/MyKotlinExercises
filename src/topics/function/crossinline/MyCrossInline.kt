package topics.function.crossinline

/*
 * Return in lambda exits the inline function as well as its enclosing function.
 * So to stop returning from the lambda expression we can mark it using the crossline.
 * It will throw a compiler error if it sees any return statement in the Lambda expression.
 */

fun main() {
    println("Main function starts")
    inlinedFunc({
        println("Lambda expression 1")
        // return    // It gives compiler error
    }, {
        println("Lambda expression 2")
        return
    })

    println("Main function ends")
}

inline fun inlinedFunc(crossinline lambda1: () -> Unit, lambda2: () -> Unit) {
    lambda1()
    lambda2()
}