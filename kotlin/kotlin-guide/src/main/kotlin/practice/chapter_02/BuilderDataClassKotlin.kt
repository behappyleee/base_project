package practice.chapter_02

class BuilderDataClassKotlin {


}

data class CarBuilder (
    val name: String,
    val year: Int,
) {
    internal class Car(
        val name: String,
        val year: Int,
    )

    fun build(): Car {
        return Car(this.name, this.year)
    }

    

}