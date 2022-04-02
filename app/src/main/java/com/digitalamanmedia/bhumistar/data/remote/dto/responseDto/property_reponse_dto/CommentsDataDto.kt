package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto

import com.digitalamanmedia.bhumistar.domain.modal.property_modal.CommentsDataModal

data class CommentsDataDto(
    val comment: String?,
    val created_at: String?,
    val id: Int?,
    val property_id: Int?,
    val rating: Int?,
    val username: String?,
    val user_id:Int?,
    val user_image:String?
){
    fun toCommentsDataModal(): CommentsDataModal {
        return CommentsDataModal(
            comment = comment,
            username = username,
            rating = rating,
            created_at = created_at,
            user_id = user_id,
            user_image = user_image
        )
    }
}