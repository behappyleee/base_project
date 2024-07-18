package com.sample.study.coroutine.inflearn

class ThreadCoroutineCompare {

    // Process - 컴퓨터에서 실행되고 있는 프로그램
    // Thread - 프로세스보다 작은 개념 프로세스에 소속되어 여러 코드를 동시에 실행할 수 있게 해 줌
    
    // 프로세스가 스레드보다 큰 개념이듯이 스레드가 코루틴보다 큰 개념임
    // 코루틴의 코드가 실행 되려면 스레드가 있어야만 한다
    // 코루틴은 특정 스레드에 종속 되어 있는 개념은 아님
    
    // Process Heap 은 공유 Stack 은 독립적임
    // CPU 에서 Context Switching 이 발생 시 Heap 메모리를 공유하고 Stack 만 교체가 되므로 Process 보다는 Context Switch 비용이 적다

    // 동일 스레드에서 코루틴이 실행이 되면 메모리 전부를 공유하므로 스레드보다 Context Switching Cost 가 낮다.
    // 하나의 스레드에서도 동시성을 확보가 가능하다
    
    // 실제로 2가지 일을 동시에 하는 것 CPU Multi-Core (병렬성)
    
    // 코루틴은 스스로 자리를 양보를 할 수 있다, 스스로 자리를 넘겨주는 걸 비선점형
    // 스레드 처럼 다른 존재가 직접적으로 접근해서 자리를 비켜주는 걸 선점형이라고 함
    // 스레드와 코루틴의 차이


}