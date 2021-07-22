package its.nugroho.kotlin.restful.service

import its.nugroho.kotlin.restful.model.CreateProductRequest
import its.nugroho.kotlin.restful.model.ListProductRequest
import its.nugroho.kotlin.restful.model.ProductResponse
import its.nugroho.kotlin.restful.model.UpdateProductRequest

interface ProductService {
    fun create(createProductRequest: CreateProductRequest): ProductResponse
    fun getId(id: String): ProductResponse
    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse
    fun delete(id: String)
    fun list(listProductRequest: ListProductRequest): List<ProductResponse>
}