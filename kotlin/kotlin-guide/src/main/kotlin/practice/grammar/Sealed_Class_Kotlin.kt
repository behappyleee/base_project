package practice.grammar

// Limitations of Enum class is overcome by sealed class
fun main() {
    val circle = Shape.Circle(3.0f)
    val square = Shape.Square(8)
    val rectangle1 = Rectangle1(20, 10)

    val noShape = Shape.NotAShape

    checkShape(circle)
    checkShape(square)
    checkShape(rectangle1)
    checkShape(noShape)

}

// Limitations of Enum Class is Overcome by sealed Class.
enum class Color(val colorShape: String) {
    RED("Light Red"),
    GREEN("Light Green"),
}

sealed class Shape {
    data class Circle(var radius: Float): Shape()       // SubClasses can be a data class
    class Square(var side: Int): Shape()                // SubClasses can be a regular class

    object NotAShape: Shape()       // SubClasses can be a regular class

    // sealed class Line : Shape()  // Subclass can be another sealed class
    // sealed interface Draw        // subclass can be an interface
}

class Rectangle1(var length: Int, var breadth: Int): Shape()

fun checkShape(shape: Shape) {
    when(shape) {
        is Shape.Circle -> println("Circle Area is ${3.14 * shape.radius * shape.radius}")
        is Shape.Square -> println("Square Area is ${shape.side * shape. side}")
        is Rectangle1 -> println("Rectangle Area is ${shape.length * shape.breadth}")
        Shape.NotAShape -> println("No Shape !!")
    }
}

