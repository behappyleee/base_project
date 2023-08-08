package com.study.graphql;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GraphQLBasic {

    @Test
    public void graphqlQuery() {
        // GraphQL tries to solve the problems of over fetching and under fetching data.
        // With GraphQL we will have a single endpoint on which the consumer can send different queries depending on the data of interest.

        // Shape of the API
        // REST API are based on resources that are identified by URLs and and HTTP method.
        // GET, POST, PUT, DELETE indicating one of the CRUD operations.

        // With REST APIs the GET endpoints are cached in the application layer or by using CDN. with GraphQL we need to cache on
        // the client-side which is surpported by some GraphQL client implementations. Applo CLient and URQL.

        // REST may be a better fit for APIs with very few entities and relationships across entities while GraphQL may be appropriate for
        // relationships across entities while GraphQL may be appropriate for applications with many different domain objects.


    }

}
