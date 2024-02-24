package com.example.kotlin_book.chapter_1

import java.lang.IllegalStateException

class DonutExample {

    // 안전하지 않은 프로그램을 더 안전하게 바꾸는 방법 신용 카드로 도넛을 구매하는 간단한 예제
    // 해당 방식은 좋지 않음, 이런 종류의 테스트 코드는 테스트 하기가 매우 어려움,
    // 테스트를 하려면 은행에 연결해 일종의 목 계정으로 거래를 등록하는 과정이 필요

    // 부수 효과가 없는 순수 함수를 합성하면 테스트 하기 쉬운 더 안전한 프로그램을 작성이 가능
    // groupBy, map, reduce 메서드의 인자로 전달 된 것이 바로 함수 값임
    // 가장 중요한 개념은 추상화임,

//    fun buyDonut(creditCard: CreditCard) {
//        val donut = Donut()
//        creditCard.charge(Donut.price)
//        return donut
//    }
    
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