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

    // TODO
    // Kotlin 학습 하기 !!!
    // TODO
    // https://kotlinlang.org/docs/numbers.html#floating-point-types
    // 공식 문서
    // TODO
    // Unlike some other languages, there are no implicit widening conversions for numbers in Kotlin. For example, a function with a Double parameter can be
    // 해당 부분부터 학습 필요 ~ !!!

}

fun main() {

    var classNew = KotlinDataType();
}