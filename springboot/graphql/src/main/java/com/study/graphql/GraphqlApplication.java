package com.study.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlApplication {

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

	// TODO
	// GraphQL Schema 부터 학습 하기 !!!
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

