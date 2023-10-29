package com.sample.study.type

class KotlinDataType {

    // Kotlin Data Type
    // In Kotlin everything is an Object in the sense that you can call member functions and properties
    // on any variable.

    // Numbers
    // Kotlin provides a set of built-in types that represent numbers
    // When initialize numbers a variable with no explicit type specification, the compiler automatically
    // infers the type with the smallest range enough to represent the value starting from Int.
    // If it is not exceeding the range of Int, the type is Int. If is exceeds the type is Long.
    val one = 1;    // Int
    val threeBillion = 300000000000;    // Long
    val oneLong = 1L    // Long
    val oneByte: Byte = 1;

    // For Real Numbers Kotlin provides floting-point types Float and Double
    // can initialize Double and Fload varialbes with numbers having a fractional part.
    // For variables initialized with fractional numbers, the compiler infers the Double type
    val pi = 3.14   // Double
    val oneDouble = 1.0     // Double

    // To explicitly specify the Float type for a value, add the suffix f or F, If such a value contains
    // more than 6-7 decimal digits, it will be rounded
    val e  = 2.71828182;       // Double
    val eFloat = 2.7182F;    // Float

    // Unlike someother languages, there are no implicit widening conversions for numbers in Kotlin.
    // For example, a function with a Double paramter can be called only on Double values, but not Float, Int or other numeric values.
    // var ttt = doubleParameterFunction(3.5f); // Error 발생
    var test = doubleParameterFunction(3.6);   // doubleㄹ 하여애 에러 발생하지 않음

    // On the JVM platform, numbers are stored as primitive types: int, double, and so on.
    // Exceptions are cases when you create a nullable number reference such as Int? or use generics.
    // In thesse cases numbers are boxed in Java classes Integer, Double and so on.

}

fun main() {

    // On the JVM platform, numbers are stored as primitive types: int, double, and so on.
    // Exceptions are cases when you create a nullable number reference such as Int? or use generics.
    // In thesse cases numbers are boxed in Java classes Integer, Double and so on.

    // All nullable references to a are actually the same object of the memory optimization that JVM
    // applies to Integer between -128 and 127, It doesn't apply to the b references, so they are different objects.

    val a: Int = 100;
    val boxedA: Int? = a;
    val anotherBoxedA: Int? = a;

    val b: Int = 10000;
    val boxedB: Int? = b;
    val anotherBoxedB: Int? = b;

    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false

}

fun doubleParameterFunction(param: Double) {



}




