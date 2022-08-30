package topics.function.anonymous
/*
 * The ability to specify the function’s return type.
 * In most cases, this is unnecessary because the return type can be inferred automatically.
 * However, if you do need to specify it explicitly, you can use an alternative syntax: an anonymous function.
 *
 * An anonymous function looks very much like a regular function declaration, except its name is omitted.
 * Its body can be either an expression (as shown above) or a block.
 */
fun main() {

    fun(x: Int, y: Int): Int = x + y

    fun(str:String):String{
        return str+"hi"
    }
//    fun(x: Int, y: Int): Int {
//        return x + y
//    }

    val ints = listOf(2,-1,0,-2,0,5)
    ints.filter(fun(item) = item > 0).forEach {
        println(it)
    }

}

