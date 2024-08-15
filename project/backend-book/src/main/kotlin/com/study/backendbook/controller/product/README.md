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

## 객체지향 프로그래밍
### 1. 캡슐화 2. 상속 3. 추상화 4. 다형성

### 의존성 주입 DI (Dependency Injection) 의존성 역전 원칙 DIP (Dependency Injection Principle)

#### 의존성 주입 패턴 -> ProductService -> ProductRepository 의존성을 주입, ProductService 가 정상 동작 하기 위하여서는 ProductRepository 가 필요
#### 의존성 역전 원칙 -> 고수준 컴포넌트가 저 수준 컴포넌트에 의존하지 말아야 한다는 의미, 쉽게 이야기하면 추상화에 의존을 하여야 한다.

#### 고수준과 저수준을 나누는 기준은 상대적이다. 비교 대상이 되는 두 컴포넌트가 있을 떄 도메인의 정책에 가까울수록 고수준으로 분류하고 애플리케이션에 외부에 가까울수록 저수준으로 분류
#### 애플리케이션 외부에 가까울수록 저수준으로 분류

#### ProductService (고수준) -> ProductRepository (고수준) <- DatabaseRepository / ListRepository (저수준)
#### 위의 방향처럼 의존성 역전에 의하여 더 이상 고 수준 컴포넌트가 저 수준 컴포넌트에 의존한지 않는다.
#### ProductService 가 추상적인 ProductRepository 에만 의존하도록 바뀜, 결정적으로 저 수준 컴포넌트 였던 두 클래스에서 ProductRepository 방향으로 의존성 방향이 생겼다.

### Refactoring - 동일한 입력에 대해 결과의 변경 없이 코드의 구조가 개선되는 것, 핵심은 결과의 변경이 없어야 한다는 점
### Refactoring - 결과의 변경이 없어야 한다는 점
### 만약 코드를 의도적으로 기존과 다르게 가능하도록 변경한 경우에는 테스트 코드를 새로운 기능에 맞게 변경하여야 함

### 통합 테스트
#### 2개 이상의 클래스 (혹은 컴포넌트) 가 협력하는 테스트

### 단위 테스트
#### 단위 테스트는 다른 클래스를 사용하지 않고 작동하는 테스트 개발 중인 로직만 간결하고 빠르게 테스트 하기 위하여 실행





