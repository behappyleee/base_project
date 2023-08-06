package com.study.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // datasource 설정이 없는 경우 해당 어노테이션 사용하면 정상 기동됨
public class GraphqlApplication {
	// 좋은 REST API 설계를 하기 위하여서는
	// HttpStatus Code 를 보내주어야 한다, 일반적인 API 통신의 경우 주로 JSON 의 형태로 응답을 하게 되는데 @ResponseBody 어노테이션을 사용 후 객체를 반환하게 되면
	// HttpMessageConvert 에 의하여 객체자 JSON 으로 변환이 된다.

	// GraphQL 은 2012 년에 Facebook 에서 Mobile App 을 위하여 개발 되었다.

	// GraphQL is a specification of a query language for APIs.
	// The client or API consumer sends the request in a query language containing
	// the fields it requires and the server returns only the requested fields instead of
	// the complete payload.

	// Instead of having many different endpoints, as we would have with REST. we have a single endpoint
	// to which the consumer sends different queries depending on the data of interest.
	// A sample GraphQL query and its response might look like

	// GraphQL is language agnostic so it defines its own query language and a schema definition language (SDL)

	// A type is the most basic component of a GraphQL schema and represents a kind of object we can fetch
	// from our service.

	// Using GraphQL on Springboot
	// 1. Module 추가 (graphql-java, spring-boot-starter-graphql)

	// 2. Schema 정의

	// 3. we can either take a top-down approach by defining the schema and then creating the POJOs for each type
	// or a bottom-up approach by creating the POJOs first and then create a schema from those POJOs.

	// GraphQL Schema needs to be defined in a file with the extension graphqls and needs to live in the resources folder.

	// Multiple resolver components convert the GraphQL request received from the API consumers and invoke
	// operations to fetch data from applicable data sources. For each type, we define a resolver.


	// TODO
	// GraphQL Schema 부터 학습 하기 !!!
	// TODO
	// Running the Application 부터 학습 팔요 !!!
	// URL : https://reflectoring.io/getting-started-with-graphql/

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

}

// In this sample we send a request for fetching a product with attributes

// Sample Query Request

//{
//	Product
//	{
//	title
//	description
//	category
//	}
//}

// Sample Query Response

//{
//	 "data": {
//		"Product": {
//			"title": "Television",
//			"description": "My 25 inch Television",
//			"category": "Electronic Goods"
//	   	}
//	  }
//}

