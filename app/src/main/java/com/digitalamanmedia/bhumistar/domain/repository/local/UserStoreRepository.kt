package com.digitalamanmedia.bhumistar.domain.repository.local

import com.digitalamanmedia.bhumistar.data.local.dataModal.UserData
import kotlinx.coroutines.flow.Flow

interface UserStoreRepository {

    suspend fun saveUserData(userData: UserData)

    suspend fun readUserData():Flow<UserData>

    suspend fun readUserLogin(key:String):String?

    suspend fun createUserLogin(value:String)

}