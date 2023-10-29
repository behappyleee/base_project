package com.sample.study.collection

fun main() {
    var stu1 = Student("test1", 13);
    var stu2 = Student("test2", 14);
    var stu3 = Student("test3", 15);
    var stu4 = Student("test4", 16);
    var stu5 = Student("test5", 17);

    var stuList: List<Student> = arrayListOf(stu1, stu2, stu3, stu4, stu5);

    stuList.forEach { stu ->
        println(stu.introduceStu());
    };

    println(stuList.size);

    var filterStu = stuList.filter { stu ->
        stu.age!! > 13
    }

    println(filterStu.size);

    stuList.filter { stu -> stu.age!! > 13 }
            .forEach { stu -> println(stu.introduceStu()) }
            .apply {  }
            // .to()

}

// Kotlin 에서는 선언 방식에 따라 Getter / Setter 생성 유무를 판단
// var 로 선언 시 멤버 변수를 변경 가능 하지만 val 로 선언 시 멤버 변수 변경이 불가
class Student (var name: String? ,var age: Int?){
//    var name: String? = name;
//    var age: Int? = age;
//
//    fun setName(name: String) {
//        this.name = name;
//    }
//
//    fun setAge(age: Int) {
//        this.age = age;
//    }
//
//    fun getName(): String? {
//        return name;
//    }
//
//    fun getAge(): Int? {
//        return age;
//    }

    fun introduceStu(): String {
        return "My Name is " + name + " and Age is : " + age;
    }

}