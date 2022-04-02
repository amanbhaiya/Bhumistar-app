package com.digitalamanmedia.bhumistar.di

import com.digitalamanmedia.bhumistar.domain.repository.local.OnBoardingDataStoreRepository
import com.digitalamanmedia.bhumistar.domain.repository.local.UserStoreRepository
import com.digitalamanmedia.bhumistar.domain.repository.local.VendorStoreRepository
import com.digitalamanmedia.bhumistar.domain.repository.remote.OtpAuthenticationRepository
import com.digitalamanmedia.bhumistar.domain.repository.remote.PropertyRepository
import com.digitalamanmedia.bhumistar.domain.repository.remote.UsersRepository
import com.digitalamanmedia.bhumistar.domain.repository.remote.VendorRepository
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
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
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideAllOtpUseCases(
        authenticationRepository: OtpAuthenticationRepository,
        usersRepository: UsersRepository,
        userStoreRepository: UserStoreRepository,
        onBoardingDataStoreRepository: OnBoardingDataStoreRepository,
        vendorRepository: VendorRepository,
        vendorStoreRepository: VendorStoreRepository,
        propertyRepository: PropertyRepository
    ): AllUseCases {
        return AllUseCases(
            sendOTPUseCase = SendOTPUseCase(
                otpAuthenticationRepository = authenticationRepository,
            ),
            checkEmailUseCase = CheckEmailUseCase(
                usersRepository = usersRepository,

                ),
            createUserUseCase = CreateUserUseCase(
                usersRepository = usersRepository,

                ),
            loginUserUseCase = LoginUserUseCase(
                usersRepository = usersRepository,

                ),
            updatePasswordUseCase = UpdatePasswordUseCase(
                usersRepository = usersRepository,

                ),
            updateUserUseCase = UpdateUserUseCase(
                usersRepository = usersRepository,

                ),
            readUserDataUseCase = ReadUserDataUseCase(
                userStoreRepository = userStoreRepository
            ),
            saveUserDataUseCase = SaveUserDataUseCase(
                userStoreRepository = userStoreRepository
            ),
            verificationAlreadyLoginUseCase = UserVerificationAlreadyLoginUseCase(
                userStoreRepository = userStoreRepository
            ),
            onBoardingUseCase = OnBoardingUseCase(
                onBoardingDataStoreRepository = onBoardingDataStoreRepository
            ),
            createVendorUseCase = CreateVendorUseCase(
                vendorRepository = vendorRepository
            ),
            loginVendorUseCase = LoginVendorUseCase(
                vendorRepository = vendorRepository
            ),
            vendorNumberCheckUseCase = VendorNumberCheckUseCase(
                vendorRepository = vendorRepository
            ),
            vendorPasswordUpdateUseCase = VendorPasswordUpdateUseCase(
                vendorRepository = vendorRepository
            ),
            readVendorDataUseSase = ReadVendorDataUseCase(
                vendorStoreRepository = vendorStoreRepository
            ),
            saveVendorDataUseCase = SaveVendorDataUseCase(
                vendorStoreRepository = vendorStoreRepository
            ),
            vendorVerificationAlreadyLoginUseCase = VendorVerificationAlreadyLoginUseCase(
                vendorStoreRepository = vendorStoreRepository
            ),
            listPropertyUseCase = ListPropertyUseCase(
                propertyRepository = propertyRepository
            ),
            allPropertyListUseCase = AllPropertyListUseCase(
                propertyRepository = propertyRepository
            ),
            searchPropertyUseCase = SearchPropertyUseCase(
                propertyRepository = propertyRepository
            ),
            getOnePropertyUseCase = GetOnePropertyUseCase(
                propertyRepository = propertyRepository
            ),
            postCommentUseCase = PostCommentUseCase(
                propertyRepository = propertyRepository
            ),
            uploadImageUseCase = UserUploadImageUseCase(
                usersRepository = usersRepository
            ),
            readUserImageUseCase = ReadUserImageUseCase(
                usersRepository = usersRepository
            ),
            getPropertyByTypeUseCase = GetPropertyByTypeUseCase(
                propertyRepository = propertyRepository
            )
        )

    }
}