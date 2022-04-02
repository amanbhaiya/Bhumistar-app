package com.digitalamanmedia.bhumistar.domain.use_cases.authentication.vendorAuthUseCases

import com.digitalamanmedia.bhumistar.core.utils.GetResponse
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.CreateVendorDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.toNormalResponseModal
import com.digitalamanmedia.bhumistar.domain.modal.NormalResponseModal
import com.digitalamanmedia.bhumistar.domain.repository.remote.VendorRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateVendorUseCase @Inject constructor(
    private val vendorRepository: VendorRepository
) {
    operator fun invoke(createVendorDto: CreateVendorDto):Flow<Resource<NormalResponseModal>>{
        return GetResponse.result {
            vendorRepository.createVendor(createVendorDto).toNormalResponseModal()
        }
    }
}