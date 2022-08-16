package com.example.product.data.remote.model

import com.example.product.data.remote.model.Product

data class ProductsResponse(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)