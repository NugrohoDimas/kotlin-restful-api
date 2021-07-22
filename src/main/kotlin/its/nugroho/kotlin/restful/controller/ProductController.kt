package its.nugroho.kotlin.restful.controller

import its.nugroho.kotlin.restful.model.*
import its.nugroho.kotlin.restful.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
            value = ["/api/products"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @GetMapping(
            value = ["/api/products/{id}"],
            produces = ["application/json"]
    )
    fun getProduct(@PathVariable(value = "id") id: String): WebResponse<ProductResponse> {
        val productResponse = productService.getId(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @PutMapping(
            value = ["/api/products/{idProduct}"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun updateProduct(@PathVariable(value = "idProduct") id: String, @RequestBody updateProductRequest: UpdateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.update(id, updateProductRequest)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @DeleteMapping(
            value = ["/api/products/{idProduct}"],
            produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable(value = "idProduct") id: String): WebResponse<String> {
        productService.delete(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = id
        )
    }

    @GetMapping(
            value = ["/api/products"],
            produces = ["application/json"]
    )
    fun listProduct(@RequestParam(value = "size", defaultValue = "10") size: Int,
                    @RequestParam(value = "page", defaultValue = "0") page: Int): WebResponse<List<ProductResponse>> {
        val request = ListProductRequest(size, page)
        val responses = productService.list(request)
        return WebResponse(
                code = 200,
                status = "OK",
                data = responses
        )
    }
}