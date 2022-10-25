package com.example.nytimesapp.Network

import com.budiyev.android.libdemoapp.news.Network.httpLoggingInterceptor
import com.budiyev.android.libdemoapp.news.Network.tokenInterceptor
import com.example.nytimesapp.Core.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitInstance {


    private val client = addTimeOut(OkHttpClient.Builder())
        .followRedirects(false)
        .followSslRedirects(false)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(tokenInterceptor)
        .build()


    fun getService(): Endpoints {

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create<Endpoints>(Endpoints::class.java)
    }

    private fun addTimeOut(httpClient: OkHttpClient.Builder): OkHttpClient.Builder {
        return httpClient.connectTimeout(60, TimeUnit.SECONDS)
            .callTimeout(0, TimeUnit.SECONDS)
            .readTimeout(0, TimeUnit.SECONDS)
            .writeTimeout(0, TimeUnit.SECONDS)
    }

}