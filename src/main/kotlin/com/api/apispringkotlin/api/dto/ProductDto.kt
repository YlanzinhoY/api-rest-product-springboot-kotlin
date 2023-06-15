package com.api.apispringkotlin.api.dto

import jakarta.validation.constraints.NotBlank

data class ProductDto(
    @NotBlank
    public var name: String? = null,
    @NotBlank
    public var price: Double = 0.0
) {}