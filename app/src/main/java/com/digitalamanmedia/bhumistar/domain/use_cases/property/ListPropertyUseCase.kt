package com.digitalamanmedia.bhumistar.domain.use_cases.property

import com.digitalamanmedia.bhumistar.core.utils.GetResponse
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.remote.dto.PropertyDto.ListPropertyDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.toNormalResponseModal
import com.digitalamanmedia.bhumistar.domain.modal.NormalResponseModal
import com.digitalamanmedia.bhumistar.domain.repository.remote.PropertyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListPropertyUseCase@Inject constructor(
    private val propertyRepository: PropertyRepository
) {
    operator fun invoke(listPropertyDto: ListPropertyDto):Flow<Resource<NormalResponseModal>> {
        return GetResponse.result {
            propertyRepository.listProperty(listPropertyDto).toNormalResponseModal()
        }
    }
}