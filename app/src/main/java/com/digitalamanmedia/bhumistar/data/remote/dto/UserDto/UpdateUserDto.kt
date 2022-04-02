package com.digitalamanmedia.bhumistar.data.remote.dto.UserDto

data class UpdateUserDto(
    val district: String,
    val email: String,
    val password:String,
    val name: String,
    val number: String,
    val pin_code: String,
    val state: String
)
