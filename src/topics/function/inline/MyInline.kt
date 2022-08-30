package topics.function.inline

fun higherOrderFunc(str: String, call: (String) -> Unit) {

    // inovkes the print() by passing the string str
    call(str)
}

// In order to reduce the memory overhead of such higher-order functions or lambda expressions,
// we can use the inline keyword which ultimately requests the compiler to not allocate memory
// and simply copy the inlined code of that function at the calling place
inline fun inlineHigherOrderFunc(str: String, call: (String) -> Unit) {
    // inovkes the print() by passing the string str
    call(str)
}

// main function
fun main() {
    print("Some text: ")
    higherOrderFunc("Description", ::println)

    print("Some text: ")
    inlineHigherOrderFunc("Description", ::println)

// var lambda = { println("Lambda expression")return }
// normally lambda expression does not allow return statement, so gives compile time error

    var lambda1 = { println("Lambda expression") }

    println("Main function starts")
    inlinedFunc(
        {
            println("Lambda expression 1")
            return
        },
        // inlined function allow return statement in lambda expression. so, does not give compile time error
        { println("Lambda expression 2") }
    )

    println("Main function ends")
}

inline fun inlinedFunc(lambda1: () -> Unit, lambda2: () -> Unit) {
    lambda1()
    lambda2()
}

