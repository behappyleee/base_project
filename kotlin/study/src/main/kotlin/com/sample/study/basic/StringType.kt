package com.sample.study.basic

fun main() {

    // Kotlint Raw String
    // Kotlin 에서도 Raw String 작성도 가능함
    var testNum = 7;
    var testStr = """
        테스트 로우 
        스트링
        ${testNum}
    """.trimIndent();

    println(testStr);

}

