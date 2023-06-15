package com.api.apispringkotlin.api.controller

import com.api.apispringkotlin.api.dto.GetProductDto
import com.api.apispringkotlin.api.dto.ProductDto
import com.api.apispringkotlin.domain.entity.Product
import com.api.apispringkotlin.domain.repository.ProductRepository
import com.api.apispringkotlin.domain.service.ProductServiceImpl
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Objects
import java.util.Optional
import java.util.UUID

@RestController
@RequestMapping("/api/product/")
class ProductApi(private val productRepository: ProductRepository, private val productServiceImpl: ProductServiceImpl) {

   @PostMapping("product")
   fun createProduct(@RequestBody @Valid productDto: ProductDto): ResponseEntity<ProductDto> {
       val product = productRepository.save(Product(productDto))
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
}