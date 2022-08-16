package com.example.product.data.repository

import com.example.product.domain.repository.ILoginRepository


class LoginRepository : ILoginRepository {
    override fun loginWithPhoneAndPassword(phoneNumber: String, password: String): Boolean {
        return if (phoneNumber.isNotEmpty() && phoneNumber.length == 11)
            password.length > 8
        else
            false
    }
}