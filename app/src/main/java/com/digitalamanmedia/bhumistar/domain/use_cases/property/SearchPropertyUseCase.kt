package com.digitalamanmedia.bhumistar.domain.use_cases.property

import com.digitalamanmedia.bhumistar.core.utils.GetResponse
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto.toPropertyDetailModal
import com.digitalamanmedia.bhumistar.domain.modal.property_modal.PropertyDetailModal
import com.digitalamanmedia.bhumistar.domain.modal.property_modal.PropertyResponseModal
import com.digitalamanmedia.bhumistar.domain.repository.remote.PropertyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchPropertyUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository
) {
    operator fun invoke(searchWord:String,page:Int,limit:Int):Flow<Resource<PropertyResponseModal>>{
        return GetResponse.result {
            propertyRepository.searchPropertyList(searchWord,page,limit).toPropertyResponseModal()
        }
    }
}