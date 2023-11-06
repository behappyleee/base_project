package com.sample.study.basic

fun main() {

    var per1 = PersonScope("test1", 21);

    // Kotlin 표준 라이브러리에서는 객체 내부에서 코드를 실행할 수 있는
    // 여러 함수가 제공 된다. 그들 중 일부는 람다 표현식이 제공이 되고 임시 스코푸가 형성이 됨
    // 이 스코프에서는 객체의 이름을 사용하지 않고 객체에 접근이 가능
    // let / also
    per1.let {
        // it 으로 접근이 가능
        println(it.age)
        println(it.name)
        it.testFun()
    }

    // Object Reference 호출 방식이 it 이냐 this 냐
    // 반환 값이 Lambda Result 냐 Object Reference 냐

    // 특이하게 with 가 남는데 with 는 다른 Scope Function 들 과 다르게 Extension Function 으로 정의되어 있다.
    // 대신 argument 로 Context Object 를 받는다.

    per1.run {
        // let 과 다르게 run 은 this 또는 그냥 접근이 가능
        println(this.name)
        println(this.age)
        println(name)
        testFun()
    }

    // 어떤 Scope Function 을 사용하여야 하는 지 감은 잘 오지는 않지만 사실 큰 차이는 없고
    // 적절한 Scope Function 이라고 생각 되는 걸 골라 사용하면 된다.

    // with
    // with 는 extension function 이 아님
    // 객체 할당 이후 이름 그대로 객체에게 다양한 작업들을 함께 (with) 할 떄 쓰면 좋다.
    // with 는 객체를 argument 로 받아서 사용을 함
    with(per1) {
        // with 는 이미 생성 된 객체에 일괄적인 작업을 처리 시 매우 유용, 실제로 공식 가이드에서
        // with 를 사용하는 상황에 대해 Grouping Function calls on an object
        this.name = "testwith";
        age = 23
    }

    // apply (extension function -> 반환 값 Object reference)
    // 이름 그대로 객체에 무언가를 적용 (apply) 할 때 쓰면 좋다.
    // with 는 인자로 context object 를 받지만 apply 는 extension function 이기 때문에 객체를 생성해서
    // 할당 하기 전에 사용이 가능 (apply 코드 블록이 모두 수행 된 후 인스턴스가 할당이 되기에 apply 는 객체 생성 시점에
    // 초기화를 할 떄 유용함
    val per2 = PersonScope("test3", 24).apply {
        name = "test4"
    }

    // also (also 는 extension function 이며 반환 값이 Object reference 이다)
    // 인자로 Lambda Function 을 받기 때문에 곧바로 Lambda Function 에 해당 하는 코드 블록 작성이 가능
    // 이름 그대로 명령을 내리기 직전에 추가 적인 작업을 함께 수행시키고 싶을 때 쓰면 좋음
    val per3 = PersonScope("test4", 25).also {
    }

    val peopleList = listOf(
              PersonScope("test5", 25)
            , PersonScope("test6", 26)
            , PersonScope("test7", 27)
            , PersonScope("test8",28)
            , PersonScope("test9", 29));

   val firstPersonNameLength = peopleList.first().run { name.length }

   val firstPersonAge = peopleList.first().let {
       pe -> pe.age + 3
   }

   firstPersonAge.let {
       print(it)
   }



}

class PersonScope(var name: String, var age: Int) {
    fun testFun(): String {
        return "This is Test Function !!";
    }
};