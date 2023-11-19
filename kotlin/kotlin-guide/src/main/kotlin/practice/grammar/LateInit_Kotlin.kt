package practice.grammar

fun main(args: Array<String>) {

    val country = Country("LATE INIT !!")
    country.setup()

}

class Country(val lateName: String) {
    lateinit var name: String
    // Error
    // lateinit keyword ony use var type
    // lateinit val age: Int

    fun setup() {
        this.name = lateName
        println("The name of country is $name")
    }

}

// lateinit keyword only with mutable data type [var]
// lateinit used only with non-nullable data type
// lateinit values must be initialised before you use it

// If you try access lateinit variable without initializing then it throws UninitializedPropertyAccessException