package topics.classes.enums

/*
 * Enum constants can declare their own anonymous classes with their corresponding methods,
 * as well as with overriding base methods.
 *
 * If the enum class defines any members, separate the constant definitions from the member definitions with a semicolon.
 */

enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

fun main() {
    val sss = ProtocolState.TALKING
    val ddd = ProtocolState.WAITING
    println(sss.signal())
    println(ddd.signal())
}