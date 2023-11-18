package practice.grammar

/*
*    Break Keyword and Labelled For Loop
*
* */

fun main(args: Array<String>) {

    for(i in 0.. 4) {
        println(i)
        if(i == 2) {
            break
        }
    }

    println()

    // myLoop@ 로 이름 지정이 가능
    for(i in 1..3) {
        println("MyLoop i : " + i)
        secondLoop@ for(j in 1..3) {
            println("Second MyLoop j : " + j)
            if(i == 2 && j == 2)
                break@secondLoop
        }
    }

    // Continue Keyword
    for(i in 1 .. 3) {
        if(i == 2) {
            continue
        }
        println(i)
    }

     for(i in 1 ..3) {
        secondLoops@ for(j in 1 .. 3) {
            if(i == 2 && j == 2) {
                continue@secondLoops
            }
            println("i : $i, j :  $j")
        }
    }


}
