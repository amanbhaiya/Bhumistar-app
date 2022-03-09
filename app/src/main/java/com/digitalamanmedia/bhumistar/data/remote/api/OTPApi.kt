package com.digitalamanmedia.bhumistar.data.remote.api

import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.*
import com.digitalamanmedia.bhumistar.data.remote.dto.otpDto.OtpDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.LogInResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface OTPApi {


    // Api request for Otp
    @POST("classes/sms_textlocal_api")
    suspend fun sendOtp(
        @Body otpDto: OtpDto
    ): NormalResponseDto


    // Api request for User registration


}