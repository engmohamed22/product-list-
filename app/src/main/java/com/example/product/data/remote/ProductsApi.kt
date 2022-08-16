package com.example.product.data.remote

import com.example.product.data.remote.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApi {

    @GET("products")
    suspend fun getAllProducts(): Response<ProductsResponse>

}