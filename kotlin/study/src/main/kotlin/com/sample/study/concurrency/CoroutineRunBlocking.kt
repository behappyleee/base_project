package com.sample.study.concurrency

class CoroutineRunBlocking {

}

fun main() {

    // runBlocking
    // launch() 와 async() 빌더의 경우 Thread 호출을 blocking 시키지 않지만 백 그라운드 스레드 풀을 통하여 작업을 실행한다.
    // 메인 스레드가 하는 일이 없었기 때문에 sleep 을 통해 백그라운드 스레드의 작업을 기다리게 만듦

    // runblocking() 빌더는 현재 스레드에서 실행되는 코루틴을 만들고 코루틴이 완료될 때까지 현재 스레드의 실행을 블럭시킨다.
    // 코투틴이 종료되면 일시 중단 람다의 결과가 호출의 결과값이 된다.


}