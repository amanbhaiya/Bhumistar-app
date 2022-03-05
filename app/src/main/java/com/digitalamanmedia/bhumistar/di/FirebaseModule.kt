package com.digitalamanmedia.bhumistar.di

import androidx.activity.ComponentActivity
import com.digitalamanmedia.bhumistar.data.remote.repositoryImpl.AuthenticationRepositoryImpl
import com.digitalamanmedia.bhumistar.domain.repository.AuthenticationRepository
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.SendOTPUseCase
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.VerifyOTPUseCase
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Singleton
    @Provides
    fun provideFirebaseAuth():FirebaseAuth {
        return FirebaseAuth.getInstance()
    }


    @Singleton
    @Provides
    fun provideRepository(
        mAuth:FirebaseAuth,
        activity: ComponentActivity
    )
    :AuthenticationRepository{
        return AuthenticationRepositoryImpl(mAuth = mAuth, activity = activity)
    }


    @Singleton
    @Provides
    fun provideAllUseCases(authenticationRepository: AuthenticationRepository):AllUseCases{
        return AllUseCases(
            sendOTPUseCase = SendOTPUseCase(authenticationRepository = authenticationRepository),
            verifyOTPUseCase = VerifyOTPUseCase(authenticationRepository = authenticationRepository)
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


