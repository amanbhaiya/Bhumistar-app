package com.digitalamanmedia.bhumistar.core.utils

sealed class Resource<out T>{
    data class Success<out S>(val data: S):Resource<S>()
    data class Error(val message: String):Resource<Nothing>()
    object Loading:Resource<Nothing>()
}
