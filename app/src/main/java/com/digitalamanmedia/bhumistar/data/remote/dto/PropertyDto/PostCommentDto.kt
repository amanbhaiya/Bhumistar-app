package com.digitalamanmedia.bhumistar.data.remote.dto.PropertyDto

data class PostCommentDto(
    val comment: String,
    val property_id: Int,
    val rating: Int,
    val username: String,
    val user_id:Int,
    val time:String
)