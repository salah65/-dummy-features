package com.example.nytimesapp.Network

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
import retrofit2.HttpException
import java.io.IOException

fun <T> handleError(m: MutableLiveData<Resource<T>>): CoroutineExceptionHandler {
    return CoroutineExceptionHandler { _, exception ->
        var title = "Warning"
        val msg: String = when (exception) {
            is IOException -> "No Internet Connection"
            is HttpException -> "Something went wrong..."
            is NotAuthorizedException -> exception.message!!
            is InternalServerErrorException -> exception.message!!
            is NotFoundException -> exception.message!!
            else -> exception.localizedMessage!!
        }
        m.postValue(Resource.error(msg, title))

    }
}