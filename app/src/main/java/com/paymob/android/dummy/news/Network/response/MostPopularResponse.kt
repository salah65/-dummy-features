package com.example.nytimesapp.Network.response

data class MostPopularResponse(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)