package com.study.backendbook.controller.product.service

import com.study.backendbook.controller.product.controller.dto.ProductDto
import com.study.backendbook.controller.product.domain.EntityNotFoundException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@ActiveProfiles("test")
open class ProductServiceTest {
    // 해당 테스트는 통합 테스트 !ㄴ
    @Autowired
    private lateinit var productService: ProductService

    // Test 코드에서 사용한 테스트 데이터가 TestDB 에 쌓이지 않도록 @Transactional 어노테이션을 붙여준다.
    // Transaction 어노테이션은 원래 트랜잭셔널한 처리를 지원하기 위하여 사용되는 어노테이션이다.
    // 테스트 코드에 @Transactional 을 사용하면 자동 Rollback 이 된다. 테스트 코드에서 추가한 데이터가 실제로는 데이터 베이스에 반영되지 않도록 한다.
    // 해당 데이터는 커밋되지 않고 자동으로 롤백이 됨 !
//    @Transactional
    @Test
    @DisplayName("상품을 추가한 후 id 로 조회 하면 해당 상품이 조회 되어야 한다.")
    open fun productAddAndFindByIdTest() {
        val productDto = ProductDto(name = "연필1", price = 300, amount = 20)
        val savedProductDto = productService.createProduct(
            ProductDto.toProductEntity(
                productDto = productDto,
            )
        )

        val productId = savedProductDto.id
        val foundProductDto = productService.findById(id = productId)

        
//      print 문을 이용하여 콘솔로 출력 시 실패하여도 일일히 확인하여야 하는 번거로움이 있다. Assertion 으로 대체해도록 하자
        println(savedProductDto.id == foundProductDto.id)
        println(savedProductDto.name == foundProductDto.name)
        println(savedProductDto.price == foundProductDto.price)
        println(savedProductDto.amount == foundProductDto.amount)

        Assertions.assertTrue { savedProductDto.id == foundProductDto.id }
        Assertions.assertTrue { savedProductDto.amount == foundProductDto.amount }
        Assertions.assertTrue { savedProductDto.name == foundProductDto.name }
        Assertions.assertTrue { savedProductDto.price == foundProductDto.price }
    }

    @Test
    @DisplayName("존재하지 않는 상품 id로 조회를 하면 EntityNotFoundException 이 발생")
    fun findProductNotExistIdTest() {
        val notExistId = -1L

        assertThrows<EntityNotFoundException> {
            productService.findById(id = notExistId)
        }
    }

    // TODO - 수정, 삭제 테스트 코드 구현이 필요 !

    @Test
    @DisplayName("동등성 및 동일성 비교를 테스트 한다.")
    fun testEquality() {
        // Kotlin 에서 == 는 동등성 비교
        // === 는 동일성 비교
        class TestLong(val num: Int)

        val a1 = TestLong(num = 126)
        val a2 = TestLong(num = 126)

        val a3 = TestLong(num = 130)
        val a4 = TestLong(num = 130)

        println(a1.num === a2.num)
        println(a3.num === a4.num)
    }
}
