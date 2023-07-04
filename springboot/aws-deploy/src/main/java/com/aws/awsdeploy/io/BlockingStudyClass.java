package com.aws.awsdeploy.io;

public class BlockingStudyClass {


    public static void main(String[] args) {
        // I/O 는 입력 스트림과 출력 스트림이 구분 되어 입/출력 별도의 생성이 필요
        // 또한 동기 방식이기에 입력과 출력이 다 될 떄 까지는 스레드가 멈춰있어야 함
        // 이것을 블로킹이라고 함

        // I/O 는 스트림으로 단 방향으로만 가능하지만, NIO 는 Channels 와 Bufferes 를 이용해 양방향으로 가능
        // 또 Selector 가 있음
        
        // 일반적인 NIO 의 I/O 채널에서 시작
        // Java NIO 채널은 몇 가지 차이점을 제외하고 스트림과 유사



    }

}
