package com.api.apispringkotlin.domain.entity

import com.api.apispringkotlin.api.dto.ProductDto
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.util.UUID


@Table(name = "product")
@Entity(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
class Product() {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private lateinit var Id: UUID
    private var name: String = ""
    private var price: Double = 0.0


    fun getId(): UUID {
        return this.Id
    }

    fun setId(id: UUID) {
        this.Id = id
    }

    fun getName(): String {
        return this.name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getPrice(): Double {
        return this.price
    }

    fun setPrice(price: Double) {
        this.price = price
    }

    constructor(dto: ProductDto) : this() {
        this.name = dto.name
        this.price = dto.price
    }

}