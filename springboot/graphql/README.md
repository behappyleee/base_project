# GraphQL

### GraphQL 정의
- GraphQL is a specification of a query language for APIs. The client or API consumer sends the request in a query language containing the fields it requires and the server returns only the requested fields instead of the complete payload.
- Instead of having many different endpoints, as we would have with REST, we have a single endpoint to which the consumer sends different queries depending on the data of interest. A sample GraphQL query and its response might look like this:

#### GraphQL Query
- REQUEST
```
{ 
    Product
 {
    title
    description
    category      
  }
}
```
- RESPONSE 
```
{
    "data": {
        "Product": {
            "title": "Television",
            "description": "My 25 inch Television",
            "category": "Electronic Goods"
        }
    }
}    
```




