package com.sample.study.basic


fun main() {
    var mapTest = hashMapOf<String, Int>()
    
    mapTest.put("test1", 1)
    mapTest.put("test2", 2)
    mapTest.put("test3", 3)
    mapTest.put("test4", 4)
    mapTest.put("test5", 5)    
    
    mapTest.forEach { key, value ->
        println("MAP KEY : " + key)
        println("MAP VALUE : " + value)
    }

    var per1 = Persons("test1", 20);
    var per2 = Persons("test2" , 21);
    var per3 = Persons("test3" , 22);
    var per4 = Persons("test4", 23);
    var per5 = Persons("test5" , 24);

    var listTest = listOf(per1, per2, per3, per4, per5);


}

class Persons(var name:String?, var age: Int?)

