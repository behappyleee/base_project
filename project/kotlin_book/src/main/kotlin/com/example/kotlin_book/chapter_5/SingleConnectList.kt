package com.example.kotlin_book.chapter_5

sealed class SingleConnectList<A> {

    abstract fun isEmpty(): Boolean

    // 빈 리스트를 표현하는 Nil 하위 클래스, List 클래스 안에서
    // 확장 클래스를 정의하고, 비공개로 선언
    private object Nil : SingleConnectList<Nothing>() {
        override fun isEmpty() = true
        override fun toString(): String = "[NIL]"
    }

    private class Cons<A>(
        internal val head:A, internal val tail: List<A>): SingleConnectList<A>() {
            override fun isEmpty() = false
            private tailrec fun toString(acc: String, list:SingleConnectList<A>) {

            }
    }

}