package com.sample.study.sealed

class SealedClassTest {

    // Sealed Class
    // 1. 상속을 제한
    // 2. 유한한 갯수의 하위 클래스를 갖는다
    // 3. 하위 클래스의 종류를 제한

    // Sealed Class 장점
    // 1. 코드 안정성 향상
    // 2. 가독성 향상
    // 3. 패턴 매칭



}

sealed class ResultTest<out T> {
    data class Success<out T>(val test: T) : ResultTest<T>()

    data class Error(val exception: Exception): ResultTest<Nothing>()


}



fun main() {

}