package com.book.cleancode.chapter_7;

public class ErrorHandling_Clean {

    // 오류 처리는 프로그램에 반드시 필요한 요소 중 하나이다.
    // 뭔가 잘못 될 가능성은 항상 존재한다. 뭔가 잘못되면 바로 잡을 책임은 항상 프로그래머에게 있다.

    // 오류 처리를 잘 하는 방법
    // 1. 오류 코드보다는 예외를 사용

    public static void main(String[] args) {


    }

}

// 오류를 발견하면 예외를 던지는 코드
// 예외에서 프로그램 안에다 범위를 정아한다는 사실이 매우 흥미롭다.
// try - catch - finally 문에서 try 블록에 들어가는 코드를 실행하면 어느 시점에서든 실행이 중단 된 후
// catch 블록으로 넘어갈 수 있다.
class DeviceController {
    
    // 오류를 발견 시 예외를 던짐
    public void shutDown() {
        try {
            tryShutDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void tryShutDown() throws Exception {
        // Shutdown Error Logic 작성 !

    }
}
