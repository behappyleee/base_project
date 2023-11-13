package practice.chapter_01

fun main() {

}

fun loops() {
    for (c in "Word") {
        println(c)
    }

    val jokers = listOf("Heath Ledger", "Joaquin Phoenix", "Jack Nicholson")

    for(j in jokers) {
        println(j)
    }

    for(i in 0..9) {
        println(i)
    }

    for(i in 0 until 10) {
        println("for Until $i")
    }

    var x = 0;
    while(x < 10) {
        x++
        println("While + $x")
    }

    x = 5
    do {
        println("DO WHILE $x")
        x--
    } while(x > 0)

}

fun whens() {
    println(getUnixSocketPolling(true))
    println(getUnixSocketPolling(false))
}

fun ifs() {
    println()
    println()
}

fun getUnixSocketPolling(isBad: Boolean): String {
    return if(isBad) {
        "kqueue"
    } else {
        "epoll"
    }
}

fun archenmy(heroName: String) = when(heroName) {
    "Bootman" -> "Jocker"
    "Superman" -> "Lex Luthor"
    "Spider-Man" -> "Green Goblin"
    else -> "Sorry, no idea"
}