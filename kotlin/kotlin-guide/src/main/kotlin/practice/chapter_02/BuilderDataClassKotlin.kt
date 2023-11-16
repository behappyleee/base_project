package practice.chapter_02

class BuilderDataClassKotlin {
//    var car1 = CarBuilder
//        .name("TEST CAR")
//        .year(1234)
//        .build()

}

data class CarBuilder (
    var name: String,
    var year: Int,
) {
    class Car (
        val name: String,
        val year: Int,
    )

    fun name(name: String): CarBuilder {
        this.name = name
        return this
    }

    fun year(year: Int): CarBuilder {
        this.year = year
        return this
    }

    fun build(): Car {
        return Car(this.name, this.year)
    }

}