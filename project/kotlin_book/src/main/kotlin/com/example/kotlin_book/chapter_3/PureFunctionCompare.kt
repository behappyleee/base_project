package com.example.kotlin_book.chapter_3

class PureFunctionCompare {

}

fun main(args: Array<String>) {

    val testFun = FunFunctions()
    val listTest = mutableListOf(2, 7, 9, 11, 12)

    val aaa = testFun.append1(3, listTest)

    // listTest 가 변이가 됨 ----> 순수 함수가 아님 ... !
    println(aaa)
    println(listTest)

    val listTest2 = mutableListOf(3, 5, 7, 11, 9)
    val bbb = testFun.append2(77, listTest2)

    println(bbb)
    // listTest2 가 변이 되지 않음 .... ! 새로운 List 가 생성이 되어 반환이 됨 ! ---> 아무것도 변이 된것이 없기에
    // ====> 순수 함수임 !!!!
    println(listTest2)

}

class FunFunctions {
    
    val percent1 = 5
    private var percent2 = 9
    val percent3 = 13
    
    // add 는 항상 인자에 따라 정해지는 값을 반환하기에 순수 함수 임, 이 함수는 인자를 변이 시키지도 않고 외부 세계와
    // 전혀 상호 작용도 없음
    fun add(a: Int, b: Int): Int = a + b
    
    // 이 함수는 순수 함수이다. 이 함수는 이름과 내용이 다르며 인자로 어떤 값을 받은 관계없이 같은 값을 반환, 이 함수는 상수
    fun mult(a: Int, b: Int?): Int = 5
    
    // Int 타입에 대한 div 함수는 순수 함수가 아님, 제수가 0 이면 예외가 발생, div 를 순수 함수로 만들기 위하여서는
    // 두 번째 파라미터를 0 검사를 하여야 함
    fun div(a: Int, b: Int): Int = a / b

    // 하지만 Int 가 아닌 Double 로 변경할 시 순수함수로 변경이 됨
    fun divDouble(a: Double, b: Double): Double = a / b

    fun applyTax1(a: Int): Int = a / 100 * (100 + percent1)
    
    fun applyTax2(a: Int): Int = a / 100 * (100 + percent2)

    fun applyTax3(a: Int): Int = a / 100 * (100 + percent3)

    // append1 함수는 인자를 반환 하기 전에 변이 시킴, 그리고 이렇게 변이 시간 함수를 함수 밖에서 관찰이 가능
    // 따라서 이 함수는 순수 함수는 아님
    fun append1(i: Int, list: MutableList<Int>): List<Int> {
        list.add(i)
        return list
    }

    // append2 함수는 원소를 인자로 받은 리스트에 더하는 것으로 보이지만 실제로는 그렇지 않음
    // list + i 라는 식의 list 의 모든 원사가 같은 순서로 되어있고 맨 뒤에 i 가 더들어 있는 새로운 리스트를 만들어 내므로
    // 아무것도 변이 된 것은 없다, 따라서 append2 는 순수 함수다
    fun append2(i: Int, list: List<Int>) = list + i
    
}

