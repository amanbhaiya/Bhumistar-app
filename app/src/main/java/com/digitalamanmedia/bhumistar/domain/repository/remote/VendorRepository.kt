package com.digitalamanmedia.bhumistar.domain.repository.remote

import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.CreateVendorDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.LoginVendorDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.VendorNumberDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.VendorPasswordUpdateDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.vendor_response_dto.VendorLoginResponseDto

interface VendorRepository {

    suspend fun createVendor(createVendorDto: CreateVendorDto):NormalResponseDto
    suspend fun updateVendorPassword(vendorPasswordUpdateDto: VendorPasswordUpdateDto):NormalResponseDto
    suspend fun loginVendor(loginVendorDto: LoginVendorDto): VendorLoginResponseDto
    suspend fun checkVendorNumber(vendorNumberDto: VendorNumberDto):NormalResponseDto
}