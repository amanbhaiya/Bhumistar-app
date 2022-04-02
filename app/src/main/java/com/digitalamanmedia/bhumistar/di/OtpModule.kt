package com.digitalamanmedia.bhumistar.di


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.core.Commons.Companion.BOOLEAN
import com.digitalamanmedia.bhumistar.core.utils.MyInterceptor
import com.digitalamanmedia.bhumistar.data.local.repositoryImpl.OnBoardingDataStoreRepositoryImpl
import com.digitalamanmedia.bhumistar.data.local.repositoryImpl.UserStoreRepositoryImpl
import com.digitalamanmedia.bhumistar.data.local.repositoryImpl.VendorStoreRepositoryImpl
import com.digitalamanmedia.bhumistar.data.remote.api.OTPApi
import com.digitalamanmedia.bhumistar.data.remote.api.PropertyApi
import com.digitalamanmedia.bhumistar.data.remote.api.UserApi
import com.digitalamanmedia.bhumistar.data.remote.api.VendorApi
import com.digitalamanmedia.bhumistar.data.remote.repositoryImpl.OtpAuthenticationRepositoryImpl
import com.digitalamanmedia.bhumistar.data.remote.repositoryImpl.PropertyRepositoryImpl
import com.digitalamanmedia.bhumistar.data.remote.repositoryImpl.UserRepositoryImpl
import com.digitalamanmedia.bhumistar.data.remote.repositoryImpl.VendorRepositoryImpl
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
import dagger.hilt.android.qualifiers.ApplicationContext

import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object OtpModule {



    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Commons.BASE_URL)
            .client(OkHttpClient.Builder().apply {
                addInterceptor(MyInterceptor())
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideOTPApi(retrofit: Retrofit):OTPApi{
        return retrofit.create(OTPApi::class.java)
    }
    @Singleton
    @Provides
    fun provideUserApi(retrofit: Retrofit):UserApi{
        return retrofit.create(UserApi::class.java)
    }

    @Singleton
    @Provides
    fun provideVendorApi(retrofit: Retrofit):VendorApi{
        return retrofit.create(VendorApi::class.java)
    }

    @Singleton
    @Provides
    fun providePropertyApi(retrofit: Retrofit):PropertyApi{
        return retrofit.create(PropertyApi::class.java)
    }








    @Singleton
    @Provides
    fun providesDatastore(@ApplicationContext context: Context ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(produceNewData = { emptyPreferences()}),
            scope = CoroutineScope(
                context = Dispatchers.IO + SupervisorJob()
            ),
            produceFile = {
                context.preferencesDataStoreFile(BOOLEAN)
            }
        )

    }

}


