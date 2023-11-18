package practice.grammar

// Loop Expression

fun main(args: Array<String>) {

    // Kotlin For Loop
    for(i in 1.. 10) {
        if(i % 2 == 0) {
            println("First Loop : " + i)
        }
    }

    println()

    for(i in 10 downTo 0) {
        if(i % 2 ==0) {
            println("Second Loop : " + i)
        }
    }

    // Kotlin While Loop
    var i = 0;
    while(i <= 10) {
        if(i % 2 == 0) {
            println("Thire Loop : " + i)
        }
        i++
    }

    println()

    var j = 10
    while(j >= 0) {
        if(j % 2 == 0) {
            println("Fourth Loop : " + j)
        }
        j--
    }

    // Kotlin Do While Loop
    var k = 0

    do {
        if(k % 2 == 0) {
            println("Kotlin Do Loop 1 : " + k)
        }
        k++
    } while(k <= 6)

    var l: Int = 10

    do {
        if(l % 2 == 0) {
            println("Koltin Do Loop 2 : " + l)
        }
        l--
    } while(l >= 0)

}