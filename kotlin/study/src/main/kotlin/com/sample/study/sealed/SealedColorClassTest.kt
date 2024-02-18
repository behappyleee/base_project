package com.sample.study.sealed

sealed class SealedColorClassTest {

    data class Red(val name: String) : SealedColorClassTest()

    data class Green(val name: String, val code: Int) : SealedColorClassTest()

    data class Blue(val name: String) : SealedColorClassTest()

    companion object {
        fun getSealedColorClassTypeCheck(type: SealedColorClassTest): String {
            return when (type) {
                is SealedColorClassTest.Red -> "This is Red ${type.name}!"
                is SealedColorClassTest.Green -> "This is Green Data ${type.name} , ${type.code}!"
                is SealedColorClassTest.Blue -> "This is Blue Data Name : ${type.name}"
            }
        }
    }
}

fun main() {

    val colorRed = SealedColorClassTest.Red("This is Red !!")
    getColorType(colorRed)

    SealedColorClassTest.getSealedColorClassTypeCheck(colorRed)

}

fun getColorType(type: SealedColorClassTest): String {
    // Sealed Class 는 when 과 같이 사용 시 강력한 기능을 발휘
    return when(type) {
        is SealedColorClassTest.Red -> "This is Red ${type.name}!"
        is SealedColorClassTest.Green -> "This is Green Data ${type.name} , ${type.code}!"
        is SealedColorClassTest.Blue -> "This is Blue Data Name : ${type.name}"
    }
}