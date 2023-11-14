package practice.chapter_01

fun main() {

    // Create a class with empty constructor
    // var player = Player();

    val player = Player("Roland")
   // Won't be compile
   // player.name = "Chnage Test"   // val cannot be reasssigned

    println(player.name)

    val aaa: Char = player.name.get(2);
    println("NAME TEST : " + aaa);


    val per1 = Player("ABCDEF")
    println("NAME TEST CHECK : " + per1.name.get(1))

    // get() 메서드로 소문자로 변환 되어 반환
    var per2 = Player("ASSDSD")
    // 음수로 set 을 해주어 0 을 반환 (음수 set 해 줄 시)
    per2.score = -35
    println("PRINT SCORE DATA : " + per2.score)

    player.score = -10

    var per7 = Player("TET 777")
    println(per7.check.get(3))

    per7.check = "CHANGE TEST"
    println(per7.check)

}

// Class with Default Empty Constructor
//class Player {
//
//}

// Class With Default Empty Constructor
class Player(name: String) {
    val name = name
        get() = field.toLowerCase()


    var check: String = "DEFAULT"
        get() = field.toLowerCase()
        set(value) {
            println("CHECK SET VALUE DATA !!")
            field = "THIS IS CHANGED TEST"
        }

   var score: Int = 0
        set(value) {
            field = if(value >= 0) {
                value
            } else {
                0
            }
        }
}