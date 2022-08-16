package com.example.product.domain.usecase

import com.example.product.core.wrapper.ResultWrapper
import com.example.product.domain.model.ProductModel
import com.example.product.domain.repository.IProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(val repo: IProductsRepository) {
    fun execute(): Flow<ResultWrapper<List<ProductModel>>> {
        return repo.getAllProducts()
    }
}