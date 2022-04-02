package com.digitalamanmedia.bhumistar.data.remote.api

import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.CreateVendorDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.LoginVendorDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.VendorNumberDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.VendorPasswordUpdateDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.vendor_response_dto.VendorLoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface VendorApi {
    @POST("v2/check_phone_number")
    suspend fun checkVendorNumber(
        @Body vendorNumberDto: VendorNumberDto
    ): NormalResponseDto

    @POST("v2/forgot_password")
    suspend fun updatePassword(
        @Body vendorPasswordUpdateDto: VendorPasswordUpdateDto
    ): NormalResponseDto

    @POST("v2/login_vendor")
    suspend fun loginVendor(
        @Body loginVendorDto: LoginVendorDto
    ): VendorLoginResponseDto

    @POST("v2/register_vendor")
    suspend fun createVendor(
        @Body createVendorDto: CreateVendorDto
    ): NormalResponseDto
}