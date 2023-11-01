package com.sample.study.basic

fun main() {
    var test: String = "this is kotlin";
    print("kotlin grammar test !");
    println("${test}");
    println("$test");

    // Raw String
    var rawString = """
        이것은 로우 스트링 입니다.
        한줄 띄 움
        쓰기 라이트
    """.trimIndent();

    println(rawString);

    


}