package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto

import com.digitalamanmedia.bhumistar.domain.modal.DataResponseModal

data class DataResponseDto(
    val created_at: String,
    val district: String,
    val email: String,
    val id: Int,
    val name: String,
    val number: String,
    val password: String,
    val pin_code: String,
    val state: String
)
fun DataResponseDto.toDataResponseModal():DataResponseModal{
    return DataResponseModal(
        district = district,
        email = email,
        id = id,
        name = name,
        number = number,
        pin_code = pin_code,
        state = state
    )
}