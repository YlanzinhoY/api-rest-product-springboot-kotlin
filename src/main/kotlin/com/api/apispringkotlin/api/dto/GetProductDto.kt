package com.api.apispringkotlin.api.dto

import com.api.apispringkotlin.domain.entity.Product
import java.util.UUID

data class GetProductDto(
    var id: UUID,
    var name: String,
    var price: Double
) {

}
