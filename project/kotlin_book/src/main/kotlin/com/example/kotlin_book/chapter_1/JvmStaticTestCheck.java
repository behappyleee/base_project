package com.example.kotlin_book.chapter_1;

public class JvmStaticTestCheck {

    public static void main(String[] args) {
        // CompanionTest 해당 클래스에서 @JvmStatic 어노테이션을 사용하여 Companion 을 제외 하고
        // 사용이 가능
        CompanionTest.create("");

        // 만약 CompanionTest 해당 클래스에서 @JvmStatic 어노테이션이 없으면 Companion 을 붙여야 사용이 가능
        CompanionTest.Companion.create("");
    }
}
