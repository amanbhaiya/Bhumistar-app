package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.user_response_dto

import com.digitalamanmedia.bhumistar.domain.modal.user_response_modal.LogInResponseModal

data class UserLogInResponseDto(
    val data: UserDataResponseDto?,
    val message: String,
    val status: Int
)

fun UserLogInResponseDto.toUserLogInResponseModal(): LogInResponseModal {
    return LogInResponseModal(
        data = data?.toUserDataResponseModal(),
        message = message,
        status = status
    )
}