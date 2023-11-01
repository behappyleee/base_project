package com.sample.study.scope

fun main() {

    scopeFunction();


}

fun scopeFunction() {
    // Kotlin 표준 라이브러리에는 객체 내부에서 코드를 실행 할 수 있는 여러 함수가 제공 된다
    // 그들 중 일부는 람다 표현식이 제공 되고 임시 스코프가 형성 된다.
    // 이 스코프에서는 객체의 이름을 사용하지 않고 객체의 접근이 가능
    // it / this 를 활용
    
    // Scope Function 에는 let / run / with / apply / also 등이 있음
    var per1 = Person("per1", 20, true);
    var per2 = Person("per2", 21, true);
    var per3 = Person("per3", 22, false);
    var per4 = Person("per4", 23, true);
    var per5 = Person("per5", 24, false);

    var perList = arrayListOf(per1, per2, per3, per4, per5);

    perList.let {
        // Scope Function it / this 등으로 객체 내부를 접근을 가능
        // 객체 내부를 그대로 보여 줌
        println(it);
    }

    // Scope Function 은 일반적으로 코드 블록을 실행하는 것과 동일, 단지 표현이 다름
    // Scope Function 에는 let / run / with / apply / also 가 있음
    // 크게 2가지임 Object reference 호출 방식이 it or this 인지 ..
    // with 는 extension function 이 아니고 with 는 객체를 argument 로 받아 사용
    // with 는 이미 생성 된 객체에 일괄적인 작업을 처리할 때 유용

    // with 사용
    // 반환 값이 Lambda result
    var perWith = with(per1) {
        this.age = 27;
        this.isKorean = false;
        // this 를 이용해서 객체 그 자체를 참고하기에 this 키워드를 생략을 가능
        name= "with1";
    }

    perList.forEach {
        it.getDataInObj();
    }

    // apply -> 이름 그대로 객체에 무언가를 적용 (apply) 할 때 쓰면 좋음
    // apply 는 with 와 비슷하지만 extension function 이며 반환 값이 Object reference 이다.
    // 인자는 Lambda function 을 받기 때문에 곧바로 Lambda Function 에 해당 하는 코드 블록을 작성 가능
    // with 는 인자로 context object 를 받지만 apply 는 extension function 이기에 객체를 생성해서
    // 할당하기 전에 사용이 가능, apply 코드 블록이 모두 수행 된 후 인스턴스가 할당 되기에 apply 는 객체 생성 시점에
    // 초기화를 할 때 유용
    var applyPer = applyPerson(
        name = "apply1"
      , age = 28,
    ).apply { var isKorean = true };

    // also -> 이름 그대로 객체에게 명령을 내리기 직전에 추가적인 (also) 작업을 함께 수행 시키고 싶을 떄 사용
    // also 는 extension funciton 이며 반환 값이 Object reference 이다. 인자로 Lambda function 을 받음
    

}

fun applyPerson(name: String, age: Int) {
    var isKorean: Boolean? = null;

}




class Person(var name:String?, var age:Int?
    , var isKorean: Boolean?) {
    fun getDataInObj(){
        println("Name : " + name + " Age : " + age + " isKorean : " + isKorean);
    }
}