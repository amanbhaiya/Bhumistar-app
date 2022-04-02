package com.digitalamanmedia.bhumistar.domain.repository.remote

import com.digitalamanmedia.bhumistar.data.remote.dto.PropertyDto.ListPropertyDto
import com.digitalamanmedia.bhumistar.data.remote.dto.PropertyDto.PostCommentDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto.OnePropertyDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto.PropertyDetailDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto.PropertyResponseDto

interface PropertyRepository {

    suspend fun listProperty(listPropertyDto: ListPropertyDto):NormalResponseDto

    suspend fun allPropertyList():PropertyResponseDto

    suspend fun searchPropertyList(searchWord:String): PropertyResponseDto

    suspend fun getOneProperty(id:Int): OnePropertyDto

    suspend fun postComments(postCommentDto: PostCommentDto):NormalResponseDto

    suspend fun getPropertyListByType(type:String):PropertyResponseDto
}