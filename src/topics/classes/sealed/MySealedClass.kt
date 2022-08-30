package topics.classes.sealed

/*
 * Sealed classes and interfaces represent restricted class hierarchies that provide more control over inheritance.
 * All direct subclasses of a sealed class are known at compile time.
 * No other subclasses may appear outside a module within which the sealed class is defined.
 * For example, third-party clients can't extend your sealed class in their code.
 * Thus, each instance of a sealed class has a type from a limited set that is known when this class is compiled.
 *
 * The same works for sealed interfaces and their implementations:
 * once a module with a sealed interface is compiled, no new implementations can appear.
 *
 * In some sense, sealed classes are similar to enum classes: the set of values for an enum type is also restricted,
 * but each enum constant exists only as a single instance, whereas a subclass of a sealed class can have multiple
 * instances, each with its own state.
 */

import java.io.File
import javax.sql.DataSource

sealed interface Error {
    class IA
    class IB
}

sealed class IOError(): Error

class FileReadError(val file: File): IOError()
class DatabaseError(val source: DataSource): IOError()

object RuntimeError : Error