package com.sample.study.function

fun main() {
    // Filter 함수는 주어진 람다의 조건을 만족하는 원소만 필터링 하는 기능
    // List 와 Set 을 필터링하는 경우에는 List 로 Map 을 필터링 하는 경우에은 Map 으로 반환
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { num -> num.length > 3 }
    // 지정 된 조건과 일치하지 않는 항목만 반환 리스트 반환
    val smallerThan3 = numbers.filterNot { num -> num.length > 3 }
    // filter 를 순환 시 Index 값도 반환이 가능 !
    val filterIndex = numbers.filterIndexed { index, num -> index != 0 && num.length > 3 }

    println("FILTERED INDEX DATA CHECK : " + filterIndex)
    println("LOGER THAN 3 : " + longerThan3)
    println("SMALLER THAN 3 : " + smallerThan3)

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10 }

    println("FILTERED MAP : " + filteredMap)


    // none - 조건을 만족하는 원소가 없으면 true
    // all - 모든 원소가 조건을 만족하면 true

    val intNumbers = listOf(3, 7, 8, 11, 12, 131, 27, 185, 38)

    // any - 조건을 만족하는 원소가 1개 이상 존재하면 true
    println(intNumbers.any { num -> num > 2 })

    // none - 조건을 만족하는 원소가 엇으면 true
    println(intNumbers.none { num -> num > 195 })

    // all - 모든 원소가 조건을 만족하면 true
    println(intNumbers.all { num -> num > 7 })




}