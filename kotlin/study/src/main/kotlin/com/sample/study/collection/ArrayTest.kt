package com.sample.study.collection

fun main() {
    // 3 사이즈와 초기값 0으로 설정
    var arr1 = Array<Int>(3, {0});
    var arr2 = arrayOf(70,60,50,40,30); // 선언과 동시에 배열에 할당

    arr1[0] = 10;
    arr1[1] = 20;
    arr1[2] = 30;

    arr1.set(3, 40);

    var arrIndex1: Int = arr1.get(1);
    println(arrIndex1);




}