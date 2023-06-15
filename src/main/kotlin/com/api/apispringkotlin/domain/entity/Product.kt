package com.api.apispringkotlin.domain.entity

import com.api.apispringkotlin.api.dto.ProductDto
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.util.UUID

@Getter
@Setter
@Table(name = "product")
@Entity(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
class Product() {


    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private lateinit var Id: UUID
    private var name: String? = ""
    private var price: Double = 0.0

    constructor(dto: ProductDto) : this() {
        this.name = dto.name
        this.price = dto.price
    }

}