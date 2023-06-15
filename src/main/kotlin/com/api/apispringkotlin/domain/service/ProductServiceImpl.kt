package com.api.apispringkotlin.domain.service

import com.api.apispringkotlin.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) {

}