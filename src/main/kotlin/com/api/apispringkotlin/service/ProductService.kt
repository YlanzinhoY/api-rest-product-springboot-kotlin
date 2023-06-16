package com.api.apispringkotlin.service

import com.api.apispringkotlin.api.dto.ProductDto
import com.api.apispringkotlin.domain.entity.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface ProductService {
    fun getAllProducts(pageable: Pageable): Page<Product>
    fun getProductById(id: UUID): Product
    fun saveProduct(product: Product): Product
    fun updateProduct(id: UUID, productDto: ProductDto): Product
    fun deleteProductById(id: UUID)
}