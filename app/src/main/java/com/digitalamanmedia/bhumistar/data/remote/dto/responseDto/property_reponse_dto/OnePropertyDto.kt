package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto

import com.digitalamanmedia.bhumistar.domain.modal.property_modal.OnePropertyModal

data class OnePropertyDto(
    val data: PropertyDetailDto?,
    val message: String,
    val status: Int
){
    fun toOnePropertyModal(): OnePropertyModal {
        return OnePropertyModal(
            data = data?.toPropertyDetailModal(),
            message = message,
            status = status
        )
    }
}