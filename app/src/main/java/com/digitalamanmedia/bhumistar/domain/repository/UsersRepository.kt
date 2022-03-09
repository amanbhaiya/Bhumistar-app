package com.digitalamanmedia.bhumistar.domain.repository

import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.*
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.LogInResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto


interface UsersRepository {

    suspend fun createUser(
         createUser: CreateUserDto
    ): NormalResponseDto


    suspend fun updateUser(
        updateUser: UpdateUserDto
    ): NormalResponseDto


    suspend fun updatePassword(
        updatePassword: UpdatePasswordDto
    ): NormalResponseDto


    suspend fun logInUser(
        loginUserDto: LoginUserDto
    ): LogInResponseDto


    suspend fun checkNumber(
        checkPhoneNumber: CheckPhoneNumberDto
    ): NormalResponseDto
}