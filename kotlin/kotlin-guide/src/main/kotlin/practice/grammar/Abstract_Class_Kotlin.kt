package practice.grammar

fun main(args: Array<String>) {

    val per1 = Indian()


}


abstract class Abstract_Class_Kotlin {

    abstract val name: String
    abstract fun eat()

    open fun getHeight() {
        println("Open fun get Height !")
    }

    fun goToSchool() {
        println("Go To School Method !!!!!!")
    }

}

class Indian: Abstract_Class_Kotlin() {

    override val name: String = "This is Override Var !!"

    override fun eat() {
        println("This is Override Fun Eat !!!")
    }

}


