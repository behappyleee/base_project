package com.study.backendbook.my.product.repository

import com.study.backendbook.my.product.domain.EntityNotFoundException
import com.study.backendbook.my.product.domain.Product
import com.study.backendbook.my.product.domain.ProductRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository
import java.util.concurrent.atomic.AtomicLong

// Repository DB 연결이 아닌 임시로 object 에 List 를 선언하여 사용
@Repository
@Profile(value = ["test"])   // Profile 을 지정 시 지정 된 환경에서만 bean 을 생성, Profile 이 Test 일 때만 해당 빈을 주입
open class ListProductRepository: ProductRepository {
    // 인프라 스트럭처 레이어 Infrastructure Layer
    // Kotlin 에 mutableList 는 ThreadSafe 하지 않음 !
    private val products = mutableListOf<Product>()

    private val sequence = AtomicLong(1)

    override fun add(product: Product): Product {
        val saveProduct =
            product.copy(
                id = sequence.getAndAdd(1L),
            )

        products.add(saveProduct)
        return saveProduct
    }

    override fun findAll(): List<Product> = products

    override fun findById(id: Long): Product {
        return products.find { product -> product.id == id }
            ?: throw EntityNotFoundException("찾으시려는 Product 가 존재하지 않습니다.")
    }

    override fun findByNameContaining(name: String) =
        products.filter {
                // 밑에 처럼 바로 name 을 가져와서 비교하는 로직을 짤 수 도 있지만 이런 식으로 하게되면 객체지향적이지 않게 된다
                // 코드가 여로 곳에 중복 될 확룰이 높아진다. 중복이 많아 지면서 절차지향적인 코드가 될 수 있다
                // product -> product.name.contains(name)
                product ->
            product.containName(name = name)
        }

    // updateProduct 는 ThreadSafe 하지 않다. ThreadSafe 하도록 고민이 필요 하다 !
    override fun update(product: Product): Product {
        // 만약 products 리스트에서 index 가 존재하지 않으면 ArrayIndexOutOfBoundsException 에러가 발생한다.
        // 인프라 스트럭쳐 계층 에러가 컨트롤러까지 전파되는 것은 좋지 않다. --> 글로벌 익셉션 처리를 구현하자 !
        val indexOfProduct = products.indexOf(element = product)
        products.set(index = indexOfProduct, product)
        return product
    }

    override fun delete(id: Long) {
        products.removeIf { product: Product -> product.id == id }
    }
}
