package com.digitalamanmedia.bhumistar.di

import com.digitalamanmedia.bhumistar.data.remote.api.OTPApi
import com.digitalamanmedia.bhumistar.data.remote.api.PropertyApi
import com.digitalamanmedia.bhumistar.data.remote.api.UserApi
import com.digitalamanmedia.bhumistar.data.remote.api.VendorApi
import com.digitalamanmedia.bhumistar.data.remote.repositoryImpl.OtpAuthenticationRepositoryImpl
import com.digitalamanmedia.bhumistar.data.remote.repositoryImpl.PropertyRepositoryImpl
import com.digitalamanmedia.bhumistar.data.remote.repositoryImpl.UserRepositoryImpl
import com.digitalamanmedia.bhumistar.data.remote.repositoryImpl.VendorRepositoryImpl
import com.digitalamanmedia.bhumistar.domain.repository.remote.OtpAuthenticationRepository
import com.digitalamanmedia.bhumistar.domain.repository.remote.PropertyRepository
import com.digitalamanmedia.bhumistar.domain.repository.remote.UsersRepository
import com.digitalamanmedia.bhumistar.domain.repository.remote.VendorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteRepositoryModule {

    @Singleton
    @Provides
    fun provideOtpRepository(otpApi: OTPApi): OtpAuthenticationRepository {
        return OtpAuthenticationRepositoryImpl(otpApi = otpApi)
    }

    @Singleton
    @Provides
    fun provideUserRepository(userApi: UserApi): UsersRepository {
        return UserRepositoryImpl(userApi = userApi)
    }

    @Singleton
    @Provides
    fun provideVendorRepository(vendorApi: VendorApi): VendorRepository {
        return VendorRepositoryImpl(vendorApi = vendorApi)
    }

    @Singleton
    @Provides
    fun providePropertyRepository(propertyApi: PropertyApi): PropertyRepository {
        return PropertyRepositoryImpl(propertyApi)
    }
}