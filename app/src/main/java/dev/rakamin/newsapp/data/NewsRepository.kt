package dev.rakamin.newsapp.data

import dev.rakamin.newsapp.models.NewsResponse
import dev.rakamin.newsapp.network.RetrofitClient

class NewsRepository {
    private val api = RetrofitClient.api

    suspend fun fetchHeadlines(country: String = "us"): NewsResponse =
        api.getTopHeadlines(country = country)

    suspend fun fetchEverything(query: String = "technology", page: Int = 1): NewsResponse =
        api.getEverything(query = query, page = page)
}
