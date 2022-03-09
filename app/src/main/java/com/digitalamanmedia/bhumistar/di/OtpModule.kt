package com.digitalamanmedia.bhumistar.di

import android.app.Application
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.core.utils.MyInterceptor
import com.digitalamanmedia.bhumistar.data.remote.api.OTPApi
import com.digitalamanmedia.bhumistar.data.remote.api.UserApi
import com.digitalamanmedia.bhumistar.data.remote.repositoryImpl.OtpAuthenticationRepositoryImpl
import com.digitalamanmedia.bhumistar.data.remote.repositoryImpl.UserRepositoryImpl
import com.digitalamanmedia.bhumistar.domain.repository.OtpAuthenticationRepository
import com.digitalamanmedia.bhumistar.domain.repository.UsersRepository
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.SendOTPUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.userAuthUsecases.*

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
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
    fun provideOtpRepository(apiServices: OTPApi):OtpAuthenticationRepository{
        return OtpAuthenticationRepositoryImpl(apiServices = apiServices)
    }

    @Singleton
    @Provides
    fun provideUserRepository(apiServices: UserApi): UsersRepository {
        return UserRepositoryImpl(apiServices = apiServices)
    }


    @Singleton
    @Provides
    fun provideAllOtpUseCases(
        authenticationRepository: OtpAuthenticationRepository,
        application: Application,
        usersRepository: UsersRepository
    ):AllUseCases{
        return AllUseCases(
            sendOTPUseCase = SendOTPUseCase(
                authenticationRepository = authenticationRepository,
                context = application
            ),
            checkNumberUseCase = CheckNumberUseCase(
                usersRepository = usersRepository,
                context = application
            ),
            createUserUseCase = CreateUserUseCase(
                usersRepository = usersRepository,
                context = application
            ),
            loginUserUseCase = LoginUserUseCase(
                usersRepository = usersRepository,
                context = application
            ),
            updatePasswordUseCase = UpdatePasswordUseCase(
                usersRepository = usersRepository,
                context = application
            ),
            updateUserUseCase = UpdateUserUseCase(
                usersRepository = usersRepository,
                context = application
            )
        )

    }


//    @Singleton
//    @Provides
//    fun providesDatastore(@ApplicationContext context: Context): DataStore<Preferences>{
//        return PreferenceDataStoreFactory.create(
//            corruptionHandler = ReplaceFileCorruptionHandler(produceNewData = { emptyPreferences()}),
//            scope = CoroutineScope(
//                context = Dispatchers.IO + SupervisorJob()
//            ),
//            produceFile = {
//                context.preferencesDataStoreFile(BOOLEAN)
//            }
//        )
//
//    }
}


