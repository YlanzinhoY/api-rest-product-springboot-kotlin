package com.api.apispringkotlin.domain.repository

import com.api.apispringkotlin.domain.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProductRepository : JpaRepository<Product, UUID> {}