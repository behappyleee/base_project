package com.study.backendbook.controller.product.service

import com.study.backendbook.my.product.controller.dto.ProductDto
import com.study.backendbook.my.product.domain.Product
import com.study.backendbook.my.product.domain.ProductRepository
import com.study.backendbook.my.product.service.ProductService
import com.study.backendbook.my.product.service.ValidationService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

// Mocking 은 구현체가 없어도 테스트가 진행 될 수 있도록 도와 줌
@ExtendWith(MockitoExtension::class)    // 자바 에서는 Mocking 라이브러리로 Mockito 를 많이 사용
class ProductServiceUnitTest {
    // 통합 테스트 에서는 @SpringBootTest 어노테이션을 사용하고 Mocking 테스트에서는 @ExtendWith 어노테이션을 사용
    // 만약 아직 ProductRepository 구현체가 없으면 Mock 을 이용하여 ProductRepository 를 사용

    // @SpringBootTest 어노테이션 -> 스프링 애플리케이션이 시작 되면서 필요한 의존성들을 빈으로 등록하고 주입하는 과정을 거침
    // @ExtendWith 어노테이션 -> 스프링 부트 애플리케이션을 실행 시키지 않고도 테스트 코드 실행이 가능 !

    // @Mock 어노테이션 -> 해당 의존성에 Mock 객체를 주입한다는 뜻
    // @InjectedMock 어노테이션 ->  @Mock 으로 주입 해 준 목 객체들을 productSerivice 내에 있는 의존성에 주입을 해준다는 의미
    // 목 객체들을 주입 받는 대상인 productService 는 Mock 객체가 아니라 실제 인스턴스를 생성하여 로직으로 실행이 가능

    @Mock
    private lateinit var productRepository: ProductRepository

    @Mock
    private lateinit var validationService: ValidationService

    @InjectMocks
    private lateinit var productService: ProductService

    @Test
    @DisplayName("상품 추가 후에는 추가 된 상품이 반환 되어야 한다.")
    fun productAddTest() {
        val productDto = ProductDto(name = "연필 테스트", price = 3000, amount = 10)
        val productId = 1L

        val product = ProductDto.toProductEntity(productDto = productDto)
        product.id = productId

        // TODO - any() 는 Null 인데 어떻게 해결하면 좋을 지 고민이 필요 ... !!
        `when`(productRepository.add(ArgumentMatchers.any(Product::class.java))).thenReturn(product)

        val savedProductDto = productService.createProduct(product)

        Assertions.assertTrue { savedProductDto.id == productId }
    }
}
