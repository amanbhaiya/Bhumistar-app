package com.digitalamanmedia.bhumistar.domain.use_cases.authentication.vendorAuthUseCases

import com.digitalamanmedia.bhumistar.core.utils.GetResponse
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.LoginVendorDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.vendor_response_dto.toVendorLoginResponseModal
import com.digitalamanmedia.bhumistar.domain.modal.vendor_response_modal.VendorLoginResponseModal
import com.digitalamanmedia.bhumistar.domain.repository.remote.VendorRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginVendorUseCase @Inject constructor(
    private val vendorRepository: VendorRepository
) {
    operator fun invoke(loginVendorDto: LoginVendorDto): Flow<Resource<VendorLoginResponseModal>> {
        return GetResponse.result {
            vendorRepository.loginVendor(loginVendorDto).toVendorLoginResponseModal()
        }
    }
}