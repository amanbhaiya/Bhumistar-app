package com.digitalamanmedia.bhumistar.domain.modal

import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.DataResponseDto

data class LogInResponseModal (
    val data: DataResponseModal,
    val message: String,
)