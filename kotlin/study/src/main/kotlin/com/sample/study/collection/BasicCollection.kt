package com.sample.study.collection

fun main() {

    for(i in 0 until 5 ) {
        println(i);
    }

    var str1: String? = "str testt";
    println(str1?.length);

    var str2: String? = null;
    println(str2?.length);


    // 1. List
    // 순서가 있는 데이터 집합 데이터의 중복 허용
    var list1: List<Int> = listOf(10, 20, 30);
    var list2: List<String> = getList();

    // 2. Set
    // 순서가 없으며 데이터의 중복을 허용 하지 않음
    var set1: Set<String> = setOf("1", "2", "3", "4");

    // 3. Map
    // 키와 값으로 이루어진 데이터 집합 순서가 없으며 키의 중복은 허용하지 않음
    var map1 = mapOf<String, Int>(Pair("Key", 2), Pair("Key1", 3), Pair("Key3", 7));
    map1.get("Key");

    var listCheck: List<Int> = listOf(3,5,6,7,8,1,2,8);

    // withIndex 는 실제 index 와 Value 를 함꼐 가져올 때 사용
    var a= listCheck.withIndex();

    for(i in 0..listCheck.size) {


    }

    // indices 는 컬렉션 타입의 인덱스 값을 의미
    for(i in listCheck.indices) {

    }


}

// var msgType = if (msgType == 1) "메세지" else "테스트";

fun getList(): List<String> {
    var listTest: List<String> = listOf("1", "2", "3", "4");

    return listTest;
}

var testA: () -> Unit = {
    println("Test 111 !!!");

};



fun methodCheck(name: String) {

}


