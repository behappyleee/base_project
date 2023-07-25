package com.sample.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnnotationApplication {

	// TODO
	// 학습 링크
	// https://reflectoring.io/java-annotation-processing/

	// Retention
	// SOURCE - The annotation is used at compile time and discarded at runtime.
	// CLASS - The annotation is stored int the class file at compile time and discarded at run time.
	// RUNTIME - The annotation is retained at runtime.

	// @Retention 어노테이션 부터 학습 필요 !!!
	// 해당 부분 부토 학습 하기 !!!!!!!!! 해당 부분 부터 공부 필요 !!!!!!!!!
	// @Retention
	// @Retention specifies when the annotation is discarded.

	public static void main(String[] args) {
		SpringApplication.run(AnnotationApplication.class, args);
	}

}
