package practice.chapter_01

fun main() {

    // Create a class with empty constructor
    // var player = Player();

    val player = Player("Roland")

   // Won't be compile
   // player.name = "Chnage Test"   // val cannot be reasssigned

    println(player.name)

    player.score = -10
}

// Class with Default Empty Constructor
//class Player {
//
//}

// Class With Default Empty Constructor
class Player(name: String) {
    val name = name
        get() = field.toUpperCase()

    var score: Int = 0
        set(value) {
            field = if(value >= 0) {
                value
            } else {
                0
            }
        }
}