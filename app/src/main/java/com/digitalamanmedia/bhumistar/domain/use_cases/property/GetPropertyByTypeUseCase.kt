package com.digitalamanmedia.bhumistar.domain.use_cases.property

import com.digitalamanmedia.bhumistar.core.utils.GetResponse
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.domain.modal.property_modal.PropertyResponseModal
import com.digitalamanmedia.bhumistar.domain.repository.remote.PropertyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPropertyByTypeUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository
) {
    operator fun invoke(type:String):Flow<Resource<PropertyResponseModal>>{
        return GetResponse.result {
            propertyRepository.getPropertyListByType(type).toPropertyResponseModal()
        }
    }
}