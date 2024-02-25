package com.example.kotlin_book.chapter_3

import java.lang.IllegalStateException

class Payment_Function_Expression {

}

fun main(args: Array<String>) {



}

class DonutExample {
    // 참조 투명성을 사용 하여 코드를 리팩토링 하면 얻을 수 있는 이점은 프로그램을 합성하기 더 좋음
    // 이 단계 에서는 더 이상 신용 카드 지급이 어떻게 이뤄지는지를 신경쓰지 않음
    fun buyDonut(creditCard: CreditCard) : Purchase {
        val donut = Donut()
        val payment = Payment(creditCard, Donut.price)
        return Purchase(donut, payment)
    }

    // Donut 을 여러개 사는 경우
    fun buyDonuts(quantity: Int = 1, creditCard: CreditCard): PurchaseMutliple =
        PurchaseMutliple(List(quantity) {
            Donut()
        }, Payment(creditCard, Donut.price * quantity))

    fun buyDonutTest(quantity: Int = 1, creditCard: CreditCard) {
        val creditCard = CreditCard()

        val pay1 = Payment(creditCard = creditCard, amount = 2000)
        val pay2 = Payment(creditCard = creditCard, amount = 3000)
        val pay3 = Payment(creditCard = creditCard, amount = 4000)

        // 객체 표기 방식으로 더 심플하게 표시가 가능 !
        val newPayment =  pay1.combine(pay2).combine(pay3)

        // Companion 방식 사용하지 않을 시

    }

}

class Donut {

    companion object {
        val price = 1000
    }
}

class CreditCard

class Payment(
    val creditCard: CreditCard,
    val amount: Int,
) {
    fun combine(payment: Payment): Payment =
        if(creditCard == payment.creditCard) {
            Payment(creditCard, amount + payment.amount)
        } else {
            // 서로 다른 두 카드의 지급을 하나로 묶는 것은 버그로 간주
            throw IllegalStateException("Cards Don't match")
        }
}

// combine 기존 함수 에서 변경해 보곘다.
class PaymentFunction(
    val creditCard: CreditCard,
    val amount: Int,
) {
    // combine 함수 사용 방식을 변경 해 보겠다
//    fun combine(payment: Payment): Payment =
//        if(creditCard == payment.creditCard) {
//            Payment(creditCard, amount + payment.amount)
//        } else {
//            // 서로 다른 두 카드의 지급을 하나로 묶는 것은 버그로 간주
//            throw IllegalStateException("Cards Don't match")
//        }
    companion object {
        fun combine(payment1: Payment, payment2: Payment): Payment {
            return if (payment1.creditCard == payment2.creditCard) {
                Payment(payment1.creditCard, payment1.amount + payment2.amount)
            } else {
                throw IllegalStateException("Card doesn't Match !!!")
            }
        }
    }

}


// 클래스 앞에 data 키워드를 추가하면 코틀린이 자동으로 equals, hashCode, toString, copy 메서드를 구현해 줌
// 한 데이터 클래스의 두 인스턴스 객체는 프로퍼티가 모두 동일할 때 만 같은 객체로 받아 줌
data class Purchase(val donut: Donut, val payment: Payment)

data class PurchaseMutliple(val donuts: List<Donut>, val payment: Payment)

// 신용 카드에 따라 지급 그룹화
class PaymentGroup(val creditCard: CreditCard, val amount: Int) {
    fun combine(payment: Payment) =
        if (creditCard == payment.creditCard)
            Payment(creditCard, amount + payment.amount)
        else
            throw IllegalStateException("Cards doesn't match !")

    companion object {
        fun groupByCard(payments: List<Payment>): List<Payment> =
            payments.groupBy { it.creditCard }
                .values
                .map {
                    it.reduce(Payment::combine)  // 함수에 대한 참조를 사용, reduce 는 연산을 인자로 받음
                }
    }
}