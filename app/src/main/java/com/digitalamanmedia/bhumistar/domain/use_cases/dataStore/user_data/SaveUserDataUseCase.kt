package com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.user_data

import com.digitalamanmedia.bhumistar.data.local.dataModal.UserData
import com.digitalamanmedia.bhumistar.domain.repository.local.UserStoreRepository
import javax.inject.Inject

class SaveUserDataUseCase @Inject constructor(
    private val userStoreRepository: UserStoreRepository
) {
    suspend operator fun invoke(userData: UserData){
        userStoreRepository.saveUserData(userData)
    }
}