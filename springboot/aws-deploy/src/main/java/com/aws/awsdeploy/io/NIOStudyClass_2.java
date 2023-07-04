package com.aws.awsdeploy.io;

import org.apache.tomcat.util.bcel.Const;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class NIOStudyClass_2 {

    // TODO
    // https://junhyunny.github.io/information/java/asynchronous-and-non-blocking-process/
    // 해당 블로그 글 Study 하기 !!!

    static class WorkerA {
        Consumer<String> ownJob = (message) -> {
            for(int index=0; index<3; index++) {
                for(int subIndex=0; subIndex<300000; subIndex++) {

                }
                System.out.println("A : Doing Something !");
            }
            System.out.println("A : " + message);
        };

        Consumer<String> workForB = (message) -> {
            for(int index=0; index<3; index++) {
                for(int subIndex=0; subIndex<30000; subIndex++) {
                }
                System.out.println("B : Doing Something !");
            }
            System.out.println("B : " + message);
        };

        void doMyWork() {
            ownJob.accept("I am Worker A, and I done.");
        }

        public Consumer<String> getWorkForB() {
            return workForB;
        }

        void isWorkForBFinished(CompletableFuture<Void> joinPoint) {
            while(!joinPoint.isDone()) {
                try {
                    Thread.sleep(2);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A : Worker B is still working. Continue check what B is finished.");
            }
            System.out.println("A : Workier B is done, I am gonna doing my work.");
        }
    }

    static class WorkerB {

        CompletableFuture<Void> doMyWork(Consumer<String> myWork) {
            return CompletableFuture.runAsync(()-> myWork.accept("I am worker B, And I am done"));
        }
    }


    public static void main(String[] args) {
        // 1. WorkerA 는 WorkerB 에게 업무를 전달
        // 2. WorkerB 는 즉각 응답 후 자신의 일을 수행 (CompletableFuture.runAsync() 메서드를 통해
        // 새로운 스레드가 WorkerB 의 일을 수행

        // 3. WorkerA 는 WorkerB 의 일이 끝났는 지 지속적으로 확인
        // 4. WorkerB 의 일이 끝나지 않았다면 일정 시간 대기 후 다시 확인
        // 5. WorkerB 의 일이 끝났다면 자신의 남은 업무를 수행

        WorkerA a = new WorkerA();
        WorkerB b = new WorkerB();

        Consumer<String> workForB = a.getWorkForB();
        CompletableFuture<Void> joinPoint = b.doMyWork(workForB);

        a.isWorkForBFinished(joinPoint);
        a.doMyWork();

    }

}
