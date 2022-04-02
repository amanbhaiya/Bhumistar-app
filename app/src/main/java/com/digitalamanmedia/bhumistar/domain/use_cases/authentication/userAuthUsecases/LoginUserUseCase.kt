package com.digitalamanmedia.bhumistar.domain.use_cases.authentication.userAuthUsecases

import com.digitalamanmedia.bhumistar.core.utils.GetResponse
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.LoginUserDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.user_response_dto.toUserLogInResponseModal
import com.digitalamanmedia.bhumistar.domain.modal.user_response_modal.LogInResponseModal
import com.digitalamanmedia.bhumistar.domain.repository.remote.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUserUseCase@Inject constructor(
    private val usersRepository: UsersRepository
){

    operator fun invoke(loginUserDto: LoginUserDto): Flow<Resource<LogInResponseModal>> {
        return GetResponse.result {
            usersRepository.logInUser(loginUserDto).toUserLogInResponseModal()
        }
    }
}