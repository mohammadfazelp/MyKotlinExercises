package topics.function.literalsWithReceiver
/*
 * Function types with receiver, such as A.(B) -> C, can be instantiated with a special form of function literals –
 * function literals with receiver.
 */
fun main() {
    val sum: Int.(Int) -> Int = { other -> plus(other) }
    val sum2 = fun Int.(other: Int): Int = this + other

    html {       // lambda with receiver begins here
        body()   // calling a method on the receiver object
    }
}

class HTML {
    fun body() {
        Unit
    }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()  // create the receiver object
    html.init()        // pass the receiver object to the lambda
    return html
}

