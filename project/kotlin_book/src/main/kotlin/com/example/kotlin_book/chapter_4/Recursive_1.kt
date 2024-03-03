package com.example.kotlin_book.chapter_4

class Recursive_1 {
    
    // Recursive Function 은 자바에서 사용하는 경우는 거의 없지만 대부분의 프로그래밍 함수에서는
    // 재귀 함수를 제공
    // 자바에서 재귀 함수 처리를 제대로 구현하지 못함
    // 코틀린은 더 나은 구현을 제공하기에 더 많이 사용이 가능
    // Important -> 루프와 마찬가지로 재귀도 직접 사용하기 보다는 함수로 추상화하여 사용 필요
    
}

// 공재귀 - String, Char 인자를 받아서 문자열 뒤에 새 문자가 붙는 새 문자열을 반환
fun append(s: String, c: Char): String = "$s$c"

// 시작 할 문자열이 없기에 이 함수만 가지고는 문자 리스트 처리가 불가능, 따라서 빈 문자열이라는 새 요소가 필요
fun toStringList(list:List<Char>, s: String): String =
    if (list.isEmpty())
        s
    else
        toStringList(list.subList(1, list.size), append(s, list[0]))