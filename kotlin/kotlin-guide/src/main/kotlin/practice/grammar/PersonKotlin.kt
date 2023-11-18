package practice.grammar

// This is main function. Entry of the application.
fun main(args: Array<String>) {

    var person1 = PersonObj()
    person1.name = "Steve"

    println("The name of the person is ${person1.name}")

    var person2 = PersonTest("Test")
    person2.display()

}

class PersonObj {
    var name: String = ""
}

class PersonTest(val name: String) {

    fun display() {
        println("The name is $name")
    }
}
