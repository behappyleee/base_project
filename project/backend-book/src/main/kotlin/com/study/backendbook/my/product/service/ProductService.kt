package com.study.backendbook.my.product.service

import com.study.backendbook.my.product.domain.Product
import com.study.backendbook.my.product.domain.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val validationService: ValidationService,
//    ProductRepository 인터페이스로 두 구현체인 Repository 를 추상화를 하여 ProductService 가 구체적인 클래스에 의존할 필요가 없어졌다.
//    private val dataBaseProductRepository: DatabaseProductRepository,
//    private val listProductRepository: ListProductRepository,
    // ProductService 를 수정하여 ProductRepository 라는 인터페이스에 의존하도록 변경하였고, 구체적인 의존체가 아닌 추상적인 존재에 의존하도록 함으로써 애플리케이션의 동작을
    // 코드 없이 변경, 실행 시점에 결정할 수 있도록 하였다.
    private val productRepository: ProductRepository,   // ProductRepository 인터페이스를 상속받은 Bean 은 2개의 bean 이므로 bean 이름을 명시해주어야 한다.
) {
    // 어플리케이션 계층 Service
    fun createProduct(product: Product): Product {
        // @Validate 어노테이션은 해당 클래스에 있는 Valid 부은 메서드 매개변수를 검증하겠다는 의미이다!
        validationService.checkValid(validationTarget = product)

        // Product 유효성 검사
        // 1. 상품 번호는 1부터 시작하여 상품이 추가 될 때 마다 1씩 증가, 동일한 상품 번호를 가진 상품은 존재 안함
        // 2. 상품 이름은 1 글자 ~ 100 글자 이하의 문자열 동일한 상품
        // 3. 가격은 0 원 이상 1,0000,000 이하의 값을 가질 수 있다.
        // 4. 재고 수량은 0개 이상 9,999 개 이하의 값을 가질 수 있다.

        // 하지만 Product 유효성 검사를 Service 로직에서 하게되다 보면 몇가지 문제 점이 있다.

        // 1. 도메인 지식이 외부로 새어나가게 된다.
        // 2. 애플리케이션 서비스 코드의 흐름을 확인하기 어렵다.
        // 3. null 을 반환한다 -> 예외를 던지지 않고 null 같은 불필요한 값을 반환하는 코드를 작성하는 것이다 ! -> null 을 반환하는 코드는 메서드를 호출하는 쪽에서
        // 예외적인 상황을 마치 정상적인 상황인 것처럼 반환값을 준다. 예외적인 상황에서 null 같은 불필요한 값을 반환하지 않고 예외를 던진다.
        if (product.name.length > 100 && product.name.length < 1) {
            // 도메인 객체를 비롯한 모든 인스턴스는 생성자를 통하여 생성이 되므로
            // 생성자를 통해 인스턴스를 초기화 할 때 유효성 검사가 이루어 지지 않으면 해당 인스턴스가 생성이 되더라도 인스턴스가 가지고 있는 필드에 잘못 된 값을 들어가게 된다.
            return Product(
                id = 0,
                name = "",
                price = 0,
                amount = 0,
            )
        }

        // ListRepository 가 아닌 Database Repository 를 사용하도록 변경
        return productRepository.add(product = product)
//        return dataBaseProductRepository.add(product = product)
//        return  listProductRepository.add(product = product)
    }

    fun getProducts(): List<Product> {
        // Product Repository 로 변경 !
        return productRepository.findAll()
//        return dataBaseProductRepository.getProducts()
//        return listProductRepository.findAll()
    }

    fun findById(id: Long): Product {
        // Database Repository 로 변경 !
        return productRepository.findById(id = id)
//        return dataBaseProductRepository.findById(product = product)
        // return listProductRepository.findById(id = id)
    }

    fun findByNameContaining(name: String): List<Product> {
        // DatabaseRepository 로 변경
        return productRepository.findByNameContaining(name = name)
//        return dataBaseProductRepository.findByNameContaining(product = product)
//        return listProductRepository.findByContainsName(name = name)
    }

    fun updateProduct(product: Product): Product {
        // DatabaseRepository 로 변경
        return productRepository.update(product = product)
//        return dataBaseProductRepository.update(product = product)
//        return listProductRepository.updateProduct(product = product)
    }
}
