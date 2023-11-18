package practice.grammar

fun main(args: Array<String>) {

    val myDog = MyDog()
    println(myDog.color)

    myDog.color = "Color Change !"
    println(myDog.color)

    myDog.eat()

}

open class MyAnimal {
    open var color: String = "White"

    open fun eat() {
        println("Animal Eating")
    }
}

class MyDog: MyAnimal() {
    var bread: String = ""
    override var color: String = "Black"

    fun bark() {
        println("MyAnimal Barking !!")
    }

    override fun eat() {
        // Parent Class 부모 메서드 eat() 실행
        super<MyAnimal>.eat()
        println("Dog is Eating ~ !!!")
    }

}






