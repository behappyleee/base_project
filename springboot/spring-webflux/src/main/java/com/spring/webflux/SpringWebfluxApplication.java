package com.spring.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories	// JPA 중 MongoDB Exclude Bean 사용할 수 있도록 설정
public class SpringWebfluxApplication {

	// TODO
	// Program 실행 시 ERROR 발생 함 !!!
	// 프로그램 왜 돌아가지 않는 지 확인 필요 !!!!
	// https://reflectoring.io/getting-started-with-spring-webflux/

	// TODO
	// How to Take Spring WebClient into Production 여기서 부터 공부 하기 !!!
	// https://reflectoring.io/spring-webclient/

	/**
	 *	Web Layer - We have covered the middleware layers to store and retrieve data.
	 *				just forcus on the web layer. Spring WebFlux supports two programming models
	 *
	 *	- Annotation-based Reactive Components
	 *	- Functional Routing and Handling
	 *
	 * **/



	/**
	 * 	The whole purpose of Reactive Streams was to intoduce a standard for asynchronous stream processing of data with non-blocking
	 * 	back pressure. Hence, Java 9 introduced the Reactive Streams API. It is implemented based upon the Publisher-Subscriber Model or Producer-Consumer
	 *	Model and primarily defined four interfaces.
	 *
	 *	Publisher : It is responsible for preparing and trasnferring data to subscribers as individual messages. A Publisher can serve multiple
	 *				subscribers but it has only one mothod, subscribe().
	 *
	 *  Subscriber : A Subscriber is responsible for receving messages from a Publisher and processing those messages. It acts as a termninal
	 *				 opertaion in the Streams API. It has four methods to deal with the events received.
	 *
	 *	Subscription : It represents a relationship between the subscriber and publisher. It can be used only once by a single Subscriber. It has
	 *				   methods that allow requesting for data and cancel the demand.
	 *
	 *	Processor : It represents a processing stage that consists of both Publisher and Subscriber.
	 *
	 * */

	/**
	 * 	Spring introduced a Multi-event Loop model to enable a reactive stack known as WebFlux. It is a fully non-blocking
	 *	and annotation-based web framework built on Project Reactor which allows building reactive web application on the HTTP Layer.
	 *
	 *	Mono : A Publisher that emits 0 or 1 element.
	 *
	 *  Flux : A Publisher that emits 0 to N elements which can keepy emitting elements forever.
	 *  	   It returns a sequence of elements and sends a notification when it has completed returning all its elements.
	 *
	 * */

	/**
	 * 	 If we want to process Big Data, However, we need to do this with immense speed and agilit. Thats' when
	 * 	 the software developers realized that they would need some kind of multi-thread environment that handles
	 *	 asynchronous and non-blocking calls to make the best use of processing resources.
	 *
	 * */
	/**
	 * 	A stream is a sequence of data that is transferred from one system to another. It traditionally operates in a blocking
	 *  sequential and FIFO (First In First Out) Pattern.
	 *
	 *	This blocking methodology of data streaming often prohibits a system to process real-time data while streaming.
	 *	A bunch of prominent developers realized that they would need an approach to build a reactive systems architecture that would
	 *	ease the processing of data while streaming. Hence, they signed a manifesto, populary known as the Reactive Manifesto.
	 *
	 * **/
	/**
	 * 	Reactive System must be an asynchronous software that deals with producers who have the single responsibility to send message
	 *	to consumers. They introduced the following features to keep in mind.
	 *
	 * **/

	/**
	 *  Spring Webflux 는 Application 을 더 빠르게 만들어 주지는 못 하지만 가장 큰 이점은
	 *  서버 스펙이 적은 서버에게도 안정성을 준다.
	 *  Application 은 무수히 많은 요청들을 굉장히 적은 시간안에 처리하도록 해준다.
	 *
	 *
	 *
	 * */
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
	 *	Spring Webflux 는 내부적으로 RxJava 와 RxNetty 를 포함하고 있다.
	 *
	 * */
	/**
	 * 	Publisher : Data 를 준비하고 가공하며 Subsscriber 에게 제공해주는 책임이 있다.
	 *			    오직 subscribe() 메서드 하나만 있다
	 *
	 *	Subscriber : A subscriber 는 메세지를 Publisher 로 부터 받는 책임이 있다.
	 *				 Subscriber 는 Terminal 처럼 Stream API 에서 작동한다.
	 * */
	/**
	 *  Webflux 는 Multi-Event-Loop Model 이며 Reactive Stack 은 Webflux 로 알려져 있다.
	 *  이것은 전체적으로 Non-blocking 이며 Annotation 기반으로 HTTP Layer 에서 Building 한다.
	 *	
	 *	Maven Repository 에서 webflux 검색 후 build.gradle 에 넣어 줌
	 *  https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-webflux
	 * 	implementation group: 'org.springframework.boot', name: 'spring-boot-starter-webflux'	
	 *
	 * */
	/**
	 * 	WebLayer - Spring Webflux supports two programming models.
	 * 	1. Annotation - based Reactive components
	 * 	2. Functional Routing and Handling
	 *
	 * */
	/**	 구현 시 가장 중요한 것은 Never Use Blocking Method 를 사용 하는 것이다. 그러면 Reactive Programming 에 장점을
	 * 	 잃어버리는 것이다.
	 *
	 */

	/**
	 *  Webflux 구현 순서
	 *  1. Handler 구현
	 *  2. Router 구현
	 * */

	// TODO
	// https://reflectoring.io/getting-started-with-spring-webflux/
	// Next, we will define the router function. Router functions 부터 학습 필요 !!!!

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxApplication.class, args);
	}

}
