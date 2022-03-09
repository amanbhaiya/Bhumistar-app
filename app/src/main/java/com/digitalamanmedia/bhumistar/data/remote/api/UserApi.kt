package com.digitalamanmedia.bhumistar.data.remote.api

import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.*
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.LogInResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("v1/create_user")
    suspend fun createUser(
        @Body createUser: CreateUserDto
    ): NormalResponseDto

    @POST("v1/update_user")
    suspend fun updateUser(
        @Body updateUser: UpdateUserDto
    ): NormalResponseDto

    @POST("v1/forgot_password")
    suspend fun updatePassword(
        @Body updatePassword: UpdatePasswordDto
    ): NormalResponseDto

    @POST("v1/login_user")
    suspend fun logInUser(
        @Body loginUser: LoginUserDto
    ): LogInResponseDto

    @POST("v1/check_ph_number")
    suspend fun checkNumber(
        @Body checkPhoneNumber: CheckPhoneNumberDto
    ): NormalResponseDto
}