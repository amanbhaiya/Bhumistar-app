package com.digitalamanmedia.bhumistar.core.utils

sealed class Resourse<out T>{
    data class Success<out S>(val data: S):Resourse<S>()
    data class Error(val message: String):Resourse<Nothing>()
    object Loading:Resourse<Nothing>()
}
