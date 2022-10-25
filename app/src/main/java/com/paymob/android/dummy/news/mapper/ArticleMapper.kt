package com.example.nytimesapp.mapper

import com.example.nytimesapp.Network.response.Result
import com.budiyev.android.libdemoapp.news.model.Article

fun List<Result>.toDomainModel(): List<Article> {
    return this.map { result ->
        val media = result.media.getOrNull(0)
        Article(
            title = result.title,
            date = result.published_date,
            byline = result.byline,
            thumbnailUrl = media?.media_metadata?.getOrNull(0)?.url,
            source = result.source,
            coverUrl = media?.media_metadata?.getOrNull(2)?.url,
            abstract = result.abstract,
            caption = media?.caption
        )
    }
}
