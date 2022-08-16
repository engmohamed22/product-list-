package com.example.product.presentation.fragment.login

import androidx.lifecycle.ViewModel
import com.example.product.domain.usecase.PhoneNumberLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val phoneNumberLoginUseCase: PhoneNumberLoginUseCase
) : ViewModel() {

    fun loginUsernameAndPassword(
        phoneNumber: String,
        password: String
    ) =
        phoneNumberLoginUseCase.execute(phoneNumber, password)

}