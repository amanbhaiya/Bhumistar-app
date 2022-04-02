package com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.user_data

import com.digitalamanmedia.bhumistar.domain.repository.local.UserStoreRepository
import javax.inject.Inject

class UserVerificationAlreadyLoginUseCase @Inject constructor(
    private val userStoreRepository: UserStoreRepository
){
    suspend fun createUserKey(value:String){
        userStoreRepository.createUserLogin(value)
    }
    suspend fun readUserKey(key:String):String?{
        return userStoreRepository.readUserLogin(key)
    }
}