package com.digitalamanmedia.bhumistar.data.remote.repositoryImpl


import com.digitalamanmedia.bhumistar.data.remote.api.OTPApi
import com.digitalamanmedia.bhumistar.data.remote.api.UserApi
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.*
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.LogInResponseDto

import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import com.digitalamanmedia.bhumistar.domain.repository.UsersRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiServices: UserApi
) :UsersRepository{
    override suspend fun createUser(createUserDto: CreateUserDto): NormalResponseDto {
        return apiServices.createUser(createUserDto)
    }

    override suspend fun updateUser(updateUserDto: UpdateUserDto): NormalResponseDto {
        return apiServices.updateUser(updateUserDto)
    }

    override suspend fun updatePassword(updatePasswordDto: UpdatePasswordDto): NormalResponseDto {
        return apiServices.updatePassword(updatePasswordDto)
    }

    override suspend fun logInUser(loginUserDto: LoginUserDto): LogInResponseDto {
        return apiServices.logInUser(loginUserDto)
    }

    override suspend fun checkNumber(checkPhoneNumberDto: CheckPhoneNumberDto): NormalResponseDto {
        return apiServices.checkNumber(checkPhoneNumberDto)
    }


}