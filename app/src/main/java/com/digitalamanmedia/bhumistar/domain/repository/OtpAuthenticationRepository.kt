package com.digitalamanmedia.bhumistar.domain.repository

import com.digitalamanmedia.bhumistar.data.remote.dto.otpDto.OtpDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto


interface OtpAuthenticationRepository {
    suspend fun sendOTP(otpDto: OtpDto):NormalResponseDto

}