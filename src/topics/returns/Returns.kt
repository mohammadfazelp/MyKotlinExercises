package topics.returns

fun main() {
    returnToLabelV0()
    returnToLabelV1()
    returnToLabelV2()
    returnToLabelV3()
    returnToLabelV4()
    returnToLabelV5()
}

fun returnToLabelV0() {
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            println("i:$i,j:$j")
            if (i % 2 == 0) break@loop
        }
    }
}

fun returnToLabelV1() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // non-local return directly to the caller of foo()
        println(it)
    }
    println("this point is unreachable")
}
fun returnToLabelV2() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda - the forEach loop
        println(it)
    }
    println(" done with explicit label")
}

fun returnToLabelV3() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
        println(it)
    }
    println(" done with implicit label")
}

fun returnToLabelV4() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return  // local return to the caller of the anonymous function - the forEach loop
        println(value)
    })
    println(" done with anonymous function")
}

fun returnToLabelV5() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // non-local return from the lambda passed to run
            println(it)
        }
    }
    println(" done with nested loop")
}