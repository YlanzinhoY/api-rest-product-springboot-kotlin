package com.api.apispringkotlin.domain.service

import com.api.apispringkotlin.api.dto.ProductDto
import com.api.apispringkotlin.domain.entity.Product
import com.api.apispringkotlin.domain.repository.ProductRepository
import com.api.apispringkotlin.exeception.ProductNotFoundException
import com.api.apispringkotlin.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService  {
    override fun getAllProducts(pageable: Pageable): Page<Product> {
        return productRepository.findAll(pageable)
    }

    override fun getProductById(id: UUID): Product {
        return productRepository.findById(id).orElseThrow { ProductNotFoundException("Product no found with id: $id") }
    }

    override fun saveProduct(product: Product): Product {
        return productRepository.save(product)
    }

    override fun updateProduct(id: UUID,productDto: ProductDto): Product{
        val existingProduct = productRepository.findById(id).orElseThrow{ ProductNotFoundException("Product not found with id: $id") }

        existingProduct.setName(productDto.name)
        existingProduct.setPrice(productDto.price)

        return productRepository.save(existingProduct)
    }

    override fun deleteProductById(id: UUID) {
        return productRepository.deleteById(id)
    }

}