package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.user_response_dto

import com.digitalamanmedia.bhumistar.domain.modal.user_response_modal.ImageResponseModal

data class ImageResponseDto(
    val image: String?,
    val status: Int
){
    fun toImageResponseModal():ImageResponseModal{
        return ImageResponseModal(
            image = image,
            status = status
        )
    }
}