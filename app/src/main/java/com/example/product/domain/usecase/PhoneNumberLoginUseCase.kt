package com.example.product.domain.usecase

import com.example.product.domain.repository.ILoginRepository
import javax.inject.Inject

class PhoneNumberLoginUseCase @Inject constructor(val repo: ILoginRepository) {
    fun execute(phoneNumber: String, password: String): Boolean {
        return repo.loginWithPhoneAndPassword(phoneNumber, password)
    }
}