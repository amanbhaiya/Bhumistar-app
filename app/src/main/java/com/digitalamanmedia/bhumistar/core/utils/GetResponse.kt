package com.digitalamanmedia.bhumistar.core.utils


import com.digitalamanmedia.bhumistar.core.Commons.Companion.ERROR
import com.digitalamanmedia.bhumistar.core.Commons.Companion.INTERNET_ERROR
import com.digitalamanmedia.bhumistar.core.Commons.Companion.SUCCESS_UPLOAD_PROPERTY
import com.digitalamanmedia.bhumistar.core.Commons.Companion.UNKNOWN_ERROR
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception


object GetResponse {

    fun <T>result(result:suspend()->T):Flow<Resource<T>> = flow {

        emit(Resource.Loading)

        try {
            val response = result()
            emit(Resource.Success(response))

        }catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage?: UNKNOWN_ERROR))
        }catch (e : IOException){
            if (e.localizedMessage == "timeout") {
                emit(Resource.Error(e.localizedMessage?:INTERNET_ERROR))
            }else{
                emit(Resource.Error(INTERNET_ERROR))
            }
        }catch (e : Exception){
            emit(Resource.Error(e.localizedMessage?: ERROR))
        }
    }
}