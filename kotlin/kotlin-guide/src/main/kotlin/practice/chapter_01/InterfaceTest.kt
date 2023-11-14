package practice.chapter_01

import kotlin.random.Random

fun main() {

    val dice = Dice()
    dice.click()
    dice.rollDice()
    dice.oneLineFunc()
}

class Dice: DiceRoller {

    // Implements 한 Interface 메서드를 Override
    override fun click() {
        println("Dice Roller Method Override !")
    }
}

interface DiceRoller {

    fun rollDice(): Int {
        val randomInt = Random.nextInt(0 ,6)

        println("ROLL DICE RANDOM NUM : " + randomInt);

        return randomInt
    }

    fun oneLineFunc() = println("This is Fun Print Function")

    fun click()
}