package com.aws.awsdeploy.io;

import java.util.function.Consumer;

public class NIOStudyClass {

    // Synchronous (동기) / Asynchronous (비동기) / Blocking / NON-Blocking 개념 숙지

    static class WorkerA {
        Consumer<String> workForA = (message) -> {
            for(int index=0; index<5; index++) {
                for(int subIndex=0; subIndex<Integer.MAX_VALUE; subIndex++) {
                }
                System.out.println("A: Doing Something !");
            }
            System.out.println("A : " + message);   // message 가 accept 파라미터로 들어감
        };

        Consumer<String> workForB = (message) -> {
            for(int index=0; index<5; index++) {
                for(int subIndex=0; subIndex<5; subIndex++) {
                }
                System.out.println("B : Doing Something !");
            }
            System.out.println("B : " + message);   // message 가 accept 파라미터로 들어감
        };

        void doWork() {
            workForA.accept("I am worker A, And I am done.");
        }

        Consumer<String> giveWorkToB() {
            return workForB;
        }

    }

    static class WorkerB {

        void takeMyWorkAndDoMyWork(Consumer<String> myWork) {
            myWork.accept("I am Worker B, And I am Done.");
        }
    }


    public static void main(String[] args) {
        // Blocking 방식 - 어떤 일을 누군가에게 요청을 하고 결과 혹은 응답이 오기를 계속 기다리는 것
        // 전통적인 서버 요청 방식이나 일반적인 함수 호출
        
        // Non-Blocking 방식 - 어떤 일을 누군가에게 요청한 후 결과를 기다리지 않고 자신의 일을 계속 수행

        // 동기 (Synchronous) / 비동기 (Asynchronous) 처리
        // 동기 방식과 비동기 방식의 차이는 Thread 로 인해 발생 하는 동시 실행에 유무 ..
        // 특정 일 (work) A 와 B, 동시에 실행 하더라도 돌 사이에 어떤 인과 관계 떄문에 항상 A가
        // 종료 된 뒤에야 B 가 종료 될 수 있다면 이는 동기 처리임.
        // ex) B 의 업무는 A 가 잘하고 있는 지 감시 하는 것임, 그렇다면  가 일을 마친 후에야 B 에 일이 종료

        // 해당 아래 케이스는 예외 케이스, 전달한 일은 논블로킹으로 처리되지만, 전달한 일이 끝났는 지 확인 후 자신의 업무를
        // 진행 하므로 동기처리가 됨
        WorkerA a = new WorkerA();
        WorkerB b = new WorkerB();

        b.takeMyWorkAndDoMyWork(a.giveWorkToB());
        a.doWork();


    }

}
