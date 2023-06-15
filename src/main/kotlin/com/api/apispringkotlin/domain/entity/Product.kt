package com.api.apispringkotlin.domain.entity

import lombok.Getter
import lombok.Setter
import java.util.UUID

@Getter
@Setter
class Product {

    private var Id: UUID = UUID.randomUUID()
    private var name: String? = null
    private var price: Double = 0.0


}