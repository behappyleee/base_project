package practice.grammar

fun main(args: Array<String>) {

    val student = Student()

    println("PASS STATUS : " + student.hasPassed(337))
    println("Scholarship Status : " + student.isScholar(83))

    val str1 = "Be"
    val str2 = "Happy"
    val str3 = "Always"
    val combine: String = str1.add(str2, str3)

    val x: Int = 10
    val y: Int = 20

    val greaterVal = x.greaterValue(y)
    println(greaterVal)

}

// 만약 Class 가 private 이면 따로 함수 지정이 불가능 클래스 Access Modifier 가 public 이여서 함수 지정이 가능
fun Student.isScholar(marks: Int): Boolean {
    return marks > 75
}

class Student {        // Our Own Class

    fun hasPassed(marks: Int): Boolean {
        return marks > 40
    }
}

fun String.add(s1: String, s2: String): String {
    return this + " " + s1 + " " + s2
}

fun Int.greaterValue(other: Int): Int {
    if(this > other) {
        return this
    } else {
        return other
    }
}
