package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto

import com.digitalamanmedia.bhumistar.domain.modal.property_modal.PropertyResponseModal


data class PropertyResponseDto(
    val data: List<PropertyDetailDto>?,
    val message: String,
    val status: Int
){
    fun toPropertyResponseModal(): PropertyResponseModal {
        return PropertyResponseModal(
            status = status,
            data = data?.map {
                it.toPropertyDetailModal()
            },
            message = message
        )
    }
}