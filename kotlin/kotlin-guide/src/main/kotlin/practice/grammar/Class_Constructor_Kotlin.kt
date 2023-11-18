package practice.grammar

/*
*   Constructor Class - Class, Primary, Constructor, Secondary Constructor and Init Block
*
* */

fun main(args: Array<String>) {

    val student1 = Student1("Test")
    println(student1.age)   // 초기화 하였던 값이 출력
    
    
    val student2 = Student1("Steve", 17)
    println(student2.age)   // Secondary 생성자로 생성

}

class Student1(val name: String) {
    var age: Int = 10

    // 항상 init block 이 먼저 실행이 됨 ~ !!!
    init {
        println("Student has got a name as $name and age is $age")
    }

    constructor(n: String, age: Int): this(n) {
        // The body of the secondary constructor is called after init block
        this.age = age
    }

}