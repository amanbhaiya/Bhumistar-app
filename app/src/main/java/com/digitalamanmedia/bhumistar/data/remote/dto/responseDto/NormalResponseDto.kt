package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto

import com.digitalamanmedia.bhumistar.domain.modal.NormalResponseModal

class NormalResponseDto(
        val status:Int,
        val message:String
)

fun NormalResponseDto.toNormalResponseModal(): NormalResponseModal {
        return NormalResponseModal(
            message = message
        )
    }
