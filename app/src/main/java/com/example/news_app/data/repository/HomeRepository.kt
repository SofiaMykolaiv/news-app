package com.example.news_app.data.repository

import com.example.news_app.data.mapper.mapResponseToModel
import com.example.news_app.data.network.response.ArticleResponse
import com.example.news_app.presentation.model.ArticleModel
import kotlinx.coroutines.delay

class HomeRepository : BaseRepository {
    suspend fun loadArticleList(): List<ArticleModel> {
        val response = arrayListOf(
            ArticleResponse(
                author = "Green Chack",
                title = "Forest",
                description = "Big big big forest and green",
                urlToImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Wiktionary_small.svg/350px-Wiktionary_small.svg.png"
            ),
            ArticleResponse(
                author = "Black Ass",
                title = "Nigga",
                description = "Big big big nigga and his ass",
                urlToImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Wiktionary_small.svg/350px-Wiktionary_small.svg.png"
            ),
            ArticleResponse(
                author = "White Dick",
                title = "Sausage",
                description = "Big big big beef and tasty",
                urlToImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Wiktionary_small.svg/350px-Wiktionary_small.svg.png"
            )
        )

        delay(2000)
        val articleList = mapResponseToModel(response)
        return articleList
    }
}