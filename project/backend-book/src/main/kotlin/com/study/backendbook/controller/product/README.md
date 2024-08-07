## 상품 관리 에플리케이션

- 상품을 관리할 수 있는 애플리케이션
- 상품은 상품 번호, 상품 이름, 가격, 재고 수랴 4가지 정보를 가짐

### 애플리케이션을 개발 할 때는 데이터에 어떤 행동을 추가할 것인지를 결정하기 보다는 데이터가 어떤 정보를 가지도록 할 것인지
###  DDD
#### 컴퓨터 과학이 발전함에 따라 많은 개발자가 소프트웨어 설계에 대하여 깊이 고민을 함, 레이어드 아키텍처가 그 결과로 나온 소프트 웨어 설계 방법 중하나

#### 표현 계층 Presentation Layer : Interface 계층 이라고 불리며 클라이언트로부터 들어오는 요청을 받고 응답해주는 역할 ---> Controller 역할
#### 어플리케이션 계층 Application Layer : 표현 계층에서 넘겨 받은 데이터로 새로운 자원을 생성하거나 저장 되어있던 자원을 가져옴 자원은 도메인 객체 조회 된 도메인 객체의 메서드를 실행시킴 ----> Service 역할
#### 도메인 계층 Domain Layer : 도메인의 핵심적인 지식이 있는 계층으로 도메인 객체가 위치함, 도메인 계층은 다른 계층이나 외부 요소에 의존 하지 않도록 만드는 것이 좋음
#### 인프라 스트럭쳐 계층 InfraStructure Layer : 특정 인프라스트럭처에 접근하는 구현 코드들이 위치하는 계층, 리스트에 상품을 저장하는 로직이나 데이터 베이스에 상품을 저장하는 코드 등 포함

### Thread-Safe - 스레드 세이프 하다는 것은 어떤 코드나 라이브러리가 멀티 스레드 환경에서 적절히 동기화를 처리해 정상적인 동작을 보장하는 것을 의미
### 만약 스레드 세이프하지 않다면 레이스 컨디션과 같은 문제가 발생, 데이터가 불일치 할 위험이 있음
### 그럼 항상 스레드 세이프 하도록 구현 하여야하는 가 .. ?! --> 그것은 해당 컬렉션 인스턴스에 동시에 여러개의 스레드가 접근할 수 있는 지에 따라 달라짐
### 동기화라는 것은 결국 Lock 같은 동기화 매커니즘을 사용하여 성능을 희생하게 됨

### Bean Validation 을 통한 유효성 검사

### 예외 처리 전략
#### Checked Exception - try - catch 문이 강제 되는 예외를 의미
#### Unchecked Exception - try - catch 문이 강제되지 않은 예외를 의미

### 애플리케이션의 각 레이어에서 발생하는 예외는 가급적 특정 레이어 내에서 특정 기술에 종속적인 예외를 사용하기 보다는 애플리케이션 내에서 의미 있는 예외를 정의하여 사용하여야 한다.

### 에러 코드가 포함 된 응답 바디

#### https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#oidc-get-id-token-info-sample

### 정의 된 에러 코드 목록

#### https://developers.kakao.com/docs/latest/ko/kakaologin/trouble-shooting#guide

##### 현재 존재하는 Schema 조회 명령어
- Docker my sql 실행 명령어
  - docker run --name some-mysql -p 3307:3306 -e MYSQL_ROOT_PASSWORD= -d mysql:8.0.29 --character-set-server=utf8mb4 --collation-server=utf8mb4_general_ci
- SHOW SCHEMAS;
- SCHEMA 생성
  - CREATE SCHEMA PRODUCT_MANAGEMENT;
- CREATE TABLE products (id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(100) NOT NULL, price INT NOT NULL, amount INT NOT NULL);
- 더미 데이터 삽입
  - INSERT INTO products (name, price, amount) VALUES ('product 1', 100, 10);
  - INSERT INTO products (name, price, amount) VALUES ('product 2', 300, 25);
  - INSERT INTO products (name, price, amount) VALUES ('product 3', 500, 75);


#### Application 과 데이터 베이스 사이의 연결은 커넥션 이라고 표현이 됨
#### 애플리케이션에서는 데이터 베이스와의 연결을 수행하는 커넥션 인스턴스를 생성하고 데이터 베이스에서는 그에 상응하는 인스턴스를 만들어서 대응
#### Connection Pool -> 커넥션 풀은 애플리케이션이 앞으로 사용할 커넥션들을 미리 만들어 두고 애플리케이션에서 커넥션이 필요한 곳에 커넥션을 빌려주었다가 돌려받음
#### Connection Pool 은 spring-starter-jdbc 에서 자동생성, 다만 첫번째 요청이 오기 전까지는 커넥션 풀을 만들지 않음