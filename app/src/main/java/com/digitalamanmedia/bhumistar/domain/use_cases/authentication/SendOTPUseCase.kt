package com.digitalamanmedia.bhumistar.domain.use_cases.authentication

import com.digitalamanmedia.bhumistar.core.utils.GetResponse
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.remote.dto.otpDto.OtpDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.toNormalResponseModal
import com.digitalamanmedia.bhumistar.domain.modal.NormalResponseModal
import com.digitalamanmedia.bhumistar.domain.repository.remote.OtpAuthenticationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SendOTPUseCase @Inject constructor(
    private val otpAuthenticationRepository: OtpAuthenticationRepository
){
    operator fun invoke(otpDto: OtpDto): Flow<Resource<NormalResponseModal>> {

        return GetResponse.result {
            otpAuthenticationRepository.sendOTP(otpDto).toNormalResponseModal()
        }



    }
}