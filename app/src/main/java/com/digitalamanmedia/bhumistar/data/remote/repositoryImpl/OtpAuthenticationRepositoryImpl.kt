package com.digitalamanmedia.bhumistar.data.remote.repositoryImpl





import com.digitalamanmedia.bhumistar.data.remote.api.OTPApi
import com.digitalamanmedia.bhumistar.data.remote.dto.otpDto.OtpDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import com.digitalamanmedia.bhumistar.domain.repository.remote.OtpAuthenticationRepository

import javax.inject.Inject


class OtpAuthenticationRepositoryImpl @Inject constructor(
    private val otpApi: OTPApi
): OtpAuthenticationRepository {
    override suspend fun sendOTP(otpDto: OtpDto): NormalResponseDto {
       return otpApi.sendOtp(otpDto = otpDto)
    }


}