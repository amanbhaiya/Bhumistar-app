package com.digitalamanmedia.bhumistar.domain.repository.remote

import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.*
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.user_response_dto.ImageResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.user_response_dto.UserLogInResponseDto


interface UsersRepository {

    suspend fun createUser(
         createUserDto: CreateUserDto
    ): NormalResponseDto


    suspend fun updateUser(
        updateUserDto: UpdateUserDto
    ): NormalResponseDto


    suspend fun updatePassword(
        updatePasswordDto: UpdatePasswordDto
    ): NormalResponseDto


    suspend fun logInUser(
        loginUserDto: LoginUserDto
    ): UserLogInResponseDto


    suspend fun checkEmail(
        checkEmailDto: CheckEmailDto
    ): NormalResponseDto

    suspend fun uploadImage(
        userImageUploadDto: UserImageUploadDto
    ): NormalResponseDto

    suspend fun readImage(
        id: Int
    ): ImageResponseDto
}