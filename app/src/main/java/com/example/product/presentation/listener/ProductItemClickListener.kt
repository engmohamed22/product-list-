package com.example.product.presentation.listener

import com.example.product.domain.model.ProductModel

interface ProductItemClickListener {
    fun onProductItemClicked(selectedProduct: ProductModel)
}