package com.digitalamanmedia.bhumistar.domain.use_cases.authentication

import com.digitalamanmedia.bhumistar.domain.repository.AuthenticationRepository
import javax.inject.Inject

class SendOTPUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
){
    suspend operator fun invoke(number:String){
        authenticationRepository.sendOTP(number = number)
    }
}