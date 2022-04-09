package com.digitalamanmedia.bhumistar.data.remote.api

import com.digitalamanmedia.bhumistar.data.remote.dto.PropertyDto.ListPropertyDto
import com.digitalamanmedia.bhumistar.data.remote.dto.PropertyDto.PostCommentDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.NormalResponseDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto.OnePropertyDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto.PropertyDetailDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto.PropertyResponseDto
import retrofit2.http.*

interface PropertyApi {

    @POST("v3/list_property")
    suspend fun listProperty(
        @Body listPropertyDto: ListPropertyDto
    ): NormalResponseDto

    @GET("v3/all_property_list")
    suspend fun allPropertyList(
        @Query("page") page:Int,
        @Query("limit") limit:Int,
        @Query("type") typeWord:String
    ): PropertyResponseDto

    @GET("v3/property_Search")
    suspend fun searchPropertyList(
        @Query("word") searchWord:String,
        @Query("page") page:Int,
        @Query("limit") limit:Int
    ): PropertyResponseDto

    @GET("v3/get_one_property")
    suspend fun getOneProperty(
        @Query("id") id:Int
    ): OnePropertyDto


    @POST("v4/insert_comments")
    suspend fun postComments(
        @Body postCommentDto: PostCommentDto
    ):NormalResponseDto

    @GET("v3/get_property_by_type")
    suspend fun getPropertyListByType(
        @Query("type") type:String,
        @Query("page") page:Int,
        @Query("limit") limit:Int
    ): PropertyResponseDto
}