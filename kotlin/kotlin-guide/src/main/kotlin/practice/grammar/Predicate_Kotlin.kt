package practice.grammar

/*
*   Kotlin Predicate !
*   
* */

fun main(args: Array<String>) {

    val myNum = listOf(2, 3, 4, 11, 6, 23)
    val myPredicate = { num: Int -> num > 10 }

    // Boolean all -> 모두  myPredicate 함수 에 조건에 속하는 지 !
    val check1: Boolean = myNum.all(myPredicate)
    println(check1)

    // Boolean any -> 어떤 것이든지 myPredicate 조건에 속하는 게 있는 지 !
    val check2: Boolean = myNum.any(myPredicate)
    println(check2)

    // Int count -> myPredicate 조건에 속하는 Element 들을 count
    val totalCount: Int = myNum.count(myPredicate)
    println(totalCount)

    // num -> find 함수 조건에 속하는 첫번쨰 Element 를 반환
    val num: Int? = myNum.find(myPredicate)
    println(num)

}