package com.example.product.domain.repository

interface ILoginRepository {
    fun loginWithPhoneAndPassword(phoneNumber: String, password: String): Boolean
}