package practice.grammar

fun main(args: Array<String>) {

    // This range contains number 1, 2, 3, 4, 5
    var r1 = 1 .. 5

    // This range contains number 5, 4, 3, 2, 1
    var r2 = 5 downTo 1

    // This range 5, 3, 1
    var r3 = 5 downTo 1 step 2

    // This range contains the values from 'a' 'b' 'c' .... 'z'
    var r4 = 'a' .. 'z'

    // This range contains number 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
    var isPresent = 'c' in r4

    // This range contains number 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
    var countDown = 10.downTo(1)

    // This range contains number 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    var moveUp = 1.rangeTo(10)

}