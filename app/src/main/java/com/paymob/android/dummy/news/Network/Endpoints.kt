package com.example.nytimesapp.Network

import com.example.nytimesapp.Network.response.MostPopularResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoints {

    @GET("viewed/{period}.json")
   suspend fun getMostPopularArticles(
        @Path("period") period: Int
    ): Response<MostPopularResponse>
}