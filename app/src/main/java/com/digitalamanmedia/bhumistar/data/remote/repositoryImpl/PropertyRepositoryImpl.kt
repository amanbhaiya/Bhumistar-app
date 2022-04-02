package com.digitalamanmedia.bhumistar.data.remote.repositoryImpl

import com.digitalamanmedia.bhumistar.data.remote.api.PropertyApi
import com.digitalamanmedia.bhumistar.data.remote.dto.PropertyDto.ListPropertyDto
import com.digitalamanmedia.bhumistar.data.remote.dto.PropertyDto.PostCommentDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto.OnePropertyDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto.PropertyDetailDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto.PropertyResponseDto
import com.digitalamanmedia.bhumistar.domain.repository.remote.PropertyRepository
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    private val propertyApi: PropertyApi
):PropertyRepository {
    override suspend fun listProperty(listPropertyDto: ListPropertyDto): NormalResponseDto {
        return propertyApi.listProperty(listPropertyDto)
    }

    override suspend fun allPropertyList(): PropertyResponseDto {
        return propertyApi.allPropertyList()
    }

    override suspend fun searchPropertyList(searchWord: String): PropertyResponseDto {
        return propertyApi.searchPropertyList(searchWord)
    }

    override suspend fun getOneProperty(id: Int): OnePropertyDto {
        return propertyApi.getOneProperty(id)
    }

    override suspend fun postComments(postCommentDto: PostCommentDto): NormalResponseDto {
        return propertyApi.postComments(postCommentDto)
    }

    override suspend fun getPropertyListByType(type: String): PropertyResponseDto {
        return propertyApi.getPropertyListByType(type)
    }
}