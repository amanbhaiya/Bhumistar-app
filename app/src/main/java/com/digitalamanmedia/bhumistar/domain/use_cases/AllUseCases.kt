package com.digitalamanmedia.bhumistar.domain.use_cases

import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.SendOTPUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.userAuthUsecases.*

data class AllUseCases(
    val sendOTPUseCase: SendOTPUseCase,
    val createUserUseCase: CreateUserUseCase,
    val updateUserUseCase: UpdateUserUseCase,
    val loginUserUseCase: LoginUserUseCase,
    val updatePasswordUseCase: UpdatePasswordUseCase,
    val checkNumberUseCase: CheckNumberUseCase
)
