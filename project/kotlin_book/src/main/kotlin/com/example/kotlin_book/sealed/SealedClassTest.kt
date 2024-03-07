package com.example.kotlin_book.sealed

class SealedClassTest {

}

fun main() {

    val color: ColorTest = ColorTest.Red(255, 0, 20)


}

sealed class ColorTest {

    // Sealed 클래스는 기본적으로 추상 클래스
    // Sealed 클래스는 추상 클래스로 상속 받는 자식 클래스의 종류를 제한시켜 버림

    // Sealed 클래스의 서브 클래스 각각에 대해 여러개의 인스턴스 생성이 가능
    // sealed 클래스의 계층 생성이 가능
    // 상태 값이 바뀌지 않는 서브 클래스의 경우 object 사용을 권장
    // 서브 클래스 각각은 각기 다른 값을 가지고 개성있게 생성될 수 있도록 되어있음
    // 컴파일러에게 애내 말고 내 자식 없으니 다른 곳 보지 않아도 알려주는 것
    // Sealed 클래스는 자기 자신이 추상 클래스이고 자신을 상속받는 여러 서브 클래스들을 가질 수 있다.
    // 이를 사용하면 enum 클래스와 달리 상속을 지원하기 때문에 상속을 활용한 풍부한 동작 구현이 가능

    // 서브 클래스들은 class / data class / object 모두 사용이 가능
    data class Red(val r: Int, val g: Int, val b: Int): ColorTest()

    class Blue(val r: Int, val g: Int, val b: Int)
        
}

fun getRunningStatus(status: RunningStatus): String {
    return when(status) {
        is RunningStatus.Run -> "This Run !"
        is RunningStatus.Ready -> "This is Ready !"
    }
}

fun getRunningStatusTest(status : RunningStatusTest): String {
    // RunningStatusTest Ready / Run 을 분기에서 모두 처리를 해주어야 에러가 발생하지 않음 !
    return when(status) {
        RunningStatusTest.Ready -> "This is Ready !"
        RunningStatusTest.Run -> "This is Run !"
    }
}

// is 는 타입을 확인 시에 사용 !
fun getInterTest(test: InterTest): String {
    return when(test) {
        is Check1 -> "This is Check 1 Class !"
        is Check2 -> "This is Check 2 Class !"
        else -> "default !"
    }
}

interface InterTest{}

class Check1: InterTest
class Check2: InterTest


enum class RunningStatusTest {
    Ready,
    Run
}

sealed class RunningStatus {

    data class Ready(val a: Int): RunningStatus()

    data class Run(val b: Int): RunningStatus()

}
