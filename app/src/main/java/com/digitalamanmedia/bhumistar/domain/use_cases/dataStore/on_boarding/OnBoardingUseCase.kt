package com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.on_boarding

import com.digitalamanmedia.bhumistar.domain.repository.local.OnBoardingDataStoreRepository
import javax.inject.Inject

class OnBoardingUseCase @Inject constructor(
    private val onBoardingDataStoreRepository: OnBoardingDataStoreRepository
) {
    suspend fun write(value:Boolean){
        onBoardingDataStoreRepository.OnBoardingKeySave(value)
    }

    suspend fun read(key:String):Boolean?{
       return onBoardingDataStoreRepository.OnBoardingReadKey(key)
    }
}