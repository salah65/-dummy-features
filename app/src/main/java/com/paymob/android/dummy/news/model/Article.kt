package com.budiyev.android.libdemoapp.news.model

import java.io.Serializable

data class Article(
    val title: String,
    val date: String,
    val byline: String,
    val thumbnailUrl: String? = "",
    val source: String,
    val coverUrl: String? = "",
    val caption: String? = "",
    val abstract: String? = ""
) : Serializable