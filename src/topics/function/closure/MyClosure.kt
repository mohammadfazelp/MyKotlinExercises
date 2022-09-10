package topics.function.closure

/*
 * A lambda expression or anonymous function (as well as a local function and an object expression) can access its
 * closure, which includes the variables declared in the outer scope.
 * The variables captured in the closure can be modified in the lambda
 *
 * A closure is a special kind of object that combines two things: a function, and the environment in which that
 * function was created.
 * The environment consists of any local variables that were in-scope at the time the closure was created
 */

fun main() {
    var sum = 0
    val ints = listOf(2, 4, 2, 1)
    ints.filter { it > 0 }.forEach {
        sum += it
    }
    print(sum)
}