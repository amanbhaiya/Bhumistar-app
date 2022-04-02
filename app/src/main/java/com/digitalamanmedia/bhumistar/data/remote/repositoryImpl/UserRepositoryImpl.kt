package com.digitalamanmedia.bhumistar.data.remote.repositoryImpl


import com.digitalamanmedia.bhumistar.data.remote.api.UserApi
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.*

import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.user_response_dto.ImageResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.user_response_dto.UserLogInResponseDto
import com.digitalamanmedia.bhumistar.domain.repository.remote.UsersRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi
) : UsersRepository {
    override suspend fun createUser(createUserDto: CreateUserDto): NormalResponseDto {
        return userApi.createUser(createUserDto)
    }

    override suspend fun updateUser(updateUserDto: UpdateUserDto): NormalResponseDto {
        return userApi.updateUser(updateUserDto)
    }

    override suspend fun updatePassword(updatePasswordDto: UpdatePasswordDto): NormalResponseDto {
        return userApi.updatePassword(updatePasswordDto)
    }

    override suspend fun logInUser(loginUserDto: LoginUserDto): UserLogInResponseDto {
        return userApi.logInUser(loginUserDto)
    }

    override suspend fun checkEmail(checkEmailDto: CheckEmailDto): NormalResponseDto {
        return userApi.checkEmail(checkEmailDto)
    }

    override suspend fun uploadImage(userImageUploadDto: UserImageUploadDto): NormalResponseDto {
        return userApi.uploadImage(userImageUploadDto)
    }

    override suspend fun readImage(id: Int): ImageResponseDto {
        return userApi.readUserImage(id)
    }


}