package practice.grammar

fun main() {
    /*
    *   Scope Function : 'also'
    *   Property 1 : Refer to context object by using it
    *   Property 2 : The return value is the 'context object'
    * */

    // Initialize numberList
    val numberList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

    // Some other code ... may be a function call or program to swap numbers (doesn't matter what code)

    // Operation on the numberList
    val duplicateNumber = numberList.also {
        println("This is NumberList Elements : $it")
        it.add(7)
        println("The list elements after adding an element : $it")
        it.remove(2)
        println("The lis elements after removing an element $it")
    }
    
    // 두 개 다 똑같이 바뀌어 있음
    println("ORIGINAL NUMBER : $numberList")    
    println("DUPLICATE NUMBER : $duplicateNumber")
    
}
