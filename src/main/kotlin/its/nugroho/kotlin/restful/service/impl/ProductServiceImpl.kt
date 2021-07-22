package its.nugroho.kotlin.restful.service.impl

import its.nugroho.kotlin.restful.entity.Product
import its.nugroho.kotlin.restful.error.NotFoundException
import its.nugroho.kotlin.restful.model.CreateProductRequest
import its.nugroho.kotlin.restful.model.ListProductRequest
import its.nugroho.kotlin.restful.model.ProductResponse
import its.nugroho.kotlin.restful.model.UpdateProductRequest
import its.nugroho.kotlin.restful.repository.ProductRepository
import its.nugroho.kotlin.restful.service.ProductService
import its.nugroho.kotlin.restful.validator.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(val productRepository: ProductRepository, val validatorUtil: ValidationUtil) : ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validatorUtil.validate(createProductRequest)
        val product = Product(
                id = createProductRequest.id,
                name = createProductRequest.name,
                price = createProductRequest.price,
                quantity = createProductRequest.quantity,
                createdAt = Date(),
                updatedAt = null
        )

        productRepository.save(product)
        return convertProductToProduct(product)
    }

    override fun getId(id: String): ProductResponse {
        val product = findProductById(id)
        return convertProductToProduct(product)
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = findProductById(id)

        validatorUtil.validate(updateProductRequest)

        product.apply {
            name = updateProductRequest.name
            price = updateProductRequest.price
            quantity = updateProductRequest.quantity
            updatedAt = Date()
        }

        productRepository.save(product)
        return convertProductToProduct(product)
    }

    override fun delete(id: String) {
        val product = findProductById(id)
        productRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page!!, listProductRequest.size!!))
        val products: List<Product> = page.get().collect(Collectors.toList())
        return products.map {
            convertProductToProduct(it)
        }
    }

    private fun findProductById(id: String): Product {
        val product = productRepository.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        } else {
            return product
        }
    }

    private fun convertProductToProduct(product: Product): ProductResponse {
        return ProductResponse(
                id = product.id,
                name = product.name,
                price = product.price,
                quantity = product.quantity,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt
        )
    }
}