package practice.grammar

val pi: Float by lazy {
    3.14f
}

fun main(args: Array<String>) {

    println("Some Lateinit Code ...")

    // pi is not initialized yet ...
    println("FIRST PI : " + pi)

    val area1 = pi * 4 * 4  // pi get initialized and assigned the value of 3.14f for the first time ...

    println("SECODED PI : " + pi)

    val area2 = pi * 9 * 9  // The value pi is loaded from cache memory

    println("THIRED PI : " + pi)

    println("Some More Code ....")

}

// lazy initialization was designed to prevent unnecessary initialization of objects.
// You variable will not be initialized unless you use it in your code.
// It is initialized only once. Next time When you use it, you get the value from cache memory.

// It is thread safe
// It is initialized in the thread where it is used for the first time.
// Other threads use the same value stroed in the cache.

// The variable can be var or val
// The variable can be nullable or non-nullable

