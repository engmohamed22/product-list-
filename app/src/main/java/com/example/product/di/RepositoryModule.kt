package com.example.product.di

import com.example.product.data.remote.ProductsApi
import com.example.product.data.repository.LoginRepository
import com.example.product.data.repository.ProductRepository
import com.example.product.domain.repository.ILoginRepository
import com.example.product.domain.repository.IProductsRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesProductsRepository(api: ProductsApi) =
        ProductRepository(api) as IProductsRepository

    @Singleton
    @Provides
    fun providesLoginRepository() =
        LoginRepository() as ILoginRepository

}