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

}