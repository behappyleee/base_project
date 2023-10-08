### Query Method 기능
* #### 메서드 이름으로 쿼리를 생성
* #### 메서드 이름으로 JPA NamedQuery 호출
  * JPA NamedQuery 는 말 그대로 쿼리에 이름을 부여하여 사용하는 방법, 어노테이션이나 XML 에 쿼리를 정의가 가능
* #### @Query 어노테이션을 사용해서 리퍼지토리 인터페이스에 쿼리를 직접 정의
    
- https://docs.spring.io/spring-data/jpa/docs/3.1.0/reference/html/#jpa.query-methods.named-queries ==> jpa method 확인
- Method 이름으로 쿼리 생성 방법 물론 정해진 규칙에 의하여 메서드 이름을 지어야 함<br>
``ex) findByEmailAndName(String, email, String name) ==> SELECT M FROM Member M WHERE M.email=?1 and M.name=?2``

