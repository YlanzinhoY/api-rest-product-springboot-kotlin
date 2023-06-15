package com.api.apispringkotlin.domain.service

import com.api.apispringkotlin.domain.entity.Product
import com.api.apispringkotlin.domain.repository.ProductRepository
import com.api.apispringkotlin.exeception.ProductNotFoundException
import com.api.apispringkotlin.service.ProductService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService  {
    override fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    override fun getProductById(id: UUID): Product {
        return productRepository.findById(id).orElseThrow { ProductNotFoundException("Product no found with id: $id") }
    }

    override fun saveProduct(product: Product): Product {
        return productRepository.save(product)
    }

    override fun updateProduct(product: Product): Product {
        return productRepository.save(product)
    }

    override fun deleteProductById(id: UUID) {
        return productRepository.deleteById(id)
    }

}