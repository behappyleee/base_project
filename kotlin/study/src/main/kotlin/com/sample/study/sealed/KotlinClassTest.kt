package com.sample.study.sealed

// Kotlin 에서 class 생성 시 default 가 public 임 !
class KotlinClassTest {

    // Java 에서는 internal 에 딱 맞는 가시성은 없음
    // package-private 과 internal 은 서로 다름
    // 모듈은 보통 여러 패키지에서 이루어짐, 서로 다른 모듈에 같은 패키지에 속한 선언이 들어있을 수 있음
    // internal 변경자는 바이트 코드 상 public 이 됨

    //

}


private class KotlinPrivateClass

class KotlinProtectedClass

