package com.api.apispringkotlin.api.dto

import com.api.apispringkotlin.domain.entity.Product
import java.util.UUID

data class GetProductDto(
    var id: UUID,
    var name: String,
    var price: Double
) {
    constructor(product: Product) : this(product.getId(), product.getName(), product.getPrice()) {
        id = product.getId()
        name = product.getName()
        price = product.getPrice()
    }
}
