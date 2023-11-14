package practice.chapter_02

import java.lang.RuntimeException

fun main() {
    val queen = Queen('a', 'b')

    println(queen.getRankTest())

    val createPiece = createPiece("pqp")
    println(createPiece)

}

interface ChessPiece {
    val file: Char
    val rank: Char
}

data class Pawn(
    override val file: Char,
    override val rank: Char,
): ChessPiece

data class Queen(
    override val file: Char,
    override val rank: Char,
): ChessPiece {

    fun getRankTest(): Char {
        return rank
    }

}

class CheckInterface(
    override val file: Char,
    override val rank: Char,
): ChessPiece {

}

fun createPiece(notation: String): ChessPiece {
    val(type, file, rank) = notation.toCharArray()
    return when(type) {
        'q' -> Queen(file, rank)
        'p' -> Pawn(file, rank)
        else -> throw RuntimeException("Unknown Piece :${type}")
    }
}

class FactoryMethodKotlin {
}