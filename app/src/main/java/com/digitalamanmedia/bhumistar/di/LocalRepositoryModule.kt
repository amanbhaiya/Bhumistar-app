package com.digitalamanmedia.bhumistar.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.digitalamanmedia.bhumistar.data.local.repositoryImpl.OnBoardingDataStoreRepositoryImpl
import com.digitalamanmedia.bhumistar.data.local.repositoryImpl.UserStoreRepositoryImpl
import com.digitalamanmedia.bhumistar.data.local.repositoryImpl.VendorStoreRepositoryImpl
import com.digitalamanmedia.bhumistar.domain.repository.local.OnBoardingDataStoreRepository
import com.digitalamanmedia.bhumistar.domain.repository.local.UserStoreRepository
import com.digitalamanmedia.bhumistar.domain.repository.local.VendorStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalRepositoryModule {
    @Singleton
    @Provides
    fun providesOnBoardingDataStoreRepository(preferences: DataStore<Preferences>): OnBoardingDataStoreRepository {
        return OnBoardingDataStoreRepositoryImpl(preferences)
    }

    @Singleton
    @Provides
    fun providesUserStoreRepository(preferences: DataStore<Preferences>): UserStoreRepository {
        return UserStoreRepositoryImpl(preferences)
    }

    @Singleton
    @Provides
    fun providesVendorStoreRepository(preferences: DataStore<Preferences>): VendorStoreRepository {
        return VendorStoreRepositoryImpl(preferences)
    }
}