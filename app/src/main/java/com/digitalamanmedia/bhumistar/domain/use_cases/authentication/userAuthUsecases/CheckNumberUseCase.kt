package com.digitalamanmedia.bhumistar.domain.use_cases.authentication.userAuthUsecases

import android.app.Application
import android.widget.Toast
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.core.utils.Resourse
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.CheckPhoneNumberDto
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.CreateUserDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.toNormalResponseModal
import com.digitalamanmedia.bhumistar.domain.modal.NormalResponseModal
import com.digitalamanmedia.bhumistar.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class CheckNumberUseCase @Inject constructor(
    private val context: Application,
    private val usersRepository: UsersRepository
){

    operator fun invoke(checkPhoneNumberDto: CheckPhoneNumberDto): Flow<Resourse<NormalResponseModal>> = flow {
        emit(Resourse.Loading)
        try {
            emit(Resourse.Loading)
            if (checkPhoneNumberDto.user_ph_number.length == 10 ){

                val response = usersRepository.checkNumber(checkPhoneNumberDto).toNormalResponseModal()

                emit(Resourse.Success(response))
            }else{
                Toast.makeText(context.applicationContext, Commons.ALL_FIELD, Toast.LENGTH_LONG).show()
            }
        }catch (e : HttpException){
            emit(Resourse.Error(e.localizedMessage?: Commons.UNKNOWN_ERROR))
        }catch (e : IOException){
            emit(Resourse.Error(e.localizedMessage?: Commons.INTERNET_ERROR))
        }catch (e : Exception){
            emit(Resourse.Error(e.localizedMessage?: Commons.ERROR))
        }
    }
}