package topics.di

class ClassA {
    private val b: ClassB = ClassB()
    fun execute() {
        b.execute()
    }
}

class ClassB {
    fun execute() {

    }
}

class ClassBB(private val myFlag: Boolean) {
    fun execute() {
        if (myFlag) {
            // Do something
        } else {
            // Do something else
        }
    }
}

class ClassAA {
    private val b = ClassBB(true)
    fun execute() {
        b.execute()
    }
}

class ClassAAA(private val b: ClassBB) {
    // constructor injection
    fun execute() {
        b.execute()
    }
}

class Injector {
    fun createA(b: ClassBB) = ClassAAA(b)
    fun createB() = ClassBB(true)
}

fun main() {
    val injector = Injector()
    val b = injector.createB()
    val a = injector.createA(b)
    a.execute()
}

class ClassAAAA(private val b: ClassBBB) {
    fun executeA() {
        b.executeB()
    }
}

interface ClassBBB {
    fun executeB()
}

class ClassB1() : ClassBBB {
    override fun executeB() {
        // Not yet implemented
    }
}

class ClassB2() : ClassBBB {
    override fun executeB() {
        // Not yet implemented
    }
}

class Injector2() {
    //  Our code depend on abstractions rather than concretions and provide different concretions for different purposes. ”

    fun createA(b: ClassBBB) = ClassAAAA(b)
    fun createB() = ClassB1()
}

/*
    Service: Represents the object that contains useful functionality (ClassB1 and ClassB2)
    Interface: Represents the service abstraction (ClassB)
    Client: Represents the object that depends on the service (ClassA)
    Injector: Represents the object responsible for constructing the services and injecting them into the client (Injector)
 */

/*
 * Two ways of injecting dependencies:
 * Constructor injection: Where dependencies are passed through the constructor.
 * Field injection: Where dependencies are passed through setter methods or by changing the instance variables.
 * This can also be referred to as setter injection, and it can also be expanded to interface injection in which
 * the setter method is abstracted to an interface.
 */