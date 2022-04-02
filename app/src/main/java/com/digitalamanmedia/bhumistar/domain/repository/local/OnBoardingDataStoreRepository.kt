package com.digitalamanmedia.bhumistar.domain.repository.local

interface OnBoardingDataStoreRepository {

    suspend fun OnBoardingKeySave(value:Boolean)

    suspend fun OnBoardingReadKey(key: String):Boolean?
}