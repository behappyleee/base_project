package com.test.springwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebfluxApplication {

    // TODO
    // Intro to Java 9 Reactive Streams API 부터 학습 필요 !!!
    // https://reflectoring.io/getting-started-with-spring-webflux/

    /***
     *  Responsive : Reactive Systems must be fast and responsive so that they can provide consistent high quantity
     *               of service.
     *
     *  Resilient : Reactive Systems should be designed to anticopate system failure. Thus, they should be responsive
     *              through replication and isolation.
     *
     *  Elastic : Reactive Systems must be adaptive to shard or replicate components based upon their requirement. They should
     *            use predictive scaling to anticipate sudden ups and down in their infrastructure.
     *
     *  Message-driven : Since all the components in a reactive system are supposed to be loosely coupled, they must communicate
     *                   across their boundaries by asynchronously exchanging messages.
     * */

    /**
     *  Blocking Request : In a conventional MVC application, whenever a request reaches the server, a servlet thread is
     *                     being created and delegated to worker threads to perform various operations like I/O
     *                     database processing, etc. While the worker threads are busy completing their processes, the servlet threads
     *                     enter a waiting state due to which the calls remain blocked. This is blocking or synchronous request processing.
     *
     *  Non Blocking Request : In a non-blocking system, all the incoming requests are accompanied by an event handler
     *                         and a callback. The request thread delegates the incoming request to a thread pool that
     *                         manages a pretty small number of threads. Then the thread pool delegates the request to
     *                         its handler function and gets availiable to process the next incoming requests from the request thread.
     *                         When the handler function completes its process, one of the threads from the pool fetches the response and passes it to the callback function. Thus the threads in a non-blocking system never go into the waiting state. This increases the productivity and the performance of the application.
     *                         A single request is potentially processed by multiple threads!
     */

    /***
     *
     *  Back Pressure : Working with reactive code, we often across the term 'back pressure'. It is an analogy derived from fluid
     *                  dynamics which literally means the resistence or force that opposes the desired flow of data.
     * */

    /**
     *
     *  Buffer - can easily buffer the deficit data and process it later when the server has capacity. But with
     *           a huge load of dta coming in, this buffer might increase and the server would soon run out of memory.
     *
     *  Drop - Dropping, not processing eventsm should be the last option. Usually we can use the concept of data sampling
     *         combined with buffering to achieve less data loss.
     *
     *  Control - The concept of controlling the producer that sends the data is by far the best option. Reactive Streams provides
     *            various options in both push and pull-based streams to control the data that is being produced and sent to the consumer
     * **/

    /**
     *  대부분 전통적인 Application 들은 Blocking Call 을 사용 하였다 (동기 적인 Call).
     *  이 말은 특정 Resource 에 접근하고 싶을 시에 대부분 Thread 들은 사용 중 이였다.
     *  그러면 Application 들은 새로운 Thread 를 하나 생성 하거나 Thread 가 작업을 마칠 때 까지 기다렸다.
     *
     *  만약 Big 데이터를 저리하고 싶을 시 빠른 처리가 필요하였고 Software Developer 들은 Multi Thread 들이
     *  필요하단 것을 꺠달았다. (Asynchronous 와 Non-Blocking Call) 이 최선의 선택이였다.
     *
     *
     * */

    /**
     *  Stream 에 대한 이해가 필요하다. Stream 은 한 시스템에서 다른 시스템으로 연속적으로 데이터를 보내주는 것이다.
     *  이것은 전통적으로 FIFO 방식으로 작동한다.
     *
     *  Reactive System 은 반드시 Asynchronous 여야하며 Producer (Consumer 에게 메세지를 보내는 단 하나의 책임만 존재하는)
     *  들을 다루어야 한다.
     *
     *  Reactive Programming 은 Non-blocking, Asynchronous 를 도와주는 패러다임이다.
     *
     *  Spring Webflux 는 내부적으로 RxJava 와 RxNetty 를 포함하고 있다.
     *
     * */



    // Spring Webflux

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxApplication.class, args);
    }

}
