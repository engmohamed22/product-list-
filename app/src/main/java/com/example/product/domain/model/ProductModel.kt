package com.example.product.domain.model

data class ProductModel(
    val productId: Int,
    val productTitle: String,
    val productDescription: String,
    val productPrice: String,
    val productImages: List<String>
)
