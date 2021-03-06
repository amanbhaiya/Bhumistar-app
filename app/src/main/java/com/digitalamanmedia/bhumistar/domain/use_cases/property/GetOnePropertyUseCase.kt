package com.digitalamanmedia.bhumistar.domain.use_cases.property

import com.digitalamanmedia.bhumistar.core.utils.GetResponse
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto.toPropertyDetailModal
import com.digitalamanmedia.bhumistar.domain.modal.property_modal.OnePropertyModal
import com.digitalamanmedia.bhumistar.domain.modal.property_modal.PropertyDetailModal
import com.digitalamanmedia.bhumistar.domain.modal.property_modal.PropertyResponseModal
import com.digitalamanmedia.bhumistar.domain.repository.remote.PropertyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOnePropertyUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository
) {
    operator fun invoke(id:Int):Flow<Resource<OnePropertyModal>>{
        return GetResponse.result {
            propertyRepository.getOneProperty(id).toOnePropertyModal()
        }
    }
}