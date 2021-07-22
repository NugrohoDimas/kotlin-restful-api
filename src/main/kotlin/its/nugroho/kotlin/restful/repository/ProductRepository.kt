package its.nugroho.kotlin.restful.repository

import its.nugroho.kotlin.restful.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String> {
}