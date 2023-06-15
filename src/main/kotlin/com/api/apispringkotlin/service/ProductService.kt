package com.api.apispringkotlin.service

import com.api.apispringkotlin.domain.entity.Product
import java.util.UUID

interface ProductService {
    fun getAllProducts(): List<Product>
    fun getProductById(id: UUID): Product
}