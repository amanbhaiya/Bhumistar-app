package com.digitalamanmedia.bhumistar.domain.use_cases

import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.SendOTPUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.userAuthUsecases.*
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.vendorAuthUseCases.CreateVendorUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.vendorAuthUseCases.LoginVendorUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.vendorAuthUseCases.VendorNumberCheckUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.vendorAuthUseCases.VendorPasswordUpdateUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.on_boarding.OnBoardingUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.user_data.ReadUserDataUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.user_data.SaveUserDataUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.user_data.UserVerificationAlreadyLoginUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.vendor_data.ReadVendorDataUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.vendor_data.SaveVendorDataUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.vendor_data.VendorVerificationAlreadyLoginUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.property.*

data class AllUseCases(
    val sendOTPUseCase: SendOTPUseCase,
    val createUserUseCase: CreateUserUseCase,
    val updateUserUseCase: UpdateUserUseCase,
    val loginUserUseCase: LoginUserUseCase,
    val updatePasswordUseCase: UpdatePasswordUseCase,
    val checkEmailUseCase: CheckEmailUseCase,
    val readUserDataUseCase: ReadUserDataUseCase,
    val saveUserDataUseCase: SaveUserDataUseCase,
    val verificationAlreadyLoginUseCase: UserVerificationAlreadyLoginUseCase,
    val onBoardingUseCase: OnBoardingUseCase,
    val createVendorUseCase: CreateVendorUseCase,
    val loginVendorUseCase: LoginVendorUseCase,
    val vendorNumberCheckUseCase: VendorNumberCheckUseCase,
    val vendorPasswordUpdateUseCase: VendorPasswordUpdateUseCase,
    val readVendorDataUseSase:ReadVendorDataUseCase,
    val saveVendorDataUseCase: SaveVendorDataUseCase,
    val vendorVerificationAlreadyLoginUseCase: VendorVerificationAlreadyLoginUseCase,
    val listPropertyUseCase: ListPropertyUseCase,
    val allPropertyListUseCase: AllPropertyListUseCase,
    val searchPropertyUseCase: SearchPropertyUseCase,
    val getOnePropertyUseCase: GetOnePropertyUseCase,
    val postCommentUseCase: PostCommentUseCase,
    val uploadImageUseCase: UserUploadImageUseCase,
    val readUserImageUseCase: ReadUserImageUseCase,
    val getPropertyByTypeUseCase: GetPropertyByTypeUseCase
)
