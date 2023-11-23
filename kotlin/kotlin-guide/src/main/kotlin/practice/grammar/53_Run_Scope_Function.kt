package practice.grammar

data class Person53(
    var name: String = "Kotlin Data Class Name",
    var age:Int = 27,
)

fun main() {
    /*
    *   Run Scope Function
    *   Property 1 : Refer to context object by using this
    *   Property 2 : The return value is the lambda result
    * */

    val per1 = Person53()
    val bio = per1?.run {
        println(name)
        println(age)
        age + 5
        "He is a nice guy"
    }
    // String 문자열이 출력
    println(bio)
    
}