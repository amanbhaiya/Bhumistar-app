package com.digitalamanmedia.bhumistar.domain.repository

interface AuthenticationRepository {
    suspend fun sendOTP(number:String)
    suspend fun verifyOTP(otp:String)
}