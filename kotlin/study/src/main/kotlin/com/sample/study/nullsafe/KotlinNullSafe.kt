package com.sample.study.nullsafe

fun main() {
    // null : 객체가 선언 되었지만 초기화 되지 않은 상태
    // 객체는 데이터가 지정 된 주소를 참조하므로 흔히 참조 변수라 한다.
    // 데이터가 메모리에 저장되는 위치를 식별하는 값을 주소라 한다.

    // null 은 객체가 주소를 가지지 못한 상태
    // null 인 상태의 객체를 이용하면 NullPointer Exception 에러가 발생
    // 널 안정성 이란 Null Pointer Exception 이 발생하지 않도록 코드를 작성

    // Kotlin 은 변수 타입을 Nullable / Not Null 로 구분
    // 변수 타입 뒤에 ? 연산자를 추가하였으므로 널 허용 변수가 되어 널(null) 을 대입 가능

    // nullable 변수
    var int1:Int? = null;

    // Not null 변수 null 선언 시 에러가 발생 null 대입이 불가
    var int2:Int = 7;

    var str1: String? = null;

    // 만약 str1 이 null 이면 0을 반환하고 null 이 아니면 str1?.length 를 반환
    var strLength = str1?.length ?: 0;

    var str2: String = "string check";
    var str2Length: Int = str2.length ?: 0;

    // 엘비스 연산자 ( ?: )
    // 변수가 null 일 떄 반환 하는 값을 대입하여 실행하는 구문에 적용
    var str5: String? = null;
    var comment: String = "This is str5 Variable ${str5 ?: "Need To Check"}";
    println(comment);

    // 예외 발생 연산자 (!!)
    // !! 연산자 : null 일 때 예외를 일으키는 연산자
    // 객체가 null 일 떄 ?. 또는 ?: 연산자를 이용하여 NullPointerException 이 발생하지 않게
    // 작성할 수 도 있지만, 또 어떤 경우에는 NullPointerException 을 발생 시켜야 할 수 있으므로 그때 사용

    // !! 연산자는 값이 절대 null 이면 안되는 곳에 사용
    var nullStr: String? = null;
    println(nullStr!!); // Null Pointer Exception 에러가 발생 !!!


}