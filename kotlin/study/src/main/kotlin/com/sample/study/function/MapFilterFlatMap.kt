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
    val characters = words.flatMap { word ->
        println("CHECK FLATMAP WORD : $word")
        word.toList() }
    println(characters)

    val words2 = listOf("hello", "word")
    val characters2 = words2.map { word -> word.toList() }
    println(characters2)

    // Flat map advance example
    // flatmap is particularly useful when dealing with collections of collections or when you need
    // to perform a transformation that results in a list for each element, and then you want to
    // merge all these lists into one.

    // Advance Example 1. List of List
    val listOfList = listOf(listOf(1, 2), listOf(3, 4), listOf(5, 6))
    val flattenedList= listOfList.flatMap { it }
    println(flattenedList)

    // Advance Example 2. Complex Data Structure
    data class PersonSample(val name: String, val hobbies: List<String>)

    val people = listOf(
        PersonSample("Alice", listOf("Reading", "Hiking")),
        PersonSample("Bob", listOf("Gaming", "Cooking")),
        PersonSample("Carol", listOf("Running", "Painting"))
    )

    val hobbies = people.flatMap { person -> person.hobbies }
    println(hobbies)   // Output: [Reading, Hiking, Gaming, Cooking, Running, Painting]

    // Advance Example 3. Combining map and flatMap
    val numbers3 = listOf(1, 2, 3, 4, 5, 6, 7)
    val result = numbers3.flatMap { number ->
        (1 .. number).map { factor ->
            "Number $number : Factor $factor"
        }
    }

    println(result)

}


class MapFilterFlatMap {
    // functional programming capabilities and are incredibly
    // useful for manipulating collections like lists.

    // Map : applies a transformation to each element in a collection.
    val numbers = listOf(1, 2, 3, 4, 5)
    val squareNumbers = numbers.map { number -> number * number }

}


