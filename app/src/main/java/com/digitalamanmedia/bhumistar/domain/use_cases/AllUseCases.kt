package com.digitalamanmedia.bhumistar.domain.use_cases

import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.SendOTPUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.VerifyOTPUseCase

data class AllUseCases(
    val sendOTPUseCase: SendOTPUseCase,
    val verifyOTPUseCase: VerifyOTPUseCase
)
