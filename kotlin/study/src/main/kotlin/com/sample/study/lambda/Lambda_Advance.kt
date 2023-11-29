package com.sample.study.lambda

fun main() {

    // Higher-order functions
    // Higher-Order function is the functional programming idiom fold for collection
    // 


}

fun <T, R> Collection<T>.fold
            (initial: R, combine: (acc: R, nextElement: T) -> R): R {
    var accumulator: R = initial
    for(element: T in this) {
            accumulator = combine(accumulator, element)
    }
    return accumulator
}