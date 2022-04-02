package com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.user_data

import com.digitalamanmedia.bhumistar.data.local.dataModal.UserData
import com.digitalamanmedia.bhumistar.domain.repository.local.UserStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class ReadUserDataUseCase @Inject constructor(
    private val userStoreRepository: UserStoreRepository
) {
    suspend operator fun invoke():Flow<UserData>{
       return userStoreRepository.readUserData()
    }
}