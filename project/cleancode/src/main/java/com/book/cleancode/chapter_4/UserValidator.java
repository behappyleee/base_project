package com.book.cleancode.chapter_4;

public class UserValidator {

    // 진짜 목표는 시스템이라는 이야기를 풀어가는 데 있다는 사실을 명심하여야 한다.
    // Master 프로그래머는 시스템을 구현 할 프로그램이 아닌 풀어갈 이야기로 여긴다.
    // 작성하는 함수가 분명하고 정확한 언어로 깔끔하게 같이 맞아 떨어져야 이야기를 풀어가기가 쉽다.

    // 함수는 표준 알고리즘을 사용해 userName 과 password 를 확인한다.
    // 두 인수가 올바르면 true 아니면 false 를 반환
    // 여기서 함수가 일으키는 부수 효과는 Session.initialize() 호출이다.
    // checkPassword 함수는 이름 그대로 암호를 확인한다.
    // 함수 이름만 보고 호출 시 Session 을 지워버릴 수도 있다.
    // 자칫 잘못 호출하면 의도하지 않게 세션 정보가 날라갈수도 있다.
    // 차라리 함수가 한가지 역할을 한다는 규칙을 위반하지만 checkPasswordAndInitializeSession 이라는 이름이 훨씬좋다

//    public boolean checkPassword(String userName, String password) {
//        User user = Usergateway.findByName(userName);
//        if (user != null) {
//            String codedPhrase = user.getPhraseEncodedByPassword();
//            String phrase = cryptographer.decrypt(codedPhrase, password);
//            if("valid Password".equals(phrase)) {
//                Session.initialize();
//                return true;
//            }
//        }
//        return false;
//    }

}
