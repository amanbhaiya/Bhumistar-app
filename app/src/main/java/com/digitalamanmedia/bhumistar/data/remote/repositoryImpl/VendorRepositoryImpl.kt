package com.digitalamanmedia.bhumistar.data.remote.repositoryImpl

import com.digitalamanmedia.bhumistar.data.remote.api.VendorApi
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.CreateVendorDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.LoginVendorDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.VendorNumberDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.VendorPasswordUpdateDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.vendor_response_dto.VendorLoginResponseDto
import com.digitalamanmedia.bhumistar.domain.repository.remote.VendorRepository
import javax.inject.Inject

class VendorRepositoryImpl @Inject constructor(
    private val vendorApi: VendorApi
):VendorRepository{
    override suspend fun createVendor(createVendorDto: CreateVendorDto): NormalResponseDto {
        return vendorApi.createVendor(createVendorDto)
    }

    override suspend fun updateVendorPassword(vendorPasswordUpdateDto: VendorPasswordUpdateDto): NormalResponseDto {
        return vendorApi.updatePassword(vendorPasswordUpdateDto)
    }

    override suspend fun loginVendor(loginVendorDto: LoginVendorDto): VendorLoginResponseDto {
       return vendorApi.loginVendor(loginVendorDto)
    }

    override suspend fun checkVendorNumber(vendorNumberDto: VendorNumberDto): NormalResponseDto {
        return vendorApi.checkVendorNumber(vendorNumberDto)
    }
}