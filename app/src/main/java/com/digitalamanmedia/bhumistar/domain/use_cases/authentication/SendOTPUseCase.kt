package com.digitalamanmedia.bhumistar.domain.use_cases.authentication

import android.app.Application
import android.widget.Toast
import com.digitalamanmedia.bhumistar.core.Commons.Companion.INTERNET_ERROR
import com.digitalamanmedia.bhumistar.core.Commons.Companion.UNKNOWN_ERROR
import com.digitalamanmedia.bhumistar.core.Commons.Companion.VALID_NUMBER
import com.digitalamanmedia.bhumistar.core.utils.Resourse
import com.digitalamanmedia.bhumistar.data.remote.dto.otpDto.OtpDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.toNormalResponseModal
import com.digitalamanmedia.bhumistar.domain.modal.NormalResponseModal
import com.digitalamanmedia.bhumistar.domain.repository.OtpAuthenticationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class SendOTPUseCase @Inject constructor(
    private val context: Application,
    private val authenticationRepository: OtpAuthenticationRepository
){
    operator fun invoke(otpDto: OtpDto): Flow<Resourse<NormalResponseModal>> = flow{

        try {
            emit(Resourse.Loading)
            if (otpDto.number.length == 10){

                val response = authenticationRepository.sendOTP(otpDto).toNormalResponseModal()

                emit(Resourse.Success(response))
            }else{
                Toast.makeText(context.applicationContext, VALID_NUMBER, Toast.LENGTH_LONG).show()
            }
        }catch (e : HttpException){
            emit(Resourse.Error(e.localizedMessage?: UNKNOWN_ERROR))
        }catch (e : IOException){
            emit(Resourse.Error(e.localizedMessage?: INTERNET_ERROR))
        }catch (e : Exception){
            emit(Resourse.Error(e.localizedMessage?:"Error"))
        }



    }
}