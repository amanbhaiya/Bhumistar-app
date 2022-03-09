package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto

import com.digitalamanmedia.bhumistar.domain.modal.LogInResponseModal

data class LogInResponseDto(
    val data: DataResponseDto,
    val message: String,
    val status: Int
)

fun LogInResponseDto.toLogInResponseModal(): LogInResponseModal {
    return LogInResponseModal(
        data = data.toDataResponseModal(),
        message = message
    )
}