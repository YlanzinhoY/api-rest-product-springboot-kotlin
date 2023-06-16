package com.api.apispringkotlin.api.controller

import com.api.apispringkotlin.api.dto.GetProductDto
import com.api.apispringkotlin.api.dto.ProductDto
import com.api.apispringkotlin.domain.entity.Product
import com.api.apispringkotlin.domain.service.ProductServiceImpl
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/product/")
class ProductApi(private val productServiceImpl: ProductServiceImpl) {

   @PostMapping("product")
   fun createProduct(@RequestBody @Valid productDto: ProductDto): ResponseEntity<ProductDto> {
       val product = productServiceImpl.saveProduct(Product(productDto))
       return ResponseEntity.status(HttpStatus.CREATED).body(productDto)
   }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable(value = "id") id: UUID): ResponseEntity<Any> {
        val product: Product = productServiceImpl.getProductById(id)

        if(product != null) {
            val productDto = GetProductDto(product)
            return ResponseEntity.ok().body(productDto)
        }
        return ResponseEntity.notFound().build()
    }

    @GetMapping("/product")
    fun getAllProduct(@PageableDefault(size = 5) pagable: Pageable): Page<Product>  {
        return productServiceImpl.getAllProducts(pagable)
    }

    @PutMapping("/product/{id}")
    @Transactional
    fun putProductById(@PathVariable(value = "id") id: UUID, @RequestBody @Valid productDto: ProductDto): ResponseEntity<Product> {
        val product = productServiceImpl.updateProduct(id,productDto)
        return if (product != null) {
            ResponseEntity.ok(product)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteProductById(@PathVariable(value = "id") id: UUID): ResponseEntity<Any> {
        val product = productServiceImpl.deleteProductById(id)
        return ResponseEntity.ok().build()
    }
}