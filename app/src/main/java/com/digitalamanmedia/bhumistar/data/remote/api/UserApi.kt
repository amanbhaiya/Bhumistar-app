package com.digitalamanmedia.bhumistar.data.remote.api

import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.*
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.user_response_dto.ImageResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.user_response_dto.UserLogInResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

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
    ): UserLogInResponseDto

    @POST("v1/check_email")
    suspend fun checkEmail(
        @Body checkEmailDto: CheckEmailDto
    ): NormalResponseDto

    @POST("v1/update_user_image")
    suspend fun uploadImage(
        @Body userImageUploadDto: UserImageUploadDto
    ):NormalResponseDto

    @GET("v1/read_user_image")
    suspend fun readUserImage(
        @Query("id") id:Int
    ):ImageResponseDto
}