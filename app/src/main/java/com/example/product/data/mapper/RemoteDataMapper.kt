package com.example.product.data.mapper

import com.example.product.data.remote.model.Product
import com.example.product.domain.model.ProductModel


fun Product.toDomainLayer() =
    ProductModel(
        productId = this.id,
        productTitle = this.title,
        productDescription = this.description,
        productImages = this.images,
        productPrice = "${this.price} EG"
    )