package data_structure

fun main() {

    // Kotlin Data Structure
    // 1. Array
    // An array is a collection of items stored at contiguous memory locations.
    // The idea is to stroe the multiple items of the same type together.

    // 빈 배열 객체를 생성
    val intArray = emptyArray<Int>();

    // 인자 값으로 넣은 Element 들을 가지는 배열 객체를 생성
    val intArray2 = arrayOf(1, 2, 3);

    // null 로 초기화
    val intArray3 = arrayOfNulls<Int>(5);

    // 생성자를 이용해서 초기화를 함
    val intArray4 = Array<Int>(3) {
        i -> i+1
    };

    // Boxing 타입을 사용할 건 지 Primitive 타입을 사용할 건지에 따라 다름
    var arr1 = Array<Int>(5, {0});  // 5 만큼의 크기를 할당하고 엘리먼트를 0 으로 초기화
    var arr2 = IntArray(5, {0});    // 5 만큼의 크기를 할당하고 엘리먼트를 0 으로 초기화

}

