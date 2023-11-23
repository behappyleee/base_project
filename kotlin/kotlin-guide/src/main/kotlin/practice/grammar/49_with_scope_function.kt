package practice.grammar

data class Person(
    val name: String = "Lee Name Test",
    var age: Int = 26,
)

fun main() {
    /*
    *   Scope Function
    *   Property 1 : Refer to context object by using this
    *   Property 2 : The return value is the 'lambda result'
    *
    * */
    val per1 = Person()
    val bio: String = with(per1) {
        println(name)
        println(age)
        age + 5
        "He is a nice guy"// will be returned and stored in 'bio' String variable
    }

    println(bio)
}