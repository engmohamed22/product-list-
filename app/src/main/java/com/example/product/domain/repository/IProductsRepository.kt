package com.example.product.domain.repository

import com.example.product.core.wrapper.ResultWrapper
import com.example.product.domain.model.ProductModel
import kotlinx.coroutines.flow.Flow

interface IProductsRepository {
    fun getAllProducts(): Flow<ResultWrapper<List<ProductModel>>>
}