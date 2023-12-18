package com.sample.study.function

fun main() {
    // functional programming capabilities and are incredibly
    // useful for manipulating collections like lists.

    // 1. Map : applies a transformation to each element in a collection.
    val numbers = listOf(1, 2, 3, 4, 5)
    val squareNumbers = numbers.map { number -> number * number }
    println(squareNumbers)

    // 2. Filter : filter function is used to select elements from a collection that meet a certain
    // criterition.
    val numbers2 = listOf(3, 7, 5, 4, 3, 6, 2)
    val filteredNumbers = numbers2.filter { number -> number % 2 == 0 }
    println(filteredNumbers)    // Filtered 된 Numbers 를 return 조건에 만족하는 Element 들 만 return

    // 3. FlatMap : flatmap function combines map and flatten, It first applies a
    // transformation to each element in a collection and then flattens the resulting collections into a
    // single list.

    // Each of these functions is a powerful tool in Kotlin, especially when dealing with collections, map transforms elements.
    // transforms each element into a collection and then flattens all the collections into a single one.
    val words = listOf("hello", "world")
    val characters = words.flatMap { word -> word.toList() }
    println(characters)

    // Flat map advance example
    //


}


class MapFilterFlatMap {
    // functional programming capabilities and are incredibly
    // useful for manipulating collections like lists.

    // Map : applies a transformation to each element in a collection.
    val numbers = listOf(1, 2, 3, 4, 5)
    val squareNumbers = numbers.map { number -> number * number }

}


