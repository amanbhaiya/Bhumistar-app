package com.digitalamanmedia.bhumistar.domain.use_cases.authentication

import com.digitalamanmedia.bhumistar.domain.repository.AuthenticationRepository
import javax.inject.Inject

class VerifyOTPUseCase  @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
){
    suspend operator fun invoke(otp:String){
        authenticationRepository.verifyOTP(otp = otp)
    }
}