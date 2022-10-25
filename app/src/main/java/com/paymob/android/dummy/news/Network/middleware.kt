package com.budiyev.android.libdemoapp.news.Network

import com.example.nytimesapp.Core.Constants
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

val httpLoggingInterceptor = run {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}


val tokenInterceptor = { chain: Interceptor.Chain ->
    var original = chain.request()
    val url = original.url.newBuilder().addQueryParameter("api-key", Constants.API_KEY).build()
    original = original.newBuilder().url(url).build()
    chain.proceed(original)
}
